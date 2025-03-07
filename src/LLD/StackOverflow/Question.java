package LLD.StackOverflow;

import java.util.List;

public class Question implements Commentable, Votable{
    private int id;
    private String title;
    private String content;

    public Question(String title, String content){
        this.id = genId();
        this.title = title;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
