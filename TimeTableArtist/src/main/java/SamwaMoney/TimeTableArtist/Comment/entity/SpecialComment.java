package SamwaMoney.TimeTableArtist.Comment.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SpecialComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "special_comment_id", nullable = false, updatable = false)
    private Long specialCommentId;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String shortContent;

    @Column(nullable = false)
    private Long priority;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "photo_id", nullable = false)
    private Photo photo;
}
