
public class ShortQuestion extends EssayQuestion {
    /**
     * Create a new short answer question
     */
    public void create() {
        super.create();
    }

    /**
     * Display a short answer question
     */
    public void display() {
        super.display();
    }

    public int getChoicesNum() {
        return 0;
    }

    public void displayChoices() {
    }

    /**
     * modify a ShortQuestion question
     *
     * @param type 1:modify prompt, 2:modify choices, 3:modify correct answer
     */
    public void modify(int type) {
        super.modify(type);
    }
}