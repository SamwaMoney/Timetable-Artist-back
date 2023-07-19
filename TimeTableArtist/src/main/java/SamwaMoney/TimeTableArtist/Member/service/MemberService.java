package SamwaMoney.TimeTableArtist.Member.service;

import SamwaMoney.TimeTableArtist.Member.domain.Member;
import SamwaMoney.TimeTableArtist.Member.repository.MemberRepository;
import SamwaMoney.TimeTableArtist.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder encoder;

    // 토큰 만료 시간을 1시간으로 설정
    private Long expireTimeMs = 1000 * 60 * 60L;

    // application-secret.yml 에서 키 가져오기
    @Value("${spring.jwt.secret-key}")
    private String key;

    // 회원가입
    public String join(String username, String password) {
        // userName 중복 체크
        if(existsByUserName(username)) throw new RuntimeException("username " + username + "은 이미 존재하는 회원명입니다!");

        // 중복되지 않는다면 저장을 수행
        memberRepository.save(
                Member.builder()
                        .username(username)
                        .password(encoder.encode(password))
                        .build()
        );

        return "성공적으로 회원가입되었습니다!";
    }

    // 로그인
    public String login(String username, String password) {
        // 존재하지 않는 username으로 로그인을 시도하였을 경우를 캐치
        Member foundMember = findMemberByUsername(username);

        // 존재하는 username을 입력하였지만, 잘못된 비밀번호를 입력하였을 경우를 캐치
        if(!encoder.matches(password, foundMember.getPassword())) throw new RuntimeException("잘못된 비밀번호입니다!");

        // 로그인 성공 -> 토큰 발행
        String token = JwtUtil.createToken(foundMember.getUsername(), key, expireTimeMs);

        // 발행된 토큰의 값을 리턴
        return token;
    }

    // 회원탈퇴
    public String delete(Long memberId, Authentication authentication) {
        Member member = findMemberById(memberId);
        memberRepository.delete(member);
        return "성공적으로 탈퇴되었습니다!";
    }


    /*
    아래는 Transactional 함수들
     */
    // username을 기준으로 Member 정보 찾기
    @Transactional(readOnly = true)
    public Member findMemberByUsername(String username) {
        return memberRepository.findByUsername(username)
                .orElseThrow(() -> new EntityNotFoundException("username " + username + "은 존재하지 않는 회원명입니다!"));
    }

    // ID를 기준으로 Member 정보 찾기
    @Transactional(readOnly = true)
    public Member findMemberById(Long id) {
        return memberRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ID가 " + id + "인 회원이 존재하지 않습니다!"));
    }

    // username 중복 체크
    @Transactional(readOnly = true)
    public boolean existsByUserName(String username) {
        return memberRepository.existsByUsername(username);
    }
}
