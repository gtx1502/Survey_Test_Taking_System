
public class TrueFalseAnswer extends Answer {
    /**
     * Create the correct answer of a T/F question
     */
    public void create() {
        io.writeLine("Enter correct answer(T/F)");
        String answer = io.readLine();
        while (!answer.equals("T") && !answer.equals("F")) {
            io.writeLine("Please put in T or F");
            answer = io.readLine();
        }
        rightAnswers.add(answer);
    }

    /**
     * Display the correct answer of a T/F question
     */
    public void display() {
        io.writeLine("The correct answer is " + rightAnswers.get(0));
    }

    /**
     * Modify the correct answer of a T/F question
     */
    public void modify() {
        io.writeLine("Enter the new correct answer");
        String newAnswer = io.readLine();
        while (!newAnswer.equals("T") && !newAnswer.equals("F")) {
            io.writeLine("Please put in T or F");
            newAnswer = io.readLine();
        }
        rightAnswers.set(0, newAnswer);
    }
}