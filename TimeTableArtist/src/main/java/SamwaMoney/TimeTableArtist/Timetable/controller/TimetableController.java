package SamwaMoney.TimeTableArtist.Timetable.controller;

import SamwaMoney.TimeTableArtist.Class.dto.ClassDto;
import SamwaMoney.TimeTableArtist.Class.service.ClassService;
import SamwaMoney.TimeTableArtist.Global.service.S3Uploader;
import SamwaMoney.TimeTableArtist.TableLike.service.TableLikeService;
import SamwaMoney.TimeTableArtist.Timetable.domain.Timetable;
import SamwaMoney.TimeTableArtist.Timetable.dto.*;
import SamwaMoney.TimeTableArtist.Timetable.dto.TimetableFindResponseDto;
import SamwaMoney.TimeTableArtist.Timetable.dto.TimetableFullResponseDto;
import SamwaMoney.TimeTableArtist.Timetable.dto.TimetableRequestDto;
import SamwaMoney.TimeTableArtist.Timetable.dto.TimetableResponseDto;
import SamwaMoney.TimeTableArtist.Timetable.repository.TimetableRepository;
import SamwaMoney.TimeTableArtist.Timetable.service.TimetableService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/timetables")
public class TimetableController {

    private final TimetableService timetableService;
    private final TimetableRepository timetableRepository;
    private final ClassService classService;
    private final TableLikeService tableLikeService;
    private final S3Uploader s3Uploader;

    // 시간표 생성
    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public TimetableResponseDto timetableCreate(@RequestBody final TimetableRequestDto requestDto) {
        Timetable timetable = timetableService.createTimetable(requestDto);
        return TimetableResponseDto.from(timetable);
    }

    // 시간표 삭제 (초기화)
    @DeleteMapping("/{member_id}/{timetable_id}")
    @ResponseStatus(value = HttpStatus.OK)
    public String timetableRemove(@PathVariable("member_id") final Long memberId, @PathVariable("timetable_id") final Long timetableId) {
        timetableService.removeTimetable(memberId, timetableId);
        return "시간표가 성공적으로 삭제되었습니다.";
    }

    // 내 시간표 조회
    @GetMapping("/{timetable_id}")
    @ResponseStatus(value = HttpStatus.OK)
    public TimetableFullResponseDto showTimetable(@PathVariable("timetable_id") Long timetableId) {
        return timetableService.showTimetable(timetableId);
    }

    // 시간표 채점
    @PatchMapping("/{timetable_id}/score")
    public ResponseEntity<String> scoreTimetable(@PathVariable("timetable_id") Long timetableId) {
        timetableService.scoreTimetable(timetableId);
        return new ResponseEntity<>("시간표가 성공적으로 채점되었습니다", HttpStatus.OK);
    }

    // 전체 시간표 조회 (사용자가 좋아요한 시간표 포함)
    @GetMapping("/board")
    @ResponseStatus(value = HttpStatus.OK)
    public List<TimetableResponseWithLikeDto> getAllTimetablesWithLikeStatus(@RequestParam("sortType") String sortType, @RequestBody TimetableRankingRequestDto timetableRankingRequestDto) {
        Long memberId = timetableRankingRequestDto.getMemberId();
        // 좋아요 여부 표시 전 전체 시간표 리스트
        List<TimetableResponseWithLikeDto> responseList = timetableService.getAllTimetablesWithLikeStatus(memberId);
        // 좋아요 여부 포함한 최종 시간표 리스트
        List<TimetableResponseWithLikeDto> timetablesWithLikeStatus = new ArrayList<>();

        for (TimetableResponseWithLikeDto timetableDto : responseList) {
            boolean liked = tableLikeService.isTimetableLikedByMember(timetableDto.getTimetableId(), memberId);
            timetableDto.setIsLiked(liked);
            timetablesWithLikeStatus.add(timetableDto);
        }

        return timetablesWithLikeStatus;
    }

    // 랭킹보드 게시
    @PutMapping(value = "{timetableId}/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<RankingResponseDto> uploadToBoard(@PathVariable Long timetableId, @RequestPart(value = "image") MultipartFile image, @RequestPart(value = "dto") RankingRequestDto rankingReqDto) throws IOException {
        String fileUrl = s3Uploader.upload(image, "image");  // request에서 받아온 image를 s3에 업로드
        String tableTypeContent = timetableService.readTableTypeContent(timetableId);
        RankingResponseDto rankingResponseDto = timetableService.updateByRankingReqDto(timetableId, rankingReqDto, fileUrl);
        return ResponseEntity.ok(rankingResponseDto);
    }
}
