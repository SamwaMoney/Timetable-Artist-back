package SamwaMoney.TimeTableArtist.Comment.Service;

import SamwaMoney.TimeTableArtist.Comment.entity.PlusComment;
import SamwaMoney.TimeTableArtist.Comment.entity.SpecialComment;
import SamwaMoney.TimeTableArtist.Comment.repository.SpecialCommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class SpecialCommentService {
    private final SpecialCommentRepository specialCommentRepository;

    @Transactional(readOnly = true)
    public SpecialComment findSpecialCommentById (Long id) {
        return specialCommentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("존재하지 않는 SpecialComment입니다!"));
    }
}
