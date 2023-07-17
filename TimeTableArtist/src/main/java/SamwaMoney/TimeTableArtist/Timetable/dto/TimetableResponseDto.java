package SamwaMoney.TimeTableArtist.Timetable.dto;

import SamwaMoney.TimeTableArtist.Timetable.domain.Timetable;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class TimetableResponseDto {

    private Long memberId;
    private Long timetableId;
    private LocalDateTime createdAt;

    public TimetableResponseDto(Long memberId, Long timetableId, LocalDateTime createdAt) {
        this.memberId = memberId;
        this.timetableId = timetableId;
        this.createdAt = createdAt;
    }

    public static TimetableResponseDto from(Timetable timetable) {
        return new TimetableResponseDto(
                timetable.getOwner().getMemberId(),
                timetable.getTimetableId(),
                timetable.getCreatedAt()
        );
    }
}