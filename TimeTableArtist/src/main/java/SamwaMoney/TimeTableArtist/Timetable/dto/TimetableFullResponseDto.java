package SamwaMoney.TimeTableArtist.Timetable.dto;

import SamwaMoney.TimeTableArtist.Class.dto.ClassDto;
import SamwaMoney.TimeTableArtist.Class.domain.Class;
import SamwaMoney.TimeTableArtist.Timetable.domain.Timetable;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class TimetableFullResponseDto {

    private Long memberId;
    private Long timetableId;
    private LocalDateTime createdAt;

    private List<ClassDto> classList;

    @Builder
    public TimetableFullResponseDto(Long memberId, Long timetableId, LocalDateTime createdAt, List<ClassDto> classList) {
        this.memberId = memberId;
        this.timetableId = timetableId;
        this.createdAt = createdAt;
        this.classList = classList;
    }

}