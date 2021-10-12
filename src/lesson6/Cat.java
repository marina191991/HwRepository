package lesson6;

public class Cat extends Animals{
        public static int countCat = 0;


    public Cat (String type, String name, int maxRun, int maxSwim) {
        super (type,name,maxRun,maxSwim);
        countCat++; //подсчет котиков
    }

    @Override
    protected int swim(int LengthSw) {
        return Animals.SWIM_None;
    } //кошка плавать не умеет, поэтому данный метод у кошки будет возвращать свое значение

}
