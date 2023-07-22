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

    public Long createReply(Long timetableId, ReplyRequestDto requestDto) {
        Timetable timetable = timetableService.findTimetableById(timetableId);
        Member writer = memberService.findMemberById(requestDto.getMemberId());
        boolean isHeart = false;
        Integer replyLikeCount = 0;
        return replyRepository.save(requestDto.toEntity(timetable, writer, isHeart, replyLikeCount)).getReplyId();
    }

    @Transactional(readOnly = true)
    public List<Reply> findReplyListByTimetable(Long timetableId){
        Timetable timetable = timetableService.findTimetableById(timetableId);
        return replyRepository.findAllByTimetableOrderByReplyLikeCountDesc(timetable);
    }

    @Transactional(readOnly = true)
    public Reply findReplyById(Long replyId){
        return replyRepository.findById(replyId)
                .orElseThrow(()->new EntityNotFoundException("해당 댓글이 존재하지 않습니다."));
    }

    public void removeReply(Long replyId){
        Reply reply = findReplyById(replyId);
        replyRepository.delete(reply);
    }
}

