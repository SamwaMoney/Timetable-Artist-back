package SamwaMoney.TimeTableArtist.Member.repository;

import SamwaMoney.TimeTableArtist.Member.domain.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RefreshTokenRepository  extends JpaRepository<RefreshToken, Long> {
    Optional<RefreshToken> findByValue(String value);
}
