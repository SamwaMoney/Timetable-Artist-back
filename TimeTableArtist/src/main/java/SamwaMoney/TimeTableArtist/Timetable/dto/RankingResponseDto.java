package SamwaMoney.TimeTableArtist.Timetable.dto;

import SamwaMoney.TimeTableArtist.Comment.repository.SpecialCommentRepository;
import SamwaMoney.TimeTableArtist.Member.domain.Member;
import SamwaMoney.TimeTableArtist.Timetable.domain.Timetable;
import SamwaMoney.TimeTableArtist.tablecommentmap.domain.TableMinusComment;
import SamwaMoney.TimeTableArtist.tablecommentmap.domain.TablePlusComment;
import SamwaMoney.TimeTableArtist.tablecommentmap.domain.TableSpecialComment;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class RankingResponseDto {
    private Long timetableId;
    private String username;
    private Long score;
    private boolean ranking;
    private boolean classHide;
    private String imgUrl;
    private String tableTypeContent;
    private Long likeCount;
    private Long replyCount;

    @Builder
    public RankingResponseDto(Timetable timetable) {
        this.timetableId = timetable.getTimetableId();
        this.username = timetable.getOwner().getUsername();
        this.score = timetable.getScore();
        this.ranking = timetable.isRanking();
        this.classHide = timetable.isClassHide();
        this.imgUrl = timetable.getImgUrl();
        this.tableTypeContent = timetable.getTableTypeContent();
        this.likeCount = timetable.getLikeCount();
        this.replyCount = timetable.getReplyCount();
    }
}
