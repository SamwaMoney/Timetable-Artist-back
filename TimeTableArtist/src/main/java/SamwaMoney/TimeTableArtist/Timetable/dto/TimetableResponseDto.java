package SamwaMoney.TimeTableArtist.Timetable.dto;

import SamwaMoney.TimeTableArtist.Timetable.domain.Timetable;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

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
