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

        //  - data1~data6을 채점하기 위한 이동난이도 쌍
        moveDifficulty.put(Arrays.asList("학관", "학관"), new MoveDto(false, Difficulty.LOW));
        moveDifficulty.put(Arrays.asList("학관", "ECC"), new MoveDto(false, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("학관", "공학관"), new MoveDto(true, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("ECC", "학관"), new MoveDto(true, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("공학관", "학관"), new MoveDto(false, Difficulty.HIGH));
        //  - data7(삼와머니 팀원들이 모은 시간표)을 채점하기 위한 이동난이도 쌍
        moveDifficulty.put(Arrays.asList("ECC", "ECC"), new MoveDto(false, Difficulty.LOW));
        moveDifficulty.put(Arrays.asList("공학관", "공학관"), new MoveDto(false, Difficulty.LOW));
        moveDifficulty.put(Arrays.asList("신세계관", "신세계관"), new MoveDto(false, Difficulty.LOW));
        moveDifficulty.put(Arrays.asList("조형예술관", "조형예술관"), new MoveDto(false, Difficulty.LOW));
        moveDifficulty.put(Arrays.asList("종합과학관", "종합과학관"), new MoveDto(false, Difficulty.LOW));
        moveDifficulty.put(Arrays.asList("포스코관", "포스코관"), new MoveDto(false, Difficulty.LOW));
        moveDifficulty.put(Arrays.asList("ECC", "대강당"), new MoveDto(true, Difficulty.LOW));
        moveDifficulty.put(Arrays.asList("ECC", "신세계관"), new MoveDto(true, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("ECC", "조형예술관"), new MoveDto(true, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("ECC", "종합과학관"), new MoveDto(true, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("ECC", "포스코관"), new MoveDto(true, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("ECC", "학관"), new MoveDto(true, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("sk텔레콤관(정보관)", "공학관"), new MoveDto(true, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("sk텔레콤관(정보관)", "대강당"), new MoveDto(true, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("공학관", "sk텔레콤관(정보관)"), new MoveDto(false, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("공학관", "대강당"), new MoveDto(false, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("공학관", "종합과학관"), new MoveDto(false, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("공학관", "포스코관"), new MoveDto(false, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("대강당", "sk텔레콤관(정보관)"), new MoveDto(false, Difficulty.LOW));
        moveDifficulty.put(Arrays.asList("대강당", "ECC"), new MoveDto(false, Difficulty.LOW));
        moveDifficulty.put(Arrays.asList("대강당", "공학관"), new MoveDto(true, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("대강당", "신세계관"), new MoveDto(false, Difficulty.LOW));
        moveDifficulty.put(Arrays.asList("대강당", "조형예술관"), new MoveDto(true, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("대강당", "종합과학관"), new MoveDto(true, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("대강당", "포스코관"), new MoveDto(true, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("대강당", "학관"), new MoveDto(false, Difficulty.LOW));
        moveDifficulty.put(Arrays.asList("신세계관", "ECC"), new MoveDto(false, Difficulty.LOW));
        moveDifficulty.put(Arrays.asList("신세계관", "대강당"), new MoveDto(true, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("신세계관", "포스코관"), new MoveDto(true, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("신세계관", "조형예술관"), new MoveDto(false, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("조형예술관", "ECC"), new MoveDto(false, Difficulty.LOW));
        moveDifficulty.put(Arrays.asList("조형예술관", "대강당"), new MoveDto(false, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("조형예술관", "신세계관"), new MoveDto(false, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("종합과학관", "ECC"), new MoveDto(false, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("종합과학관", "공학관"), new MoveDto(false, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("종합과학관", "대강당"), new MoveDto(false, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("종합과학관", "포스코관"), new MoveDto(false, Difficulty.LOW));
        moveDifficulty.put(Arrays.asList("종합과학관", "학관"), new MoveDto(false, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("포스코관", "ECC"), new MoveDto(false, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("포스코관", "공학관"), new MoveDto(true, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("포스코관", "대강당"), new MoveDto(false, Difficulty.LOW));
        moveDifficulty.put(Arrays.asList("포스코관", "신세계관"), new MoveDto(false, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("포스코관", "종합과학관"), new MoveDto(false, Difficulty.LOW));
        moveDifficulty.put(Arrays.asList("포스코관", "학관"), new MoveDto(false, Difficulty.HIGH));
        moveDifficulty.put(Arrays.asList("학관", "ECC"), new MoveDto(false, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("학관", "대강당"), new MoveDto(false, Difficulty.LOW));
        moveDifficulty.put(Arrays.asList("학관", "종합과학관"), new MoveDto(true, Difficulty.MEDIUM));
        moveDifficulty.put(Arrays.asList("학관", "포스코관"), new MoveDto(true, Difficulty.LOW));

        // 완성된 이동난이도 Map을 리턴
        return moveDifficulty;

    }
}
