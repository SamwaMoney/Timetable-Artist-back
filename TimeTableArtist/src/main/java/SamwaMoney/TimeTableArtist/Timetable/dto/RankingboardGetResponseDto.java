package SamwaMoney.TimeTableArtist.Timetable.dto;

import SamwaMoney.TimeTableArtist.Timetable.domain.Timetable;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class RankingboardGetResponseDto {
    private Long timetableId;
    private String username;
    private Long score;
    private boolean ranking;
    private boolean classHide;
    private String imgUrl;
    private String tableTypeContent;
    private Long likeCount;
    private Long replyCount;
    private boolean isLiked;

    public RankingboardGetResponseDto() {

    }

    public void setIsLiked(boolean isLiked) {
        this.isLiked = isLiked;
    }

    public static RankingboardGetResponseDto from(Timetable timetable, boolean isLiked) {
        RankingboardGetResponseDto dto = new RankingboardGetResponseDto();
        dto.setTimetableId(timetable.getTimetableId());
        dto.setUsername(timetable.getOwner().getUsername());
        dto.setScore(timetable.getScore());
        dto.setRanking(timetable.isRanking());
        dto.setClassHide(timetable.isClassHide());
        dto.setImgUrl(timetable.getImgUrl());
        dto.setTableTypeContent(timetable.getTableTypeContent());
        dto.setLikeCount(timetable.getLikeCount());
        dto.setReplyCount(timetable.getReplyCount());
        dto.setIsLiked(isLiked);
        return dto;
    }


//    private List<RankingboardList> rankingboardList;
//
//    public static RankingboardGetResponseDto of(List<Timetable> timetableList) {
//        return RankingboardGetResponseDto.builder()
//                .rankingboardList(timetableList.stream().map(RankingboardList::of).collect(Collectors.toList()))
//                .build();
//    }
//
//    public static class RankingboardList {
//        private Long timetableId;
//        private String username;
//        private Long score;
//        private boolean ranking;
//        private boolean classHide;
//        private String imgUrl;
//        private String tableTypeContent;
//        private Long likeCount;
//        private Long replyCount;
//        private boolean isLiked;
//
//        public RankingboardList(Timetable timetable) {
//            this.timetableId = timetable.getTimetableId();
//            this.username = timetable.getOwner().getUsername();
//            this.score = timetable.getScore();
//            this.ranking = timetable.isRanking();
//            this.classHide = timetable.isClassHide();
//            this.imgUrl = timetable.getImgUrl();
//            this.tableTypeContent = timetable.getTableTypeContent();
//            this.likeCount = timetable.getLikeCount();
//            this.replyCount = timetable.getReplyCount();
//            this.isLiked = timetable.isLiked();
//        }
//
//        public static RankingboardList of(Timetable timetable) {
//            return new RankingboardList(timetable);
//        }
//    }
}
