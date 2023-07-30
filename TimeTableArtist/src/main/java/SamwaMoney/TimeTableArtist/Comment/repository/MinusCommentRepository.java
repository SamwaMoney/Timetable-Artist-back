package SamwaMoney.TimeTableArtist.Comment.repository;

import SamwaMoney.TimeTableArtist.Comment.entity.MinusComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface MinusCommentRepository extends JpaRepository<MinusComment, Long> {
    ArrayList<MinusComment> findAll();
}

