import java.io.Serializable;
import java.util.Scanner;

/**
 * Created by gtx on 2017/7/26.
 */
public class IO implements Serializable {
    public void writeLine(String str) {
        System.out.println(str);
    }

    void write(String str) {
        System.out.print(str);
    }

    String readLine() {
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    String read() {
        Scanner input = new Scanner(System.in);
        return input.next();
    }

    int readInt(int size) {
        IO io = new IO();
        Scanner input = new Scanner(System.in);
        int choice;
        while (!input.hasNextInt()) {
            if (size == 0)
                io.writeLine("Please enter a positive number");
            else
                io.writeLine("Please choose a number from 1 to " + size);
            input = new Scanner(System.in);
        }
        choice = input.nextInt();
        if (size == 0) {
            while (choice < 1) {
                io.writeLine("Please enter a positive number");
                input = new Scanner(System.in);
                choice = input.nextInt();
            }
        } else {
            while (choice < 1 || choice > size) {
                io.writeLine("Please choose a number from 1 to " + size);
                input = new Scanner(System.in);
                choice = input.nextInt();
            }
        }
        return choice;
    }
}
