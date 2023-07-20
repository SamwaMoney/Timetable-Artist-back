package SamwaMoney.TimeTableArtist.Timetable.dto;

import SamwaMoney.TimeTableArtist.Reply.domain.Reply;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class TimetableRepliesResponseDto {
    private Long timetableId;
    private List<TimetableReply> replies;

    public static TimetableRepliesResponseDto of(Long timetableId, List<Reply> replyList){
        return TimetableRepliesResponseDto.builder()
                .timetableId(timetableId)
                .replies(replyList.stream().map(TimetableReply::of).collect(Collectors.toList()))
                .build();
    }

    @Getter
    public static class TimetableReply{
        private Long replyId;
        private Long timetableId;
        private Long memberId;
        private String content;
        private LocalDateTime createdAt;

        public TimetableReply(Reply reply){
            this.replyId = reply.getReplyId();
            this.timetableId = reply.getTimetable().getTimetableId();
            this.memberId = reply.getWriter().getMemberId();
            this.content = reply.getContent();
            this.createdAt = reply.getCreatedAt();
        }

        public static TimetableReply of(Reply reply){
            return new TimetableReply(reply);
        }
    }
}
