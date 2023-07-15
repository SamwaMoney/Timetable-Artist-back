package SamwaMoney.TimeTableArtist.Comment.entity;

import SamwaMoney.TimeTableArtist.tablecommentmap.domain.TableMinusComment;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MinusComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "minus_comment_id", nullable = false, updatable = false)
    private Long minusCommentId;

    @Column(nullable = false)
    private String content;

    @OneToMany(mappedBy = "minusComment")
    private List<TableMinusComment> tables = new ArrayList<>();
}
