package SamwaMoney.TimeTableArtist.Class.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Weekday {
    MON(0, "월"),
    TUE(1, "화"),
    WED(2, "수"),
    THU(3, "목"),
    FRI(4, "금"),
    ONLINE(5, "원격/온라인");

    private final Integer weekdayId;

    private final String title;
}
