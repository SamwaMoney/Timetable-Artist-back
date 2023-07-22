package SamwaMoney.TimeTableArtist.Class.dto;

import SamwaMoney.TimeTableArtist.Class.domain.Class;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ClassListDto {
    Long classListId;
    List<ClassDto> classList; // 모든 수업의 리스트
    List<ClassDto> monday; // 월요일 수업 리스트
    List<ClassDto> tuesday; // 화요일 수업 리스트
    List<ClassDto> wednesday; // 수요일 수업 리스트
    List<ClassDto> thursday; // 목요일 수업 리스트
    List<ClassDto> friday; // 금요일 수업 리스트
}
