import java.util.Iterator;

public class MultipleChoiceAnswer extends Answer {
    private MultipleChoice multipleChoice;

    MultipleChoiceAnswer(MultipleChoice multipleChoice) {
        this.multipleChoice = multipleChoice;
    }

    /**
     * Create the correct answer of a multiple choice question
     */
    public void create() {
        int choiceNum = multipleChoice.getChoicesNum();
        int num = getNum();
        for (int i = 0; i < num; i++) {
            io.writeLine("Enter the index of correct answer" + (i + 1));
            int answer = io.readInt(choiceNum);
            rightAnswers.add(multipleChoice.getChoice(answer - 1));
        }
    }

    /**
     * Display the correct answer of a multiple choice question
     */
    public void display() {
        io.write("The correct answer is: ");
        Iterator<String> iter = rightAnswers.iterator();
        while (iter.hasNext()) {
            String multipleChoiceAnswer = iter.next();
            io.write(multipleChoiceAnswer + "   ");
        }
        io.write("\n");
    }

    /**
     * Modify the correct answer of a multiple choice question
     */
    public void modify() {
        rightAnswers.clear();
        create();
    }

    /**
     * Parse the input
     *
     * @return the number of correct answers
     */
    private int getNum() {
        int choiceNum = multipleChoice.getChoicesNum();
        io.writeLine("Enter the number of correct answers");
        return io.readInt(choiceNum);
    }
}