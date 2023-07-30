package SamwaMoney.TimeTableArtist.Comment.dto;

import SamwaMoney.TimeTableArtist.Comment.entity.MinusComment;
import SamwaMoney.TimeTableArtist.Comment.entity.PlusComment;
import SamwaMoney.TimeTableArtist.Comment.entity.SpecialComment;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommentResponseDto {
    private String commentType; // 해당 코멘트가 plus, minus, special 중 어느 것인지 명시
    private Long commentId;     // 코멘트의 ID
    private String content;      // 코멘트 내용

    // 세 가지 코멘트에 대한 생성자
    public CommentResponseDto (PlusComment comment) {
        this.commentType = "plus";
        this.commentId = comment.getPlusCommentId();
        this.content = comment.getContent();
    }
    public CommentResponseDto (MinusComment comment) {
        this.commentType = "minus";
        this.commentId = comment.getMinusCommentId();
        this.content = comment.getContent();
    }
    public CommentResponseDto (SpecialComment comment) {
        this.commentType = "special";
        this.commentId = comment.getSpecialCommentId();
        this.content = comment.getContent();
    }
}
