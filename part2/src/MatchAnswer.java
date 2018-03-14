import java.util.ArrayList;
import java.util.Iterator;

public class MatchAnswer extends Answer {
    private Match match;

    MatchAnswer(Match match) {
        this.match = match;
    }

    /**
     * Create the correct answer of a match question
     */
    public void create() {
        io.writeLine("Enter correct answer");
        ArrayList existNum = new ArrayList();
        int size = match.getSize();
        for (int i = 0; i < size; i++) {
            io.writeLine("Enter the index of the element which matches with " + match.getColumn1().get(i));
            int matchNum = io.readInt(size);
            while (existNum.contains(matchNum)) {
                io.writeLine("Duplicate.Please enter again.");
                matchNum = io.readInt(size);
            }
            existNum.add(matchNum);
            rightAnswers.add(match.getColumn2().get(matchNum - 1));
        }
    }

    /**
     * Display the correct answer of a match question
     */
    public void display() {
        io.writeLine("The correct answer is :");
        Iterator<String> iter = rightAnswers.iterator();
        int count = 0;
        while (iter.hasNext()) {
            String answer = iter.next();
            io.writeLine("(" + (count + 1) + ")" + match.getColumn1().get(count) + "-" + answer);
            count++;
        }
    }

    /**
     * Modify the correct answer of a match question
     */
    public void modify() {
        rightAnswers.clear();
        create();
    }
}