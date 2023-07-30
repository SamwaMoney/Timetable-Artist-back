package SamwaMoney.TimeTableArtist.TableLike.controller;

import SamwaMoney.TimeTableArtist.TableLike.dto.TableLikeRequestDto;
import SamwaMoney.TimeTableArtist.TableLike.service.TableLikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/timetables/{timetable_id}/likes")
@RequiredArgsConstructor
public class TableLikeController {

    private final TableLikeService tableLikeService;

    // timetable 좋아요
    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public String createTableLike(@PathVariable("timetable_id") Long timetableId, @RequestBody TableLikeRequestDto dto) {
        tableLikeService.createTableLike(timetableId, dto.getMemberId());
        return "좋아요 처리 되었습니다.";
    }

    @DeleteMapping
    @ResponseStatus(value = HttpStatus.OK)
    public String deleteTableLike(@PathVariable("timetable_id") Long timetableId, @RequestParam("memberId") Long memberId) {
        tableLikeService.deleteTableLike(timetableId, memberId);
        return "좋아요 삭제 처리 되었습니다.";
    }

}
