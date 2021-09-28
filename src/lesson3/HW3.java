package lesson3;

import java.util.Arrays;

public class HW3 {


        public static void main(String[] args) {
            int[] arr1 = new int[]{0, 1, 0, 0, 1, 0, 1, 1};
            int[] arr2 = new int[100];
            int[] arr3 = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
            int[][] arr4 = new int[5][5];
            int[] arr6 = new int[]{1, 1,18,10,10,-1};
            System.out.println("1.*********");
            arrInt(arr1);
            System.out.println("2.*********");
            arrInt2(arr2);
            System.out.println("3.*********");
            arrInt3(arr3);
            System.out.println("4.*********");
            twoDimArr4(arr4);
            System.out.println("5.*********");
            oneDimArr ( 6, 1 );
            System.out.println("6.*********");
            oneMinMaxArr(arr6);
            System.out.println("7.*********");
            System.out.println(lftRghtSum(arr6));
        }
// * 1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
// * С помощью цикла и условия заменить 0 на 1, 1 на 0;
        
        public static void arrInt(int[] inArr) {
            for(int i = 0; i < inArr.length; ++i) {
                if (inArr[i] == 1) {
                    inArr[i] = 0;
                } else {
                    inArr[i] = 1;
                }
            }

            System.out.println(Arrays.toString(inArr));
        }

//* 2. Задать пустой целочисленный массив длиной 100. С помощью цикла заполнить его значениями 1 2 3 4 5 6 7 8 … 100;
       
        public static void arrInt2(int[] inArr2) {
            for(int i = 0; i < inArr2.length; ++i) {
                inArr2[i] = i + 1;
            }

            System.out.println(Arrays.toString(inArr2));
        }

// * 3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;


        public static void arrInt3(int[] inArr3) {
            for(int i = 0; i < inArr3.length; ++i) {
                if (inArr3[i] < 6) {
                    inArr3[i] *= 2;
                }
            }

            System.out.println(Arrays.toString(inArr3));
        }
//* 4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
// * и с помощью цикла(-ов) заполнить его диагональные элементы единицами (можно только одну из диагоналей, если обе сложно).
// * Определить элементы одной из диагоналей можно по следующему принципу: индексы таких элементов равны,
// то есть [0][0], [1][1], [2][2], …, [n][n];

        public static void twoDimArr4(int[][] inArr4) {
            for(int i = 0; i < inArr4.length; i++) {
                for(int j = 0; j < inArr4.length; j++) {
                    if (i == j || i + j == inArr4.length-1)
                    { inArr4[i][j] = 1;
                        System.out.print(inArr4[i][j] + " " );}
                    else {inArr4[i][j] = 0;
                        System.out.print(inArr4[i][j] + " " );}
                }

                System.out.println();
            }
        }

        // * 5. Написать метод, принимающий на вход два аргумента: len и initialValue, и возвращающий одномерный массив типа int длиной len,
// каждая ячейка которого равна initialValue;

        public static void oneDimArr (int len, int initialValue ) {
            int arr5[]= new int[len];
            for (int i=0; i<len; i++) {
                arr5[i]=initialValue;

            }
            System.out.println(Arrays.toString(arr5));
        }
        //* 6. * Задать одномерный массив и найти в нем минимальный и максимальный элементы ;


        public static void oneMinMaxArr(int[] inArr6) {

            int min = inArr6[0];
            int max= inArr6[0];
            for (int i = 1; i < inArr6.length; i++) {

                if (inArr6[i] < min) {
                    min = inArr6[i];
                }
                if (inArr6[i] > max) {
                    max= inArr6[i];;
                } }

            System.out.println(Arrays.toString(inArr6));
            System.out.println("min=" + min);
            System.out.println("max=" + max);
        }


//* 7. ** Написать метод, в который передается не пустой одномерный целочисленный массив,
        // * метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.
        
        public static boolean lftRghtSum(int[] inArr7) {
            int s=0;
            for (int i = 0; i < inArr7.length; i++) {
                s += inArr7[i];
            }

            int m=s;
            for (int i = 0; i < inArr7.length; i++) {
                if (s!=m/2 && m%2==0)
                {s -= inArr7[i];
                }

            }
            return (s==m/2 )  ;
        }
    }



