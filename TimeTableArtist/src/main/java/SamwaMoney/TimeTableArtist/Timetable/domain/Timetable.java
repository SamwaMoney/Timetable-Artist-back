package SamwaMoney.TimeTableArtist.Timetable.domain;

import SamwaMoney.TimeTableArtist.Global.entity.BaseTimeEntity;
import SamwaMoney.TimeTableArtist.Member.domain.Member;
import SamwaMoney.TimeTableArtist.Class.domain.Class;
import SamwaMoney.TimeTableArtist.Timetable.dto.RankingRequestDto;
import SamwaMoney.TimeTableArtist.tablecommentmap.domain.TableMinusComment;
import SamwaMoney.TimeTableArtist.tablecommentmap.domain.TablePlusComment;
import SamwaMoney.TimeTableArtist.tablecommentmap.domain.TableSpecialComment;
import lombok.*;
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

    @OneToMany(mappedBy = "timetable", cascade = CascadeType.REMOVE)
    private List<Class> classList = new ArrayList<>();

    @Setter
    @Column(nullable = false)
    private Long score;

    @Setter
    private Long tableType;

    @OneToMany(mappedBy = "timetable")
    private List<TablePlusComment> plusComments = new ArrayList<>();

    @OneToMany(mappedBy = "timetable")
    private List<TableMinusComment> minusComments = new ArrayList<>();

    @OneToMany(mappedBy = "timetable")
    private List<TableSpecialComment> specialComments = new ArrayList<>();

    @Column(nullable = false)
    @ColumnDefault("false")
    private boolean ranking;

    @Column(nullable = false)
    @ColumnDefault("false")
    private boolean classHide;

    @Column
    private String imgUrl; // 시간표 게시할 때 프론트로부터 받는 시간표 이미지

    @Setter
    private String typeImage; // 시간표의 type에 해당하는 짤

    @Setter
    private boolean isLiked;

    @Column(nullable = false)
    @ColumnDefault("0")
    @Setter
    private Long likeCount;

    @Column(nullable = false)
    @ColumnDefault("0")
    @Setter
    private Long replyCount;

    @Setter
    private String tableTypeContent;

    @Builder
    public Timetable(Member owner, List<Class> classList, Long score, List<TablePlusComment> plusComments, List<TableMinusComment> minusComments,
                     List<TableSpecialComment> specialComments, boolean ranking, boolean classHide, String imgUrl, String typeImage, boolean isLiked, Long likeCount, long replyCount, String tableTypeContent) {
        this.owner = owner;
        this.classList = classList;
        this.score = score;
        this.plusComments = plusComments;
        this.minusComments = minusComments;
        this.specialComments = specialComments;
        this.ranking = ranking;
        this.classHide = classHide;
        this.imgUrl = imgUrl;
        this.typeImage = typeImage;
        this.isLiked = isLiked;
        this.likeCount = likeCount;
        this.replyCount = replyCount;
        this.tableTypeContent = tableTypeContent;
    }

    // 빈 시간표를 만드는 생성자
    public Timetable(Member owner) {
        this.owner = owner;
        this.classList = new ArrayList<>();
        this.score = 60L;
        this.plusComments = new ArrayList<>();
        this.minusComments = new ArrayList<>();
        this.specialComments = new ArrayList<>();
        this.ranking = false;
        this.classHide = false;
        this.likeCount = 0L;
        this.replyCount = 0L;
    }

    // 랭킹보드 게시
    public void uploadToBoard(RankingRequestDto rankingRequestDto, String fileUrl, String tableTypeContent){
        this.classHide = rankingRequestDto.isClassHide();
        this.ranking = rankingRequestDto.isRanking();
        this.imgUrl = fileUrl;
        this.tableTypeContent = tableTypeContent;
    }
}
