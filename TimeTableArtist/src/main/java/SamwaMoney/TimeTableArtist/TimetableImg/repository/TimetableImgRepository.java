package SamwaMoney.TimeTableArtist.TimetableImg.repository;

import SamwaMoney.TimeTableArtist.TimetableImg.domain.TimetableImg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimetableImgRepository extends JpaRepository<TimetableImg, Long> {
}
