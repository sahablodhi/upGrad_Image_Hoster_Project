package ImageHoster.service;

import ImageHoster.model.Comment;
import ImageHoster.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    // The method calls the createComment() method in the Repository and passes the
    // comment to be persisted in the database
    public void createNewComment(Comment comment) {
        commentRepository.createComment(comment);
    }
}