package SamwaMoney.TimeTableArtist.TableLike.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TableLikeRequestDto {
    @NotNull(message = "작성자는 필수로 입력되어야 합니다.")
    private Long memberId;

    @NotNull(message = "좋아요 할 시간표가 필수로 입력되어야 합니다.")
    private Long timetableId;
}
