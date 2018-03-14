
public class EssayQuestion extends Question {

    /**
     * Create an essay question
     */
    public void create() {
        while (prompt == null) {
            io.writeLine("Enter the prompt for your question");
            prompt = io.readLine();
        }
    }

    /**
     * Display an essay question
     */
    public void display() {
        io.writeLine(prompt);
    }

    public int getChoicesNum() {
        return 0;
    }

    public void displayChoices() {
    }

    /**
     * modify a Essay question
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