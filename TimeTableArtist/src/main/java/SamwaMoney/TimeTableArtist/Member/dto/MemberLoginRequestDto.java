package SamwaMoney.TimeTableArtist.Member.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class MemberLoginRequestDto {

    private String username;
    private String password;

}