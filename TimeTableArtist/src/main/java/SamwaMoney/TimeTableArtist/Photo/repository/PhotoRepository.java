package SamwaMoney.TimeTableArtist.Photo.repository;

import SamwaMoney.TimeTableArtist.Photo.domain.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoRepository extends JpaRepository {
    Photo findByPhotoId(Long photoId);
}
