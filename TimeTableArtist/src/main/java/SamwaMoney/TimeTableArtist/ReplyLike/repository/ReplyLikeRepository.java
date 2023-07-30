package SamwaMoney.TimeTableArtist.ReplyLike.repository;

import SamwaMoney.TimeTableArtist.Member.domain.Member;
import SamwaMoney.TimeTableArtist.Reply.domain.Reply;
import SamwaMoney.TimeTableArtist.ReplyLike.domain.ReplyLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ReplyLikeRepository extends JpaRepository<ReplyLike, Long> {
    Integer countByReply(Reply reply);
    boolean existsByOwnerAndReply(Member owner, Reply reply);
    Optional<ReplyLike> findByOwnerAndReply(Member owner, Reply reply);
}
