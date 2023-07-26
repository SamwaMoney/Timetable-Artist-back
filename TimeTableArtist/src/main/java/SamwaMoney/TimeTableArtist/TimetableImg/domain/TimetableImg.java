package SamwaMoney.TimeTableArtist.TimetableImg.domain;

import SamwaMoney.TimeTableArtist.Global.entity.BaseTimeEntity;
import SamwaMoney.TimeTableArtist.Timetable.domain.Timetable;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TimetableImg extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "timetable_img_id", nullable = false, updatable = false)
    private Long timetableImgId;

    // 이미지 URL을 저장할 필드
    private String imageUrl;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "timetable_id", nullable = false, updatable = false)
    private Timetable timetable;

    @Builder
    public TimetableImg(String imageUrl, Timetable timetable) {
        this.imageUrl = imageUrl;
        this.timetable = timetable;
    }
}
