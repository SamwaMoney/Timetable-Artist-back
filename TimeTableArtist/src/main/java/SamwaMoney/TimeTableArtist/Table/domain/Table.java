package SamwaMoney.TimeTableArtist.Table.domain;

import SamwaMoney.TimeTableArtist.Member.domain.Member;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Table {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "table_id", nullable = false, updatable = false)
    private Long tableId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false, updatable = false)
    private Member owner;

    @Column(nullable = false)
    private Long score;

    /*
    @ManyToOne
    @JoinColumn(name = "comment_id", nullable = false)
    private Comment tableType;
     */

    @Column(name = "table_type", nullable = false)
    private Long tableType;

    private Long rank;

    @Column(nullable = false)
    private Boolean classHide;

    @Builder
    public Table(Member owner, Long score, Long tableType, Long rank, Boolean classHide) {
        this.owner = owner;
        this.score = score;
        this.tableType = tableType;
        this.rank = rank;
        this.classHide = classHide;
    }
}
