package SamwaMoney.TimeTableArtist.Comment.Service;

import SamwaMoney.TimeTableArtist.Comment.entity.PlusComment;
import SamwaMoney.TimeTableArtist.Comment.repository.PlusCommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class PlusCommentService {
    private final PlusCommentRepository plusCommentRepository;

    @Transactional(readOnly = true)
    public PlusComment findPlusCommentById (Long id) {
        return plusCommentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("존재하지 않는 PlusComment입니다!"));
    }
}
