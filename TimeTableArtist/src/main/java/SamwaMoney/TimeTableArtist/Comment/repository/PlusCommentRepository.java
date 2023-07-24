package SamwaMoney.TimeTableArtist.Comment.repository;

import SamwaMoney.TimeTableArtist.Comment.entity.PlusComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface PlusCommentRepository extends JpaRepository<PlusComment, Long> {
    ArrayList<PlusComment> findAll();
}
