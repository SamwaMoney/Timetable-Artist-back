package SamwaMoney.TimeTableArtist.Timetable.controller;

import SamwaMoney.TimeTableArtist.Timetable.domain.Timetable;
import SamwaMoney.TimeTableArtist.Timetable.dto.TimetableRequestDto;
import SamwaMoney.TimeTableArtist.Timetable.dto.TimetableResponseDto;
import SamwaMoney.TimeTableArtist.Timetable.service.TimetableService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/timetables")
public class TimetableController {

    private final TimetableService timetableService;

    // 시간표 생성 -> !수업 객체와 연결 필요! -> !알고리즘 계산 결과 도출되는 코멘트 유형 연결 필요!
    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public TimetableResponseDto timetableCreate(@RequestBody final TimetableRequestDto requestDto) {
        Timetable timetable = timetableService.createTimetable(requestDto);
        return TimetableResponseDto.from(timetable);
    }

    // 시간표 삭제 (초기화)
    @DeleteMapping("/{timetableId}/{memberId}")
    @ResponseStatus(value = HttpStatus.OK)
    public String timetableRemove(@PathVariable final Long timetableId, @PathVariable final Long memberId) {
        timetableService.removeTimetable(timetableId, memberId);
        return "시간표가 성공적으로 삭제되었습니다.";
    }
}
