package SamwaMoney.TimeTableArtist.Class.domain;

import SamwaMoney.TimeTableArtist.Timetable.domain.Timetable;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Class {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "class_id", nullable = false, updatable = false)
    private Long classId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "table_id", nullable = false, updatable = false)
    private Timetable timetable;

    @Column(nullable = false)
    private String className;

    @Column(nullable = false)
    private String location;

    private Weekday weekday;

    private Long startH;

    private Long startM;

    private Long endH;

    private Long endM;

    @Builder
    public Class(Timetable timetable, String className, String location, Weekday weekday, Long startH, Long startM, Long endH, Long endM) {
        this.timetable = timetable;
        this.className = className;
        this.location = location;
        this.weekday = weekday;
        this.startH = startH;
        this.startM = startM;
        this.endH = endH;
        this.endM = endM;
    }
}
