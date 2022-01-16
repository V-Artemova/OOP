package com.company;

import javax.swing.*;
import java.awt.*;


public class Main extends JFrame {
    // переменные для кофейных напитков
    public static JRadioButton coffeeRadioButton = new JRadioButton("Латте классический  150Р");
    public static JRadioButton cappuccinoRadioButton = new JRadioButton("Капуччино                   120Р");
    public static JRadioButton teaRadioButton = new JRadioButton("Чайный напиток          80Р");
    public static JLabel coffeeLabel = new JLabel("Кофейные напитки");

    // переменные для десертов
    public static JCheckBox bagelsCheckBox = new JCheckBox("Бельгийские вафли               150Р");
    public static JCheckBox croissantCheckBox = new JCheckBox("Круассан классический         160Р");
    public static JCheckBox toastCheckBox = new JCheckBox("Тост с джемом клубничным 170Р");
    public static JLabel dessertLabel = new JLabel("Дессерты");


    public static JLabel subtotalLabel = new JLabel("                                                               Сумма без скидки");
    public static JLabel taxLabel = new JLabel("                                                                                 Скидка");
    public static JLabel totalLabel = new JLabel("                                                               Сумма со скидкой");
    public static JLabel controlLabel = new JLabel("Кнопки управления");


    // поля для вывода численных значений
    public static JTextField subtotalTxt = new JTextField("                       ");
    public static JTextField taxTxt = new JTextField("                       ");
    public static JTextField totalTxt = new JTextField("                       ");

    // кнопки
    public static JButton enterBtn = new JButton("Расчитать");
    public static JButton clearBtn = new JButton(" Очистить");
    public static JButton exitBtn = new JButton("   Выход   ");

    public static double total = 0; // для хранения цены со скидкой
    public static double subtotal = 0; // для хранения цены без скидки
    public static final double taxrate = 0.05; // скидка
    public static double tax = 0; // для хранения надбавки


    public static void main(String[] args) {


        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //реальное закрытие программы, при закрытии окна(нажатии на красный крестик)
        frame.setSize(1000, 400);
        JPanel panelMain = new JPanel();

        panelMain.setLayout(new BoxLayout(panelMain, BoxLayout.X_AXIS));

        //панель для расположения  кофейных напитков
        JPanel panelCoffee = new JPanel(new VerticalLayout());
        panelCoffee.add(coffeeLabel);
        panelCoffee.add(coffeeRadioButton);
        panelCoffee.add(cappuccinoRadioButton);
        panelCoffee.add(teaRadioButton);
        panelCoffee.add(subtotalLabel);
        panelCoffee.add(taxLabel);
        panelCoffee.add(totalLabel);


        //панель для расположения дессертов
        JPanel panelDessert = new JPanel(new VerticalLayout());
        panelDessert.add(dessertLabel);
        panelDessert.add(bagelsCheckBox);
        panelDessert.add(croissantCheckBox);
        panelDessert.add(toastCheckBox);
        panelDessert.add(subtotalTxt);
        panelDessert.add(taxTxt);
        panelDessert.add(totalTxt);


        //панель для расположения полей для расчета стоимости
        JPanel panelThree = new JPanel(new VerticalLayout());
        panelThree.add(controlLabel);
        panelThree.add(enterBtn);
        panelThree.add(clearBtn);
        panelThree.add(exitBtn);


        panelMain.add(panelCoffee);
        panelMain.add(panelDessert);
        panelMain.add(panelThree);

        frame.add(panelMain);

        // обработка выбора напитка
        coffeeRadioButton.addActionListener(event -> {
            cappuccinoRadioButton.setSelected(false);
            teaRadioButton.setSelected(false);
        });

        cappuccinoRadioButton.addActionListener(event -> {
            coffeeRadioButton.setSelected(false);
            teaRadioButton.setSelected(false);
        });

        teaRadioButton.addActionListener(event -> {
            coffeeRadioButton.setSelected(false);
            cappuccinoRadioButton.setSelected(false);
        });

        // обработка нажатий кнопок

        exitBtn.addActionListener(event -> {
            System.exit(0); // обработка нажатия кнопки "Выход"
        });

        clearBtn.addActionListener(event -> {
            coffeeRadioButton.setSelected(false);
            cappuccinoRadioButton.setSelected(false);
            teaRadioButton.setSelected(false);
            bagelsCheckBox.setSelected(false);
            croissantCheckBox.setSelected(false);
            toastCheckBox.setSelected(false);
            subtotalTxt.setText("");
            taxTxt.setText("");
            totalTxt.setText("");
        });
        enterBtn.addActionListener(event -> {
            subtotal=0;
            total=0;
            tax=0;
            if (coffeeRadioButton.isSelected()) {
                subtotal = subtotal + 100;
            } else if (cappuccinoRadioButton.isSelected()) {
                subtotal = subtotal + 150;
            } else if (teaRadioButton.isSelected()) {
                subtotal = subtotal + 80;
            }
            /*учет дополнительной вкусняшки*/

            if (bagelsCheckBox.isSelected()) {
                subtotal = subtotal + 150;
            }

            if (croissantCheckBox.isSelected()) {
                subtotal = subtotal + 160;
            }

            if (toastCheckBox.isSelected()) {
                subtotal = subtotal + 170;
            }
            subtotalTxt.setText(Double.toString(subtotal)); // вывод общей суммы без надбавки
            subtotal = Double.parseDouble(subtotalTxt.getText());
            tax = subtotal * taxrate; // высчитываем скидку
            total =  subtotal-tax; // полная суммма

            taxTxt.setText(Double.toString(tax)); // ввывод надбавки
            totalTxt.setText(Double.toString(total)); // вывод полной суммы
        });
        frame.setVisible(true);


    }


}