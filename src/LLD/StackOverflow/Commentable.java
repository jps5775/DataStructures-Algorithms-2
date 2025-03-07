package LLD.StackOverflow;

import java.util.List;

public interface Commentable {
    void postComment(Comment comment);
    List<Comment> getComments();
}
