import java.io.Serializable;

abstract class Question implements Serializable {
    String prompt;
    protected IO io=new IO();
    abstract protected void create();

    abstract protected void display();

    abstract protected void modify(int type);

    abstract protected int getChoicesNum();

    abstract protected void displayChoices();
}