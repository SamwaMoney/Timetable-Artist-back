package SamwaMoney.TimeTableArtist.Class.dto;

import SamwaMoney.TimeTableArtist.Class.domain.Weekday;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClassRequestDto {
    private Long memberId;
    private Long table;
    private String className;
    private String location;
    private Weekday weekday;
    private Long startH;
    private Long startM;
    private Long endH;
    private Long endM;
}

