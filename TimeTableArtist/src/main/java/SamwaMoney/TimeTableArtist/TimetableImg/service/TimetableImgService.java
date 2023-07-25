package SamwaMoney.TimeTableArtist.TimetableImg.service;

import SamwaMoney.TimeTableArtist.TimetableImg.domain.TimetableImg;
import SamwaMoney.TimeTableArtist.TimetableImg.dto.TimetableImgDto;
import SamwaMoney.TimeTableArtist.TimetableImg.repository.TimetableImgRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimetableImgService {

    private final TimetableImgRepository timetableImgRepository;

    @Autowired
    public TimetableImgService(TimetableImgRepository timetableImgRepository) {
        this.timetableImgRepository = timetableImgRepository;
    }

    public TimetableImg saveTimetableImage(String imageUrl) {
        TimetableImg timetableImg = new TimetableImg.Builder(imageUrl).build();
        return timetableImgRepository.save(timetableImg);
    }

    public TimetableImgDto getTimetableImageById(Long id) {
        TimetableImg timetableImg = timetableImgRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 ID의 이미지를 찾을 수 없습니다."));
        return new TimetableImgDto(timetableImg.getImageUrl());
    }
}

