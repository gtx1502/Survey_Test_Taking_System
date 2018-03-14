import java.io.IOException;
import java.util.Scanner;

public class Handle {
    private static Test test;
    private static Survey survey;
    static int saved = 0;         //已保存：1，未保存：0
    private static final int NUM = 7;   //菜单选项数

    /**
     * Show Menu1
     */
    private static void menu() {
        System.out.println("Menu 1");
        System.out.println("1) Create a new Survey Question");  //当前无survey，则创建新survey，否则在原有survey基础上继续编辑
        System.out.println("2) Create a new Test Question");    //当前无test，则创建新test，否则在原有test基础上继续编辑
        System.out.println("3) Display Survey");
        System.out.println("4) Display a Test");
        System.out.println("5) Save a Survey");
        System.out.println("6) Save a Test");
        System.out.println("7) Quit");
        System.out.println("Please choose a number from 1 to " + NUM);
    }

    public static void main(String args[]) throws IOException {
        while (true) {
            menu();
            Scanner input = new Scanner(System.in);
            while (!input.hasNextInt()) {
                System.out.println("Please choose a number from 1 to " + NUM);
                input = new Scanner(System.in);
            }
            int choice = input.nextInt();
            while (choice < 1 || choice > NUM) {
                System.out.println("Please choose a number from 1 to " + NUM);
                input = new Scanner(System.in);
                choice = input.nextInt();
            }
            switch (choice) {
                case 1:
                    if (test != null) {
                        System.out.println("You can't create a test and a survey at the same time.");
                        continue;
                    }
                    if (survey == null)
                        survey = new Survey();
                    survey.create();
                    break;
                case 2:
                    if (survey != null) {
                        System.out.println("You can't create a test and a survey at the same time.");
                        continue;
                    }
                    if (test == null)
                        test = new Test();
                    test.create();
                    break;
                case 3:
                    if (survey != null) {
                        survey.display();
                        break;
                    } else {
                        System.out.println("You are creating a survey and you can only display the current survey");
                        continue;
                    }
                case 4:
                    if (test != null) {
                        test.display();
                        break;
                    } else {
                        System.out.println("You are creating a test and you can only display the current test");
                        continue;
                    }
                case 5:
                    if (survey != null) {
                        survey.save();
                        saved = 1;
                        break;
                    } else {
                        System.out.println("You are creating a survey and you can only save the survey now");
                        continue;
                    }
                case 6:
                    if (test != null) {
                        test.save();
                        saved = 1;
                        break;
                    } else {
                        System.out.println("You are creating a test and you can only save the test now");
                        continue;
                    }
                case 7:
                    if (saved == 0 && (test != null || survey != null)) {
                        System.out.println("Do you want to save? Enter 'save' or 'not'");
                        input = new Scanner(System.in);
                        String s = input.next();
                        while (!s.equals("save") && !s.equals("not")) {
                            System.out.println("Enter 'save' or 'not'");
                            input = new Scanner(System.in);
                            s = input.next();
                        }
                        if (s.equals("save")) {
                            if (test != null)
                                test.save();
                            else if (survey != null)
                                survey.save();
                        }
                    }
                    System.exit(0);
            }
        }
    }
}