package SamwaMoney.TimeTableArtist.Timetable.dto;

import SamwaMoney.TimeTableArtist.Class.dto.ClassDto;
import SamwaMoney.TimeTableArtist.Comment.dto.CommentResponseDto;
import SamwaMoney.TimeTableArtist.Timetable.domain.Timetable;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class TimetableFullResponseDto {

    private Long memberId;  // 작성자 ID
    private Long timetableId;   // 시간표 ID
    private Long score;      // 점수
    private Long tableType;     // 시간표 유형의 ID (해당되는 스페셜 코멘트의 ID)
    private String tableTypeContent;    // 시간표 유형 내용
    private Boolean classHide;  // 수업명 숨기기 여부
    private String photo;       // 시간표의 유형에 해당하는 짤의 ImgURL
    private LocalDateTime createdAt;    // 작성일시
    private List<ClassDto> classList;   // 수업 목록
    private List<CommentResponseDto> plusComments;
    private List<CommentResponseDto> minusComments;
    private List<CommentResponseDto> specialComments;


    @Builder
    public TimetableFullResponseDto(Timetable table, List<ClassDto> classList,
                                    List<CommentResponseDto> plusComments,
                                    List<CommentResponseDto> minusComments,
                                    List<CommentResponseDto> specialComments) {
        this.memberId = table.getOwner().getMemberId();
        this.timetableId = table.getTimetableId();
        this.score = table.getScore();
        this.tableType = table.getTableType();
        this.tableTypeContent = table.getTableTypeContent();
        this.classHide = table.isClassHide();
        this.photo = table.getImgUrl();
        this.createdAt = table.getCreatedAt();
        this.classList = classList;
        this.plusComments = plusComments;
        this.minusComments = minusComments;
        this.specialComments = specialComments;
    }

}