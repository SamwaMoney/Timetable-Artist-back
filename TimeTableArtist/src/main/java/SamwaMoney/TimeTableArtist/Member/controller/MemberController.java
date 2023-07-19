package SamwaMoney.TimeTableArtist.Member.controller;

import SamwaMoney.TimeTableArtist.Member.dto.MemberJoinRequestDto;
import SamwaMoney.TimeTableArtist.Member.dto.MemberLoginRequestDto;
import SamwaMoney.TimeTableArtist.Member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

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
    // 성공적으로 로그인되었을 경우, 문자열 "성공적으로 로그인되었습니다!"와 함께 토큰의 값을 응답함
    @PostMapping("/login")
    public ResponseEntity<String> login (@RequestBody MemberLoginRequestDto requestDto) {
        String token = memberService.login(requestDto.getUsername(), requestDto.getPassword());
        return ResponseEntity.ok().body("성공적으로 로그인되었습니다! (token: " + token + ")");
    }

    // 회원탈퇴
    // 성공적으로 탈퇴되었을 경우, 문자열 "성공적으로 탈퇴되었습니다!"를 응답함
    @DeleteMapping("/{memberId}")
    public ResponseEntity<String> delete(@PathVariable Long memberId, Authentication authentication) {
        return ResponseEntity.ok().body(memberService.delete(memberId, authentication));
    }

}
