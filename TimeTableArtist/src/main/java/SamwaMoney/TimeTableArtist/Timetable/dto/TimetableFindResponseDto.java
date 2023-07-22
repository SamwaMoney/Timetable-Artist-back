package SamwaMoney.TimeTableArtist.Timetable.dto;

import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class TimetableFindResponseDto {

    private List<Class> classList;

    public static TimetableFindResponseDto of(List<Class> classList) {
        return TimetableFindResponseDto.builder()
                .classList(classList.stream().collect(Collectors.toList()))
                .build();
    }
}
