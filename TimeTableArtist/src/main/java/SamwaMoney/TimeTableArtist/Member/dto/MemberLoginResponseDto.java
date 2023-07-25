package SamwaMoney.TimeTableArtist.Member.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberLoginResponseDto {
    private Long memberId;
    private String username;
    private String accessToken;
    private String refreshToken;

    @Builder
    public MemberLoginResponseDto(Long memberId, String username, String accessToken, String refreshToken) {
        this.memberId = memberId;
        this.username = username;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }
}
