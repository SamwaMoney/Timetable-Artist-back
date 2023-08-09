package SamwaMoney.TimeTableArtist.tablecommentmap.repository;

import SamwaMoney.TimeTableArtist.tablecommentmap.domain.TableMinusComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TableMinusCommentRepository extends JpaRepository<TableMinusComment, Long> {
}
