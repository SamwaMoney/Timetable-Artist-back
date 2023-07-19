package SamwaMoney.TimeTableArtist.Table.domain;

import SamwaMoney.TimeTableArtist.Comment.entity.MinusComment;
import SamwaMoney.TimeTableArtist.Comment.entity.PlusComment;
import SamwaMoney.TimeTableArtist.Comment.entity.SpecialComment;
import SamwaMoney.TimeTableArtist.Global.entity.BaseTimeEntity;
import SamwaMoney.TimeTableArtist.Member.domain.Member;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Table extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "table_id", nullable = false, updatable = false)
    private Long tableId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false, updatable = false)
    private Member owner;

    @Column(nullable = false)
    private Long score;

    @ManyToMany(mappedBy = "table")
    private List<PlusComment> plusComments = new ArrayList<>();

    @ManyToMany(mappedBy = "table")
    private List<MinusComment> minusComments = new ArrayList<>();

    @ManyToMany(mappedBy = "table")
    private List<SpecialComment> specialComments = new ArrayList<>();

    private Long rank;

    @Column(nullable = false)
    private Boolean classHide;

    @Builder
    public Table(Member owner, Long score, List<PlusComment> plusComments, List<MinusComment> minusComments,
                 List<SpecialComment> specialComments, Long rank, Boolean classHide) {
        this.owner = owner;
        this.score = score;
        this.plusComments = plusComments;
        this.minusComments = minusComments;
        this.specialComments = specialComments;
        this.rank = rank;
        this.classHide = classHide;
    }
}
