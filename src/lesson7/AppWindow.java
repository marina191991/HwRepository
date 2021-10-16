package lesson7;
//setVisible(boolean visible) - сделать окно видимым.
//setDefaultCloseOperation(int operation) - определение действия при завершении программы;
//setSize(int width, int height) - определение размеров окна;


import javax.swing.*;
import java.awt.*;


public class AppWindow extends JFrame {
    private int WWight=800;
    private int WHeight=600;
    private int WPosX=550;
    private int WPosY=200;
    private DrinkPanel panel;


    AppWindow(){
        setupWindow();
        panel=new DrinkPanel();
        add(panel, BorderLayout.WEST);
        setVisible(true); }
    //закинули всё в один метод
    private void setupWindow() {
        setSize(WWight,WHeight) ;
        setLocation(WPosX,WPosY);
        setTitle("Drink");

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


    }
}
