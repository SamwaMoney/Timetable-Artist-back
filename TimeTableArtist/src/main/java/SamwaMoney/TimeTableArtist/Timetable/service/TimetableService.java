package SamwaMoney.TimeTableArtist.Timetable.service;

import SamwaMoney.TimeTableArtist.Member.domain.Member;
import SamwaMoney.TimeTableArtist.Member.repository.MemberRepository;
import SamwaMoney.TimeTableArtist.Member.service.MemberService;
import SamwaMoney.TimeTableArtist.TableLike.service.TableLikeService;
import SamwaMoney.TimeTableArtist.Timetable.domain.Timetable;
import SamwaMoney.TimeTableArtist.Timetable.dto.TimetableRequestDto;
import SamwaMoney.TimeTableArtist.Timetable.dto.TimetableResponseWithLikeDto;
import SamwaMoney.TimeTableArtist.Timetable.repository.TimetableRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TimetableService {

    private final TimetableRepository timetableRepository;
    private final MemberRepository memberRepository;
    private final TableLikeService tableLikeService;

    // 시간표 생성
    public Timetable createTimetable(TimetableRequestDto requestDto) {
        Member owner = memberRepository.findById(requestDto.getMemberId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 계정입니다."));

        return timetableRepository.save(
                Timetable.builder()
                        .owner(owner)
                        .classList(null)
                        .build()
        );
    }

    // 시간표 삭제 (초기화)
    public void removeTimetable(Long timetableId, Long memberId) {
        Timetable timetable = timetableRepository.findByTimetableIdAndOwner(timetableId, memberId)
                .orElseThrow(() -> new IllegalArgumentException("잘못된 접근입니다."));
        timetableRepository.delete(timetable);
    }

    //reply에서 사용
    @Transactional(readOnly = true)
    public Timetable findTimetableById(Long timetableId){
        return timetableRepository.findById(timetableId)
                .orElseThrow(()->new EntityNotFoundException("해당 시간표가 존재하지 않습니다."));
    }

    // 전체 시간표 조회 (사용자가 좋아요한 시간표 포함)
    @Transactional(readOnly = true)
    public List<TimetableResponseWithLikeDto> getAllTimetablesWithLikeStatus(Long memberId) {
        List<Timetable> allTimetables = timetableRepository.findAll();

        List<TimetableResponseWithLikeDto> responseList = new ArrayList<>();
        for (Timetable timetable : allTimetables) {
            boolean isLiked = tableLikeService.isTimetableLikedByMember(timetable.getTimetableId(), memberId);
            String tableType = "";
            String tableImg = "";
            responseList.add(TimetableResponseWithLikeDto.from(timetable, isLiked, tableType, tableImg));
        }

        return responseList;
    }
}
