import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;

public class Conversion extends JFrame {
    private JTextField Arabic;
    private JTextField Roman;
    private JTextField Roman2;
    private JTextField Arabic2;

    public Conversion(){
        super("Conversion");
        setLayout(new FlowLayout());

        Arabic = new JTextField("Enter Arabic value here", 10); //Text inside box and size.
        add(Arabic); //add to the widow

        Roman = new JTextField("Roman Output here.", 10); //Text inside box and size.
        add(Roman); //add to the window

        Roman2 = new JTextField("Enter Roman value here", 10);
        add(Roman2);

        Arabic2 = new JTextField("Arabic Output here.", 10);
        add(Arabic2);

        TextFieldHandler handler = new TextFieldHandler(); //Registering the event handler
        Arabic.addActionListener(handler); //handler for Arabic Text field.

        TextFieldRoman handle = new TextFieldRoman();
        Roman2.addActionListener(handle); //handler for Roman Text field
    }

    private class TextFieldHandler implements ActionListener{
        public void actionPerformed(ActionEvent e){
            int userInputArabic = Integer.parseInt(Arabic.getText());
            int held;
            int held2;
            int held3;
            int held4;
            int held5;
            int held6;
            String val = "";
            String[] romanVal =
                    {"M","CM","D","CD","C","XC","L",
                            "XL","X","IX","V","IV","I"};

            while(userInputArabic != 0){
                if(userInputArabic > 1000){
                    held = userInputArabic /1000;
                    userInputArabic = userInputArabic % 1000;
                    for(int i = 0; i < held ;i++) {
                        val = val + romanVal[0];
                    }
                }
                if (userInputArabic >= 900){
                    userInputArabic = userInputArabic %100;
                    val = val + romanVal[1];
                }
                if(userInputArabic > 500) {
                    held2 = (userInputArabic - 500) / 100;
                    userInputArabic = userInputArabic % 100;
                    val = val + romanVal[2];
                    for (int j = 0; j < held2; j++) {
                        val = val + romanVal[4];
                    }
                }
                if(userInputArabic >= 500){
                    userInputArabic = userInputArabic % 100;
                    val = val + romanVal[2];
                }
                if(userInputArabic >= 400){
                    userInputArabic = userInputArabic % 100;
                    val = val + romanVal[3];
                }
                if(userInputArabic >=100){
                    held3 = userInputArabic / 100;
                    userInputArabic = userInputArabic % 100;
                    for(int k = 0; k < held3; k++){
                        val = val + romanVal[4];
                    }
                }
                if(userInputArabic >=90){
                    userInputArabic = userInputArabic % 10;
                    val = val + romanVal[5];
                }
                if(userInputArabic >= 50){
                    held4 = (userInputArabic - 50) / 10;
                    userInputArabic = userInputArabic % 10;
                    val = val + romanVal[6];
                    for (int m = 0; m < held4; m++) {
                        val = val + romanVal[8];
                    }
                }
                if(userInputArabic >= 40){
                    userInputArabic = userInputArabic % 10;
                    val = val + romanVal[7];
                }
                if(userInputArabic >= 10){
                    held5 = userInputArabic /10;
                    userInputArabic = userInputArabic % 10;
                    for(int n = 0; n < held5; n++){
                        val = val + romanVal[8];
                    }
                }
                if(userInputArabic == 9){
                    userInputArabic = userInputArabic % 9;
                    val = val + romanVal[9];
                }
                if(userInputArabic >=5){
                    held5 = (userInputArabic - 5);
                    userInputArabic = 0;
                    val = val + romanVal[10];
                    for (int m = 0; m < held5; m++) {
                        val = val + romanVal[12];
                    }
                }
                if(userInputArabic == 4){
                    userInputArabic = 0;
                    val = val + romanVal[11];
                }
                if(userInputArabic >= 3){
                    held6 = userInputArabic;
                    userInputArabic = 0;
                    for(int o = 0; o < held6 ; o++){
                        val = val + romanVal[12];
                    }
                }
            }
            Roman.setText(val);
        }
    }

    private class TextFieldRoman implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String userInputRoman = Roman2.getText();
            int sum=0;
            int value = 0;
            int oldVal = 0;
            char[] RomanChar = userInputRoman.toCharArray();

            int i = 0;
            while(i < RomanChar.length) {
                if (RomanChar[i] == 'M') {value = 1000;}
                if (RomanChar[i] == 'D') {value = 500;}
                if (RomanChar[i] == 'C') {value = 100; }
                if (RomanChar[i] == 'L') {value = 50; }
                if (RomanChar[i] == 'X') {value = 10;}
                if (RomanChar[i] == 'V') {value = 5; }
                if (RomanChar[i] == 'I') {value = 1;}
                if(oldVal < value){
                    value = value - oldVal;
                    sum = sum - oldVal;
                }
                sum = sum + value;
                i++;
                oldVal = value;
            }

            Arabic2.setText(String.valueOf(sum));
        }
    }
}

