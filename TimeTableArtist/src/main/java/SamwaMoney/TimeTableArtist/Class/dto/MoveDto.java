package SamwaMoney.TimeTableArtist.Class.dto;

import SamwaMoney.TimeTableArtist.Class.domain.Difficulty;
import lombok.Getter;

@Getter
public class MoveDto {
    boolean uphill;         // 오르막길 여부
    Difficulty difficulty;  // 난이도 상, 중, 하

    // 생성자
    public MoveDto(boolean uphill, Difficulty difficulty) {
        this.uphill = uphill;
        this.difficulty = difficulty;
    }
}
