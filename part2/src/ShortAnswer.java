import java.util.Iterator;

public class ShortAnswer extends Answer {
    private final int DOWN = 1;         //最低字符数
    private final int UP = 80;          //最高字符数

    /**
     * Create the correct answer of a short answer question
     */
    public void create() {
        int answerNum = getNum();
        for (int i = 0; i < answerNum; i++) {
            io.writeLine("Enter correct answer " + (i + 1));
            String answer = io.readLine();
            while (answer.length() < DOWN || answer.length() > UP) {
                io.writeLine("The number of characters should be between" + DOWN + "and" + UP);
                answer = io.readLine();
            }
            rightAnswers.add(answer);
        }
    }

    /**
     * display the correct answer of a short answer question
     */
    public void display() {
        io.writeLine("The correct answer is :");
        Iterator<String> iterator = rightAnswers.iterator();
        int count = 0;
        while (iterator.hasNext()) {
            String answer = iterator.next();
            io.writeLine("(" + (count + 1) + ")" + answer);
            count++;
        }
    }

    /**
     * Modify the correct answer of a short answer question
     */
    public void modify() {
        int answerNum = getNum();
        for (int i = 0; i < answerNum; i++) {
            io.writeLine("Enter reference answer " + (i + 1));
            String answer = io.readLine();
            while (answer.length() < DOWN || answer.length() > UP) {
                io.writeLine("The number of characters should be between" + DOWN + "and" + UP);
                answer = io.readLine();
            }
            rightAnswers.set(i, answer);
        }
    }

    /**
     * Parse the input
     *
     * @return the number of correct answers
     */
    private int getNum() {
        io.writeLine("Enter the number of correct answers");
        return io.readInt(0);
    }
}