package SamwaMoney.TimeTableArtist.Timetable.dto;

import SamwaMoney.TimeTableArtist.Class.domain.Class;
import SamwaMoney.TimeTableArtist.Class.dto.ClassDto;
import SamwaMoney.TimeTableArtist.Timetable.domain.Timetable;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TimetableFindResponseDto {

    private Long timetableId;
    private List<ClassDto> classList;

    // 생성자 추가
    public TimetableFindResponseDto(Long timetableId, List<ClassDto> classList) {
        this.timetableId = timetableId;
        this.classList = classList;
    }

    // responseDto 전달 메서드
    public static TimetableFindResponseDto from(Timetable timetable, List<Class> classList) {
        List<ClassDto> classDtoList = classList.stream()
                .map(ClassDto::from)
                .collect(Collectors.toList());
        return new TimetableFindResponseDto(timetable.getTimetableId(), classDtoList);
    }
}
