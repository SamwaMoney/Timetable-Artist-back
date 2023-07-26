package SamwaMoney.TimeTableArtist.Timetable.dto;

import SamwaMoney.TimeTableArtist.Member.domain.Member;
import SamwaMoney.TimeTableArtist.Timetable.domain.Timetable;
import SamwaMoney.TimeTableArtist.tablecommentmap.domain.TableMinusComment;
import SamwaMoney.TimeTableArtist.tablecommentmap.domain.TablePlusComment;
import SamwaMoney.TimeTableArtist.tablecommentmap.domain.TableSpecialComment;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class RankingResponseDto { // 여기다 다 넣음
    private Long timetableId;
    private Long score;
    private boolean ranking;
    private boolean classHide;
    private String imgUrl;

    @Builder
    public RankingResponseDto(Timetable timetable) {
        this.timetableId = timetable.getTimetableId();
        this.score = timetable.getScore();
        this.ranking = timetable.isRanking();
        this.classHide = timetable.isClassHide();
        this.imgUrl = timetable.getImgUrl();
    }
}
