package SamwaMoney.TimeTableArtist.Timetable.dto;

import SamwaMoney.TimeTableArtist.Timetable.domain.Timetable;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class RankingboardGetResponseDto {
    private Long timetableId;
    private String username;
    private Long score;
    private boolean ranking;
    private boolean classHide;
    private String imgUrl;
    private String tableTypeContent;
    private Long likeCount;
    private Long replyCount;
    private boolean isLiked;

    public RankingboardGetResponseDto() {

    }

    public void setLikeCount(Long likeCount) {
        this.likeCount = likeCount;
    }

    public void setIsLiked(boolean isLiked) {
        this.isLiked = isLiked;
    }

    public static RankingboardGetResponseDto from(Timetable timetable, Long likeCount, boolean isLiked) {
        RankingboardGetResponseDto dto = new RankingboardGetResponseDto();
        dto.setTimetableId(timetable.getTimetableId());
        dto.setUsername(timetable.getOwner().getUsername());
        dto.setScore(timetable.getScore());
        dto.setRanking(timetable.isRanking());
        dto.setClassHide(timetable.isClassHide());
        dto.setImgUrl(timetable.getImgUrl());
        dto.setTableTypeContent(timetable.getTableTypeContent());
        dto.setLikeCount(likeCount);
        dto.setReplyCount(timetable.getReplyCount());
        dto.setIsLiked(isLiked);
        return dto;
    }
}