package lesson5;

/**
 * 1. Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.
 * 2. Конструктор класса должен заполнять эти поля при создании объекта.
 * 3. Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.
 * 4. Создать массив из 5 сотрудников.
 * Пример:
 * Person[] persArray = new Person[5]; // Вначале объявляем массив объектов
 * persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30);
 * // потом для каждой ячейки массива задаем объект
 * 5. С помощью цикла вывести информацию только о сотрудниках старше 40 лет.
 */

public class Colleague {
private String surname; //поле Фамилия
private String firstName; //поле Имя
private String patronymic; //поле Отчество
private  String post; //поле должность
private String email; //поле эл.почта
private String phone; // номер телефона
private int wages; // поле зарпата
private int age; //поле возраст

// создаем конструктор c ключевым словом this
public Colleague(String surname,String firstName,String patronymic, String post, String email, String phone, int wages, int age) {
    this.surname=surname;
    this.firstName=firstName;
    this.patronymic=patronymic;
    this.post=post;
    this.email=email;
    this.phone=phone;
    this.wages=wages;
    this.age=age;
}



    String getSurname() {
        return this.surname; }

    String getFirstName() {
         return this.firstName;}

    String getPatronymic () {
        return this.patronymic; }
    String getPost () {
        return this.post; }
    String getEmail () {
        return this.email; }
    String getPhone () {
        return this.phone; }
    int getWages () {
        return this.wages; }
    int getAge () {
        return this.age; }

        String getFullInfo() {
            return this.surname + " "+
            this.firstName+ " "+ this.patronymic + " ,"
                    + this.post + " ,"+ this.email + " ,"
                    + this.phone + " ,"+ this.wages +
                    ", "+ this.age; }

}


