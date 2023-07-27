package SamwaMoney.TimeTableArtist.Comment.repository;

import SamwaMoney.TimeTableArtist.Comment.entity.MinusComment;
import SamwaMoney.TimeTableArtist.Comment.entity.SpecialComment;
import SamwaMoney.TimeTableArtist.Timetable.domain.Timetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface SpecialCommentRepository extends JpaRepository<SpecialComment, Long> {
    @Query("SELECT s.id FROM SpecialComment s")
    List<Long> getAllIds();
    List<SpecialComment> findAll();
    SpecialComment findBySpecialCommentId (Long specialCommentId);
}
