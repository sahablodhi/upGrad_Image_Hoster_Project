package ImageHoster.repository;

import ImageHoster.model.Comment;
import org.springframework.stereotype.Repository;

import javax.persistence.*;

@Repository
public class CommentRepository {

    @PersistenceUnit(unitName = "imageHoster")
    private EntityManagerFactory emf;

    // The method receives the Comment object to be persisted in the database
    // Creates an instance of EntityManager
    // Starts a transaction
    // The transaction is committed if it is successful
    // The transaction is rolled back in case of unsuccessful transaction
    public Comment createComment(Comment newComment) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.persist(newComment);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }

        return newComment;
    }

}