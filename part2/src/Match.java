import java.util.ArrayList;

public class Match extends Question {
    private ArrayList<String> column1 = new ArrayList<>();         //list of column1
    private ArrayList<String> column2 = new ArrayList<>();         //list of column2
    private int size;                                              //number of items in each column

    /**
     * Create a match question
     */
    public void create() {
        while (prompt == null) {
            io.writeLine("Enter the prompt for your question");
            prompt = io.readLine();
        }
        io.writeLine("Enter the size of both columns");
        size = io.readInt(0);
        io.writeLine("Enter column 1");
        for (int i = 0; i < size; i++) {
            io.writeLine("Enter the NO." + (i + 1) + " element");
            String element1 = io.readLine();
            column1.add(element1);
        }
        io.writeLine("Enter column 2");
        for (int i = 0; i < size; i++) {
            io.writeLine("Enter the NO." + (i + 1) + " element");
            String element2 = io.readLine();
            column2.add(element2);
        }
    }

    /**
     * Display a match question
     */
    public void display() {
        io.writeLine(prompt);
        displayChoices();
    }

    public int getChoicesNum() {
        return this.size;
    }

    /**
     * display choices
     */
    public void displayChoices() {
        for (int i = 0; i < column1.size(); i++)
            io.write("(" + (i + 1) + ")" + column1.get(i) + " ");
        io.write("\n");
        for (int i = 0; i < column2.size(); i++)
            io.write("<" + (i + 1) + ">" + column2.get(i) + " ");
        io.write("\n");
    }

    /**
     * modify a Match question
     *
     * @param type 1:modify prompt, 2:modify columns, 3:modify correct answer
     */
    public void modify(int type) {
        if (type == 1) {
            io.writeLine("Enter a new prompt");
            prompt = io.readLine();
        } else if (type == 2) {
            io.writeLine("Do you want to modify choices(1),or remove a choice(2),or add a choice(3)?");
            int modify = io.readInt(3);
            switch (modify) {
                case 1:         //modify
                    modifyColumn(1);
                    modifyColumn(2);
                    break;
                case 2:         //remove
                    removeFromColumn(1);
                    removeFromColumn(2);
                    size--;
                    break;
                case 3:         //add
                    addToColumn(1);
                    addToColumn(2);
                    size++;
                    break;
            }
        }
    }

    /**
     * add an item to a column
     *
     * @param column 1 or 2
     */
    private void addToColumn(int column) {
        io.writeLine("Enter a new value to column" + column);
        String addValue = io.readLine();
        if (column == 1)
            column1.add(addValue);
        else if (column == 2)
            column2.add(addValue);
    }

    /**
     * remove an item from a column
     *
     * @param column 1 or 2
     */
    private void removeFromColumn(int column) {
        io.writeLine("Which choice do you want to remove in column" + column + "?");
        int choice = io.readInt(size);
        if (column == 1)
            column1.remove(choice - 1);
        else if (column == 2)
            column2.remove(choice - 1);
    }

    /**
     * modify an item in a column
     *
     * @param column 1 or 2
     */
    private void modifyColumn(int column) {
        io.writeLine("Do you want to modify column" + column + "?");
        String res = io.read();
        while (!res.equals("Yes") && !res.equals("No")) {
            io.writeLine("Enter Yes or No");
            res = io.read();
        }
        if (res.equals("Yes")) {
            io.writeLine("Which one do you want to modify?");
            int choice = io.readInt(size);
            io.writeLine("Enter a new value");
            String newValue = io.readLine();
            if (column == 1)
                column1.set(choice - 1, "(" + choice + ")" + newValue);
            else if (column == 2)
                column2.set(choice - 1, newValue);
        }
    }

    ArrayList<String> getColumn1() {
        return column1;
    }

    ArrayList<String> getColumn2() {
        return column2;
    }

    int getSize() {
        return this.size;
    }
}