import java.util.ArrayList;
import java.util.Scanner;

public class EssayAnswer extends Question {
    private int downLimit = 81;
    private int upLimit = 1000;
    private int answerNum;
    private ArrayList<String> rightAnswers = new ArrayList<>();

    /**
     * Create an essay question
     */
    public void create() {
        while (prompt == null) {
            System.out.println("Enter the prompt for your question");
            Scanner input = new Scanner(System.in);
            prompt = input.nextLine();
        }
    }

    /**
     * Display an essay question
     */
    public void display() {
        System.out.println(prompt);
        if (rightAnswers.size() > 0) {
            System.out.println("The reference answer is :");
            for (int i = 0; i < rightAnswers.size(); i++)
                System.out.println("(" + (i + 1) + ")" + rightAnswers.get(i));
        }
    }

    /**
     * Set reference answer of essay question
     */
    public void setRightAnswer() {
        System.out.println("Enter the number of right answers");
        Scanner input = new Scanner(System.in);
        while (!input.hasNextInt()) {
            System.out.println("Please enter a positive number");
            input = new Scanner(System.in);
        }
        answerNum = input.nextInt();
        while (answerNum < 1) {
            System.out.println("Please enter a positive number");
            input = new Scanner(System.in);
            answerNum = input.nextInt();
        }
        for (int i = 0; i < answerNum; i++) {
            System.out.println("Enter correct answer " + (i + 1));
            String answer = input.next();
            while (answer.length() < downLimit || answer.length() > upLimit) {
                System.out.println("The number of characters should be between" + downLimit + "and" + upLimit);
                input = new Scanner(System.in);
                answer = input.next();
            }
            rightAnswers.add(answer);
        }
    }
}