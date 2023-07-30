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
import java.util.List;
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
        List<Long> plusCommentIds = plusCommentRepository.findAll()
                .stream()
                .map(PlusComment::getPlusCommentId)
                .collect(Collectors.toList());

        System.out.println("받아온 Plus 댓글 ID들: " + plusCommentIds);
        return plusCommentIds.stream()
                .map(Long::intValue)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    // MinusComment 엔티티의 모든 commentId 조회하여 ArrayList로 반환
    public ArrayList<Integer> getAllMinusCommentIds() {
        List<Long> minusCommentIds = minusCommentRepository.findAll()
                .stream()
                .map(MinusComment::getMinusCommentId)
                .collect(Collectors.toList());

        System.out.println("받아온 Minus 댓글 ID들: " + minusCommentIds);
        return minusCommentIds.stream()
                .map(Long::intValue)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    // SpecialComment 엔티티의 모든 commentId 조회하여 ArrayList로 반환
    public ArrayList<Integer> getAllSpecialCommentIds() {
        List<Long> specialCommentIds = specialCommentRepository.getAllIds();

        System.out.println("받아온 Special 댓글 ID들: " + specialCommentIds);
        return specialCommentIds.stream()
                .map(Long::intValue)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
