package SamwaMoney.TimeTableArtist.tablecommentmap.domain;

import SamwaMoney.TimeTableArtist.Comment.entity.PlusComment;
import SamwaMoney.TimeTableArtist.Timetable.domain.Timetable;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TablePlusComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "table_pluscomment_id", nullable = false, updatable = false)
    private Long tablePlusCommentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="timetable_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Timetable timetable;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="pluscomment_id")
    private PlusComment plusComment;

    @Builder
    public TablePlusComment (Timetable timetable, PlusComment plusComment) {
        this.timetable = timetable;
        this.plusComment = plusComment;
    }
}
