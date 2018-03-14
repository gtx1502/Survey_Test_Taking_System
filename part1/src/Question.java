import java.io.Serializable;

abstract class Question implements Serializable {
    protected String prompt;

    abstract protected void create();

    abstract protected void display();

    abstract protected void setRightAnswer();
}