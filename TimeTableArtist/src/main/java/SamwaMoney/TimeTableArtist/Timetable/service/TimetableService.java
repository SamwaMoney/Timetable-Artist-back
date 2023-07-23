package SamwaMoney.TimeTableArtist.Timetable.service;

import SamwaMoney.TimeTableArtist.Class.domain.Class;
import SamwaMoney.TimeTableArtist.Class.dto.ClassDto;
import SamwaMoney.TimeTableArtist.Class.service.ClassService;
import SamwaMoney.TimeTableArtist.Member.domain.Member;
import SamwaMoney.TimeTableArtist.Member.repository.MemberRepository;
import SamwaMoney.TimeTableArtist.Member.service.MemberService;
import SamwaMoney.TimeTableArtist.Timetable.domain.Timetable;
import SamwaMoney.TimeTableArtist.Timetable.dto.TimetableFullResponseDto;
import SamwaMoney.TimeTableArtist.Timetable.dto.TimetableRequestDto;
import SamwaMoney.TimeTableArtist.Timetable.repository.TimetableRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TimetableService {

    private final TimetableRepository timetableRepository;
    private final MemberRepository memberRepository;
    private final ClassService classService;

    // 시간표 생성
    public Timetable createTimetable(TimetableRequestDto requestDto) {
        Member owner = memberRepository.findById(requestDto.getMemberId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 계정입니다."));

        return timetableRepository.save(
                new Timetable(owner)
        );
    }

    // 시간표 삭제 (초기화)
    public void removeTimetable(Long timetableId, Long memberId) {
        Timetable timetable = timetableRepository.findByTimetableIdAndOwner(timetableId, memberId)
                .orElseThrow(() -> new IllegalArgumentException("잘못된 접근입니다."));
        timetableRepository.delete(timetable);
    }

    // ID를 기준으로 시간표 데이터를 찾아오는 메소드
    // reply 및 showTimetable 메소드에서 사용
    @Transactional(readOnly = true)
    public Timetable findTimetableById(Long timetableId){
        return timetableRepository.findById(timetableId)
                .orElseThrow(()->new EntityNotFoundException("해당 시간표가 존재하지 않습니다."));
    }

    // 내 시간표 조회에 사용
    public TimetableFullResponseDto showTimetable(Long timetableId) {
        // timetableId를 기준으로 Timetable 하나 찾아오기
        Timetable timetable = findTimetableById(timetableId);

        // timetableId를 기준으로, 이 시간표에 속한 모든 수업들의 정보를 담은 DTO 리스트 받아오기
        List<ClassDto> classList = classService.findClassesByTimetableId(timetableId);

        // 찾아온 데이터를 DTO에 넣어 리턴
        return TimetableFullResponseDto.builder()
                .memberId(timetable.getOwner().getMemberId())
                .timetableId(timetable.getTimetableId())
                .createdAt(timetable.getCreatedAt())
                .classList(classList)
                .build();
    }
}
