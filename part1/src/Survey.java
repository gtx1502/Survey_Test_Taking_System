import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Survey implements Serializable {
    protected ArrayList<Question> questions = new ArrayList<>();
    protected final int TYPE_NUM = 6;     //问题类型数

    /**
     * Create a new survey
     */
    public void create() {
        System.out.println("Menu 2");
        System.out.println("1) Add a new T/F question");
        System.out.println("2) Add a new multiple choice question");
        System.out.println("3) Add a new short answerHandle question");
        System.out.println("4) Add a new essay question");
        System.out.println("5) Add a new ranking question");
        System.out.println("6) Add a new matching question ");
        Scanner input = new Scanner(System.in);
        while (!input.hasNextInt()) {
            System.out.println("Please choose a number from 1 to " + TYPE_NUM);
            input = new Scanner(System.in);
        }
        int choice = input.nextInt();
        while (choice < 1 || choice > TYPE_NUM) {
            System.out.println("Please choose a number from 1 to " + TYPE_NUM);
            input = new Scanner(System.in);
            choice = input.nextInt();
        }
        Question question;
        switch (choice) {
            case 1:
                question = new TrueFalse();
                break;
            case 2:
                question = new MultipleChoice();
                break;
            case 3:
                question = new ShortAnswer();
                break;
            case 4:
                question = new EssayAnswer();
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
        System.out.println("A Survey");
        for (int i = 0; i < questions.size(); i++) {
            System.out.print((i + 1) + ")");
            questions.get(i).display();
        }
    }

    /**
     * Save a survey
     *
     * @throws IOException
     */
    public void save() throws IOException {
        System.out.println("Enter the name of the file");
        String filename;
        while (true) {          //输入文件名并判断是否有同名文件
            Scanner input = new Scanner(System.in);
            String name = input.next();
            filename = name + ".survey";
            File file = new File(filename);
            if (file.exists())
                System.out.println("There already exists a file with the same name.Please enter another name.");
            else
                break;
        }
        FileOutputStream output;
        try {
            output = new FileOutputStream(filename);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(output);
            objectOutputStream.writeObject(this);
            output.close();
            System.out.println("The survey is saved");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}