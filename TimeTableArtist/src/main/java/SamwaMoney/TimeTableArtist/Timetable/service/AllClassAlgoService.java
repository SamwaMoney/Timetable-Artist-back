package SamwaMoney.TimeTableArtist.Timetable.service;

import SamwaMoney.TimeTableArtist.Class.dto.ClassListDto;
import SamwaMoney.TimeTableArtist.Class.dto.ClassDto;
import SamwaMoney.TimeTableArtist.Class.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class AllClassAlgoService {
    private final TimetableService timetableService;

    @Autowired
    public AllClassAlgoService(TimetableService timetableService) {
        this.timetableService = timetableService;
    }

    // 알고리즘을 수행하고 점수를 반환하는 메서드
    public int calculateTimetableScore(Long timetableId, ArrayList<Integer> good, ArrayList<Integer> bad) {
        ClassListDto classListDto = timetableService.scoreTimetable(timetableId);

        int score = 0;

        // 모든 강의 개수에 따른 가점 계산
        int allCount = classListDto.getClassList().size();
        int onlineCount = OnlineAlgo(classListDto); // 원격/비대면 강의 개수 계산
        if (allCount <= 6) {
            score += (allCount - onlineCount); // 수업 하나당 1점씩 가점
        } else {
            score += (6 - onlineCount); // 수업이 7개 이상이라도 6개까지만 가점
        }
        score += (onlineCount * 3); // 원격/비대면 강의당 3점씩 가점

        // 1교시 수업에 따른 감점 계산
        int firstClassCount = FirstClassAlgo(classListDto, good, bad);
        score -= (firstClassCount * 3); // 1교시 수업 하나당 3점씩 감점

        // 채플 개수에 따른 가점 계산
        int chapelCount = ChapelAlgo(classListDto);
        score += (chapelCount * 5); // 채플 하나당 5점씩 가점

        return score;
    }

    // 전체 과목 개수 count
    // 수업 7개 미만: 수업 하나당 +1, 원격 비대면일 경우 +7
    public static int allClassAlgo(ClassListDto t, ArrayList<Integer> good, ArrayList<Integer> bad, ArrayList<Integer> special) {
        Set<String> allClasses = new HashSet<>(); // 모든 강의 리스트

        int allCount = 0; // 모든 강의의 수 저장
        int online = 0; // 원격/비대면 강의의 수 저장
        int score = 0; // 가/감점된 점수 저장
        int totalTime = 0; // 전체 수업 시간 분 단위로 저장
        int allBlockCount = 0; // 전체 수업 블럭 수 저장 (90분 단위)
        int chapelCount = ChapelAlgo(t); // 전체 채플 수
        int locationCount = locationAlgo(t); // 전체 강의실 건물 수
        int firstClassCount = FirstClassAlgo(t, good, bad);

        for (ClassDto c : t.getClassList()) {
            if (c.getLocation().equals("원격/비대면"))
                online++;
            allClasses.add(c.getClassName());
            totalTime += (c.getEndH() - c.getStartH()) * 60 + (c.getEndH() - c.getStartM());
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

        if(allBlockCount <= 6)
            special.add(0); // special comment id 0 취미는 학교 다니기
        else if (allBlockCount >= 14)
            special.add(1); // special comment id 1 등록금 뿌린 대로 거두자

        if (online >= 3)
            special.add(2); // special comment id 2 이화 사이버 대학교
        if (online >= 2)
            good.add(10); // good comment id 10 비대면 강의 있음

        if (chapelCount >= 2)
            special.add(3); // special comment id 3 하나님의 축복이 끝이 없네

        score += DayoffAlgo(t, good, bad); // 공강 관련 가감점 및 코멘트 처리 함수
        score += FirstClassAlgo(t, good, bad); // 1교시 관련 감점 및 코멘트 처리 함수

        if (allAfternoonAlgo(t))
            special.add(4); // special comment id 4 상여자 특) 점심 먹고 등교함

        if (locationCount == 1){
            good.add(11); // good comment id 11 나는 한 건물만 판다
            special.add(13); // special comment id 13 00 건물 지박령 - 교체 예정
        }
        else if (locationCount >= 4){
            special.add(8); // special comment id 8 동에 번쩍 서에 번쩍
        }

        System.out.println("과목의 개수가 " + allCount + "개이고, 원격/온라인 강의의 개수는 " + online +"개 이므로, 총 점수는 " + score);

        return score;

    }
    // 공강 개수 count
    // 요일 공강 하나당 +10
    public static int DayoffAlgo(ClassListDto t, ArrayList<Integer> good, ArrayList<Integer> bad) {

        boolean[] dayOffs = new boolean[5]; // 공강 여부 저장하는 배열
        int score = 0; // 점수 저장
        int dayOffCnt = 0;

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
            good.add(7); // good comment id 7 최고 인기 금공강!
        }

        for (int i=0; i<5; i++){
            if(dayOffs[i] == true)
                dayOffCnt++;
        }

        score = dayOffCnt * 10;

        if (dayOffCnt == 1){
            for (int i=0; i<5; i++){
                if(dayOffs[i] == true){
                    good.add(i); // good comment id i 기분 좋은 _요일
                    break;
                }
            }
        } else if (dayOffCnt == 2){
            good.add(5); // good comment id 5 행복한 2공강
        } else if (dayOffCnt == 3){
            good.add(6); // good comment id 6 엄청난 3공강
        } else if (dayOffCnt == 0){
            bad.add(4); // bad comment id 4 공강 1도 없어
        }

        System.out.println("요일 공강의 개수가 " + dayOffCnt + "개 이므로, 공강에 의한 가점은 " + score);

        return score;
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
    public static int FirstClassAlgo(ClassListDto t, ArrayList<Integer> good, ArrayList<Integer> bad) {
        int firstClass = 0; // 1교시 수업 개수 저장
        int score = 0; // 점수 저장

        for (ClassDto c : t.getClassList()) {
            if (c.getStartH() == 8) {
                firstClass++;
                score -= 3 ;
            }
        }

        if (firstClass == 0)
            good.add(8); // good comment id 8 1교시 제로
        else if (firstClass >= 2)
            bad.add(1); // bad comment id 1 오전부터 바빠요!

        System.out.println("1교시의 개수가 " + firstClass + "개 이므로, 1교시에 의한 감점은 " + score);

        return score;
    }

    // 강의 장소 수 세는 알고리즘
    public static int locationAlgo(ClassListDto t) {

        Set<String> locations = new HashSet<>(); // 강의 장소 저장
        int locationNum = 0; // 강의 장소의 수 저장

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
            if (c.getStartH() >= 12) {
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