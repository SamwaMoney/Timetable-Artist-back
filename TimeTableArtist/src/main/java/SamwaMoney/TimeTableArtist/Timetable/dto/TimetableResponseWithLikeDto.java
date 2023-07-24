package SamwaMoney.TimeTableArtist.Timetable.dto;

import SamwaMoney.TimeTableArtist.Member.domain.Member;
import SamwaMoney.TimeTableArtist.Timetable.domain.Timetable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TimetableResponseWithLikeDto {
    private Long timetableId;
    private String ownerUsername;
    private Long ranking;
    private Long score;
    private String tableType;
    private String tableImg;
    private Long likeCount;
    private Long replyCount;
    private boolean isLiked;

    public void setIsLiked(boolean isLiked) {
        this.isLiked = isLiked;
    }

    public void setTableType(String tableType) {
        this.tableType = tableType;
    }

    public void setTableImg(String tableImg) {
        this.tableImg = tableImg;
    }

    // timetableDto에서 timetableId 받아오기
    public static TimetableResponseWithLikeDto from(Timetable timetable, boolean isLiked, String tableType, String tableImg, Long likeCount) {
        TimetableResponseWithLikeDto dto = new TimetableResponseWithLikeDto();
        dto.setTimetableId(timetable.getTimetableId());
        dto.setOwnerUsername(timetable.getOwner().getUsername());
        dto.setRanking(timetable.getRanking());
        dto.setScore(timetable.getScore());
        dto.setLikeCount(likeCount);
//        dto.setReplyCount(timetable.getReplyCount());
        dto.setTableImg(tableImg);
        dto.setTableType(tableType);
        dto.setIsLiked(isLiked);
        return dto;
    }

}
