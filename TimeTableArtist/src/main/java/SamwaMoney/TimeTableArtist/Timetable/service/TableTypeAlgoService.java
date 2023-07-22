package SamwaMoney.TimeTableArtist.Timetable.service;

import SamwaMoney.TimeTableArtist.Comment.entity.SpecialComment;
import SamwaMoney.TimeTableArtist.Comment.repository.SpecialCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TableTypeAlgoService {
    private final SpecialCommentRepository specialCommentRepository;

    @Autowired
    public TableTypeAlgoService(SpecialCommentRepository specialCommentRepository) {
        this.specialCommentRepository = specialCommentRepository;
    }

    // 특정 시간표의 스페셜 코멘트 아이디 리스트를 받아와서, DB를 참고하여 우선순위대로 정렬 후, 가장 우선순위가 높은 것의 ID를 리턴
    public int tableTypeAlgo(List<Long> special) {
        // Comparator 내부 메소드 오버라이딩을 통해 정렬 방식 정의
        Comparator<Long> cp = new Comparator<Long>() {
            @Override
            public int compare(Long i1, Long i2) {
                // DB에서 읽어온 우선순위를 기준으로 내림차순 정렬
                SpecialComment s1 = specialCommentRepository.findById(Long.valueOf(i1)).orElse(null);
                SpecialComment s2 = specialCommentRepository.findById(Long.valueOf(i2)).orElse(null);
                if (s1 != null && s2 != null) {
                    if (s1.getPriority() > s2.getPriority()) return 1;
                    else return -1;
                }
                return 0;
            }
        };

        // 정의한 정렬 방식대로 special 리스트를 정렬
        Collections.sort(special, cp);
        // 정렬이 잘 되었는지 프린트해보기
        System.out.println("우선순위를 기준으로 정렬된 special 코멘트 리스트: " + special);

        // 가장 우선순위가 높은 하나의 코멘트의 ID를 리턴
        if (!special.isEmpty()) {
            return special.get(0).intValue();
        }
        return -1; // 혹시나 빈 리스트라면 -1을 리턴
    }
}