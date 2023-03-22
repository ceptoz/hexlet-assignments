package exercise.repository;

import exercise.model.Comment;
import liquibase.pro.packaged.C;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {

    // BEGIN
    Iterable<Comment> findAllByPostId(long postId);
    Optional<Comment> findByIdAndPostId(Long id, Long postId);
    // END
}
