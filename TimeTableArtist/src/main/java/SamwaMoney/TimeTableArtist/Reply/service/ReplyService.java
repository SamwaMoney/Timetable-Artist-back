package SamwaMoney.TimeTableArtist.Reply.service;

import SamwaMoney.TimeTableArtist.Member.domain.Member;
import SamwaMoney.TimeTableArtist.Member.service.MemberService;
import SamwaMoney.TimeTableArtist.Reply.domain.Reply;
import SamwaMoney.TimeTableArtist.Reply.dto.ReplyRequestDto;
import SamwaMoney.TimeTableArtist.Reply.repository.ReplyRepository;
import SamwaMoney.TimeTableArtist.Timetable.domain.Timetable;
import SamwaMoney.TimeTableArtist.Timetable.service.TimetableService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
@AllArgsConstructor
public class ReplyService {
    private final ReplyRepository replyRepository;
    private final MemberService memberService;

    @Autowired
    @Lazy
    private TimetableService timetableService;

    public Long createReply(Long timetableId, ReplyRequestDto requestDto) {
        Timetable timetable = timetableService.findTimetableById(timetableId);
        Member writer = memberService.findMemberById(requestDto.getMemberId());
        boolean nameHide = requestDto.isNameHide();
        String name = writer.getUsername();
        String replyName = selectName(nameHide, name);
        boolean isHeart = false;
        Integer replyLikeCount = 0;
        timetable.setReplyCount(timetable.getReplyCount() + 1);
        return replyRepository.save(requestDto.toEntity(timetable, writer, replyName, isHeart, replyLikeCount)).getReplyId();
    }

    // 익명 설정 여부에 따라 해당 댓글의 작성자 익명 표시
    public static String selectName(boolean hide, String username){
        if (hide){
            return "익명";
        }
        else {
            return username;
        }
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

    public String removeReply(Long memberId, Long replyId){
        Reply reply = findReplyById(replyId);
        if (Objects.equals(reply.getWriter().getMemberId(), memberId)){
            replyRepository.delete(reply);
            Timetable timetable = findReplyById(replyId).getTimetable();
            timetable.setReplyCount(timetable.getReplyCount() - 1);
            return "댓글이 삭제되었습니다.";
        }
        else {
            return "해당 댓글을 삭제할 권한이 없습니다.";
        }
    }
}

