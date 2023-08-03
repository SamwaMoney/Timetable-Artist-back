package SamwaMoney.TimeTableArtist.Reply.controller;

import SamwaMoney.TimeTableArtist.Reply.domain.Reply;
import SamwaMoney.TimeTableArtist.Reply.dto.ReplyRequestDto;
import SamwaMoney.TimeTableArtist.Reply.dto.ReplyResponseDto;
import SamwaMoney.TimeTableArtist.Reply.service.ReplyService;
import SamwaMoney.TimeTableArtist.ReplyLike.service.ReplyLikeService;
import SamwaMoney.TimeTableArtist.Timetable.dto.TimetableRepliesResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReplyController {
    private final ReplyService replyService;
    private final ReplyLikeService replyLikeService;

    // 특정 시간표의 댓글 생성
    @PostMapping("/timetables/{timetableId}/replies")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ReplyResponseDto createTimetableReply(@PathVariable Long timetableId, @RequestBody @Valid ReplyRequestDto requestDto) {
        Long replyId = replyService.createReply(timetableId, requestDto);
        Reply reply = replyService.findReplyById(replyId);
        return ReplyResponseDto.of(reply);
    }

    // 특정 시간표 댓글 목록 조회
    @GetMapping("/timetables/{timetableId}/replies")
    @ResponseStatus(code = HttpStatus.OK)
    public TimetableRepliesResponseDto readTimetableReplies(@PathVariable Long timetableId, @RequestParam(value = "memberId") Long memberId){
        List<Reply> replyList = replyService.findReplyListByTimetable(timetableId);
        if (memberId != null){
            for (Reply reply : replyList)
            {
                reply.heart = replyLikeService.isHeart(memberId, reply);
            }
        }
        else {
            for (Reply reply : replyList)
            {
                reply.heart = false;
            }
        }

        return TimetableRepliesResponseDto.of(timetableId, replyList);
    }

    // 댓글 삭제
    @DeleteMapping("replies/{memberId}/{replyId}")
    @ResponseStatus(value = HttpStatus.OK)
    public String removeReply(@PathVariable Long memberId, @PathVariable Long replyId) {
        String notice = replyService.removeReply(memberId, replyId);
        return notice;
    }
}