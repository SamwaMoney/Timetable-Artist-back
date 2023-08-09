package SamwaMoney.TimeTableArtist.Reply.repository;

import SamwaMoney.TimeTableArtist.Reply.domain.Reply;
import SamwaMoney.TimeTableArtist.Timetable.domain.Timetable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReplyRepository extends JpaRepository<Reply, Long> {
    List<Reply> findAllByTimetableOrderByReplyLikeCountDesc(Timetable timetable);
    Integer countByTimetable(Timetable timetable);
}
