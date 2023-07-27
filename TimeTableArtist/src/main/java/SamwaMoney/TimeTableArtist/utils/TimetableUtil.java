package SamwaMoney.TimeTableArtist.utils;

import SamwaMoney.TimeTableArtist.Class.domain.Difficulty;
import SamwaMoney.TimeTableArtist.Class.dto.MoveDto;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimetableUtil {
    private TimetableUtil() {}

    public static Map<List<String>, MoveDto> makeMoveDifficulties () {
        Map<List<String>, MoveDto> moveDifficulty = new HashMap<>();

        // ECC
        moveDifficulty.put(Arrays.asList("ECC", "학관"), new MoveDto(true, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("ECC", "ECC"), new MoveDto(false, Difficulty.LOW));
        moveDifficulty.put(Arrays.asList("ECC", "대강당"), new MoveDto(true, Difficulty.LOW));
        moveDifficulty.put(Arrays.asList("ECC", "신세계관"), new MoveDto(true, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("ECC", "조형예술관"), new MoveDto(true, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("ECC", "종합과학관"), new MoveDto(true, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("ECC", "포스코관"), new MoveDto(true, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("ECC", "공학관"), new MoveDto(true, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("ECC", "교육관"), new MoveDto(true, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("ECC", "국제교육관"), new MoveDto(false, Difficulty.LOW));
        moveDifficulty.put(Arrays.asList("ECC", "법학관"), new MoveDto(true, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("ECC", "헬렌관"), new MoveDto(true, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("ECC", "연구협력관"), new MoveDto(true, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("ECC", "테니스장"), new MoveDto(true, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("ECC", "생활관"), new MoveDto(true, Difficulty.LOW));
        moveDifficulty.put(Arrays.asList("ECC", "약학관"), new MoveDto(true, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("ECC", "sk텔레콤관(정보관)"), new MoveDto(true, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("ECC", "체육관"), new MoveDto(true, Difficulty.LOW));
        moveDifficulty.put(Arrays.asList("ECC", "음악관"), new MoveDto(true, Difficulty.MEDIUM));

        // 공학관
        moveDifficulty.put(Arrays.asList("공학관", "sk텔레콤관(정보관)"), new MoveDto(false, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("공학관", "대강당"), new MoveDto(false, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("공학관", "종합과학관"), new MoveDto(false, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("공학관", "포스코관"), new MoveDto(false, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("공학관", "공학관"), new MoveDto(false, Difficulty.LOW));
        moveDifficulty.put(Arrays.asList("공학관", "학관"), new MoveDto(false, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("공학관", "ECC"), new MoveDto(false, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("공학관", "교육관"), new MoveDto(false, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("공학관", "국제교육관"), new MoveDto(false, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("공학관", "법학관"), new MoveDto(false, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("공학관", "헬렌관"), new MoveDto(false, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("공학관", "연구협력관"), new MoveDto(true, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("공학관", "테니스장"), new MoveDto(true, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("공학관", "생활관"), new MoveDto(false, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("공학관", "약학관"), new MoveDto(false, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("공학관", "신세계관"), new MoveDto(false, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("공학관", "조형예술관"), new MoveDto(false, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("공학관", "체육관"), new MoveDto(false, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("공학관", "음악관"), new MoveDto(false, Difficulty.HIGH));

        // 교육관
        moveDifficulty.put(Arrays.asList("교육관", "sk텔레콤관(정보관)"), new MoveDto(false, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("교육관", "대강당"), new MoveDto(false, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("교육관", "종합과학관"), new MoveDto(true, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("교육관", "포스코관"), new MoveDto(true, Difficulty.LOW));
        moveDifficulty.put(Arrays.asList("교육관", "공학관"), new MoveDto(true, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("교육관", "학관"), new MoveDto(false, Difficulty.LOW));
        moveDifficulty.put(Arrays.asList("교육관", "ECC"), new MoveDto(true, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("교육관", "교육관"), new MoveDto(false, Difficulty.LOW));
        moveDifficulty.put(Arrays.asList("교육관", "국제교육관"), new MoveDto(false, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("교육관", "법학관"), new MoveDto(true, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("교육관", "헬렌관"), new MoveDto(true, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("교육관", "연구협력관"), new MoveDto(true, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("교육관", "테니스장"), new MoveDto(true, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("교육관", "생활관"), new MoveDto(true, Difficulty.LOW));
        moveDifficulty.put(Arrays.asList("교육관", "약학관"), new MoveDto(true, Difficulty.LOW));
        moveDifficulty.put(Arrays.asList("교육관", "신세계관"), new MoveDto(false, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("교육관", "조형예술관"), new MoveDto(true, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("교육관", "체육관"), new MoveDto(true, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("교육관", "음악관"), new MoveDto(true, Difficulty.HIGH));

        // 학관
        moveDifficulty.put(Arrays.asList("학관", "학관"), new MoveDto(false, Difficulty.LOW));
        moveDifficulty.put(Arrays.asList("학관", "ECC"), new MoveDto(false, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("학관", "공학관"), new MoveDto(true, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("학관", "대강당"), new MoveDto(false, Difficulty.LOW));
        moveDifficulty.put(Arrays.asList("학관", "종합과학관"), new MoveDto(true, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("학관", "포스코관"), new MoveDto(true, Difficulty.LOW));
        moveDifficulty.put(Arrays.asList("학관", "교육관"), new MoveDto(false, Difficulty.LOW));
        moveDifficulty.put(Arrays.asList("학관", "국제교육관"), new MoveDto(false, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("학관", "법학관"), new MoveDto(true, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("학관", "헬렌관"), new MoveDto(true, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("학관", "연구협력관"), new MoveDto(true, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("학관", "테니스장"), new MoveDto(true, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("학관", "생활관"), new MoveDto(true, Difficulty.LOW));
        moveDifficulty.put(Arrays.asList("학관", "약학관"), new MoveDto(true, Difficulty.LOW));
        moveDifficulty.put(Arrays.asList("학관", "신세계관"), new MoveDto(false, Difficulty.LOW));
        moveDifficulty.put(Arrays.asList("학관", "sk텔레콤관(정보관)"), new MoveDto(false, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("학관", "조형예술관"), new MoveDto(true, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("학관", "체육관"), new MoveDto(true, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("학관", "음악관"), new MoveDto(true, Difficulty.MEDIUM));

        // 국제교육관
        moveDifficulty.put(Arrays.asList("국제교육관", "학관"), new MoveDto(true, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("국제교육관", "ECC"), new MoveDto(false, Difficulty.LOW));
        moveDifficulty.put(Arrays.asList("국제교육관", "공학관"), new MoveDto(true, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("국제교육관", "대강당"), new MoveDto(true, Difficulty.LOW));
        moveDifficulty.put(Arrays.asList("국제교육관", "종합과학관"), new MoveDto(true, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("국제교육관", "포스코관"), new MoveDto(true, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("국제교육관", "교육관"), new MoveDto(false, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("국제교육관", "국제교육관"), new MoveDto(false, Difficulty.LOW));
        moveDifficulty.put(Arrays.asList("국제교육관", "법학관"), new MoveDto(true, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("국제교육관", "헬렌관"), new MoveDto(true, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("국제교육관", "연구협력관"), new MoveDto(true, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("국제교육관", "테니스장"), new MoveDto(true, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("국제교육관", "생활관"), new MoveDto(true, Difficulty.LOW));
        moveDifficulty.put(Arrays.asList("국제교육관", "약학관"), new MoveDto(true, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("국제교육관", "신세계관"), new MoveDto(false, Difficulty.LOW));
        moveDifficulty.put(Arrays.asList("국제교육관", "sk텔레콤관(정보관)"), new MoveDto(false, Difficulty.LOW));
        moveDifficulty.put(Arrays.asList("국제교육관", "조형예술관"), new MoveDto(true, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("국제교육관", "체육관"), new MoveDto(true, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("국제교육관", "음악관"), new MoveDto(true, Difficulty.MEDIUM));

        // 대강당
        moveDifficulty.put(Arrays.asList("대강당", "sk텔레콤관(정보관)"), new MoveDto(false, Difficulty.LOW));
        moveDifficulty.put(Arrays.asList("대강당", "ECC"), new MoveDto(false, Difficulty.LOW));
        moveDifficulty.put(Arrays.asList("대강당", "공학관"), new MoveDto(true, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("대강당", "신세계관"), new MoveDto(false, Difficulty.LOW));
        moveDifficulty.put(Arrays.asList("대강당", "조형예술관"), new MoveDto(true, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("대강당", "종합과학관"), new MoveDto(true, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("대강당", "포스코관"), new MoveDto(true, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("대강당", "학관"), new MoveDto(false, Difficulty.LOW));
        moveDifficulty.put(Arrays.asList("대강당", "교육관"), new MoveDto(false, Difficulty.LOW));
        moveDifficulty.put(Arrays.asList("대강당", "국제교육관"), new MoveDto(false, Difficulty.LOW));
        moveDifficulty.put(Arrays.asList("대강당", "대강당"), new MoveDto(false, Difficulty.LOW));
        moveDifficulty.put(Arrays.asList("대강당", "법학관"), new MoveDto(false, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("대강당", "헬렌관"), new MoveDto(true, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("대강당", "연구협력관"), new MoveDto(true, Difficulty.LOW));
        moveDifficulty.put(Arrays.asList("대강당", "테니스장"), new MoveDto(true, Difficulty.LOW));
        moveDifficulty.put(Arrays.asList("대강당", "생활관"), new MoveDto(false, Difficulty.LOW));
        moveDifficulty.put(Arrays.asList("대강당", "약학관"), new MoveDto(false, Difficulty.LOW));
        moveDifficulty.put(Arrays.asList("대강당", "체육관"), new MoveDto(true, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("대강당", "음악관"), new MoveDto(true, Difficulty.MEDIUM));

        // 법학관
        moveDifficulty.put(Arrays.asList("법학관", "sk텔레콤관(정보관)"), new MoveDto(true, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("법학관", "ECC"), new MoveDto(false, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("법학관", "공학관"), new MoveDto(true, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("법학관", "신세계관"), new MoveDto(false, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("법학관", "조형예술관"), new MoveDto(false, Difficulty.LOW));
        moveDifficulty.put(Arrays.asList("법학관", "종합과학관"), new MoveDto(true, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("법학관", "포스코관"), new MoveDto(false, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("법학관", "학관"), new MoveDto(true, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("법학관", "교육관"), new MoveDto(true, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("법학관", "국제교육관"), new MoveDto(false, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("법학관", "대강당"), new MoveDto(false, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("법학관", "법학관"), new MoveDto(false, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("법학관", "헬렌관"), new MoveDto(false, Difficulty.LOW));
        moveDifficulty.put(Arrays.asList("법학관", "연구협력관"), new MoveDto(true, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("법학관", "테니스장"), new MoveDto(true, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("법학관", "생활관"), new MoveDto(false, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("법학관", "약학관"), new MoveDto(false, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("법학관", "체육관"), new MoveDto(false, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("법학관", "음악관"), new MoveDto(true, Difficulty.MEDIUM));

        // 헬렌관
        moveDifficulty.put(Arrays.asList("헬렌관", "ECC"), new MoveDto(false, Difficulty.LOW));
        moveDifficulty.put(Arrays.asList("헬렌관", "공학관"), new MoveDto(true, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("헬렌관", "교육관"), new MoveDto(true, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("헬렌관", "학관"), new MoveDto(false, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("헬렌관", "국제교육관"), new MoveDto(false, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("헬렌관", "대강당"), new MoveDto(false, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("헬렌관", "법학관"), new MoveDto(true, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("헬렌관", "헬렌관"), new MoveDto(false, Difficulty.LOW));
        moveDifficulty.put(Arrays.asList("헬렌관", "연구협력관"), new MoveDto(true, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("헬렌관", "테니스장"), new MoveDto(true, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("헬렌관", "생활관"), new MoveDto(false, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("헬렌관", "약학관"), new MoveDto(false, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("헬렌관", "신세계관"), new MoveDto(false, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("헬렌관", "sk텔레콤관(정보관)"), new MoveDto(false, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("헬렌관", "조형예술관"), new MoveDto(false, Difficulty.LOW));
        moveDifficulty.put(Arrays.asList("헬렌관", "체육관"), new MoveDto(false, Difficulty.LOW));
        moveDifficulty.put(Arrays.asList("헬렌관", "음악관"), new MoveDto(true, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("헬렌관", "종합과학관"), new MoveDto(true, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("헬렌관", "포스코관"), new MoveDto(false, Difficulty.LOW));

        // 연구협력관
        moveDifficulty.put(Arrays.asList("연구협력관", "ECC"), new MoveDto(false, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("연구협력관", "공학관"), new MoveDto(false, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("연구협력관", "교육관"), new MoveDto(false, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("연구협력관", "학관"), new MoveDto(false, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("연구협력관", "국제교육관"), new MoveDto(false, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("연구협력관", "대강당"), new MoveDto(false, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("연구협력관", "법학관"), new MoveDto(false, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("연구협력관", "헬렌관"), new MoveDto(false, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("연구협력관", "연구협력관"), new MoveDto(false, Difficulty.LOW));
        moveDifficulty.put(Arrays.asList("연구협력관", "테니스장"), new MoveDto(false, Difficulty.LOW));
        moveDifficulty.put(Arrays.asList("연구협력관", "생활관"), new MoveDto(false, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("연구협력관", "약학관"), new MoveDto(false, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("연구협력관", "신세계관"), new MoveDto(false, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("연구협력관", "sk텔레콤관(정보관)"), new MoveDto(false, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("연구협력관", "조형예술관"), new MoveDto(false, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("연구협력관", "체육관"), new MoveDto(false, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("연구협력관", "음악관"), new MoveDto(false, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("연구협력관", "종합과학관"), new MoveDto(false, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("연구협력관", "포스코관"), new MoveDto(false, Difficulty.HIGH));

        // 테니스장
        moveDifficulty.put(Arrays.asList("테니스장", "ECC"), new MoveDto(false, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("테니스장", "공학관"), new MoveDto(false, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("테니스장", "교육관"), new MoveDto(false, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("테니스장", "학관"), new MoveDto(false, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("테니스장", "국제교육관"), new MoveDto(false, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("테니스장", "대강당"), new MoveDto(false, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("테니스장", "법학관"), new MoveDto(false, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("테니스장", "헬렌관"), new MoveDto(false, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("테니스장", "연구협력관"), new MoveDto(true, Difficulty.LOW));
        moveDifficulty.put(Arrays.asList("테니스장", "테니스장"), new MoveDto(false, Difficulty.LOW));
        moveDifficulty.put(Arrays.asList("테니스장", "생활관"), new MoveDto(false, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("테니스장", "약학관"), new MoveDto(false, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("테니스장", "신세계관"), new MoveDto(false, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("테니스장", "sk텔레콤관(정보관)"), new MoveDto(false, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("테니스장", "조형예술관"), new MoveDto(false, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("테니스장", "체육관"), new MoveDto(false, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("테니스장", "음악관"), new MoveDto(false, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("테니스장", "종합과학관"), new MoveDto(false, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("테니스장", "포스코관"), new MoveDto(false, Difficulty.HIGH));

        // 생활관
        moveDifficulty.put(Arrays.asList("생활관", "ECC"), new MoveDto(false, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("생활관", "공학관"), new MoveDto(true, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("생활관", "교육관"), new MoveDto(false, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("생활관", "학관"), new MoveDto(false, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("생활관", "국제교육관"), new MoveDto(false, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("생활관", "대강당"), new MoveDto(false, Difficulty.LOW));
        moveDifficulty.put(Arrays.asList("생활관", "법학관"), new MoveDto(true, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("생활관", "헬렌관"), new MoveDto(true, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("생활관", "연구협력관"), new MoveDto(true, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("생활관", "테니스장"), new MoveDto(true, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("생활관", "생활관"), new MoveDto(false, Difficulty.LOW));
        moveDifficulty.put(Arrays.asList("생활관", "약학관"), new MoveDto(false, Difficulty.LOW));
        moveDifficulty.put(Arrays.asList("생활관", "신세계관"), new MoveDto(false, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("생활관", "sk텔레콤관(정보관)"), new MoveDto(false, Difficulty.LOW));
        moveDifficulty.put(Arrays.asList("생활관", "조형예술관"), new MoveDto(true, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("생활관", "체육관"), new MoveDto(false, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("생활관", "음악관"), new MoveDto(true, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("생활관", "종합과학관"), new MoveDto(true, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("생활관", "포스코관"), new MoveDto(true, Difficulty.MEDIUM));

        // 약학관
        moveDifficulty.put(Arrays.asList("약학관", "ECC"), new MoveDto(false, Difficulty.LOW));
        moveDifficulty.put(Arrays.asList("약학관", "공학관"), new MoveDto(true, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("약학관", "교육관"), new MoveDto(true, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("약학관", "학관"), new MoveDto(false, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("약학관", "국제교육관"), new MoveDto(false, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("약학관", "대강당"), new MoveDto(false, Difficulty.LOW));
        moveDifficulty.put(Arrays.asList("약학관", "법학관"), new MoveDto(true, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("약학관", "헬렌관"), new MoveDto(false, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("약학관", "연구협력관"), new MoveDto(true, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("약학관", "테니스장"), new MoveDto(true, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("약학관", "생활관"), new MoveDto(false, Difficulty.LOW));
        moveDifficulty.put(Arrays.asList("약학관", "약학관"), new MoveDto(false, Difficulty.LOW));
        moveDifficulty.put(Arrays.asList("약학관", "신세계관"), new MoveDto(false, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("약학관", "sk텔레콤관(정보관)"), new MoveDto(false, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("약학관", "조형예술관"), new MoveDto(false, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("약학관", "체육관"), new MoveDto(false, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("약학관", "음악관"), new MoveDto(true, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("약학관", "종합과학관"), new MoveDto(true, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("약학관", "포스코관"), new MoveDto(true, Difficulty.LOW));

        // 신세계관
        moveDifficulty.put(Arrays.asList("신세계관", "ECC"), new MoveDto(false, Difficulty.LOW));
        moveDifficulty.put(Arrays.asList("신세계관", "대강당"), new MoveDto(true, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("신세계관", "포스코관"), new MoveDto(true, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("신세계관", "조형예술관"), new MoveDto(false, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("신세계관", "공학관"), new MoveDto(true, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("신세계관", "교육관"), new MoveDto(false, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("신세계관", "학관"), new MoveDto(false, Difficulty.LOW));
        moveDifficulty.put(Arrays.asList("신세계관", "국제교육관"), new MoveDto(false, Difficulty.LOW));
        moveDifficulty.put(Arrays.asList("신세계관", "법학관"), new MoveDto(true, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("신세계관", "헬렌관"), new MoveDto(true, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("신세계관", "연구협력관"), new MoveDto(true, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("신세계관", "테니스장"), new MoveDto(true, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("신세계관", "생활관"), new MoveDto(false, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("신세계관", "약학관"), new MoveDto(true, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("신세계관", "sk텔레콤관(정보관)"), new MoveDto(false, Difficulty.LOW));
        moveDifficulty.put(Arrays.asList("신세계관", "체육관"), new MoveDto(false, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("신세계관", "음악관"), new MoveDto(true, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("신세계관", "종합과학관"), new MoveDto(true, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("신세계관", "신세계관"), new MoveDto(false, Difficulty.LOW));

        // sk텔레콤관(정보관)
        moveDifficulty.put(Arrays.asList("sk텔레콤관(정보관)", "공학관"), new MoveDto(true, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("sk텔레콤관(정보관)", "대강당"), new MoveDto(true, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("sk텔레콤관(정보관)", "ECC"), new MoveDto(false, Difficulty.LOW));
        moveDifficulty.put(Arrays.asList("sk텔레콤관(정보관)", "포스코관"), new MoveDto(true, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("sk텔레콤관(정보관)", "조형예술관"), new MoveDto(true, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("sk텔레콤관(정보관)", "교육관"), new MoveDto(false, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("sk텔레콤관(정보관)", "학관"), new MoveDto(false, Difficulty.LOW));
        moveDifficulty.put(Arrays.asList("sk텔레콤관(정보관)", "국제교육관"), new MoveDto(false, Difficulty.LOW));
        moveDifficulty.put(Arrays.asList("sk텔레콤관(정보관)", "법학관"), new MoveDto(true, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("sk텔레콤관(정보관)", "헬렌관"), new MoveDto(true, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("sk텔레콤관(정보관)", "연구협력관"), new MoveDto(true, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("sk텔레콤관(정보관)", "테니스장"), new MoveDto(true, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("sk텔레콤관(정보관)", "생활관"), new MoveDto(false, Difficulty.LOW));
        moveDifficulty.put(Arrays.asList("sk텔레콤관(정보관)", "약학관"), new MoveDto(true, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("sk텔레콤관(정보관)", "신세계관"), new MoveDto(false, Difficulty.LOW));
        moveDifficulty.put(Arrays.asList("sk텔레콤관(정보관)", "sk텔레콤관(정보관)"), new MoveDto(false, Difficulty.LOW));
        moveDifficulty.put(Arrays.asList("sk텔레콤관(정보관)", "체육관"), new MoveDto(false, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("sk텔레콤관(정보관)", "음악관"), new MoveDto(true, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("sk텔레콤관(정보관)", "종합과학관"), new MoveDto(true, Difficulty.HIGH));

        // 조형예술관
        moveDifficulty.put(Arrays.asList("조형예술관", "ECC"), new MoveDto(false, Difficulty.LOW));
        moveDifficulty.put(Arrays.asList("조형예술관", "공학관"), new MoveDto(true, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("조형예술관", "교육관"), new MoveDto(false, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("조형예술관", "학관"), new MoveDto(false, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("조형예술관", "국제교육관"), new MoveDto(false, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("조형예술관", "대강당"), new MoveDto(false, Difficulty.LOW));
        moveDifficulty.put(Arrays.asList("조형예술관", "법학관"), new MoveDto(true, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("조형예술관", "헬렌관"), new MoveDto(true, Difficulty.LOW));
        moveDifficulty.put(Arrays.asList("조형예술관", "연구협력관"), new MoveDto(true, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("조형예술관", "테니스장"), new MoveDto(true, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("조형예술관", "생활관"), new MoveDto(false, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("조형예술관", "약학관"), new MoveDto(false, Difficulty.LOW));
        moveDifficulty.put(Arrays.asList("조형예술관", "신세계관"), new MoveDto(false, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("조형예술관", "sk텔레콤관(정보관)"), new MoveDto(false, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("조형예술관", "조형예술관"), new MoveDto(false, Difficulty.LOW));
        moveDifficulty.put(Arrays.asList("조형예술관", "체육관"), new MoveDto(false, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("조형예술관", "음악관"), new MoveDto(true, Difficulty.LOW));
        moveDifficulty.put(Arrays.asList("조형예술관", "종합과학관"), new MoveDto(true, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("조형예술관", "포스코관"), new MoveDto(true, Difficulty.LOW));

        // 체육관
        moveDifficulty.put(Arrays.asList("체육관", "ECC"), new MoveDto(false, Difficulty.LOW));
        moveDifficulty.put(Arrays.asList("체육관", "공학관"), new MoveDto(true, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("체육관", "교육관"), new MoveDto(false, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("체육관", "학관"), new MoveDto(false, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("체육관", "국제교육관"), new MoveDto(false, Difficulty.LOW));
        moveDifficulty.put(Arrays.asList("체육관", "대강당"), new MoveDto(true, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("체육관", "법학관"), new MoveDto(true, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("체육관", "헬렌관"), new MoveDto(true, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("체육관", "연구협력관"), new MoveDto(true, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("체육관", "테니스장"), new MoveDto(true, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("체육관", "생활관"), new MoveDto(true, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("체육관", "약학관"), new MoveDto(false, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("체육관", "신세계관"), new MoveDto(false, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("체육관", "sk텔레콤관(정보관)"), new MoveDto(false, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("체육관", "조형예술관"), new MoveDto(false, Difficulty.LOW));
        moveDifficulty.put(Arrays.asList("체육관", "체육관"), new MoveDto(false, Difficulty.LOW));
        moveDifficulty.put(Arrays.asList("체육관", "음악관"), new MoveDto(true, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("체육관", "종합과학관"), new MoveDto(true, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("체육관", "포스코관"), new MoveDto(true, Difficulty.MEDIUM));

        // 음악관
        moveDifficulty.put(Arrays.asList("음악관", "ECC"), new MoveDto(false, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("음악관", "공학관"), new MoveDto(true, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("음악관", "교육관"), new MoveDto(false, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("음악관", "학관"), new MoveDto(false, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("음악관", "국제교육관"), new MoveDto(false, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("음악관", "대강당"), new MoveDto(false, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("음악관", "법학관"), new MoveDto(true, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("음악관", "헬렌관"), new MoveDto(false, Difficulty.LOW));
        moveDifficulty.put(Arrays.asList("음악관", "연구협력관"), new MoveDto(true, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("음악관", "테니스장"), new MoveDto(true, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("음악관", "생활관"), new MoveDto(false, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("음악관", "약학관"), new MoveDto(false, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("음악관", "신세계관"), new MoveDto(false, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("음악관", "sk텔레콤관(정보관)"), new MoveDto(false, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("음악관", "조형예술관"), new MoveDto(false, Difficulty.LOW));
        moveDifficulty.put(Arrays.asList("음악관", "체육관"), new MoveDto(false, Difficulty.LOW));
        moveDifficulty.put(Arrays.asList("음악관", "음악관"), new MoveDto(false, Difficulty.LOW));
        moveDifficulty.put(Arrays.asList("음악관", "종합과학관"), new MoveDto(true, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("음악관", "포스코관"), new MoveDto(true, Difficulty.MEDIUM));

        // 종합과학관
        moveDifficulty.put(Arrays.asList("종합과학관", "ECC"), new MoveDto(false, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("종합과학관", "공학관"), new MoveDto(false, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("종합과학관", "대강당"), new MoveDto(false, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("종합과학관", "포스코관"), new MoveDto(false, Difficulty.LOW));
        moveDifficulty.put(Arrays.asList("종합과학관", "학관"), new MoveDto(false, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("종합과학관", "조형예술관"), new MoveDto(false, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("종합과학관", "종합과학관"), new MoveDto(false, Difficulty.LOW));
        moveDifficulty.put(Arrays.asList("종합과학관", "교육관"), new MoveDto(false, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("종합과학관", "국제교육관"), new MoveDto(false, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("종합과학관", "법학관"), new MoveDto(false, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("종합과학관", "헬렌관"), new MoveDto(false, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("종합과학관", "연구협력관"), new MoveDto(true, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("종합과학관", "테니스장"), new MoveDto(true, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("종합과학관", "생활관"), new MoveDto(false, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("종합과학관", "약학관"), new MoveDto(false, Difficulty.LOW));
        moveDifficulty.put(Arrays.asList("종합과학관", "신세계관"), new MoveDto(false, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("종합과학관", "sk텔레콤관(정보관)"), new MoveDto(false, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("종합과학관", "체육관"), new MoveDto(false, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("종합과학관", "음악관"), new MoveDto(false, Difficulty.HIGH));

        // 포스코관
        moveDifficulty.put(Arrays.asList("포스코관", "포스코관"), new MoveDto(false, Difficulty.LOW));
        moveDifficulty.put(Arrays.asList("포스코관", "ECC"), new MoveDto(false, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("포스코관", "공학관"), new MoveDto(true, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("포스코관", "대강당"), new MoveDto(false, Difficulty.LOW));
        moveDifficulty.put(Arrays.asList("포스코관", "신세계관"), new MoveDto(false, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("포스코관", "종합과학관"), new MoveDto(false, Difficulty.LOW));
        moveDifficulty.put(Arrays.asList("포스코관", "학관"), new MoveDto(false, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("포스코관", "교육관"), new MoveDto(false, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("포스코관", "국제교육관"), new MoveDto(false, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("포스코관", "법학관"), new MoveDto(false, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("포스코관", "헬렌관"), new MoveDto(false, Difficulty.LOW));
        moveDifficulty.put(Arrays.asList("포스코관", "연구협력관"), new MoveDto(true, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("포스코관", "테니스장"), new MoveDto(true, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("포스코관", "생활관"), new MoveDto(false, Difficulty.LOW));
        moveDifficulty.put(Arrays.asList("포스코관", "약학관"), new MoveDto(false, Difficulty.LOW));
        moveDifficulty.put(Arrays.asList("포스코관", "sk텔레콤관(정보관)"), new MoveDto(false, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("포스코관", "조형예술관"), new MoveDto(false, Difficulty.LOW));
        moveDifficulty.put(Arrays.asList("포스코관", "체육관"), new MoveDto(false, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("포스코관", "음악관"), new MoveDto(false, Difficulty.MEDIUM));

        // 완성된 이동난이도 Map을 리턴
        return moveDifficulty;

    }
}
