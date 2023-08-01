package SamwaMoney.TimeTableArtist.Photo.domain;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Entity
public class Photo {
    @Id
    @Column
    private Long photoId;

    @Column
    private String name;
}
