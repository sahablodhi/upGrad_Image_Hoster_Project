package ImageHoster.model;

import javax.persistence.*;
import java.time.LocalDate;

//@Entity annotation specifies that the corresponding class is a JPA entity
@Entity
// @Table annotation provides more options to customize the mapping.
// Here the name of the table to be created in the database is explicitly
// mentioned as 'comments'. Hence the table named 'comments' will be created in
// the database with all the columns mapped to all the attributes in 'Comment'
// class
@Table(name = "comments")
public class Comment {

    // @Id annotation specifies that the corresponding attribute is a primary key
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    // @Column annotation specifies that the attribute will be mapped to the column
    // in the database.
    // Here the column name is explicitly mentioned as 'id'
    private Integer id;

    @Column(name = "text")
    private String text;

    @Column(name = "created_at")
    private LocalDate createdDate;

    // The 'comments' table is mapped to 'users' table with Many:One mapping
    // One Image can have only one user (owner) but one user can have multiple
    // comments
    // FetchType is EAGER
    @ManyToOne(fetch = FetchType.EAGER)
    // Below annotation indicates that the name of the column in 'comments' table
    // referring the primary key in 'users' table will be 'user_id'
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "image_id")
    private Image image;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}