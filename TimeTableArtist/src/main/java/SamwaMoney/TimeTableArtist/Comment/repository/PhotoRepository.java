package SamwaMoney.TimeTableArtist.Comment.repository;

import SamwaMoney.TimeTableArtist.Comment.entity.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoRepository extends JpaRepository <Photo, Long> {
    Photo findByPhotoId(Long photoId);
}
