import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class Survey implements Serializable {
    ArrayList<Question> questions = new ArrayList<>();
    final int QUESTION_NUM = 6;       //问题种类数
    public static IO io = new IO();

    /**
     * Create a new survey question
     */
    public void create() {
        displayMenu();
        int choice = io.readInt(QUESTION_NUM);
        Question question;
        switch (choice) {
            case 1:
                question = new TrueFalse();
                break;
            case 2:
                question = new MultipleChoice();
                break;
            case 3:
                question = new ShortQuestion();
                break;
            case 4:
                question = new EssayQuestion();
                break;
            case 5:
                question = new Rank();
                break;
            case 6:
                question = new Match();
                break;
            default:
                question = null;
        }
        question.create();
        questions.add(question);
    }

    /**
     * Display a survey
     */
    public void display() {
        io.writeLine("A Survey");
        Iterator<Question> iterator = questions.iterator();
        int count = 0;
        while (iterator.hasNext()) {
            Question question = iterator.next();
            io.writeLine((count + 1) + ")");
            question.display();
            count++;
        }
    }

    /**
     * Modify a survey
     */
    public void modify() {
        display();
        io.writeLine("Do you want to modify questions(1),or remove a question(2),or add a question(3)?");
        int choice;
        int modify = io.readInt(3);
        switch (modify) {
            case 1:
                modifyQuestionWithoutAnswer();
                break;
            case 2:
                io.writeLine("Which choice do you want to remove?");
                choice = io.readInt(questions.size());
                questions.remove(choice - 1);
                break;
            case 3:
                create();
                break;
        }
    }

    int modifyQuestionWithoutAnswer() {
        Boolean response;
        io.writeLine("What question do you wish to modify? Please choose a number from 1 to " + questions.size());
        int choice = io.readInt(questions.size());
        questions.get(choice - 1).display();
        io.writeLine("Do you wish to modify the prompt? Enter Yes or No");
        response = checkResponse();
        if (response) {
            io.writeLine(questions.get(choice - 1).prompt);
            questions.get(choice - 1).modify(1);
        }
        if (questions.get(choice - 1).getChoicesNum() > 0) {
            io.writeLine("Do you wish to modify choices?");
            response = checkResponse();
            if (response) {
                questions.get(choice - 1).displayChoices();
                questions.get(choice - 1).modify(2);
            }
        }
        return choice;
    }

    boolean checkResponse() {
        String res = io.read();
        while (!res.equals("Yes") && !res.equals("No")) {
            io.writeLine("Enter Yes or No");
            res = io.read();
        }
        return res.equals("Yes");
    }

    void displayMenu() {
        io.writeLine("Menu 2");
        io.writeLine("1) Add a new T/F question");
        io.writeLine("2) Add a new multiple choice question");
        io.writeLine("3) Add a new short answer question");
        io.writeLine("4) Add a new essay question");
        io.writeLine("5) Add a new ranking question");
        io.writeLine("6) Add a new matching question ");
    }
}