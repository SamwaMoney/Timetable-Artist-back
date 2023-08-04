package SamwaMoney.TimeTableArtist.Class.dto;

import SamwaMoney.TimeTableArtist.Class.domain.Class;
import SamwaMoney.TimeTableArtist.Class.domain.Weekday;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ClassDto {

    private String className;
    private String location;
    private Weekday weekday;
    private Long startH;
    private Long startM;
    private Long endH;
    private Long endM;
    private String bgColor;

    public static ClassDto from(Class classEntity) {
        return ClassDto.builder()
                .className(classEntity.getClassName())
                .location(classEntity.getLocation())
                .weekday(classEntity.getWeekday())
                .startH(classEntity.getStartH())
                .startM(classEntity.getStartM())
                .endH(classEntity.getEndH())
                .endM(classEntity.getEndM())
                .bgColor(classEntity.getBgColor())
                .build();
    }
}