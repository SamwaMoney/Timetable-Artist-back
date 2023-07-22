package SamwaMoney.TimeTableArtist.Timetable.domain;

import SamwaMoney.TimeTableArtist.Global.entity.BaseTimeEntity;
import SamwaMoney.TimeTableArtist.Member.domain.Member;
import SamwaMoney.TimeTableArtist.Class.domain.Class;
import SamwaMoney.TimeTableArtist.tablecommentmap.domain.TableMinusComment;
import SamwaMoney.TimeTableArtist.tablecommentmap.domain.TablePlusComment;
import SamwaMoney.TimeTableArtist.tablecommentmap.domain.TableSpecialComment;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Timetable extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "timetable_id", nullable = false, updatable = false)
    private Long timetableId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false, updatable = false)
    private Member owner;

    @OneToMany(mappedBy = "timetable")
    private List<Class> classList = new ArrayList<>();

    @Column(nullable = false)
    @ColumnDefault("60")
    private Long score;

    @OneToMany(mappedBy = "timetable")
    private List<TablePlusComment> plusComments = new ArrayList<>();

    @OneToMany(mappedBy = "timetable")
    private List<TableMinusComment> minusComments = new ArrayList<>();

    @OneToMany(mappedBy = "timetable")
    private List<TableSpecialComment> specialComments = new ArrayList<>();

    private Long ranking;

    @Column(nullable = false)
    @ColumnDefault("0")
    private Boolean classHide;

    @Builder
    public Timetable(Member owner, List<Class> classList, Long score, List<TablePlusComment> plusComments, List<TableMinusComment> minusComments,
                     List<TableSpecialComment> specialComments, Long ranking, Boolean classHide) {
        this.owner = owner;
        this.classList = classList;
        this.score = score;
        this.plusComments = plusComments;
        this.minusComments = minusComments;
        this.specialComments = specialComments;
        this.ranking = ranking;
        this.classHide = classHide;
    }
}
