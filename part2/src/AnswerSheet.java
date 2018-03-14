import java.io.Serializable;
import java.util.ArrayList;

class AnswerSheet implements Serializable {
    private ArrayList<Answer> answerArrayList = new ArrayList<>();

    void addAnswer(Answer answer) {
        this.answerArrayList.add(answer);
    }

    Answer getAnswer(int index) {
        return answerArrayList.get(index);
    }
    void removeAnswer(int index){
        answerArrayList.remove(index);
    }
}
