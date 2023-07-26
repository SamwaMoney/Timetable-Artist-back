package SamwaMoney.TimeTableArtist.Member.controller;

import SamwaMoney.TimeTableArtist.Member.dto.MemberJoinRequestDto;
import SamwaMoney.TimeTableArtist.Member.dto.MemberLoginRequestDto;
import SamwaMoney.TimeTableArtist.Member.dto.MemberLoginResponseDto;
import SamwaMoney.TimeTableArtist.Member.dto.RefreshTokenRequestDto;
import SamwaMoney.TimeTableArtist.Member.service.MemberService;
import SamwaMoney.TimeTableArtist.Member.service.RefreshTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;
    private final RefreshTokenService refreshTokenService;
    @GetMapping
    public String test() {
        return "test";
    }

    // 회원가입
    // 성공적으로 회원가입되었을 경우, 문자열 "성공적으로 회원가입되었습니다!"를 응답함
    @PostMapping("/signup")
    public ResponseEntity<String> join (@RequestBody MemberJoinRequestDto requestDto) {
        return ResponseEntity.ok().body(memberService.join(requestDto.getUsername(), requestDto.getPassword()));
    }

    // 로그인
    // 성공적으로 로그인되었을 경우, 회원의 ID, 회원명, AccessToken 값, RefreshToken 값을 담은 DTO를 응답함
    @PostMapping("/login")
    public MemberLoginResponseDto login (@RequestBody MemberLoginRequestDto requestDto) {
        return memberService.login(requestDto.getUsername(), requestDto.getPassword());
    }

    // 로그아웃
    // Body로 전달된 RefreshToken을 DB에서 삭제
    // 성공적으로 로그아웃되었을 경우, 문자열 "성공적으로 로그아웃되었습니다!"를 응답함
    @DeleteMapping("/logout")
    public String logout(@RequestBody RefreshTokenRequestDto requestDto) {
        refreshTokenService.deleteRefreshToken(requestDto.getRefreshToken());
        return "성공적으로 로그아웃되었습니다!";
    }

    // 회원탈퇴
    // 성공적으로 탈퇴되었을 경우, 문자열 "성공적으로 탈퇴되었습니다!"를 응답함
    @DeleteMapping("/{memberId}")
    public ResponseEntity<String> delete(@PathVariable Long memberId, Authentication authentication) {
        return ResponseEntity.ok().body(memberService.delete(memberId, authentication));
    }

    // RefreshToken을 이용해 새 AccessToken을 발급받는 요청
    // 프론트에서 유효한 RefreshToken을 보냈다면, 새 AccessToken 값과 기존 RefreshToken 값을 담은 DTO를 응답함
    @PostMapping("/refreshtoken")
    public MemberLoginResponseDto requestRefresh (@RequestBody RefreshTokenRequestDto refreshTokenDto) {
        return memberService.requestRefresh(refreshTokenDto.getRefreshToken());
    }

}
