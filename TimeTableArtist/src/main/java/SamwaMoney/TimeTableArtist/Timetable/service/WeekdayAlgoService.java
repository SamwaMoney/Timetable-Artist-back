package SamwaMoney.TimeTableArtist.Timetable.service;

import SamwaMoney.TimeTableArtist.Class.dto.MoveDto;
import SamwaMoney.TimeTableArtist.Class.dto.ClassDto;
import SamwaMoney.TimeTableArtist.Class.dto.ClassListDto;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class WeekdayAlgoService {

    public static Map<String, Integer> score;
    public static int sevenCnt;
    public static int stayLongCnt;
    public static int plopCnt;
    public static int highCnt;
    public static int uphillCnt;
    public static int noLunchCnt;
    public static int threeInARowCnt;
    public static int maxInARowCnt;
    public static int totalScore;

    public static int weekdayAlgo(ClassListDto classListDto, Map<List<String>, MoveDto> moveDifficulty, ArrayList<Integer> good, ArrayList<Integer> bad, ArrayList<Integer> special) {

        score = new HashMap<>(); // key: 감/가점 요인, value: 감/가점된 점수
        sevenCnt = 0; // 7교시 수
        stayLongCnt = 0; // 6시간 이상 학교에 머무는 날 수
        plopCnt = 0; // 퐁당퐁당인 날 수
        highCnt = 0; // 연강인 경우 건물 이동 난이도 상의 개수
        uphillCnt = 0; // 연강인 경우 오르막길 이동 수
        noLunchCnt = 0; // 점심 못 먹는 날 수
        threeInARowCnt = 0; // 3연강 이상 수
        maxInARowCnt = 1; // 최대 연강 수

        totalScore = 0; // 감/가점 총합

        dayAlgo(classListDto.getMonday(), moveDifficulty);
        dayAlgo(classListDto.getTuesday(), moveDifficulty);
        dayAlgo(classListDto.getWednesday(), moveDifficulty);
        dayAlgo(classListDto.getThursday(), moveDifficulty);
        dayAlgo(classListDto.getFriday(), moveDifficulty);

        score.put("threeInARow", -5 * threeInARowCnt);

        if (sevenCnt >= 3)
            special.add(5); // special comment id 5 (충격) 6시 넘어서 수업 듣는 사람 (진짜 계심)
        if (stayLongCnt >= 3)
            special.add(6); // special comment id 6 이대 지박령을 뵙습니다
        if(plopCnt > 0)
            special.add(7); // special comment id 7 퐁당퐁당 수업을 나누자
        if (highCnt >= 3)
            special.add(9); // special comment id 9 이대생인 내가 쉬는 시간에는 치타?
        if (uphillCnt >= 3)
            special.add(10); // special comment id 10 이화사랑산악회
        if (noLunchCnt == 0)
            special.add(11); // special comment id 11 점심은 포기 못해
        else if (noLunchCnt >= 3)
            special.add(12); // special comment id 12 “밥은 먹고 다니냐?”
        if (threeInARowCnt >= 2)
            bad.add(2); // bad comment id 2 파워 연강러
        if (maxInARowCnt >= 4)
            bad.add(3); // bad comment id 3 4연강은 힘들어요

        if (score.getOrDefault("uphill", 0) == 0)
            good.add(9); // good comment id 9 오르막길은 싫어요
        else if (score.getOrDefault("uphill", 0) <= -10)
            bad.add(0); // bad comment id 0 오르막길 마스터

        if (score.getOrDefault("difficulty", 0) >= 10)
            good.add(12); // good comment id 12 이동거리가 가까워요
        else if (score.getOrDefault("difficulty", 0) <= -10)
            bad.add(5); // bad comment id 5 이동거리가 멀어요

        score.forEach((key, value) -> {
            totalScore += value;
        });

        if(good.size() > 3) {
            good = pickThree(good);
        }
        if(bad.size() > 3) {
            bad = pickThree(bad);
        }
        if(special.size() > 3) {
            special = pickThree(special);
        }

        System.out.println("7교시 있는 날의 수: " + sevenCnt + ", 6시간 이상 학교에 머무는 날 수: " + stayLongCnt);
        System.out.println("퐁당퐁당 수: " + plopCnt + ", 점심 못 먹는 날 수: " + noLunchCnt);
        System.out.println("건물 이동 난이도 상의 수: " + highCnt + ", 오르막길 수: " + uphillCnt);
        System.out.println("3연강 이상 수: " + threeInARowCnt + ", 최대 연강 수: " + maxInARowCnt);
        System.out.println("요일별 점수 계산:" + score);
        System.out.println("요일별 계산에 의한 총 점수: " + totalScore);

        return totalScore;
    }

    public static ArrayList<Integer> pickThree(ArrayList<Integer> list) {
        // 선택된 3개 코멘트의 ID를 담을 리스트
        ArrayList<Integer> result = new ArrayList<>();

        Random random = new Random();
        for(int i=0; i<3; i++) {
            // 0 이상, 현재 리스트의 크기 미만 중 하나의 수를 랜덤으로 선택
            int picked = random.nextInt(list.size());
            // 선택된 수를 인덱스로 사용하여, list에서 수 하나를 꺼내 result로 옮김
            result.add(list.get(picked));
            list.remove(picked); // 선택된 수가 list에서 remove되었으므로, 이미 선택된 요소가 중복선택될 우려가 없음
        }

        // 결과 리스트 리턴
        return result;
    }

    static void dayAlgo(List<ClassDto> day, Map<List<String>, MoveDto> moveDifficulty) {
        if (day.isEmpty()){ // 수업이 없는 날이면
            return; // 바로 종료
        }

        day.sort((a, b) -> {
            if (a.getStartH() < b.getStartH() || (a.getStartH() == b.getStartH() && a.getStartM() < b.getStartM()))
                return -1;
            else
                return 1;
        });

        stayLongCntAlgo(day);
        inARowAlgo(day, moveDifficulty);
        cntTimeAlgo(day);
    }

    // 학교에 머무는 시간이 6시간 이상인 날 세는 함수
    static void stayLongCntAlgo(List<ClassDto> day){
        ClassDto first = day.get(0);
        ClassDto last = day.get(day.size()-1);
        long diff = (last.getEndH() - first.getStartH()) * 60 + last.getEndM() - first.getStartM();
        if (diff >= 360)
            stayLongCnt++;
    }

    // 연강 관련 로직 처리 함수
    static void inARowAlgo(List<ClassDto> day, Map<List<String>, MoveDto> moveDifficulty){
        // 각 강의가 각각 몇 연강인지 계산
        ArrayList<Integer> classTime = new ArrayList<>();
        for (ClassDto c : day) {
            long time = (c.getEndH() - c.getStartH()) * 60 + c.getEndH() - c.getStartM();
            if (time < 90){
                classTime.add(0);
            } else if (time >= 90 && time < 180){
                classTime.add(1);
            } else if (time >= 180 && time < 270){
                classTime.add(2);
            } else if (time >= 270 && time < 360){
                classTime.add(3);
            } else if (time == 360){
                classTime.add(4);
            }
        }

        long diff; // 강의와 강의 사이의 시간을 계산
        boolean inARow = false; // 이전 쌍이 연강이었다면 true
        int falseCnt = 0; // 연강이 아닌 경우의 수
        int rowCnt = classTime.get(0); // 현재 연강 수
        MoveDto moveDto; // 현재 검사하는 쌍의 이동 난이도

        for (int i = 0; i < day.size() - 1; i++) {
            ClassDto current = day.get(i);
            ClassDto next = day.get(i + 1);

            // 강의와 강의 사이의 시간을 계산
            if (current.getEndH() == next.getStartH()) {
                diff = next.getStartM() - current.getEndM();
            } else {
                diff = (next.getStartH() - current.getEndH()) * 60 + (next.getStartM() - current.getEndM());
            }

            if (diff == 0) { // 강의가 연속되어 있다면
                if (inARow) { // 이전 쌍도 연강이었다면
                    rowCnt += classTime.get(i+1); // n연강 수 증가
                } else { // 이전은 연강이 아니었다면
                    rowCnt = classTime.get(i) + classTime.get(i+1); // 직전 강의 + 다음 강의 강의 단위 합
                    inARow = true; // flag 갱신
                }
                maxInARowCnt = Math.max(maxInARowCnt, rowCnt); // 현재까지의 최대 연강 수 저장

                List<String> locationPair = Arrays.asList(current.getLocation(), next.getLocation());

                // 연속된 두 수업 중 하나라도, 시간이 정해진 원격/비대면 수업이라면, 오르막길이 아닌 이동난이도 '하'와 동일하게 취급
                if(current.getLocation().equals("원격/비대면") || next.getLocation().equals("원격/비대면"))
                    score.put("difficulty", score.getOrDefault("difficulty", 0) + 3);

                    // 연속된 두 수업 모두 오프라인 강의라면, 이동난이도 계산
                else{
                    moveDto = moveDifficulty.get(locationPair);

                    if (moveDto.isUphill()) {
                        score.put("uphill", score.getOrDefault("uphill", 0) - 3);
                        uphillCnt++;
                    }

                    switch (moveDto.getDifficulty()) {
                        case LOW:
                            score.put("difficulty", score.getOrDefault("difficulty", 0) + 3);
                            break;
                        case MEDIUM:
                            score.put("difficulty", score.getOrDefault("difficulty", 0));
                            break;
                        case HIGH:
                            score.put("difficulty", score.getOrDefault("difficulty", 0) - 3);
                            highCnt++;
                            break;
                    }

                }

            } else {
                falseCnt++;
                inARow = false;
                if (rowCnt >= 3)
                    threeInARowCnt++;
                rowCnt = classTime.get(i);
            }
        }
        if (rowCnt >= 3)
            threeInARowCnt++;
        if (falseCnt >= 2)
            plopCnt++;
    }

    // 점심 못 먹는 날 + 7교시 수 세는 함수
    static void cntTimeAlgo(List<ClassDto> day){
        boolean[] hasClass = new boolean[28]; // 8시~22시에 대해 한 인덱스가 30분 동안 수업이 있는지 없는지에 대한 t/f 값
        int hasTimeCnt = 0;
        for (ClassDto c: day){
            long time = ((c.getEndH() - c.getStartH()) * 60 + c.getEndH() - c.getStartH()) / 30; // 해당 수업의 30분 블록 수 계산
            long startIdx = ((c.getStartH() - 8) * 60 + c.getStartM()) / 30; // 해당 수업의 시작 인덱스 계산
            for (int i = (int)startIdx; i<startIdx + time; i++){ // 시작 인덱스부터 수업 길이만큼 true 처리
                hasClass[i] = true;
            }
        }

        // 점심 못 먹는 날 검사
        for (int i = 6; i < 12; i++){ // 11시부터 14시까지
            if (hasClass[i] == false)
                hasTimeCnt++;
        }
        if (hasTimeCnt < 1){ // 밥 먹을 수 있는 시간이 30분 미만이면
            noLunchCnt++;
        }

        // 7교시 있는 날 검사
        for (int i = 18; i < 28; i++){ // 17시부터 하나라도 수업이 있으면 7교시 있는 날로 처리
            if (hasClass[i] == true){
                sevenCnt++;
                break;
            }
        }
    }
}
