package LLD.StackOverflow;

import java.util.ArrayList;
import java.util.List;

public class Answer implements Commentable, Votable{
    private int id;
    private String content;
    private List<Comment> comments;

    public Answer(String content){
        this.id = genId();
        this.content = content;
        comments = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public void postComment(Comment comment) {

    }

    @Override
    public List<Comment> getComments() {
        return List.of();
    }

    @Override
    public void vote(User user, int value) {

    }

    @Override
    public int getVoteCount() {
        return 0;
    }

    private int genId(){
        return 0;
    }
}
