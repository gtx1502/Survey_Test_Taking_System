import java.io.*;

public class Handle {
    private static Test test;
    private static Survey survey;
    private static String fName;        //文件名
    private static int saved = 1;                 //已保存：1，未保存：0  create或modify后变为0
    private final static int NUM = 11;    //菜单选项数
    public static IO io;

    /**
     * Show Menu1
     */
    private static void menu() {
        io.writeLine("Menu 1");
        io.writeLine("1) Create a new Survey Question");  //当前无survey，则创建新survey，否则在原有survey基础上继续编辑
        io.writeLine("2) Create a new Test Question");    //当前无test，则创建新test，否则在原有test基础上继续编辑
        io.writeLine("3) Display Survey");
        io.writeLine("4) Display a Test");
        io.writeLine("5) Save a Survey");
        io.writeLine("6) Save a Test");
        io.writeLine("7) Modify an Existing Survey");
        io.writeLine("8) Modify an Existing Test");
        io.writeLine("9) Load a Survey");
        io.writeLine("10) Load a Test");
        io.writeLine("11) Quit");
        io.writeLine("Please choose a number from 1 to " + NUM);
    }

    /**
     * Load test or survey that already exists
     *
     * @param type 0:survey,1:test
     * @return filename
     */
    private String load(int type) {
        io.writeLine("Enter the name of the file");
        String name = io.read();
        String filename;
        if (type == 1)
            filename = name + ".test";
        else if (type == 0)
            filename = name + ".survey";
        else
            filename="error";
        FileInputStream input;
        Object object = null;
        try {
            input = new FileInputStream(filename);
            ObjectInputStream output = new ObjectInputStream(input);
            object = output.readObject();
            output.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        if (type == 1)
            test = (Test) object;
        else if (type == 0)
            survey = (Survey) object;
        return filename;
    }

    /**
     * Save a survey
     * @param existName 已有文件名
     * @param pro 后缀
     * @return filename
     * @throws IOException 异常
     */
    private String save(Object object,String existName,String pro) throws IOException {
        String filename;
        String name;
        if (existName == null) {
            io.writeLine("Enter the name of the file");
            name = io.read();
            filename = name + pro;
        } else {
            name = existName;
            filename = existName;
        }
        FileOutputStream output;
        try {
            output = new FileOutputStream(filename);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(output);
            objectOutputStream.writeObject(object);
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return name;
    }
    public static void main(String args[]) throws IOException {
        Handle handle = new Handle();
        io=new IO();
        while (true) {
            menu();
            int choice = io.readInt(NUM);
            switch (choice) {
                case 1:
                    if (test != null) {
                        io.writeLine("You can't create a test and a survey at the same time.");
                        continue;
                    }
                    if (survey == null)
                        survey = new Survey();
                    survey.create();
                    saved = 0;
                    break;
                case 2:
                    if (survey != null) {
                        io.writeLine("You can't create a test and a survey at the same time.");
                        continue;
                    }
                    if (test == null)
                        test = new Test();
                    test.create();
                    saved = 0;
                    break;
                case 3:
                    if (survey != null) {
                        survey.display();
                        break;
                    } else {
                        io.writeLine("You have no survey to display now");
                        continue;
                    }
                case 4:
                    if (test != null) {
                        test.display();
                        break;
                    } else {
                        io.writeLine("You have no test to display now");
                        continue;
                    }
                case 5:
                    if (survey != null) {
                        fName = handle.save(survey,fName,".survey");
                        saved = 1;
                        break;
                    } else {
                        io.writeLine("You have no survey to save now");
                        continue;
                    }
                case 6:
                    if (test != null) {
                        handle.save(test,fName,".test");
                        saved = 1;
                        break;
                    } else {
                        io.writeLine("You have no test to save now");
                        continue;
                    }
                case 7:
                    if (survey != null) {
                        survey.modify();
                        saved = 0;
                        break;
                    } else {
                        io.writeLine("Please load a survey first");
                        continue;
                    }
                case 8:
                    if (test != null) {
                        test.modify();
                        saved = 0;
                        break;
                    } else {
                        io.writeLine("Please load a test first");
                        continue;
                    }
                case 9:
                    if (test == null && survey == null) {
                        String name = handle.load(0);
                        survey.display();
                        fName = name;
                        break;
                    } else {
                        io.writeLine("You already have a survey or test so that you can't load a new one");
                        continue;
                    }
                case 10:
                    if (test == null && survey == null) {
                        String name = handle.load(1);
                        test.display();
                        fName = name;
                        break;
                    } else {
                        io.writeLine("You already have a survey or test so that you can't load a new one");
                        continue;
                    }
                case 11:
                    if (saved == 0) {      //存在修改，退出时提示是否保存
                        io.writeLine("Do you want to save? Enter 'Yes' or 'No'");
                        String s = io.read();
                        while (!s.equals("Yes") && !s.equals("No")) {
                            io.writeLine("Enter 'Yes' or 'No'");
                            s = io.read();
                        }
                        if (s.equals("Yes")) {
                            if (test != null)
                                handle.save(test,fName,".test");
                            else if (survey != null)
                                handle.save(survey,fName,".survey");
                        }
                    }
                    System.exit(0);
            }
        }
    }
}
