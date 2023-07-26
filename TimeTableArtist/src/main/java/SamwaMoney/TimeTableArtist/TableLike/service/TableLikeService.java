package SamwaMoney.TimeTableArtist.TableLike.service;

import SamwaMoney.TimeTableArtist.Member.domain.Member;
import SamwaMoney.TimeTableArtist.Member.repository.MemberRepository;
import SamwaMoney.TimeTableArtist.Member.service.MemberService;
import SamwaMoney.TimeTableArtist.TableLike.domain.TableLike;
import SamwaMoney.TimeTableArtist.TableLike.repository.TableLikeRepository;
import SamwaMoney.TimeTableArtist.Timetable.domain.Timetable;
import SamwaMoney.TimeTableArtist.Timetable.repository.TimetableRepository;
import SamwaMoney.TimeTableArtist.Timetable.service.TimetableService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class TableLikeService {
    private final MemberService memberService;
    private final TableLikeRepository tableLikeRepository;
    @Autowired
    @Lazy
    private TimetableService timetableService;

    // 좋아요 생성
    public void createTableLike(Long timetableId, Long memberId) {
        Timetable timetable = timetableService.findTimetableById(timetableId);
        Member owner = memberService.findMemberById(memberId);

        if (isExistsByOwnerAndTimetable(owner, timetable)) {
            throw new RuntimeException("이미 좋아요를 누른 게시물입니다.");
        }

        TableLike tableLike = TableLike.builder()
                .timetable(timetable)
                .owner(owner)
                .build();

        tableLikeRepository.save(tableLike);
        incrementLikeCount(timetable); // 좋아요 개수 증가
    }

    // 좋아요 삭제
    public void deleteTableLike(Long timetableId, Long memberId) {
        Timetable timetable = timetableService.findTimetableById(timetableId);
        Member owner = memberService.findMemberById(memberId);
        TableLike tableLike = tableLikeRepository.findByOwnerAndTimetable(owner, timetable)
                .orElseThrow(() -> new RuntimeException("좋아요가 존재하지 않습니다."));

        tableLikeRepository.delete(tableLike);
        decrementLikeCount(timetable); // 좋아요 개수 감소
    }

    // 사용자가 시간표를 좋아요했는지 확인
    @Transactional(readOnly = true)
    public boolean isTimetableLikedByMember(Long timetableId, Long memberId) {
        if (memberId == null) {
            return false;
        }
        Timetable timetable = timetableService.findTimetableById(timetableId);
        Member member = memberService.findMemberById(memberId);
        return tableLikeRepository.existsByOwnerAndTimetable(member, timetable);
    }

    @Transactional(readOnly = true)
    public boolean isExistsByOwnerAndTimetable(Member owner, Timetable timetable) {
        return tableLikeRepository.existsByOwnerAndTimetable(owner, timetable);
    }

    // 좋아요 추가시 좋아요 개수 증가
    private void incrementLikeCount(Timetable timetable) {
        timetable.setLikeCount(timetable.getLikeCount() + 1);
    }

    // 좋아요 삭제시 좋아요 개수 감소
    private void decrementLikeCount(Timetable timetable) {
        timetable.setLikeCount(timetable.getLikeCount() - 1);
    }

    // 좋아요 개수 조회
    @Transactional(readOnly = true)
    public long getLikeCount(Long timetableId) {
        Timetable timetable = timetableService.findTimetableById(timetableId);
        return timetable.getLikeCount();
    }
}
