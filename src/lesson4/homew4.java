package lesson4;

import java.util.Random;
import java.util.Scanner;

public class homew4 {
    public static int levelGame = 0; //первоначальный уровень

// описание комнаты
    public static Random random= new Random ();
    public static Scanner scanner= new Scanner(System.in);
    public static char[][] room; // комната
    public static char[][] invisibleRoom; // туманная комната
    public static int roomWidth; // ширина комнаты X
    public static int roomHeight; // высота комнаты Y
    public static int roomSizeMin=3; //минимальный размер комнаты
    public static int roomSizeMax=6; //максимальный размер комнаты
    public static char emptyCell = '_'; // обозначение пустой ячейки
    public static char readyCell = '*'; //занятая ячейка (на которой уже были)
    public static int countEnemies; // количество врагов

    // описание врага
    public static char enemy = 'E'; // обозначение врага
    public static int enemyHP; //здоровье врага
    public static int enemyAttack; // сила врага
    public static int enemyValueMin = 5; // минимальная сила/здоровье врага
    public static int enemyValueMax = 10; // максимаьная сила/здоровье врага

    //описание героя
    public static char player = '@'; // обозначение героя
    public static int playerHP = 100; //здоровье героя
    public static int playerAttack = 20; // сила героя
    public static int playerPosX; // положение игрока по Х
    public static int playerPosY; // положение игрока по Y
    public static final int playerMoveUp = 8; // движение вверх (неизменяемое значение final)
    public static final int playerMoveLeft = 4; // движение влево (неизменяемое значение final)
    public static final int playerMoveRight = 6; // движение вправо (неизменяемое значение final)
    public static final int playerMoveDown = 2; // движение вниз (неизменяемое значение final)


    public static void main(String[] args) {
// пока жив игрок, поднимаем уровень, выводим сообщение с инф об уровне и вызываем метод создающий новые комнаты, игрока,врагов...)
        while (isAlivePlayer()) {
            ++levelGame;
            System.out.println("WELCOME TO LEVEL " + levelGame);
            roomGameCycle();
        }
        System.out.println("GAME OVER! Player clear room's is " + levelGame);
    }
    //метод, создающий новые комнаты и позволяющий ходить игроку пока он жив или есть враги
    public static void roomGameCycle() {
        createRoom(); //создали конату
        spawnPlayer(); //создали игрока
        spawnEnemies(); //создали врагов
    //делать бесконечно
        while(true) {
            showRoom(); //показываем комнату в консоли
            playerMove(); //идвижение игрока по комнате
//если игрок не жив (!HP>0) ,выводим сообщение "Player is dead"
            if (!isAlivePlayer()) {
                System.out.println("Player is dead");
                break;
            }
//если враги закончились (!countEnemies > 0) ,выводим сообщение "Current room is clear. Go to LEVEL " + "повышение уровня"
            if (!isExistEnemies()) {
                System.out.println("Current room is clear. Go to LEVEL " + (levelGame + 1));
                break;
            }
        }
    }

    //создаем комнату
    public static void createRoom() {
        roomWidth = randomValue(roomSizeMin, roomSizeMax); // рандомная ширина комнаты с учетом мин  и макс значения в переменных roomSizeMin, roomSizeMax
        roomHeight = randomValue(roomSizeMin, roomSizeMax); // рандомная высота комнаты с учетом мин  и макс значения в переменных roomSizeMin, roomSizeMax
        room = new char[roomHeight][roomWidth]; // заполняем размер массива комнаты рандомными значениями из переменных roomWidth,roomHeight
        invisibleRoom = new char[roomHeight][roomWidth]; //заполняем размер массива туманной комнаты рандомными значениями из переменных roomWidth,roomHeight

        //заполняем комнаты  и присваиваем ячейкам значение emptyCell
        for (int y = 0; y < roomHeight; y++) {
            for (int x = 0; x < roomWidth; x++) {
                room[y][x] = emptyCell;
                invisibleRoom[y][x] = emptyCell;
            }
        }
        System.out.println("Create room with size " + roomWidth + "x" + roomHeight);
    }
    //выводим комнату в консоль
    public static void showRoom() {
        System.out.println("===== ROOM =====");
        for (int y = 0; y < roomHeight; y++) {
            for (int x = 0; x < roomWidth; x++) {
                System.out.print(room[y][x] + "|");
            }
            System.out.println();
        }
        System.out.println("================");
    }
    // описание игрока
    public static void spawnPlayer() {
        playerPosX = randomValue(0, roomWidth - 1); // начальная позиция игрока по Х
        playerPosY = randomValue(0, roomHeight - 1);// начальная позиция игрока по Y
        room[playerPosY][playerPosX] = player; //добавили в ячейку массива room (комнату) игрока
        System.out.println("Player has been spawn in [" + (playerPosX + 1) + ":" + (playerPosY + 1) + "] (HP=" + playerHP + " STR=" + playerAttack + ")");
    } //вывели в консоль описание позиции игрока(+1 для удобства восприятия позиции) и его параметры здоровье и силу

    // описание врага
    public static void spawnEnemies(){
        enemyHP = randomValue(enemyValueMin, enemyValueMax); //числовой переменной enemyHP присвоили рандомное значение в пределах enemyValueMin, enemyValueMax
        enemyAttack = randomValue(enemyValueMin, enemyValueMax); //числовой переменной enemyAttack присвоили рандомное значение в пределах

        countEnemies = (roomWidth + roomHeight) / 2; //количество врагов высчитываем в зависимости от размера комнаты деленной на два

        int enemyPosX; // вводим числовую переменную для обозначения координаты положения врага по Х
        int enemyPosY; //вводим числовую переменную для обозначения координаты положения врага по Х

        //располагаем врагов по ячейкам
        for (int i = 1; i <= countEnemies; i++) {

            do {
                enemyPosX = random.nextInt(roomWidth); //подбираем рандомно позицию по Х с учетом ширины комнаты
                enemyPosY = random.nextInt(roomHeight); //подбираем рандомно позицию по Y с учетом высоты комнаты
            } while (!isEmptyCell(room, enemyPosX, enemyPosY) || !isEmptyCell(invisibleRoom, enemyPosX, enemyPosY));
            // делаем подборку позиций врагов, пока isEmptyCell с комнатой или туманной комнатой ложны. Т.е, пока ячейка из какой-либо комнаты не пуста, мы генерируем позиции врага.
            invisibleRoom[enemyPosY][enemyPosX] = enemy;
            //когда логическое условие не выполнилось, т.е выпала пустая ячейка в обеих комнатах, мы записываем врага в ячейку массива туманной комнаты
        }
        System.out.println("Create " + countEnemies + " enemies with HP=" + enemyHP + " STR=" + enemyAttack);
// Вывели в консоль информацию о количестве врагов с их здоровьем и силой
    }

    // метод, описывающий движение игрока
    public static void playerMove() {
        int currentPlayerX = playerPosX; //запоминаем положение игрока в комнате
        int currentPlayerY = playerPosY; //запоминаем положение игрока в комнате

        int playerDestination; // переменная, обозначающая движение игрока, введенное с консоли

        do {
            System.out.print("Enter direction (UP=" + playerMoveUp + ", LEFT=" + playerMoveLeft + ", DOWN=" + playerMoveDown + ", RIGHT=" + playerMoveRight + ") > ");
            playerDestination = scanner.nextInt(); // пользователь вводит значение
// используем оператор switch для изменения координат позиции игрока
            switch (playerDestination) {
                case playerMoveUp:
                    playerPosY -= 1; //уменьшаем координату по Y , т.е. поднимаемся вверх
                    break;
                case playerMoveLeft:
                    playerPosX -= 1;
                    break;
                case playerMoveDown:
                    playerPosY += 1;
                    break;
                case playerMoveRight:
                    playerPosX += 1;
                    break;
            }
        } while (!checkPlayerMove(currentPlayerX, currentPlayerY, playerPosX, playerPosY));
        //пока checkPlayerMove !false =true выполняем данный цикл do while
              playerNextMoveAction(currentPlayerX, currentPlayerY, playerPosX, playerPosY);
//вызвали метод перемещения игрока
    }
    // метод, который определяет, что происходит после передвижения игрока
    public static void playerNextMoveAction(int lastPosX, int lastPosY, int nextPosX, int nextPosY) {
        //если позиция игрока совпадает с позицией врага. Используем невидимую комнату, что спрятать врагов
        if (invisibleRoom[nextPosY][nextPosX] == enemy) {
           do {
               playerHP -= enemyAttack;//враг аттакует игрока
               enemyHP-= playerAttack; //игрок аттакует врага
           }
           while (playerHP==0 || enemyHP==0);
            System.out.println("ALERT! Enemy give damage " + enemyAttack + ". Player HP now is " + playerHP);
            countEnemies--; // уменьшаем на один кол-во врагов
            invisibleRoom[nextPosY][nextPosX] = emptyCell; // присваиваем позиции занятое место * в невидимой комнате
        }
//новая позиция в комнате присваивается игроку
        room[playerPosY][playerPosX] = player;
 //предыдущая позиция игрока присваивается занятому месту *
        room[lastPosY][lastPosX] = readyCell;
    }
    //метод, определяющий корректность движения игрока. За рамки комнаты выйти нельзя. В случае else  координаты игрока возвращаются
    public static boolean checkPlayerMove(int currentX, int currentY, int nextX, int nextY) {
        //если новая позиция по X/Y меньше ширины/высоты комнаты и больше, либо равна 0 , тогда выводим сообщение
        //о перемещении игрока на новые позиции ( +1 используется для удобства восприятия) и возвращаем тру
        if (nextX >= 0 && nextX < roomWidth && nextY >= 0 && nextY < roomHeight) {
            System.out.println("Player move to [" + (nextX + 1) + ":" + (nextY + 1) + "] success!");
            return true;
        }
        //иначе выводим сообщение об ошибке движения и новой попытке. Вовращаем предыдущие позиции игроку и возврат false
        else {
            System.out.println("Player - you Invalid! Your move is FAIL! Please try again!");
            playerPosX = currentX;
            playerPosY = currentY;
            return false;
        }
    }

    //метод для обнаружения пустых ячеек
    public static boolean isEmptyCell(char[][] checkRoom, int x, int y) {
        return checkRoom[y][x] == emptyCell;
    }
    // генератор случайных чисел
    public static int randomValue(int min, int max) {
        return min + random.nextInt(max - min + 1);
    }
    //остались ли враги?
    public static boolean isExistEnemies() {
        return countEnemies > 0;
    }
    //проверка жив ли игрок
    public static boolean isAlivePlayer() {
        return playerHP > 0;
    }








}

