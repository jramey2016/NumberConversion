import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;
import java.awt.Color;
import java.util.Random;
import java.awt.Graphics;

public class Create extends JFrame {
    private final JTextField field;
    private int randomVal;
    private JLabel TooHigh;
    private JLabel TooLow;
    private int oldGuess;
    // private final JTextField guess;
    //Constructor will add the text fields to the frame.
    public Create() {
        super("Guess My Number"); //Title of the game.
        setLayout(new FlowLayout());

        final Random myVal = new Random(); //Creates object from Class Random to get random value
        randomVal = myVal.nextInt(randomVal + 1001); //Set Bounds
        System.out.print(randomVal); //(Printed value for oral in command counsel for oral exam).

        field = new JTextField("Enter your guess here!"); //Shows user where to enter text and creates box for input.
        add(field); //add the field to window.

        TooHigh = new JLabel("Too High"); //will add to window after first user input.
        TooLow = new JLabel("Too Low"); //will add to window after first user input.

        TextFieldHandler handle = new TextFieldHandler(); //Registering event handler
        field.addActionListener(handle);

        oldGuess = 0;

        JButton tryAgain = new JButton("Play Again"); //creates button for user to play again
        add(tryAgain); //added to window.
        tryAgain.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                randomVal = myVal.nextInt(1001); //creates new bound
                field.setEditable(true); //allows field to be edited
                System.out.print(randomVal); //for oral exam purposes
            }
        });

    }

    //inner class for event handling.
    private class TextFieldHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            int userVal;
            userVal = Integer.parseInt(field.getText()); //This will bring in the user input from the textfield
            //and convert to integer for logic below.

            if ((userVal > randomVal)) { //Control statement to check user input and set Red.
                add(TooHigh);
            }

            else if((userVal < randomVal)){ // Control statement to check user input and set Blue
                add(TooLow);
            }

            if(userVal == randomVal){ //Control statement to check user input and set Green.
                getContentPane().setBackground(Color.GREEN);
                JOptionPane.showMessageDialog(null, "YOU WIN!"); //Lets user know they won.
                field.setEditable(false); //User is not allowed to input anymore values
            }

            if((randomVal - oldGuess) > (randomVal - userVal) ){ //Warmer
                getContentPane().setBackground(Color.RED); //window is now red
            }

            else{ //Colder
                getContentPane().setBackground(Color.BLUE); //window is now blue
            }
            oldGuess = userVal; //Value update for comparision to see if the user is getting closer or further away.
        }
    }
}
