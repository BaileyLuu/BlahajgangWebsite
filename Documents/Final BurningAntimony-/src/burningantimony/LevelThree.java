package burningantimony;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import javax.swing.*;

public class LevelThree extends JFrame{
    
    //Text area to display the cipher. 
    JTextArea display;
    //Label that will display text for the user to enter a character to replace.
    final private JLabel replaceLabel;
    //Creates a label that will display text for the user to enter character to replace the previous character with.
    final private JLabel withLabel;
    //Creates a button to update the cipher. 
    final private JButton updateButton;
    //Creates a field for the user to input the replace character.
    private static JTextField replaceField;
    //Creates a field for the user to input the replace with character. 
    private static JTextField withField;
    //Creates a newline string for convenience. 
    private final String newline = "\n";
    //Creates a button to print the encrypted message. 
    final private JButton printEncrypted;
    //Creates a generic container to add the GUI elements to.
    final private JButton returnBtn;
    Container contain;
    //Creates a string to store the encrypted cipher. 
    String encrypted;
    //Creates a string to store the reloaded cipher using the user's input. 
    String reloaded = "";
    //Creates a string to store user input. 
    String input;
    //Integer to determine whether it is the start of the game or not. 1 = start. 
    boolean start = true;
    //String to copy into over to. Initialized to blank. 
    String tempInput = "";
    //Original text before being encrypted.
    final String originalText = "Wow, you're not as bad as I thought. ";
    //How many to shift by when encrypting. 
    final int shift = 13;
    //create a new text file to save the user game's progress
    File file = new File ("LevelThreeProgress.txt");
    String temp ;
    
    public LevelThree (){
        super("BEGINNER");
        //Gets the pane.
        contain = getContentPane();
        //Sets a background color for the content pane (contain).
        getContentPane().setBackground(new java.awt.Color(0, 0, 0));
        //Using flow layout manager.
        contain.setLayout(new FlowLayout());
        returnBtn = new JButton("Go Back");
        returnBtn.setForeground(Color.green);
        
        replaceLabel = new JLabel("Replace character in cipher");
        //Sets the text color to green for replaceLabel.
        replaceLabel.setForeground(Color.green);
        //Sets the updateButton text.
        updateButton = new JButton("Update cipher");
        //Sets the text color to green for updateButton.
        updateButton.setForeground(Color.green);
        //Sets field size for replaceField.
        replaceField = new JTextField(15);
        //Sets field size for replaceField.
        printEncrypted = new JButton("Click to print original encrypted message");
        // button to print the original message
        printEncrypted.setForeground(Color.green);
        display = new JTextArea(35,90);
        //set text area to 35 rows, 50 columns
        display.setFont(display.getFont().deriveFont(16f)); 
        display.setBackground(Color.black);
        display.setForeground(Color.green);
        display.setEditable(false); 
        // not edit for text area
        printEncrypted.setFont(printEncrypted.getFont().deriveFont(15f));
        //set the same font to all the buttons
        updateButton.setFont(updateButton.getFont().deriveFont(15f));
        replaceLabel.setFont(replaceLabel.getFont().deriveFont(15f));
        returnBtn.setFont(replaceLabel.getFont().deriveFont(15f));
        
        JScrollPane scroll = new JScrollPane(display); 
        //add JScrollPane to the text area
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);  
        // appears vertical scroll when it needed
     
        withLabel = new JLabel("with"); 
        withLabel.setForeground(Color.green);
        //set word colour to green
        withLabel.setFont(replaceLabel.getFont().deriveFont(15f));
        //btnFahrenheit = new JButton("oof");
        withField = new JTextField(15);
        //create textfield with 15 columns
        contain.add(returnBtn);
        //container add returnBtn
        add(printEncrypted, BorderLayout.NORTH);
        //add printOriginalMessage button on the top beside replacelabel
        contain.add(replaceLabel);
        // container add replaceLabel
        contain.add(replaceField); 
        // container add replaceField 
        contain.add(withLabel); 
        // container add withLabel
        contain.add(withField); 
        // container add withField
        contain.add(updateButton); 
        // container add updateButton
        add(scroll); 
        // add JScrollPane to this frame
        
        ButtonHandler btnHandler = new ButtonHandler(); 
        //call ButtonHandler method from this file
        updateButton.addActionListener(btnHandler); 
        //this method contain updateButton with the ActionListener
        
        printMessage btPrintMessage = new printMessage(); 
        // call printMessage method from this file
        printEncrypted.addActionListener(btPrintMessage); 
        // this method contain printEncrypted button with the ActionListener
        
        goBack btnReturn = new goBack();
        //return button allow user to go back to menu
        returnBtn.addActionListener(btnReturn);
        //add ActionLister to the button
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        //Maximized the frame 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }//end method
    private class Code {
        public Code() {
            //text to encrypt.
            String text = "Wow, you're not as bad as I thought. ";
            //Shift by this amount to encrypt.
            int shift = 13;
            //Creates the cipher and stores it in the string encrypted.
            encrypted = encryptText (text, shift);
            //If this is the start of the game assign encrypted to reloaded and set start to zero to indicate 
            //it is not the beginning of the game.
            while (start == true){
            reloaded = encrypted;
            start = false;
            }
            //If the previous input is the same as the current input do not reload the cipher.
            if (tempInput.equals(input) == false)
            temp = reloaded;
            //Reloads the cipher using the reloadCipher method.
            reloaded = reloadCipher (input.charAt(0), input.charAt(1), text, reloaded, encrypted);
            //Sets start to zero to indicate it is not the start of the game. 
            start = false;
        }
       //Method to reload the cipher. 
        public  String reloadCipher (char replace, char with, String originalText, String currCipher, String textToEncrypt){
        //Sets the initial reloaded string to blank to add to it. 
        String reloaded = "";
       
        //Loops through the character indices of the originalText and compares them to replace and with.
        for (int i = 0; i < originalText.length(); i++) {
            if (Character.toLowerCase(originalText.charAt(i)) == with){
                if(Character.toLowerCase(currCipher.charAt(i)) == replace){
                //Reload the cipher using the character at the original cipher if with is the same as with in the current cipher and 
                //replace is the character in the original cipher.
                    reloaded = reloaded + originalText.charAt(i);
                }else{
                    //if replace isn't equal to currCipher.charAt(i), 
                    reloaded = reloaded + currCipher.charAt(i); 
                }
            }
            else {
                //If the replace and with do not align add the character at the i index of the current cipher. 
                reloaded = reloaded + currCipher.charAt(i);                                                                   
            }
        }
        //Return the decrypted string. 
        return reloaded;
    }
        public String encryptText (String textToEncrypt, int shift){
        //Initializes the encrypted string to blank to add to it. 
        String encrypted = "";
        //Alphabet array.
        final char[] alpha = {'A' , 'B' , 'C' , 'D' , 'E' , 'F' , 'G' , 'H' ,'I' , 'J' , 'K' , 'L' , 'M' , 'N' , 'O' , 'P' , 'Q' , 'R' , 'S' , 'T' ,'U' , 'V' , 'W' , 'X' , 'Y' , 'Z'};
        //Loop to go through the length of the text to be encrypted.
        for (int i = 0; i < textToEncrypt.length(); i++){
            //Loop through the alphabet. 
            for (int y = 0; y < 26; y ++){
                //If the current character at i is a space, question mark, or period add it to encrypted.
                    if (textToEncrypt.charAt(i)== ' ' || textToEncrypt.charAt(i) == '?' || textToEncrypt.charAt(i) == '.'){
                        encrypted = encrypted + textToEncrypt.charAt(i);
                        break;
                    }
                    //Otherwise shift the alphabet array by shift and then add that character to encrypted.
                        else if (Character.toLowerCase(textToEncrypt.charAt(i)) == Character.toLowerCase(alpha[y])) {
                        int shiftBy = y - shift; 
                        if (shiftBy < 0){
                            shiftBy = 26 + shiftBy;
                        }
                        encrypted = encrypted + alpha[shiftBy];
                        break;
                        }
                }
            }
        //Return the encrypted text.
       
        return encrypted;        
    }
    }//end method
    private class ButtonHandler implements ActionListener{ 
        
        public void actionPerformed(ActionEvent ae){ 
            try{
                if (ae.getSource() == updateButton){
                    //if user click on the updateCipher button
                    input = Character.toString(replaceField.getText().charAt(0)) + Character.toString(withField.getText().charAt(0));
                    //the string input equals to the charAt(0) of each textField
                    Code code = new Code();
                    //go to Code method
                    if(!reloaded.equals(temp)){ 
                    //if reloaded string equals to temp string
                        display.append("Congrats, here is your updated cipher:\t\t"); 
                        // print congrats message
                        temp = ""; //reset the temp string to continue comparation 
                    }else{
                        display.append("You enter the wrong letter!\t\t\t"); 
                        //print Oh No message
                        temp = "";
                    }
                    display.append(reloaded + newline + newline);
                    //new cipher will be added to text area
                    try{
                       FileWriter writer = new FileWriter(file, true);
                       //FileWriter Constructor pass the name of the file.  File is created if does not exist
                       writer.write(reloaded + newline + newline);
                       //reloaded string will be added to the text file
                       writer.close();
                       //used when a program is done with a file
                    }catch(Exception e){
                       System.out.println("ERROR");
                    }
                    //textArea displays the new cipher
                    if(reloaded.equals(originalText)){
                    //if the cipher equals to the original message
                        try{
                           FileWriter writer = new FileWriter(file, true);
                           writer.write("You did it!" + newline);
                           
                        }catch(Exception e){
                           System.out.println("ERROR");
                        }
                    display.append("You did it!" + newline);
                    //text area displays congratulation message
                    updateButton.setEnabled(false);
                    //set the updateCipher button to false so user can't click since the game ends    
                    }
                    replaceField.setText("");
                    //reset replaceField
                    withField.setText("");
                    //reset withField
                }//end if
            }//end try
            catch (Exception e){
                    withField.setText("");
            }//end catch
        }//end inner class
    }
    private class printMessage implements ActionListener{
        //class for printMessage button 
        public void actionPerformed(ActionEvent ae){
            try{
                if (ae.getSource() == printEncrypted){
                    //if the user click on printMessage button
                    try{
                       FileWriter writer = new FileWriter(file, true);
                       writer.write("The original message is:\t\t\t" + encryptText(originalText,shift) + newline + newline);
                       writer.close();
                    }catch(Exception e){
                        System.out.println("ERROR");
                    }
                display.append("The original message is:\t\t\t" + encryptText(originalText, shift) + newline + newline); 
                // encrypted text add to text area
                printEncrypted.setEnabled(false);
                //printMessage button will only used once. It will be false after the first click
                }
            }catch(Exception e){
                System.out.println("Encrypted code will be printed once");
            }
        }
        
    }
    private class goBack implements ActionListener{
        //class for returnBtn
            public void actionPerformed(ActionEvent ae){
                try{
                    if (ae.getSource() == returnBtn){
                        //if user click to go back to menu
                        dispose(); 
                        // the current level will be disposed
                        BurningAntimony startMenu = new BurningAntimony();
                        //call BurningAntimony method
                    }
                }catch(Exception e){
                    System.out.println("ERROR");
                }
            }
    }
    public String encryptText (String textToEncrypt, int shift){
        String encrypted = "";
        final char[] alpha = {'A' , 'B' , 'C' , 'D' , 'E' , 'F' , 'G' , 'H' ,'I' , 'J' , 'K' , 'L' , 'M' , 'N' , 'O' , 'P' , 'Q' , 'R' , 'S' , 'T' ,'U' , 'V' , 'W' , 'X' , 'Y' , 'Z'};
        for (int i = 0; i < textToEncrypt.length(); i++){
            for (int y = 0; y < 26; y ++){
                if (textToEncrypt.charAt(i)==' ' || textToEncrypt.charAt(i) == ',' || textToEncrypt.charAt(i) == '.' 
                    || textToEncrypt.charAt(i) == '?' || textToEncrypt.charAt(i) == '!'){
                    //System.out.print(textToEncrypt.charAt(i));
                    encrypted = encrypted + textToEncrypt.charAt(i);
                    break;
                }else if (Character.toLowerCase(textToEncrypt.charAt(i)) == Character.toLowerCase(alpha[y])) {
                    int shiftBy = y - shift; 
                    if (shiftBy < 0){
                        shiftBy = 26 + shiftBy;
                    }
                    encrypted = encrypted + alpha[shiftBy];
                    //System.out.print(alpha[shiftBy]);
                    break;
                }
            }
        }
        return encrypted;        
    }
//end class
     public static void main (String[]args){
         
        new LevelThree();
        //go to LevelThree method
     }
}