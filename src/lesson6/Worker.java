package lesson6;

public class Worker {

 public static void main(String[] args) {
     String tempWinEvent = " преодолена";
     String tempLossEvent = " не преодолена";
     String eventResult; //записываем в переменную результат

     int lengthR=350; // длина препятствия run
     int lengthSw=10; // длина препятствия swim


     Cat cat1 = new Cat("Кошка","Мурка", 100, 1);
     Cat cat2 = new Cat("Кошка","Рыжик", 150, 3);
     Dog dog1 = new Dog("Собака","Шарик", 300, 10);
     Dog dog2 = new Dog("Собака","Кинг", 400, 5);

     Animals[] arrAnimals = {cat1, cat2, dog1, dog2}; //массив животных

     for (int i=0; i<arrAnimals.length;i++) {

         if (arrAnimals[i].run(lengthR)) {eventResult=tempWinEvent;}
         else eventResult=tempLossEvent; //записываем в переменную результат выполнения метода run.
                  System.out.println (arrAnimals[i].type + " " + arrAnimals[i].getName() + " " + "может пробежать" + " " + arrAnimals[i].getMaxRun()
                 + "m" + "." + " " + "Дистанция " + " "  + lengthR  + "m"  +" "+ eventResult);

        if (arrAnimals[i].swim(lengthSw)==Animals.SWIM_Ok) {
            eventResult=tempWinEvent;
        } else   eventResult=tempLossEvent; //записываем в переменную результат выполнения метода swim. Если возвращает

              if (arrAnimals[i].swim(lengthSw) == Animals.SWIM_None)
             eventResult = " не преодолена, т.к. не умеет плавать";
                  System.out.println (arrAnimals[i].type + " " + arrAnimals[i].getName() + " " + "может проплыть" + " " + arrAnimals[i].getMaxSwim()
                 + "m" + "." + " " + "Дистанция "+" "+ lengthSw  + "m"  +" "+ eventResult);
         System.out.println();

     }

     System.out.println("Общее количество животных = " + Animals.countAnimal + " Кошек = " + Cat.countCat + " Собак = " + Dog.countDog);
 }


    }



