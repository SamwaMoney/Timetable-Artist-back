package SamwaMoney.TimeTableArtist.Comment.Service;

import SamwaMoney.TimeTableArtist.Comment.entity.MinusComment;
import SamwaMoney.TimeTableArtist.Comment.repository.MinusCommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class MinusCommentService {

    private final MinusCommentRepository minusCommentRepository;

    @Transactional(readOnly = true)
    public MinusComment findMinusCommentById (Long id) {
        return minusCommentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("존재하지 않는 MinusComment입니다!"));

    }
}
