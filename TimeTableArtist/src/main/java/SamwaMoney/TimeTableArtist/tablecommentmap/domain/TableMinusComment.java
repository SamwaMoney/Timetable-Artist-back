package SamwaMoney.TimeTableArtist.tablecommentmap.domain;

import SamwaMoney.TimeTableArtist.Comment.entity.MinusComment;
import SamwaMoney.TimeTableArtist.Timetable.domain.Timetable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TableMinusComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "table_minuscomment_id", nullable = false, updatable = false)
    private Long tablePlusCommentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="timetable_id")
    private Timetable timetable;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="minuscomment_id")
    private MinusComment minusComment;
}
