package SamwaMoney.TimeTableArtist.TimetableImg.domain;

import SamwaMoney.TimeTableArtist.Class.domain.Weekday;
import SamwaMoney.TimeTableArtist.Timetable.domain.Timetable;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="TimetableImg")
@Getter
@Setter
public class TimetableImg {
    @Id
    @GeneratedValue
    @Column(name="timetableImg_id")
    private Long id;

    @Column(nullable = false)
    private String imgUrl;

    //class랑 매핑하기
    @OneToOne
    @JoinColumn(name="class_id")
    private Class class;

    @Builder
    public TimetableImg(Long id, String imgUrl){
        this.id = id;
        this.imgUrl = imgUrl;
    }
}
