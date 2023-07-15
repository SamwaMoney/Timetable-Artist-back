package SamwaMoney.TimeTableArtist.Member.repository;

import SamwaMoney.TimeTableArtist.Member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    // userName 중복 검사를 위한 메소드
    Boolean existsByUsername(String username);
    Optional<Member> findByUsername(String username);
}
