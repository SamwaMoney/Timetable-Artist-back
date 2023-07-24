package SamwaMoney.TimeTableArtist.Timetable.service;

import SamwaMoney.TimeTableArtist.Class.domain.Class;
import SamwaMoney.TimeTableArtist.Class.dto.ClassDto;
import SamwaMoney.TimeTableArtist.Class.dto.ClassListDto;
import SamwaMoney.TimeTableArtist.Class.dto.MoveDto;
import SamwaMoney.TimeTableArtist.Class.repository.ClassRepository;
import SamwaMoney.TimeTableArtist.Comment.Service.CommentService;
import SamwaMoney.TimeTableArtist.Comment.repository.SpecialCommentRepository;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static SamwaMoney.TimeTableArtist.utils.TimetableUtil.makeMoveDifficulties;

@Service
@Transactional
@RequiredArgsConstructor
public class TimetableService {

    private final TimetableRepository timetableRepository;
    private final MemberRepository memberRepository;
    private final TableLikeService tableLikeService;
    private final ClassRepository classRepository;
    private final CommentService commentService;
    private final SpecialCommentRepository specialCommentRepository;
    private final WeekdayAlgoService weekdayAlgoService;
    private final TableTypeAlgoService tableTypeAlgoService;
    private final Map<List<String>, MoveDto> moveDifficultyMap = makeMoveDifficulties();

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
            long likeCount = tableLikeService.getLikeCount(timetable.getTimetableId());
            String tableType = "";
            String tableImg = "";
            responseList.add(TimetableResponseWithLikeDto.from(timetable, isLiked, tableType, tableImg, likeCount));
        }

        return responseList;
    }

    public ClassListDto scoreTimetable(Long timetableId) {
        Timetable timetable = timetableRepository.findById(timetableId)
                .orElseThrow(() -> new EntityNotFoundException("해당 시간표를 찾을 수 없습니다: " + timetableId));

        List<Class> classList = classRepository.findAllByTimetableTimetableId(timetableId);
        List<ClassDto> classDtoList = convertToClassDtoList(classList); // ClassDto 리스트로 변환


        // 요일별로 분류하여 저장할 리스트들 초기화
        List<ClassDto> monday = new ArrayList<>();
        List<ClassDto> tuesday = new ArrayList<>();
        List<ClassDto> wednesday = new ArrayList<>();
        List<ClassDto> thursday = new ArrayList<>();
        List<ClassDto> friday = new ArrayList<>();

        // 요일별로 분류하여 리스트에 추가
        for (ClassDto classDto : classDtoList) {
            switch (classDto.getWeekday()) {
                case MON:
                    monday.add(classDto);
                    break;
                case TUE:
                    tuesday.add(classDto);
                    break;
                case WED:
                    wednesday.add(classDto);
                    break;
                case THU:
                    thursday.add(classDto);
                    break;
                case FRI:
                    friday.add(classDto);
                    break;
                default:
                    break;
            }
        }

        System.out.println("월요일 강의 목록: " + monday);
        System.out.println("화요일 강의 목록: " + tuesday);
        System.out.println("수요일 강의 목록: " + wednesday);
        System.out.println("목요일 강의 목록: " + thursday);
        System.out.println("금요일 강의 목록: " + friday);

        // ClassListDto에 데이터 저장
        ClassListDto classListDto = new ClassListDto();
        classListDto.setClassListId(timetableId);
        classListDto.setClassList(classDtoList);
        classListDto.setMonday(monday);
        classListDto.setTuesday(tuesday);
        classListDto.setWednesday(wednesday);
        classListDto.setThursday(thursday);
        classListDto.setFriday(friday);

        System.out.println("금요일 강의 목록: " + friday);

        ArrayList<Integer> plusCommentIds = commentService.getAllPlusCommentIds();
        ArrayList<Integer> minusCommentIds = commentService.getAllMinusCommentIds();
        ArrayList<Integer> specialCommentIds = commentService.getAllSpecialCommentIds();

        int score;
        int score1 = AllClassAlgoService.allClassAlgo(classListDto, plusCommentIds, minusCommentIds, specialCommentIds);
        int score2 = weekdayAlgoService.weekdayAlgo(classListDto, moveDifficultyMap, plusCommentIds, minusCommentIds, specialCommentIds);
        score = 60 + score1 + score2;
        if (score < 0) {
            score = 0;
        } else if (score > 100) {
            score = 100;
        }

        int tableTypeCommentId = tableTypeAlgoService.tableTypeAlgo(specialCommentRepository.getAllIds());

        // 시간표 엔티티의 score와 tableType 필드를 업데이트
        timetable.setScore((long) score);
        timetable.setTableType((long) tableTypeCommentId);

        timetableRepository.save(timetable);

        return classListDto;
    }

    // classDto -> classListDto로 변환
    private List<ClassDto> convertToClassDtoList(List<Class> classList) {
        return classList.stream()
                .map(ClassDto::from)
                .collect(Collectors.toList());
    }
}
