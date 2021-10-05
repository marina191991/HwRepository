package lesson5;

public class HW5 {
    public static void main(String[] args) {
        //создаем массив сотрудников
        Colleague[] dataColl= new Colleague[5];
        dataColl[0]= new Colleague("Старцев",
                "Михаил",
                "Валерьевич",
                "менеджер отдела продаж",
                "p1232@gmail.com",
                "79038887886",
                60000,
                27);
        dataColl[1]= new Colleague("Величко",
                "Данил",
                "Валерьевич",
                "руководитель отдела продаж",
                "vel1232@gmail.com",
                "79614554545",
                120000,
                41);
        dataColl[2]= new Colleague("Кравцева",
                "Татьяна",
                "Николаева",
                "бухгалтер",
                "tat1232@gmail.com",
                "79289284545",
                80000,
                42);
        dataColl[3]= new Colleague("Вихнарь",
                "Надежда",
                "Петровна",
                "секретарь",
                "vih1232@gmail.com",
                "79037772255",
                50000,
                50);
        dataColl[4]= new Colleague("Мельников",
                "Станислав",
                "Валерьевич",
                "менеджер по работе с клиентами",
                "mel1232@gmail.com",
                "79518887886",
                60000,
                33);

        printAllColl(dataColl);
        System.out.println( );
        System.out.println("ex.5");
        grownColl (40,dataColl);
    }
    //метод для поиска сотрудников старше 40
 private static void grownColl (int age,Colleague[] dataColl) {
        int k=1;
     for (int i = 0; i<dataColl.length; i++) {
        if (dataColl[i].getAge() > age)  {
            System.out.println((k+1)+ ". " + dataColl[i].getFullInfo());
        k++;}
     }

 }
 //метод для вывода в консоль полного списка сотрудников
  private static void printAllColl (Colleague[] dataColl) {
      System.out.println( "Сотрудники:");
        for (int i = 0; i<dataColl.length; i++) {
            System.out.println((i+1)+ ". " + dataColl[i].getFullInfo());
      }

  }

}
