package ru.geekbrains.homework1;

public class HW1 {
   public static void main (String[] args)
   { fruits();
      System.out.println("****");
 int z = 0;
   checkSumSign(5, 10);
      if (z>=0) {
         System.out.println("Сумма положительная");
      }
      else {System.out.println("Сумма отрицательная");
      }
       System.out.println("****");

       printColor(20);
       System.out.println("****");
       compareNumbers(44,82);

   }

   //ex.2
   static void fruits() {
   System.out.println("Orange");
   System.out.println("Banana");
   System.out.println("Apple");
   }

   //ex.3
   static void checkSumSign(int a, int b) {
      int z = a + b;
   }

   // ex.4
    static void printColor(int value) {

        if (value <= 0) {
            System.out.println("Красный");
        } else if (value > 0 && value <= 100) {
            System.out.println("Желтый");
        } else if (value > 100) {
            System.out.println("Зеленый");
        }
    }

    // ex.5
    static void compareNumbers(int a,int b)
    {
        if (a >= b) {
            System.out.println("a >= b");
        }
        else
            { System.out.println("a < b");}
    }

    }


