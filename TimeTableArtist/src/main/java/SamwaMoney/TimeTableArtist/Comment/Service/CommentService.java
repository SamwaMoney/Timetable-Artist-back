package SamwaMoney.TimeTableArtist.Comment.Service;

import SamwaMoney.TimeTableArtist.Comment.entity.MinusComment;
import SamwaMoney.TimeTableArtist.Comment.entity.PlusComment;
import SamwaMoney.TimeTableArtist.Comment.entity.SpecialComment;
import SamwaMoney.TimeTableArtist.Comment.repository.MinusCommentRepository;
import SamwaMoney.TimeTableArtist.Comment.repository.PlusCommentRepository;
import SamwaMoney.TimeTableArtist.Comment.repository.SpecialCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
public class CommentService {
    private final PlusCommentRepository plusCommentRepository;
    private final MinusCommentRepository minusCommentRepository;
    private final SpecialCommentRepository specialCommentRepository;

    @Autowired
    public CommentService(PlusCommentRepository plusCommentRepository,
                          MinusCommentRepository minusCommentRepository,
                          SpecialCommentRepository specialCommentRepository) {
        this.plusCommentRepository = plusCommentRepository;
        this.minusCommentRepository = minusCommentRepository;
        this.specialCommentRepository = specialCommentRepository;
    }

    // PlusComment 엔티티의 모든 commentId 조회하여 ArrayList로 반환
    public ArrayList<Integer> getAllPlusCommentIds() {
        return plusCommentRepository.findAll().stream()
                .map(PlusComment::getPlusCommentId)
                .map(Long::intValue)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    // MinusComment 엔티티의 모든 commentId 조회하여 ArrayList로 반환
    public ArrayList<Integer> getAllMinusCommentIds() {
        return minusCommentRepository.findAll().stream()
                .map(MinusComment::getMinusCommentId)
                .map(Long::intValue)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    // SpecialComment 엔티티의 모든 commentId 조회하여 ArrayList로 반환
    public ArrayList<Integer> getAllSpecialCommentIds() {
        return specialCommentRepository.findAll().stream()
                .map(SpecialComment::getSpecialCommentId)
                .map(Long::intValue)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
