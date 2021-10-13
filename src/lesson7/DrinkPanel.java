package lesson7;

import javafx.scene.control.RadioButton;

import javax.swing.*;
import java.awt.*;

public class DrinkPanel extends JPanel {
    private JPanel drink;
    private JButton espresso;
    private JButton americano;
    private JButton cappuccino;
    private JButton chocolate;
    private JButton blackTea;


    private JPanel volumeDrink;
    private JLabel textVolume;
    private JRadioButton minVolume;
    private JRadioButton maxVolume;


      DrinkPanel() {
      setLayout(new GridLayout(2,1,5,3));
        ChooseDrink ();
        ChooseVolume ();



    }


    private void ChooseDrink () {
        drink= new JPanel();
        drink.setLayout(new GridLayout(5,1));
                espresso= new JButton("Espresso");
        americano=new JButton("Americano");
        cappuccino=new JButton("Cappuccino");
        chocolate=new JButton("Chocolate");
        blackTea=new JButton("BlackTea");
               drink.add(espresso);
        drink.add(americano);
        drink.add(cappuccino);
        drink.add(chocolate);
        drink.add(blackTea);
        add(drink);

    }
    private void ChooseVolume () {
        volumeDrink=new JPanel();
        volumeDrink.setLayout(new GridLayout(3,1));
        textVolume=new JLabel("Выберите объем");

        minVolume = new JRadioButton("200 ml");

        minVolume.setActionCommand("200 ml");
        minVolume.setSelected(true);

        maxVolume = new JRadioButton("400 ml");

        minVolume.setActionCommand("400 ml");
        ButtonGroup group = new ButtonGroup(); //группируем кнопки для переключения
        group.add(minVolume);
        group.add(maxVolume);
        volumeDrink.add(textVolume);
        volumeDrink.add(minVolume);
        volumeDrink.add(maxVolume);
        add(volumeDrink);
    }


}
