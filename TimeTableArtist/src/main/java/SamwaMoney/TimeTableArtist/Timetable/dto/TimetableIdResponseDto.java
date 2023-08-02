package SamwaMoney.TimeTableArtist.Timetable.dto;

import lombok.Builder;

public class TimetableIdResponseDto {
    private Long memberId;
    private Long timetableId;

    @Builder
    public TimetableIdResponseDto(Long memberId, Long timetableId) {
        this.memberId = memberId;
        this.timetableId = timetableId;
    }
}
