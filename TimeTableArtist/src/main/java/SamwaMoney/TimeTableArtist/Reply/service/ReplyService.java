package SamwaMoney.TimeTableArtist.Reply.service;

import SamwaMoney.TimeTableArtist.Member.domain.Member;
import SamwaMoney.TimeTableArtist.Member.service.MemberService;
import SamwaMoney.TimeTableArtist.Reply.domain.Reply;
import SamwaMoney.TimeTableArtist.Reply.dto.ReplyRequestDto;
import SamwaMoney.TimeTableArtist.Reply.repository.ReplyRepository;
import SamwaMoney.TimeTableArtist.Timetable.domain.Timetable;
import SamwaMoney.TimeTableArtist.Timetable.service.TimetableService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class ReplyService {
    private final ReplyRepository replyRepository;
    private final TimetableService timetableService;
    private final MemberService memberService;

    public Long createReply(Long memberId, Long timetableId, ReplyRequestDto requestDto) {
        Member writer = memberService.findMemberById(memberId);
        Timetable timetable = timetableService.findTimetableById(timetableId);
        return replyRepository.save(requestDto.toEntity(timetable, writer)).getReplyId();
    }

    @Transactional(readOnly = true)
    public List<Reply> findReplyListByTimetable(Long timetableId){
        Timetable timetable = timetableService.findTimetableById(timetableId);
        return replyRepository.findAllByTimetable(timetable);
    }

    //replylike 구현 이후 완성할 부분
    //@Transactional l(readOnly = true)
    //public int getReviewCount(Long storeId) {
    //    int replylikeCount = replylikeRepository.countByStoreStoreId(storeId);
    //    return reviewCount;
    //}

    @Transactional(readOnly = true)
    public Reply findReplyById(Long replyId){
        return replyRepository.findById(replyId)
                .orElseThrow(()->new EntityNotFoundException("해당 댓글이 존재하지 않습니다."));
    }

    public String removeReply(Member member, Long replyId){
        Reply reply = replyRepository.findById(replyId).orElseThrow(()->new IllegalArgumentException("해당 댓글이 존재하지 않습니다."));
        replyRepository.delete(reply);
        return "해당 댓글이 삭제되었습니다.";
    }
}