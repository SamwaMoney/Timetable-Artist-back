package SamwaMoney.TimeTableArtist.Reply.domain;

import SamwaMoney.TimeTableArtist.Global.entity.BaseTimeEntity;
import SamwaMoney.TimeTableArtist.Member.domain.Member;
import SamwaMoney.TimeTableArtist.Timetable.domain.Timetable;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Reply extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reply_id", nullable = false, updatable = false)
    private Long replyId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "table_id", nullable = false)
    private Timetable timetable;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member writer;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Column(nullable = false)
    @ColumnDefault("false") // true일 때 익명
    private boolean nameHide;

    @Column
    private String replyName;

    @Column(nullable = false)
    @ColumnDefault("false") // like 값이 false면 좋아요 누르지 않은 상태
    public boolean heart;

    @Column(nullable = false)
    @ColumnDefault("0")
    private Integer replyLikeCount;

    public void updateLikeCount(Integer newReplyLikeCount){
        this.replyLikeCount = newReplyLikeCount;
    }

    public void updateHeart(boolean newHeart){
        this.heart = newHeart;
    }

    @Builder
    public Reply(Timetable timetable, Member writer, String content, boolean nameHide, String replyName, boolean heart, Integer replyLikeCount) {
        this.timetable = timetable;
        this.writer = writer;
        this.content = content;
        this.nameHide = nameHide;
        this.replyName = replyName;
        this.heart = heart;
        this.replyLikeCount = replyLikeCount;
    }
}