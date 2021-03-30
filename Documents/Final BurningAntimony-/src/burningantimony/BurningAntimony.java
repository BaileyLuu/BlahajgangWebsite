//Burning Antimony is a text-based game that tasks the player with breaking codes or “ciphers” at different difficulty levels that progressively get harder. 

package burningantimony;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

    public class BurningAntimony extends JFrame {
        public final JButton lvOnebtn; 
        // Level one button
        public final JButton lvTwobtn; 
        // Level two button
        public final JButton lvThreebtn; 
        //Level three button
        public final JButton lvFourbtn; 
        // Level four button
        public final JButton lvFivebtn; 
        //level five button
          JFrame frame;
         
        public static void main(String[]args){
            new BurningAntimony(); 
            //call BurningAntimony method
        }
        public BurningAntimony() {
            lvOnebtn = new JButton("BEGINNER"); 
            //beginner level button
            lvTwobtn = new JButton("EASY ");    
            //easy level button
            lvThreebtn = new JButton("IMMEDIATE"); 
            //immediate level button
            lvFourbtn = new JButton("HARD");       
            //hard level button
            lvFivebtn = new JButton("EXTREME"); 
            //extreme level button

            startButton clickHere = new startButton();
            // add ActionListener to each button and link it to startButton method
            lvOnebtn.addActionListener(clickHere); 
            lvTwobtn.addActionListener(clickHere); 
            lvThreebtn.addActionListener(clickHere);
            lvFourbtn.addActionListener(clickHere);
            lvFivebtn.addActionListener(clickHere);

            //     lvOnebtn.setBorder(BorderFactory.createEmptyBorder());
            lvOnebtn.setContentAreaFilled(true);               
            //set content area filled to true
            lvOnebtn.setHorizontalAlignment(JButton.CENTER); 
            //set the title of buttons to center
            lvOnebtn.setFont(new Font("Serif", Font.BOLD, 40));
            // set the same font to 'serif', bold, and size of 40 to five buttons
            lvOnebtn.setForeground(Color.GREEN); 
            // set the same words colour on the buttons to green to five buttons
            lvOnebtn.setBounds(150,500,250,80); 
            // set lvOnebtn to the farthest left, 500 units from the top, width is 250, height is 80

            //  lvTwobtn.setContentAreaFilled(true);
            lvTwobtn.setBounds(500, 500, 270, 80);
            //set lvTwobtn next to lvOnebtn, allign the same row as lvOnebtn, width is 270, height is 80
            lvTwobtn.setFont(new Font("Serif", Font.BOLD, 40)); 
            lvTwobtn.setForeground(Color.GREEN); 

            lvThreebtn.setBounds(870, 500, 300, 80); 
            //set lvThreebtn next to lvTwobtn, allign the same row as lvTwobtn, width is 300, height is 80
            lvThreebtn.setFont(new Font("Serif", Font.BOLD, 40)); 
            lvThreebtn.setForeground(Color.GREEN);

            lvFourbtn.setBounds(350, 650, 270, 80); 
            //set the lvFourbtn next to lvThreebtn, allign the same row as lvThreebtn, the same width and height as lvThreebtn
            lvFourbtn.setFont(new Font("Serif", Font.BOLD, 40));
            lvFourbtn.setForeground(Color.GREEN);

            lvFivebtn.setBounds(720, 650, 300, 80);
            //set the lvFivebtn next to lvFourbtn, allign the same row as lvFourbtn, the same width and height as lvFourbtn
            lvFivebtn.setFont(new Font("Serif", Font.BOLD, 40));
            lvFivebtn.setForeground(Color.GREEN);
            lvFivebtn.setBackground(Color.BLACK);

            JLabel label = new JLabel("Burning Antimony"); //GAME TITLE 
            label.setFont(new Font("Serif", Font.BOLD, 100));
            //set font to 'serif', bold, and size of 100 
            label.setForeground(Color.GREEN);
            label.setBounds(350, 100, 1500, 150);// set the title fixed position

            JLabel matrix = new JLabel();//GIF LABEL
            //  new JLabel for gif picture in the background
            matrix.setIcon(new ImageIcon(getClass().getResource("backgroundMatrix.gif")));
            //set JLabel to an icon image
            matrix.setBounds(0, 0, 1920,1080);
            //gif label at the center, width is 1920, height is 1080

            JLayeredPane layers = new JLayeredPane();
            // use to overlap the layers if needed
            layers.add(label, new Integer(1));
            //1 is the highest layer
            layers.add(lvOnebtn, new Integer(1));
            // set the all the buttons to the same layer
            layers.add(lvTwobtn, new Integer(1));
            layers.add(lvThreebtn, new Integer(1));
            layers.add(lvFourbtn, new Integer(1));
            layers.add(lvFivebtn, new Integer(1));
            layers.add(matrix, new Integer(0));
            // 0 is the default layer, lowest layer
            //     layers.add(matrix, new Integer(0));

            frame = new JFrame("Burning Antimony");
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            //maximized the frame
            frame.add(layers);
            //add layers to frame
            frame.pack();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        }
        public class startButton implements ActionListener{
          
            
            public void actionPerformed(ActionEvent ae){
                try{
                    if(ae.getSource() == lvOnebtn){ 
                        //if user click on level one button
                        frame.dispose();
                        LevelOne levelOne = new LevelOne(); 
                        //call the levelOne method from other file
                    }
                    if(ae.getSource() == lvTwobtn){ 
                        // if user click on level two button
                        frame.dispose();
                        LevelTwo lvTwo = new LevelTwo(); 
                        //call the levelTwo method from other file
                    }if(ae.getSource() == lvThreebtn){ 
                        // if user click on level three button
                        frame.dispose();
                        LevelThree lvThree = new LevelThree();
                        //call the levelThree method from other file
                    }if(ae.getSource() == lvFourbtn){ 
                        // if user click on level four button
                        frame.dispose();
                        LevelFour lvFour = new LevelFour(); 
                        //call the levelFour method from other file
                    }if(ae.getSource() == lvFivebtn){
                        // if user click on level five button 
                        frame.dispose();
                        LevelFive lvFive = new LevelFive();  
                        //call the levelFive method from other file
                    }
                }catch(Exception e){
                }
            }

        private void setVisible(boolean b) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        }
     }
