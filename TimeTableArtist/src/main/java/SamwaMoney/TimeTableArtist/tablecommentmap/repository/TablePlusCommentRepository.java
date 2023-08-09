package SamwaMoney.TimeTableArtist.tablecommentmap.repository;

import SamwaMoney.TimeTableArtist.tablecommentmap.domain.TablePlusComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TablePlusCommentRepository  extends JpaRepository<TablePlusComment, Long> {
}
