import java.util.ArrayList;
import java.util.Iterator;

public class MultipleChoice extends Question {
    private int choiceNum;
    private ArrayList<String> choices = new ArrayList<>();         //list of choices

    /**
     * Create a multiple choice question
     */
    public void create() {
        while (prompt == null) {
            io.writeLine("Enter the prompt for your question");
            prompt = io.readLine();
        }
        io.writeLine("Enter the number of choices for your multiple choice question.");
        choiceNum = io.readInt(0);
        for (int i = 0; i < choiceNum; i++) {
            io.writeLine("Enter choice #" + (i + 1));
            String choice = io.readLine();
            choices.add(choice);
        }
    }

    /**
     * Display a multiple choice question
     */
    public void display() {
        io.writeLine(prompt);
        displayChoices();
    }

    public int getChoicesNum() {
        return this.choiceNum;
    }

    String getChoice(int index) {
        return choices.get(index);
    }

    /**
     * display choices
     */
    public void displayChoices() {
        Iterator<String> iterator = choices.iterator();
        int count = 0;
        while (iterator.hasNext()) {
            String choice = iterator.next();
            io.write("(" + (count + 1) + ")" + choice + " ");
            count++;
        }
        io.write("\n");
    }

    /**
     * modify a MultipleChoice question
     *
     * @param type 1:modify prompt, 2:modify choices
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
                    io.writeLine("Which choice do you want to modify?");
                    choice = io.readInt(choiceNum);
                    io.writeLine("Enter a new value");
                    String newValue = io.readLine();
                    choices.set(choice - 1, newValue);
                    break;
                case 2:
                    io.writeLine("Which choice do you want to remove?");
                    choice = io.readInt(choiceNum);
                    choices.remove(choice - 1);
                    choiceNum--;
                    break;
                case 3:
                    io.writeLine("Enter a new value");
                    String addValue = io.readLine();
                    choices.add(addValue);
                    choiceNum++;
                    break;
            }
        }
        display();
    }
}