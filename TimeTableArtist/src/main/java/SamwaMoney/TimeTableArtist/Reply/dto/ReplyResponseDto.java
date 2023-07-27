package SamwaMoney.TimeTableArtist.Reply.dto;

import SamwaMoney.TimeTableArtist.Reply.domain.Reply;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ReplyResponseDto {
    private Long replyId;
    private Long memberId;
    private Long timetableId;
    private String content;
    private boolean nameHide;
    private String replyName;
    private LocalDateTime createdAt;
    private boolean heart;
    private Integer replyLikeCount;

    public static ReplyResponseDto of (Reply reply){
        return ReplyResponseDto.builder()
                .replyId(reply.getReplyId())
                .timetableId(reply.getTimetable().getTimetableId())
                .memberId(reply.getWriter().getMemberId())
                .content(reply.getContent())
                .nameHide(reply.isNameHide())
                .replyName(reply.getReplyName())
                .replyName(reply.getReplyName())
                .createdAt(reply.getCreatedAt())
                .heart(reply.isHeart())
                .replyLikeCount(reply.getReplyLikeCount())
                .build();
    }
}
