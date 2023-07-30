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
    private String owner;
    private Long likeCount;
    private boolean isLiked;
    private LocalDateTime createdAt;

    private List<ClassDto> classList;



    @Builder
    public TimetableFullResponseDto(Long memberId, Long timetableId, String owner, Long likeCount, boolean isLiked, LocalDateTime createdAt, List<ClassDto> classList) {
        this.memberId = memberId;
        this.timetableId = timetableId;
        this.owner = owner;
        this.likeCount = likeCount;
        this.isLiked = isLiked;
        this.createdAt = createdAt;
        this.classList = classList;
    }

}