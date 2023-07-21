package SamwaMoney.TimeTableArtist.Reply.dto;

import SamwaMoney.TimeTableArtist.Member.domain.Member;
import SamwaMoney.TimeTableArtist.Reply.domain.Reply;
import SamwaMoney.TimeTableArtist.Timetable.domain.Timetable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReplyRequestDto {
    private Long memberId;
    private String content;

    public Reply toEntity(Timetable timetable, Member writer){
        return Reply.builder()
                .timetable(timetable)
                .writer(writer)
                .content(this.content)
                .build();
    }
}
