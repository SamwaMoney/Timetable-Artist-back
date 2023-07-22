package SamwaMoney.TimeTableArtist.Timetable.service;

import SamwaMoney.TimeTableArtist.Class.domain.Class;
import SamwaMoney.TimeTableArtist.Class.dto.ClassDto;
import SamwaMoney.TimeTableArtist.Member.domain.Member;
import SamwaMoney.TimeTableArtist.Member.repository.MemberRepository;
import SamwaMoney.TimeTableArtist.Member.service.MemberService;
import SamwaMoney.TimeTableArtist.Timetable.domain.Timetable;
import SamwaMoney.TimeTableArtist.Timetable.dto.TimetableFindResponseDto;
import SamwaMoney.TimeTableArtist.Timetable.dto.TimetableRequestDto;
import SamwaMoney.TimeTableArtist.Timetable.repository.TimetableRepository;
import SamwaMoney.TimeTableArtist.tablecommentmap.domain.TablePlusComment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class TimetableService {

    private final TimetableRepository timetableRepository;
    private final MemberRepository memberRepository;

    private final MemberService memberService;

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
}

    // 내 시간표 조회
    public List<Class> findClassListByTimetableId(Long timetableId) {
        return timetableRepository.findAllByTimetableId(timetableId);
    }

    // 시간표 ID로 시간표를 찾기
    public TimetableFindResponseDto findTimetableById(Long timetableId) {
        Timetable timetable = timetableRepository.findById(timetableId)
                .orElseThrow(() -> new IllegalArgumentException("시간표를 찾을 수 없습니다. 시간표 ID: " + timetableId));

        List<Class> classList = timetable.getClassList(); // 해당 시간표에 속한 수업들을 가져옴
        TimetableFindResponseDto responseDto = TimetableFindResponseDto.from(timetable, classList); // 시간표와 수업 리스트를 TimetableFindResponseDto로 변환
        return responseDto;
    }

    // 수업 리스트를 ClassDto 리스트로 변환하는 메서드
    private List<ClassDto> convertClassListToClassDtoList(List<Class> classList) {
        return classList.stream()
                .map(ClassDto::from)
                .collect(Collectors.toList());
    }
}
