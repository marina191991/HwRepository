package lesson6;

public abstract class Animals {
    static final int SWIM_Fail = 0;
    static final int SWIM_Ok= 1;
    static final int SWIM_None= -1;

    protected String type; //тип животного
    protected String name; //имя животного
    protected int maxRun; //расстояние,которое может пробежать животное
    protected int maxSwim; //умение плавать


    public static int countAnimal = 0;



    public Animals (String type,String name, int maxRun, int maxSwim) {
        this.type=type;
        this.name=name;
        this.maxRun=maxRun;
        this.maxSwim= maxSwim;
        countAnimal++; //считаем животных, при помощи количества вызовов конструктора

    }
    //String getType () { return this.type;}
    String getName() {return this.name;}
    int getMaxRun() {return this.maxRun;}
    int getMaxSwim() {return this.maxSwim;}



    protected boolean run(int lengthR) {
        return  (lengthR<=maxRun);

    }

    protected  int swim (int LengthSw) {
        {
            return (LengthSw<=maxSwim) ? SWIM_Ok : SWIM_Fail; //если дистанция меньше либо равна максимальному значению животного,
            // то возвращаем SWIM_Ok, если нет-SWIM_Fail. Булевым быть ек может, так как есть третий вариант исхода (из-за котиков)
        }
    }
}
