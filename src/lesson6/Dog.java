package lesson6;

public class Dog  extends Animals {

    protected String type;
    public static int countDog=0;




    public Dog (String type, String name, int maxRun, int maxSwim ) {
        super (type, name,maxRun,maxSwim);
        countDog++; //подсчет собак при помощи подсчета вызовов конструктора
    }
}
