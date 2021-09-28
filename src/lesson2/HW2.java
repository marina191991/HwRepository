package lesson2;

public class HW2 {
    public static void main(String[] args) {
        System.out.println(summBool(10, 20));
        System.out.println("*******");
        inNumb(2);
        System.out.println("*******");
        System.out.println(numbBool(7));
        System.out.println("*******");
        strNumb("not bad ", 5);
        System.out.println(" ");
        System.out.println("*******");
        System.out.println(leapYear(1988));


    }

//*1. Написать метод, принимающий на вход два целых числа и проверяющий,
// * что их сумма лежит в пределах от 10 до 20 (включительно), если да – вернуть true,
// * в противном случае – false.
    static boolean summBool(int a, int b) {

        return (a + b >= 10) && (a + b <= 20);
    }
// * 2. Написать метод, которому в качестве параметра передается целое число,
// * метод должен напечатать в консоль, положительное ли число передали или
// отрицательное.
// * Замечание: ноль считаем положительным числом.

    static void inNumb(int a) {
        if (a >= 0) {
            System.out.println("Число положительное");
        } else {
            System.out.println("Число положительное");
        }
    }

//* 3. Написать метод, которому в качестве параметра передается целое число.
// * Метод должен вернуть true, если число отрицательное,
//* и вернуть false если положительное.
    static boolean numbBool(int a) {
        return (a < 0);
    }

//* 4. Написать метод, которому в качестве аргументов передается строка и число,
// * метод должен отпечатать в консоль указанную строку, указанное количество раз;
    static void strNumb(String a, int num) {
        while (num > 0) {
            System.out.print(num + "." + a + " ");
            num--;
        }
    }
//* 5. Написать метод, который определяет, является ли год високосным,
// * и возвращает boolean (високосный - true, не високосный - false).
// * Каждый 4-й год является високосным, кроме каждого 100-го,
// *при этом каждый 400-й – високосный.
    // Google гласит: любой год, который делится на 4 без остатка,является високосным годом

    static boolean leapYear(int year) {
        return (year % 4 == 0);
    }
}


