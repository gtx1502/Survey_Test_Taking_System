import java.util.ArrayList;
import java.util.Iterator;

public class RankAnswer extends Answer {
    private Rank rank;

    RankAnswer(Rank rank) {
        this.rank = rank;
    }

    /**
     * Create the correct answer of a rank question
     */
    public void create() {
        io.writeLine("Enter correct answer");
        ArrayList existNum = new ArrayList();
        int size = rank.getSize();
        for (int i = 0; i < size; i++) {
            io.writeLine("Enter the index of the element whose rate is " + (i + 1));
            int matchNum = io.readInt(size);
            while (existNum.contains(matchNum)) {
                io.writeLine("Duplicate.Please enter again.");
                matchNum = io.readInt(size);
            }
            existNum.add(matchNum);
            rightAnswers.add(rank.getColumn2().get(matchNum - 1));
        }
    }

    /**
     * Display correct answer of a rank question
     */
    public void display() {
        io.writeLine("The correct answer is:");
        Iterator<String> iterator = rightAnswers.iterator();
        while (iterator.hasNext()) {
            String answer = iterator.next();
            io.writeLine(answer);
        }
    }

    /**
     * Modify the correct answer of a rank question
     */
    public void modify() {
        rightAnswers.clear();
        create();
    }
}