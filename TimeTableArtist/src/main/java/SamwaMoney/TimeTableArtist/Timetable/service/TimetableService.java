package SamwaMoney.TimeTableArtist.Timetable.service;

import SamwaMoney.TimeTableArtist.Member.domain.Member;
import SamwaMoney.TimeTableArtist.Member.repository.MemberRepository;
import SamwaMoney.TimeTableArtist.Timetable.domain.Timetable;
import SamwaMoney.TimeTableArtist.Timetable.dto.TimetableRequestDto;
import SamwaMoney.TimeTableArtist.Timetable.repository.TimetableRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class TimetableService {

    private final TimetableRepository timetableRepository;
    private final MemberRepository memberRepository;

//    private final TimetableService timetableService;
//    private final MemberService memberService;

    // 시간표 생성 -> !수업 객체와 연결 필요! -> !알고리즘 계산 결과 도출되는 코멘트 유형 연결 필요!
    public Timetable createTimetable(TimetableRequestDto requestDto) {
        Member owner = memberRepository.findById(requestDto.getMemberId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 계정입니다."));

        return timetableRepository.save(
                Timetable.builder()
                        .owner(owner)
                        .build()
        );
    }

    // 시간표 삭제 (초기화)
    public void removeTimetable(Long timetableId, Long memberId) {
        Timetable timetable = timetableRepository.findByTimetableAndOwner(timetableId, memberId)
                .orElseThrow(() -> new IllegalArgumentException("잘못된 접근입니다."));
        timetableRepository.delete(timetable);
    }

//    // 시간표 삭제 (초기화)
//    public void removeTimetable(Long timetableId, Long memberId) {
//        Timetable timetable = timetableService.findTimetableById(timetableId);
//        Member member = memberService.findMemberById(memberId);
//
//        Timetable timetableAuthorized = timetableRepository.findByTimetableAndOwner(timetable, member)
//                .orElseThrow(() -> new IllegalArgumentException("잘못된 접근입니다."));
//        timetableRepository.delete(timetableAuthorized);
//    }

//    // ID를 기준으로 Timetable 정보 찾기
//    @Transactional(readOnly = true)
//    public Timetable findTimetableById(Long id) {
//        return timetableRepository.findById(id)
//                .orElseThrow(() -> new EntityNotFoundException("ID가 " + id + "인 회원이 존재하지 않습니다!"));
//    }


}
