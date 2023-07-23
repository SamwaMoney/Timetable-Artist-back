package SamwaMoney.TimeTableArtist.TableLike.repository;

import SamwaMoney.TimeTableArtist.Member.domain.Member;
import SamwaMoney.TimeTableArtist.TableLike.domain.TableLike;
import SamwaMoney.TimeTableArtist.Timetable.domain.Timetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TableLikeRepository extends JpaRepository<TableLike, Long> {
    boolean existsByOwnerAndTimetable(Member owner, Timetable timetable);
    Optional<TableLike> findByOwnerAndTimetable(Member owner, Timetable timetable);
}
