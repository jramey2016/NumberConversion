import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;

public class DualConversion extends JFrame {
    private JTextField Arabic2Roman;
    private JTextField Roman2Arabic;
    public DualConversion(){
        super("Dual Conversion");
        setLayout(new FlowLayout());

        Arabic2Roman = new JTextField("Arabic -> Roman",10);
        add(Arabic2Roman);

        Roman2Arabic = new JTextField("Roman -> Arabic", 10);
        add(Roman2Arabic);

        TextFieldHandler handle = new TextFieldHandler();
        Arabic2Roman.addActionListener(handle);

        TextField2 handler = new TextField2();
        Roman2Arabic.addActionListener(handler);

    }
    private class TextFieldHandler implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            int userInputArabic = Integer.parseInt(Arabic2Roman.getText());
            int newheld;
            int newheld2;
            int newheld3;
            int newheld4;
            int newheld5;
            int newheld6;
            String newval = "";
            String[] romanVal =
                    {"M", "CM", "D", "CD", "C", "XC", "L",
                            "XL", "X", "IX", "V", "IV", "I"};

            while (userInputArabic != 0) {
                if (userInputArabic > 1000) {
                    newheld = userInputArabic / 1000;
                    userInputArabic = userInputArabic % 1000;
                    for (int i = 0; i < newheld; i++) {
                        newval = newval + romanVal[0];
                    }
                }
                if (userInputArabic >= 900) {
                    userInputArabic = userInputArabic % 100;
                    newval = newval + romanVal[1];
                }
                if (userInputArabic > 500) {
                    newheld2 = (userInputArabic - 500) / 100;
                    userInputArabic = userInputArabic % 100;
                    newval = newval + romanVal[2];
                    for (int j = 0; j < newheld2; j++) {
                        newval = newval + romanVal[4];
                    }
                }
                if (userInputArabic >= 500) {
                    userInputArabic = userInputArabic % 100;
                    newval = newval + romanVal[2];
                }
                if (userInputArabic >= 400) {
                    userInputArabic = userInputArabic % 100;
                    newval = newval + romanVal[3];
                }
                if (userInputArabic >= 100) {
                    newheld3 = userInputArabic / 100;
                    userInputArabic = userInputArabic % 100;
                    for (int k = 0; k < newheld3; k++) {
                        newval = newval + romanVal[4];
                    }
                }
                if (userInputArabic >= 90) {
                    userInputArabic = userInputArabic % 10;
                    newval = newval + romanVal[5];
                }
                if (userInputArabic >= 50) {
                    newheld4 = (userInputArabic - 50) / 10;
                    userInputArabic = userInputArabic % 10;
                    newval = newval + romanVal[6];
                    for (int m = 0; m < newheld4; m++) {
                        newval = newval + romanVal[8];
                    }
                }
                if (userInputArabic >= 40) {
                    userInputArabic = userInputArabic % 10;
                    newval = newval + romanVal[7];
                }
                if (userInputArabic >= 10) {
                    newheld5 = userInputArabic / 10;
                    userInputArabic = userInputArabic % 10;
                    for (int n = 0; n < newheld5; n++) {
                        newval = newval + romanVal[8];
                    }
                }
                if (userInputArabic == 9) {
                    userInputArabic = userInputArabic % 9;
                    newval = newval + romanVal[9];
                }
                if (userInputArabic >= 5) {
                    newheld5 = (userInputArabic - 5);
                    userInputArabic = 0;
                    newval = newval + romanVal[10];
                    for (int m = 0; m < newheld5; m++) {
                        newval = newval + romanVal[12];
                    }
                }
                if (userInputArabic == 4) {
                    userInputArabic = 0;
                    newval = newval + romanVal[11];
                }
                if (userInputArabic >= 3) {
                    newheld6 = userInputArabic;
                    userInputArabic = 0;
                    for (int o = 0; o < newheld6; o++) {
                        newval = newval + romanVal[12];
                    }
                }
            }
            Roman2Arabic.setText(newval);
        }
    }
    private class TextField2 implements ActionListener {
        public void actionPerformed(ActionEvent e){
            String userInputRoman = Roman2Arabic.getText();
            int sum=0;
            int value = 0;
            int oldVal = 0;
            int ct = 0,ct1 = 0,ct2 = 0,ct3 = 0,ct4 = 0,ct5 =0 ,ct6 = 0;
            char[] RomanChar = userInputRoman.toCharArray();

            int i = 0;
            while(i < RomanChar.length) {
                if (RomanChar[i] == 'M') { value = 1000; ct++; }
                if (RomanChar[i] == 'D') { value = 500; ct1++;
                    if (ct1 == 2) {
                        Arabic2Roman.setText("Invalid value");
                        i = RomanChar.length; }
                }
                if (RomanChar[i] == 'C') { value = 100; ct2++;
                    if (ct2 == 4) {
                        Arabic2Roman.setText("Invalid value");
                        i = RomanChar.length; }
                }
                if (RomanChar[i] == 'L') { value = 50; ct3++;
                    if (ct3 == 2) {
                        Arabic2Roman.setText("Invalid value");
                        i = RomanChar.length; }
                }
                if (RomanChar[i] == 'X') { value = 10; ct4++;
                    if (ct4 == 4) {
                        Arabic2Roman.setText("Invalid value");
                        i = RomanChar.length; }
                }
                if (RomanChar[i] == 'V') { value = 5; ct5++;
                    if (ct5 == 2) {
                        Arabic2Roman.setText("Invalid value");
                        i = RomanChar.length; }
                }
                if (RomanChar[i] == 'I') { value = 1; ct6++;
                    if(ct6 == 4 ){
                        Arabic2Roman.setText("Invalid value");
                        i = RomanChar.length; }
                }

                if(oldVal < value){
                    value = value - oldVal;
                    sum = sum - oldVal;
                }
                sum = sum + value;
                i++;
                oldVal = value;
                System.out.print(ct);
            }

            Arabic2Roman.setText(String.valueOf(sum));
        }
    }
}



