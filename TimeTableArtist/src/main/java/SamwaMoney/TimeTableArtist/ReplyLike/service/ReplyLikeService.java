package SamwaMoney.TimeTableArtist.ReplyLike.service;

import SamwaMoney.TimeTableArtist.Member.domain.Member;
import SamwaMoney.TimeTableArtist.Member.service.MemberService;
import SamwaMoney.TimeTableArtist.Reply.domain.Reply;
import SamwaMoney.TimeTableArtist.Reply.service.ReplyService;
import SamwaMoney.TimeTableArtist.ReplyLike.domain.ReplyLike;
import SamwaMoney.TimeTableArtist.ReplyLike.repository.ReplyLikeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class ReplyLikeService {
    private final ReplyLikeRepository replyLikeRepository;
    private final ReplyService replyService;
    private final MemberService memberService;

    public void create(Long replyId, Long memberId){
        Reply reply = replyService.findReplyById(replyId);
        Member owner = memberService.findMemberById(memberId);

        ReplyLike replyLike = ReplyLike.builder()
                .reply(reply)
                .owner(owner)
                .build();

        replyLikeRepository.save(replyLike);

        Integer replyLikeCount = getReplyLikeCount(reply);
        reply.updateLikeCount(replyLikeCount);

        boolean like = isHeart(memberId, reply);
        reply.updateHeart(like);
    }

    public void delete(Long replyId, Long memberId) {
        Reply reply = replyService.findReplyById(replyId);
        Member owner = memberService.findMemberById(memberId);

        ReplyLike replyLike = replyLikeRepository.findByOwnerAndReply(owner, reply)
                .orElseThrow(() -> new RuntimeException("좋아요가 존재하지 않습니다."));
        replyLikeRepository.delete(replyLike);

        Integer replyLikeCount = getReplyLikeCount(reply);
        reply.updateLikeCount(replyLikeCount);

        boolean heart = isHeart(memberId, reply);
        reply.updateHeart(heart);
    }

    public boolean isHeart(Long memberId, Reply reply){
        Member member = memberService.findMemberById(memberId);
        return isExistsByOwnerAndReply(member, reply);
    }

    @Transactional(readOnly = true)
    public boolean isExistsByOwnerAndReply(Member member, Reply reply){
        return replyLikeRepository.existsByOwnerAndReply(member, reply);
    }

    @Transactional (readOnly = true)
    public Integer getReplyLikeCount(Reply reply) {
        Integer replylikeCount = replyLikeRepository.countByReply(reply);
        return replylikeCount;
    }
}
