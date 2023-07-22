package SamwaMoney.TimeTableArtist.ReplyLike.controller;

import SamwaMoney.TimeTableArtist.ReplyLike.dto.ReplyLikeRequestDto;
import SamwaMoney.TimeTableArtist.ReplyLike.service.ReplyLikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/{replyId}/likes")
@RequiredArgsConstructor
public class ReplyLikeController {
    private final ReplyLikeService replyLikeService;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public String createReplyLike(@PathVariable Long replyId, @RequestBody ReplyLikeRequestDto requestDto){
        Long memberId = requestDto.getMemberId();
        replyLikeService.create(replyId, memberId);
        return "좋아요를 눌렀습니다.";
    }

    @DeleteMapping
    @ResponseStatus(value = HttpStatus.OK)
    public String deleteReplyLike(@PathVariable Long replyId, @RequestBody ReplyLikeRequestDto requestDto){
        Long memberId = requestDto.getMemberId();
        replyLikeService.delete(replyId, memberId);
        return "좋아요가 취소되었습니다.";
    }

}
