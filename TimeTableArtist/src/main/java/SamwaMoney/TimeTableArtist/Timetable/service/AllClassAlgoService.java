package SamwaMoney.TimeTableArtist.Timetable.service;

import SamwaMoney.TimeTableArtist.Class.dto.ClassListDto;
import SamwaMoney.TimeTableArtist.Class.dto.ClassDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AllClassAlgoService {
    private final TimetableService timetableService;

    @Autowired
    public AllClassAlgoService(TimetableService timetableService) {
        this.timetableService = timetableService;
    }

    // 전체 과목 개수 count
    // 수업 7개 미만: 수업 하나당 +1, 원격 비대면일 경우 +7
    public static Map<String, ArrayList<Long>> allClassAlgo(ClassListDto t) {
        // 결과를 담을 해시맵 초기화
        Map<String, ArrayList<Long>> result = new HashMap<>();
        result.put("score", new ArrayList<>()); // score 리스트에는 점수 값을 나타내는 정수 하나만 들어있음
        result.get("score").add(60L);    // 기본 점수인 60점으로 초기화
        result.put("good", new ArrayList<>());  // 좋은 코멘트의 아이디 리스트. 빈 리스트로 초기화
        result.put("bad", new ArrayList<>());   // 좋은 코멘트의 아이디 리스트. 빈 리스트로 초기화
        result.put("special", new ArrayList<>());   // 좋은 코멘트의 아이디 리스트. 빈 리스트로 초기화
        // good, bad, special 리스트에는 채점의 각 단계마다 해당되는 코멘트의 ID가 추가될 것임

        Set<String> allClasses = new HashSet<>(); // 모든 강의 리스트

        int score = 0;  // 채점 결과 기본 점수 60점에서 몇 점이 변동되어야 하는지 저장
        int allCount = 0; // 모든 강의의 수 저장
        int online = 0; // 원격/비대면 강의의 수 저장
        int totalTime = 0; // 전체 수업 시간 분 단위로 저장
        int allBlockCount = 0; // 전체 수업 블럭 수 저장 (90분 단위)
        int chapelCount = ChapelAlgo(t); // 전체 채플 수
        int locationCount = locationAlgo(t); // 전체 강의실 건물 수

        // DB에 저장된 모든 코멘트
        ArrayList<Integer> goodComments = new ArrayList<>();
        ArrayList<Integer> badComments = new ArrayList<>();
        ArrayList<Integer> specialComments = new ArrayList<>();

        for (ClassDto c : t.getClassList()) {
            if ("원격/비대면".equals(c.getLocation()))
                online++;

            allClasses.add(c.getClassName());

            Integer startH = c.getStartH() != null ? c.getStartH().intValue() : null;
            Integer endH = c.getEndH() != null ? c.getEndH().intValue() : null;
            Integer startM = c.getStartM() != null ? c.getStartM().intValue() : null;
            Integer endM = c.getEndM() != null ? c.getEndM().intValue() : null;

            if (startH != null && endH != null && startM != null && endM != null) {
                totalTime += (endH - startH) * 60 + (endM - startM);
            }
        }

        allBlockCount = totalTime / 90;
        System.out.println("총 수업시간은 " + totalTime + ", 총 블럭 수는 " + allBlockCount);

        allCount = allClasses.size();

        if (allCount <= 6){
            score += (allCount - online); // 수업 하나당 1점씩
        } else {
            score += (6 - online); // 수업이 77개 이상이라도 6개까지만 가점
        }
        score += (online * 3); // 원격/비대면 강의당 3점씩 가점
        System.out.println("강의 개수에 의한 가점은 " + score);

        if(allBlockCount <= 6) {
            result.get("special").add(0L); // special comment id 0 취미는 학교 다니기
            System.out.println(result.get("special"));
        }
        else if (allBlockCount >= 14) {
            result.get("special").add(1L); // special comment id 1 등록금 뿌린 대로 거두자
            System.out.println(result.get("special"));
        }
        if (online >= 3)
            result.get("special").add(2L); // special comment id 2 이화 사이버 대학교
        System.out.println(result.get("special"));
        if (online >= 2)
            result.get("good").add(10L); // good comment id 10 비대면 강의 있음
        System.out.println(result.get("special"));

        if (chapelCount >= 2)
            result.get("special").add(3L); // special comment id 3 하나님의 축복이 끝이 없네

        // 지금까지 계산된 점수 변동량을 HashMap에 반영
        Long now = result.get("score").get(0);
        result.get("score").set(0, now+score);


        // 이제 따로 함수로 정의된 채점 과정을 수행할 차례임
        // 함수의 매개변수로 result를 통째로 넘김으로써, 함수 종료 후에는 result 내의 모든 값이 업데이트되어 리턴되도록 함

        result = DayoffAlgo(t, result); // 공강 관련 가감점 및 코멘트 처리 함수
        result = FirstClassAlgo(t, result); // 1교시 관련 감점 및 코멘트 처리 함수

        // 모든 강의가 오후에 있는지 확인
        if (allAfternoonAlgo(t))
            result.get("special").add(4L); // special comment id 4 상여자 특) 점심 먹고 등교함

        // 채플을 제외한 모든 수업이 한 건물에서 진행되는지 확인
        if (locationCount == 1){
            result.get("good").add(11L); // good comment id 11 나는 한 건물만 판다
            result.get("special").add(13L); // special comment id 13 한 건물 지박령
        }
        // 건물의 종류가 4가지 이상인지 확인
        else if (locationCount >= 4){
            result.get("special").add(8L); // special comment id 8 동에 번쩍 서에 번쩍
        }

        System.out.println("과목의 개수가 " + allCount + "개이고, 원격/온라인 강의의 개수는 " + online +"개 이므로, 총 점수는 " + result.get("score").get(0));

        System.out.println("채점 결과는..." + result);

        return result;

    }
    // 공강 개수 count
    // 요일 공강 하나당 +10
    public static Map<String, ArrayList<Long>> DayoffAlgo(ClassListDto t, Map<String, ArrayList<Long>> result) {

        boolean[] dayOffs = new boolean[5]; // 월(0), 화(1), 수(2), 목(3), 금(4) 요일별로 공강 여부를 저장하는 배열
        int score = 0; // DayoffAlgo로 인해 변동되는 점수를 기록
        int dayOffCnt = 0;  // 공강인 날의 개수를 저장

        // mon
        if (t.getMonday().isEmpty()) {
            dayOffs[0] = true;
        }

        // tue
        if (t.getTuesday().isEmpty()) {
            dayOffs[1] = true;
        }

        // wed
        if (t.getWednesday().isEmpty()) {
            dayOffs[2] = true;
        }

        // thu
        if (t.getThursday().isEmpty()) {
            dayOffs[3] = true;
        }

        // fri
        if (t.getFriday().isEmpty()) {
            dayOffs[4] = true;
            result.get("good").add(7L); // good comment id 7 최고 인기 금공강!
        }

        // 공강인 날 개수 세기
        for (int i=0; i<5; i++){
            if(dayOffs[i] == true)
                dayOffCnt++;
        }

        // 공강인 날 하루마다 10점씩 가점
        score = dayOffCnt * 10;

        // 딱 하루만 공강인 경우, 요일에 따라 코멘트 부여
        if (dayOffCnt == 1){
            for (int i=0; i<5; i++){
                if(dayOffs[i] == true){
                    result.get("good").add(Long.valueOf(i)); // good comment id i 기분 좋은 _요일
                    break;
                }
            }
            // 이틀이 공강인 경우
        } else if (dayOffCnt == 2){
            result.get("good").add(5L); // good comment id 5 행복한 2공강
            // 사흥이 공강인 경우
        } else if (dayOffCnt == 3){
            result.get("good").add(6L); // good comment id 6 엄청난 3공강
            // 공강인 날이 없는 경우
        } else if (dayOffCnt == 0){
            result.get("bad").add(4L); // bad comment id 4 공강 1도 없어
        }

        // 확인용 출력문
        System.out.println("DayoffAlgo 채점 결과:");
        System.out.println("요일 공강의 개수가 " + dayOffCnt + "개 이므로, 공강에 의한 가점은 " + score);

        // 점수 변동량을 result의 점수 변수에 반영
        Long now = result.get("score").get(0);
        result.get("score").set(0, now+score);

        // 점수와 코멘트 내역이 업데이트된 result를 반환
        return result;
    }

    // 채플 개수 count
    public static int ChapelAlgo(ClassListDto t) {
        int chapel = 0; // 채플 개수 저장

        for (ClassDto c : t.getClassList()) {
            if (c.getClassName().equals("채플")) {
                chapel++;
            }
        }

        System.out.println("채플 수: " + chapel);

        return chapel;
    }

    // 원격/비대면 강의 개수 count
    public static int OnlineAlgo(ClassListDto t) {
        int online = 0; // 원격/비대면 강의 개수 저장

        for (ClassDto c : t.getClassList()) {
            if (c.getLocation().equals("원격/비대면")) {
                online++;
            }
        }

        System.out.println("원격/비대면 강의 수: " + online);

        return online;
    }

    // 오전(1, 2교시) 수업 개수 count
    public static int MorningClassAlgo(ClassListDto t) {
        int morningClass = 0; // 오전 수업 개수 저장

        for (ClassDto c : t.getClassList()) {
            if (c.getStartH() == 8 || c.getStartH() == 9) {
                morningClass++;
            }
        }

        System.out.println("1, 2교시 수업 수 " + morningClass);

        return morningClass;
    }


    // 1교시 수업 개수 count
    // 1교시 수업 유무: 1교시 수업 하나당 -3
    public static Map<String, ArrayList<Long>> FirstClassAlgo(ClassListDto t, Map<String, ArrayList<Long>> result) {
        int firstClass = 0; // 1교시 수업 개수 저장
        int score = 0; // FirestClassAlgo로 인해 변동되는 점수를 저장

        // 모든 수업 리스트를 탐색하며, 1교시 수업이 하나 발견될 때마다 firstClass를 1 증가시키고 점수를 3점 감점함
        for (ClassDto c : t.getClassList()) {
            Integer startH = c.getStartH() != null ? c.getStartH().intValue() : null;
            if (startH != null && startH == 8) {
                firstClass++;
                score -= 3;
            }
        }

        // 코멘트 반영
        if (firstClass == 0)
            result.get("good").add(8L); // good comment id 8 1교시 제로
        else if (firstClass >= 2)
            result.get("bad").add(1L); // bad comment id 1 오전부터 바빠요!

        // 확인용 출력문
        System.out.println("FirstClassAlgo 채점 결과:");
        System.out.println("1교시의 개수가 " + firstClass + "개 이므로, 1교시에 의한 감점은 " + score);

        // 점수 변동량을 result의 점수 변수에 반영
        Long now = result.get("score").get(0);
        result.get("score").set(0, now+score);

        // 점수와 코멘트 내역이 업데이트된 result를 반환
        return result;
    }

    // 강의 장소 수 세는 알고리즘
    public static int locationAlgo(ClassListDto t) {

        Set<String> locations = new HashSet<>(); // 강의 장소 저장
        int locationNum = 0; // 강의 장소의 수 저장

        // 대강당(채플 장소)를 제외한 서로 다른 건물의 종류 수를 카운트
        for (ClassDto c : t.getClassList()) {
            if (c.getClassName().equals("채플")) // 채플은 제외
                continue;
            else
                locations.add(c.getLocation());
        }

        locationNum = locations.size();
        System.out.println("건물 수: " + locationNum);

        return locationNum;
    }

    // 강의가 모두 오전인지 판별
    public static boolean allMorningAlgo(ClassListDto t) {
        for (ClassDto c : t.getClassList()) {
            if (c.getEndH() < 12) {
                continue;
            } else {
                System.out.println("강의 모두 오전 아님");
                return false;
            }
        }
        System.out.println("강의 모두 오전");
        return true;
    }

    // 강의가 모두 오후인지 판별
    public static boolean allAfternoonAlgo(ClassListDto t) {
        for (ClassDto c : t.getClassList()) {
            Long startH = c.getStartH();
            if (startH != null && startH.longValue() >= 12L) {
                continue;
            } else {
                System.out.println("강의 모두 오후 아님");
                return false;
            }
        }
        System.out.println("강의 모두 오후");
        return true;
    }
}