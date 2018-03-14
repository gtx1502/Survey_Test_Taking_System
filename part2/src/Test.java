import java.io.*;
import java.util.Iterator;

public class Test extends Survey implements Serializable {
    private AnswerSheet answerSheet = new AnswerSheet();

    /**
     * Create a new test question
     */
    public void create() {
        super.displayMenu();
        int choice = io.readInt(QUESTION_NUM);
        Question question;
        Answer answer;
        switch (choice) {
            case 1:
                question = new TrueFalse();
                answer = new TrueFalseAnswer();
                break;
            case 2:
                question = new MultipleChoice();
                answer = new MultipleChoiceAnswer((MultipleChoice) question);
                break;
            case 3:
                question = new ShortQuestion();
                answer = new ShortAnswer();
                break;
            case 4:
                question = new EssayQuestion();
                answer = null;
                break;
            case 5:
                question = new Rank();
                answer = new RankAnswer((Rank) question);
                break;
            case 6:
                question = new Match();
                answer = new MatchAnswer((Match) question);
                break;
            default:
                question = null;
                answer = null;
        }
        question.create();
        questions.add(question);
        if (answer != null)
            answer.create();
        answerSheet.addAnswer(answer);
    }

    /**
     * Display a test
     */
    public void display() {
        io.writeLine("A Test");
        Iterator<Question> iterator = questions.iterator();
        int count = 0;
        while (iterator.hasNext()) {
            Question question = iterator.next();
            io.write((count + 1) + ")");
            question.display();
            if (answerSheet.getAnswer(count) != null)
                answerSheet.getAnswer(count).display();
            count++;
        }
    }

    /**
     * Modify a test
     */
    public void modify() {
        display();
        io.writeLine("Do you want to modify questions(1),or remove a question(2),or add a question(3)?");
        int choice;
        int modify = io.readInt(3);
        switch (modify) {
            case 1:
                choice = super.modifyQuestionWithoutAnswer();
                modifyAnswer(choice);
                break;
            case 2:
                io.writeLine("Which choice do you want to remove?");
                choice = io.readInt(questions.size());
                questions.remove(choice - 1);
                answerSheet.removeAnswer(choice - 1);
                break;
            case 3:
                create();
                break;
        }
    }

    private void modifyAnswer(int choice) {
        io.writeLine("Do you wish to modify the correct answer? Please modify the correct answer if you have already change the choices of correct answer");
        Boolean response = checkResponse();
        if (response)
            answerSheet.getAnswer(choice - 1).modify();
    }
}