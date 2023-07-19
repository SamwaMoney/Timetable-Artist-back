package SamwaMoney.TimeTableArtist.Comment.entity;

import SamwaMoney.TimeTableArtist.tablecommentmap.domain.TablePlusComment;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PlusComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "plus_comment_id", nullable = false, updatable = false)
    private Long plusCommentId;

    @Column(nullable = false)
    private String content;

    @OneToMany(mappedBy = "plusComment")
    private List<TablePlusComment> tables = new ArrayList<>();
}