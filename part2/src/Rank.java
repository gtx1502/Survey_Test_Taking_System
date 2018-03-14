import java.util.ArrayList;
import java.util.Iterator;

public class Rank extends Question {
    private ArrayList<String> column2 = new ArrayList<>();         //list of column2
    private int size;

    /**
     * Create a rank question
     */
    public void create() {
        while (prompt == null) {
            io.writeLine("Enter the prompt for your question");
            prompt = io.readLine();
        }
        io.writeLine("Enter the size of the ranking question");
        size = io.readInt(0);
        for (int i = 0; i < size; i++) {
            io.writeLine("Enter the NO." + (i + 1) + " element");
            String element = io.readLine();
            column2.add(element);
        }
    }

    /**
     * Display a rank question
     */
    public void display() {
        io.writeLine(prompt);
        displayChoices();
    }

    public int getChoicesNum() {
        return this.size;
    }

    int getSize() {
        return this.size;
    }

    ArrayList<String> getColumn2() {
        return this.column2;
    }

    /**
     * display choices
     */
    public void displayChoices() {
        Iterator<String> iterator = column2.iterator();
        int count = 0;
        while (iterator.hasNext()) {
            String choice = iterator.next();
            io.write("<" + (count + 1) + ">" + choice + " ");
            count++;
        }
        io.write("\n");
    }

    /**
     * modify a Rank question
     *
     * @param type 1:modify prompt, 2:modify choices, 3:modify correct answer
     */
    public void modify(int type) {
        if (type == 1) {
            io.writeLine("Enter a new prompt");
            prompt = io.readLine();
        } else if (type == 2) {
            io.writeLine("Do you want to modify choices(1),or remove choices(2),or add choices(3)?");
            int choice;
            int modify = io.readInt(3);
            switch (modify) {
                case 1:
                    io.writeLine("Which one do you want ro modify?");
                    choice = io.readInt(size);
                    io.writeLine("Enter a new value");
                    String newValue = io.readLine();
                    column2.set(choice - 1, newValue);
                    break;
                case 2:
                    io.writeLine("Which one do you want to remove?");
                    choice = io.readInt(size);
                    column2.remove(choice - 1);
                    break;
                case 3:
                    io.writeLine("Enter a new value");
                    String addValue = io.readLine();
                    column2.add(addValue);
                    break;
            }
        }
    }
}