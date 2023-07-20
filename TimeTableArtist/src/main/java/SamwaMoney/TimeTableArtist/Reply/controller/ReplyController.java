package SamwaMoney.TimeTableArtist.Reply.controller;

import SamwaMoney.TimeTableArtist.Member.domain.Member;
import SamwaMoney.TimeTableArtist.Reply.domain.Reply;
import SamwaMoney.TimeTableArtist.Reply.dto.ReplyRequestDto;
import SamwaMoney.TimeTableArtist.Reply.dto.ReplyResponseDto;
import SamwaMoney.TimeTableArtist.Reply.service.ReplyService;
import SamwaMoney.TimeTableArtist.Timetable.dto.TimetableRepliesResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReplyController {
    private final ReplyService replyService;

    // 특정 시간표의 댓글 생성
    @PostMapping("/timetables/{timetableId}/replies")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ReplyResponseDto createTimetableReply(@AuthenticationPrincipal Member member, @PathVariable Long timetableId, @RequestBody @Valid ReplyRequestDto requestDto){
        Long replyId = replyService.createReply(member.getMemberId(), timetableId, requestDto);
        Reply reply = replyService.findReplyById(replyId);
        return ReplyResponseDto.of(reply);
    }

    //특정 시간표 댓글 목록 조회
    @GetMapping("/timetables/{timetableId}/replies")
    @ResponseStatus(code = HttpStatus.OK)
    public TimetableRepliesResponseDto readTimetableReplies(@PathVariable Long timetableId){
        List<Reply> replyList = replyService.findReplyListByTimetable(timetableId);
        return TimetableRepliesResponseDto.of(timetableId, replyList);
    }

    //댓글 삭제
    @DeleteMapping("replies/{replyId}")
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<?> removeReply(@AuthenticationPrincipal Member member, @PathVariable Long replyId){
        String response = replyService.removeReply(member, replyId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
