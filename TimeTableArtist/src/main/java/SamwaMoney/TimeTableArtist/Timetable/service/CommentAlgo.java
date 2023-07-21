package SamwaMoney.TimeTableArtist.Timetable.service;

import SamwaMoney.TimeTableArtist.Comment.entity.SpecialComment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;

public class CommentAlgo {
    // 특정 시간표의 스페셜 코멘트 아이디 리스트를 받아와서, DB를 참고하여 우선순위대로 정렬 후, 가장 우선순위가 높은 것의 ID를 리턴
    public static int tableTypeAlgo (ArrayList<Integer> special, Map<Long, SpecialComment> db) {
        // Comparator 내부 메소드 오버라이딩을 통해 정렬 방식 정의
        Comparator<Integer> cp = new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                // DB에서 읽어온 우선순위를 기준으로 내림차순 정렬
                SpecialComment s1 = db.get(Long.valueOf(i1));
                SpecialComment s2 = db.get(Long.valueOf(i2));
                if(s1.priority>s2.priority) return 1;
                else return -1;
            }
        };

        // 정의한 정렬 방식대로 special 리스트를 정렬
        Collections.sort(special, cp);
        // 정렬이 잘 되었는지 프린트해보기
        System.out.println("우선순위를 기준으로 정렬된 special 코멘트 리스트: " + special);

        // 가장 우선순위가 높은 하나의 코멘트의 ID를 리턴
        return special.get(0);
    }
}
