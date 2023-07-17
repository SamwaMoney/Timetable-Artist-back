package SamwaMoney.TimeTableArtist.Timetable.repository;

import SamwaMoney.TimeTableArtist.Timetable.domain.Timetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TimetableRepository extends JpaRepository<Timetable, Long> {
}
