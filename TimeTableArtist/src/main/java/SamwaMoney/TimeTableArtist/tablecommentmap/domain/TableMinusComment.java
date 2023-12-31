package SamwaMoney.TimeTableArtist.tablecommentmap.domain;

import SamwaMoney.TimeTableArtist.Comment.entity.MinusComment;
import SamwaMoney.TimeTableArtist.Timetable.domain.Timetable;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TableMinusComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "table_minuscomment_id", nullable = false, updatable = false)
    private Long tableMinusCommentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="timetable_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Timetable timetable;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="minuscomment_id")
    private MinusComment minusComment;

    @Builder
    public TableMinusComment (Timetable timetable, MinusComment minusComment) {
        this.timetable = timetable;
        this.minusComment = minusComment;
    }
}
