package SamwaMoney.TimeTableArtist.TimetableImg.dto;

import SamwaMoney.TimeTableArtist.TimetableImg.domain.TimetableImg;

public class TimetableImgDto {

    private String imageUrl; // AWS S3에 저장된 이미지의 URL

    public void TimetableImgDTO(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
