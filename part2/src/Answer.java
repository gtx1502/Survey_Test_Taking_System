import java.io.Serializable;
import java.util.ArrayList;

abstract class Answer implements Serializable {
    ArrayList<String> rightAnswers = new ArrayList<>();
    protected IO io=new IO();

    abstract void create();

    abstract void display();

    abstract void modify();
}
