package LLD.StackOverflow;

import java.util.HashMap;
import java.util.Map;

public class StackOverflow {
    private Map<Integer, Question> questions;
    private Map<Integer, Answer> answers;
    private Map<Integer, User> users;

    public StackOverflow(){
        questions = new HashMap<>();
        answers = new HashMap<>();
        users = new HashMap<>();
    }

    public User createUser(String username, String email){
        User user = new User(users.size() + 1, username, email);
        users.put(users.size() + 1, user);
        return user;
    }

    public Question postQuestion(User user, String title, String content){
        Question question = new Question(title, content);
        user.getQuestions().add(question);
        questions.put(question.getId(), question);
        return question;
    }

    public Answer answerQuestion(User user, Question question, String content){
        Answer answer = new Answer(content);
        user.getAnswers().add(answer);
        answers.put(answer.getId(), answer);
        return answer;
    }

    public Comment postComment(User user, Commentable commentable, String content){
        Comment comment = new Comment();
        user.getComments().add(comment);
        return comment;
    }

}
