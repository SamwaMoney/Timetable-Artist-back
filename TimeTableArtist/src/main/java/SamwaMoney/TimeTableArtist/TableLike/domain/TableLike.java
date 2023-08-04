package SamwaMoney.TimeTableArtist.TableLike.domain;

import SamwaMoney.TimeTableArtist.Member.domain.Member;
import SamwaMoney.TimeTableArtist.Timetable.domain.Timetable;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TableLike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "table_like_id", nullable = false, updatable = false)
    private Long tableLikeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "table_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Timetable timetable;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Member owner;

    @Builder
    public TableLike(Timetable timetable, Member owner) {
        this.timetable = timetable;
        this.owner = owner;
    }
}
