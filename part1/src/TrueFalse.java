import java.util.Scanner;

public class TrueFalse extends Question {
    private String rightAnswer;      //correct answer

    /**
     * create a T/F question
     */
    public void create() {
        while (prompt == null) {
            System.out.println("Enter the prompt for your question");
            Scanner input = new Scanner(System.in);
            prompt = input.nextLine();
        }
    }

    /**
     * Display a T/F question
     */
    public void display() {
        System.out.println(prompt);
        System.out.println("T/F");
        if (rightAnswer != null)
            System.out.println("The correct answer is " + rightAnswer);
    }

    /**
     * Set the correct answer of a T/F question
     */
    public void setRightAnswer() {
        System.out.println("Enter correct answer(T/F)");
        Scanner input = new Scanner(System.in);
        String answer = input.next();
        while (!answer.equals("T") && !answer.equals("F")) {
            System.out.println("Please put in T or F");
            input = new Scanner(System.in);
            answer = input.next();
        }
        rightAnswer = answer;
    }
}