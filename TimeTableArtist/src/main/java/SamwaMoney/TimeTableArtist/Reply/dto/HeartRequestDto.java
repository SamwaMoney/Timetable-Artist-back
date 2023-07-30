package SamwaMoney.TimeTableArtist.Reply.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class HeartRequestDto { // 좋아요 여부 표시를 위해 memberId 전달하는 Dto
    private Long memberId;
}