import java.util.ArrayList;
import java.util.Scanner;

public class Match extends Question {
    private ArrayList<String> rightAnswers = new ArrayList<>();    //list of correct answers
    private ArrayList<String> column1 = new ArrayList<>();         //list of column1
    private ArrayList<String> column2 = new ArrayList<>();         //list of column2
    private int size;

    /**
     * Create a match question
     */
    public void create() {
        while (prompt == null) {
            System.out.println("Enter the prompt for your question");
            Scanner input = new Scanner(System.in);
            prompt = input.nextLine();
        }
        System.out.println("Enter the size of both columns");
        Scanner input = new Scanner(System.in);
        while (!input.hasNextInt()) {
            System.out.println("Please enter a positive number");
            input = new Scanner(System.in);
        }
        size = input.nextInt();
        while (size < 1) {
            System.out.println("Please enter a positive number");
            input = new Scanner(System.in);
            size = input.nextInt();
        }
        System.out.println("Enter column 1");
        for (int i = 0; i < size; i++) {
            System.out.println("Enter the NO." + (i + 1) + " element");
            String element1 = input.next();
            column1.add("(" + (i + 1) + ")" + element1);
            //answerHandle.setColumn1("(" + (i + 1) + ")" + element1);
        }
        System.out.println("Enter column 2");
        for (int i = 0; i < size; i++) {
            System.out.println("Enter the NO." + (i + 1) + " element");
            String element1 = input.next();
            column2.add("<" + (i + 1) + ">" + element1);
            //answerHandle.setColumn2("<" + (i + 1) + ">" + element1);
        }
    }

    /**
     * Display a match question
     */
    public void display() {
        System.out.println(prompt);
        for (int i = 0; i < column1.size(); i++) {
            System.out.print(column1.get(i) + " ");
        }
        System.out.print("\n");
        for (int i = 0; i < column2.size(); i++) {
            System.out.print(column2.get(i) + " ");
        }
        System.out.print("\n");
        if (rightAnswers.size() > 0) {
            System.out.print("The correct answer is ");
            for (int i = 0; i < rightAnswers.size(); i++) {
                System.out.print(column1.get(i) + "-" + rightAnswers.get(i) + " ");
            }
            System.out.print("\n");
        }

    }

    /**
     * Set the correct answer of a match question
     */
    public void setRightAnswer() {
        System.out.println(size);
        System.out.println("Enter correct answer");
        ArrayList existNum = new ArrayList();
        for (int i = 0; i < size; i++) {
            System.out.println("Enter the index of the element which matches with " + column1.get(i));
            Scanner input = new Scanner(System.in);
            while (!input.hasNextInt()) {
                System.out.println("Please choose a number from 1 to " + size);
                input = new Scanner(System.in);
            }
            int matchNum = input.nextInt();
            while (matchNum < 1 || matchNum > size || existNum.contains(matchNum)) {
                if (existNum.contains(matchNum))
                    System.out.println("Duplicate.Please enter again.");
                else
                    System.out.println("Please choose a number from 1 to " + size);
                input = new Scanner(System.in);
                matchNum = input.nextInt();
            }
            existNum.add(matchNum);
            rightAnswers.add(column2.get(matchNum - 1));
            //answerHandle.setRightAnswer(answerHandle.getColumn2(matchNum - 1));
        }
    }
}