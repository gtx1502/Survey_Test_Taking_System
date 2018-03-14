import java.util.ArrayList;
import java.util.Scanner;

public class MultipleChoice extends Question {
    private int choiceNum;
    private ArrayList<String> choices = new ArrayList<>();         //list of choices
    private ArrayList<String> rightAnswers = new ArrayList<>();

    /**
     * Create a multiple choice question
     */
    public void create() {
        while (prompt == null) {
            System.out.println("Enter the prompt for your question");
            Scanner input = new Scanner(System.in);
            prompt = input.nextLine();
        }
        System.out.println("Enter the number of choices for your multiple choice question.");
        Scanner input = new Scanner(System.in);
        while (!input.hasNextInt()) {
            System.out.println("please put in a positive number");
            input = new Scanner(System.in);
        }
        choiceNum = input.nextInt();
        while (choiceNum < 1) {
            System.out.println("please put in a positive number");
            input = new Scanner(System.in);
            choiceNum = input.nextInt();
        }
        for (int i = 0; i < choiceNum; i++) {
            System.out.println("Enter choice #" + (i + 1));
            String choice = input.next();
            choices.add("(" + (i + 1) + ")" + choice);
            //answerHandle.setChoice("(" + (i + 1) + ")" + choice);
        }
    }

    /**
     * Display a multiple choice question
     */
    public void display() {
        System.out.println(prompt);
        for (int i = 0; i < choices.size(); i++) {
            System.out.print(choices.get(i) + " ");
        }
        System.out.print("\n");
        if (rightAnswers.size() > 0) {
            System.out.print("The correct answer is ");
            for (int i = 0; i < rightAnswers.size(); i++) {
                System.out.print(rightAnswers.get(i) + " ");
            }
            System.out.print("\n");
        }
    }

    /**
     * Set the correct answer of a multiple choice question
     */
    public void setRightAnswer() {
        System.out.println("Enter the number of correct answers");
        Scanner input = new Scanner(System.in);
        while (!input.hasNextInt()) {
            System.out.println("Please enter a positive number");
            input = new Scanner(System.in);
        }
        int num = input.nextInt();
        while (num < 1) {
            System.out.println("Please enter a positive number");
            input = new Scanner(System.in);
            num = input.nextInt();
        }
        for (int i = 0; i < num; i++) {
            System.out.println("Enter the index of correct answer" + (i + 1));
            while (!input.hasNextInt()) {
                System.out.println("Please enter a number from 1 to " + choiceNum);
                input = new Scanner(System.in);
            }
            int answer = input.nextInt();
            while (answer < 1 || answer > choiceNum) {
                System.out.println("Please choose a number from 1 to " + choiceNum);
                input = new Scanner(System.in);
                answer = input.nextInt();
            }
            rightAnswers.add(choices.get(answer - 1));
            //answerHandle.setRightAnswer(answerHandle.getChoice(answer - 1));
        }
    }
}