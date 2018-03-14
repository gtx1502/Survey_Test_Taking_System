
public class TrueFalse extends Question {
    /**
     * create a T/F question
     */
    public void create() {
        while (prompt == null) {
            io.writeLine("Enter the prompt for your question");
            prompt = io.readLine();
        }
    }

    /**
     * Display a T/F question
     */
    public void display() {
        io.writeLine(prompt);
        io.writeLine("T/F");
    }


    public int getChoicesNum() {
        return 0;
    }

    public void displayChoices() {
    }

    /**
     * modify a TrueFalse question
     *
     * @param type 1:modify prompt
     */
    public void modify(int type) {
        if (type == 1) {
            io.writeLine("Enter a new prompt");
            prompt = io.readLine();
        }
    }
}