package SamwaMoney.TimeTableArtist.TimetableImg.domain;

import SamwaMoney.TimeTableArtist.Timetable.domain.Timetable;
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

    @OneToOne
    @JoinColumn(name="timetable_id")
    private Timetable timetable;
}
