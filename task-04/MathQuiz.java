import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;


public class MathQuiz extends JFrame {

    JRadioButton radioButton1, radioButton2, radioButton3, radioButton4, radioButton5, radioButton6, radioButton7, radioButton8;
    ButtonGroup typeGroup = new ButtonGroup();
    ButtonGroup levelGroup = new ButtonGroup();

    //labels
    JLabel QuestionLabel = new JLabel("Question:");
    JLabel answerLabel = new JLabel("Answer:");
    JLabel shownLabel = new JLabel("Question will be shown :");
    JLabel questionshownLabel = new JLabel("Question:");
    JLabel countLabel = new JLabel("Correct count be shown");
    JLabel timeLabel = new JLabel("Time spent will be shown");
    JLabel selectLabel = new JLabel("Select the interval:  ");
    JLabel toLabel = new JLabel(" to ");
    JLabel correctAnswer = new JLabel("0");
    JLabel wrongAnswer = new JLabel("0");

    //textfields
    JTextField input = new JTextField(12);
    JTextField interval1 = new JTextField(4);
    JTextField interval2 = new JTextField(4);

    //jbuttons
    JButton startButton = new JButton("Start");
    JButton stopButton = new JButton("Stop");

    //variables
    int num1, num2, operator, interval=0;
    int correctCount=0, wrongCount = 0;
    double result;
    String question;
    long startTime, finishTime, timeSpent;

    //invisible panel of selecting intervals
    JPanel panel4 = new JPanel();

    //New Frame objects
    JPanel panel6 = new JPanel();
    JPanel panel61 = new JPanel();
    JPanel panel62 = new JPanel();

    //ours design elements
    Font font = new Font("Verdana", Font.BOLD, 50);
    Color backgroundOfPanel4 = new Color(73, 175, 205);
    Color backgroundOfPanel61 = new Color(64, 173, 95);
    Color backgroundOfPanel62 = new Color(212, 42, 42);

    //creating new frame
    JFrame gameOver = new JFrame();


    public MathQuiz() {
        //frame layout
        setLayout(new BorderLayout());

        //creating panels
        JPanel panel1 = new JPanel(); // types + levels
        JPanel panel11 = new JPanel(); // types
        JPanel panel12 = new JPanel(); // levels
        JPanel panel2 = new JPanel(); //  question + answer + label of input + input + start & stop buttons
        JPanel panel21 = new JPanel(); // question + answer
        JPanel panel211 = new JPanel(); // question
        JPanel panel212 = new JPanel(); // answer
        JPanel panel22 = new JPanel(); // label of input + input
        JPanel panel23 = new JPanel(); // start & stop button
        JPanel panel3 = new JPanel(); // correct count + time spent
        JPanel panel31 = new JPanel(); // correct count
        JPanel panel32 = new JPanel(); // time spent
        //we create panel4 outside of constructor
        JPanel panel5 = new JPanel(); //invisble panel4 + panel2

        //setting panel4 to invisible
        panel4.setVisible(false);

        //adding borders to panels
        panel11.setBorder(new TitledBorder("Choose a type"));
        panel12.setBorder(new TitledBorder("Choose a level"));
        panel31.setBorder(new TitledBorder("Correct Count"));
        panel32.setBorder(new TitledBorder("Time Spent"));


        //designing titles, panel backgrounds and font colors

        TitledBorder titledBorder = new TitledBorder("Choose a level"); // the object named "title" is created
        titledBorder.setTitleColor(Color.WHITE); // the color is added to the object "title".
        panel4.setBorder(titledBorder); // titledborder is set to panel4.

        panel4.setBackground(backgroundOfPanel4);
        selectLabel.setForeground(Color.white);
        toLabel.setForeground(Color.white);

        //layouts (the others are flow layout by default)
        panel1.setLayout(new GridLayout(1, 2));
        panel11.setLayout(new GridLayout(4, 1));
        panel12.setLayout(new GridLayout(4, 1));
        panel2.setLayout(new GridLayout(3, 1));
        panel21.setLayout(new GridLayout(1, 2));
        panel211.setLayout(new FlowLayout(FlowLayout.LEFT)); /* Gridlerin içini flow yaptýk. Çünki */
        panel212.setLayout(new FlowLayout(FlowLayout.LEFT)); /* label'lar ortalý duruyorlar idi.   */
        panel3.setLayout(new GridLayout(1, 2));
        panel5.setLayout(new BorderLayout());


        //defining objects
        radioButton1 = new JRadioButton("Add");
        radioButton2 = new JRadioButton("Subtract");
        radioButton3 = new JRadioButton("Multipy");
        radioButton4 = new JRadioButton("Divide");

        radioButton5 = new JRadioButton("Starter");
        radioButton6 = new JRadioButton("Intermediate");
        radioButton7 = new JRadioButton("Advanced");
        radioButton8 = new JRadioButton("Select the interval");


        //adding objects to group
        typeGroup.add(radioButton1);
        typeGroup.add(radioButton2);
        typeGroup.add(radioButton3);
        typeGroup.add(radioButton4);

        levelGroup.add(radioButton5);
        levelGroup.add(radioButton6);
        levelGroup.add(radioButton7);
        levelGroup.add(radioButton8);

        //adding objects to panel
        panel11.add(radioButton1);
        panel11.add(radioButton2);
        panel11.add(radioButton3);
        panel11.add(radioButton4);
        panel12.add(radioButton5);
        panel12.add(radioButton6);
        panel12.add(radioButton7);
        panel12.add(radioButton8);

        panel211.add(QuestionLabel);
        panel212.add(answerLabel);

        panel22.add(shownLabel);
        panel22.add(input);
        panel23.add(startButton);
        panel23.add(stopButton);

        panel31.add(countLabel);
        panel32.add(timeLabel);

        panel4.add(selectLabel);
        panel4.add(interval1);
        panel4.add(toLabel);
        panel4.add(interval2);

        //adding nested panels
        panel1.add(panel11);
        panel1.add(panel12);

        panel21.add(panel211);
        panel21.add(panel212);
        panel2.add(panel21);
        panel2.add(panel22);
        panel2.add(panel23);

        panel3.add(panel31);
        panel3.add(panel32);

        panel5.add(panel4, BorderLayout.NORTH);
        panel5.add(panel2, BorderLayout.SOUTH);

        //adding panel to frame
        add(panel1, BorderLayout.NORTH);
        add(panel5, BorderLayout.CENTER);
        add(panel3, BorderLayout.SOUTH);



        //START OF NEW FRAME
        //designing new frame (colors, font, etc...)
        correctAnswer.setFont(font);
        correctAnswer.setForeground(Color.white);
        wrongAnswer.setFont(font);
        wrongAnswer.setForeground(Color.white);
        panel61.setBackground(backgroundOfPanel61);
        panel62.setBackground(backgroundOfPanel62);

        //titledborders of new frame
        TitledBorder titledBorder2 = new TitledBorder("Correct Answer");
        titledBorder2.setTitleColor(Color.WHITE);
        panel61.setBorder(titledBorder2);

        TitledBorder titledBorder3 = new TitledBorder("Wrong Answer");
        titledBorder3.setTitleColor(Color.WHITE);
        panel62.setBorder(titledBorder3);

        //layout of new frame's panel
        panel6.setLayout(new GridLayout(1, 2, 10, 10));

        //adding objects to panel and panel to frame
        panel61.add(correctAnswer);
        panel62.add(wrongAnswer);
        panel6.add(panel61);
        panel6.add(panel62);
        gameOver.add(panel6);

        //frame settings
        gameOver.setTitle("Game Over");
        gameOver.setVisible(false);
        gameOver.setSize(270, 150);
        gameOver.setLocationRelativeTo(null);
        //END OF NEW FRAME


        //Register a listener for the radio buttons.
        radioButton1.addActionListener(new addListener());
        radioButton2.addActionListener(new subListener());
        radioButton3.addActionListener(new multipyListener());
        radioButton4.addActionListener(new divideListener());
        radioButton5.addActionListener(new starterListener());
        radioButton6.addActionListener(new intermediateListener());
        radioButton7.addActionListener(new advancedListener());
        radioButton8.addActionListener(new selectListener());
        input.addKeyListener(new enterListener());
        startButton.addActionListener(new startListener());
        stopButton.addActionListener(new stopListener());
    }


    class starterListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            num1 = (int)(Math.random() * 6); // generating number 0 - 5
            num2 = (int)(Math.random() * 6);
            interval = 1; // for generating random numbers after first progress is completed
        }
    }

    class intermediateListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            num1 = (int)(Math.random() * 7 + 3); // generating number 3 - 10
            num2 = (int)(Math.random() * 7 + 3);
            interval = 2; // for generating random numbers after first progress is completed
        }
    }

    class advancedListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            num1 = (int)(Math.random() * 21); // generating number 0 - 20
            num2 = (int)(Math.random() * 21);
            interval = 3; // for generating random numbers after first progress is completed
        }
    }

    class selectListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            panel4.setVisible(true); // setting panel4 to visible for getting intervals from user
            interval = 4; // for generating random numbers after first progress is completed
        }
    }


    class addListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            operator = 1; // for generating formula to calculate correct answer
        }
    }

    class subListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            operator = 2; // for generating formula to calculate correct answer
        }
    }

    class multipyListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            operator = 3; // for generating formula to calculate correct answer
        }
    }

    class divideListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            operator = 4; // for generating formula to calculate correct answer
        }
    }

    class startListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            if (interval == 4) {
                // getting intervals from user
                int doubleOfInterval1 = Integer.parseInt(interval1.getText());
                int doubleOfInterval2 = Integer.parseInt(interval2.getText());

                // generating numbers between intervals
                num1 = (int)(Math.random() * (doubleOfInterval2 - doubleOfInterval1 + 1) + doubleOfInterval1);
                num2 = (int)(Math.random() * (doubleOfInterval2 - doubleOfInterval1 + 1) + doubleOfInterval1);

                // changing label text by intervals
                radioButton8.setText(doubleOfInterval1 + " to " + doubleOfInterval2);

                // hiding panel4 after pressing start button
                panel4.setVisible(false);

            }

            // if the user selects no interval for calculation
            else { if (interval != 4 && interval != 3 && interval != 2 && interval != 1) {
                num1 = (int)(Math.random() * 100);
                num2 = (int)(Math.random() * 100);
            }}



            // generating formula
            if (interval!=0) {
            if (operator == 1) {
                result = num1 + num2; //formula 
                question = ("" + num1 + "+" + num2);//question label content
            } else if (operator == 2) {
                result = num1 - num2; //formula 
                question = ("" + num1 + "-" + num2); //question label content
            } else if (operator == 3) {
                result = num1 * num2; //formula 
                question = ("" + num1 + "*" + num2); //question label content
            } else if (operator == 4) {
                result =(double)num1 / (++num2); //formula 
                question = ("" + num1 + "/" + num2); //question label content
            } else {
               question=("Select a type"); //question label content
            }}
            else {
                question=("Select a level");
            }

            shownLabel.setText(question); // changing question label
            startTime = System.currentTimeMillis(); // starting to get time after pressing start button

            // clearing counts after re-play
            correctCount = 0;
            wrongCount = 0;
            countLabel.setText("Correct count be shown");
            timeLabel.setText("Time spent will be shown");


        }

    }

    //we must use keylistener because of reading action of enter from keyboard
    class enterListener implements KeyListener {
        public void keyPressed(KeyEvent e) {


            // checking enter action
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {


                double doubleOfInput = Double.parseDouble(input.getText()); // getting string to double
             doubleOfInput*=100;
             doubleOfInput=(int)doubleOfInput;
             doubleOfInput/=100;

                // checking answer is correct or wrong
                if (doubleOfInput == result) {
                    correctCount ++; // increasing counter
                    String stringcount = Integer.toString(correctCount); // getting integer to string
                    countLabel.setText(stringcount); // setting string to label	
                } else {
                    wrongCount ++; // increasing wrong counter
                }

                input.setText(""); // clearing input after user entered answer

                // re-generating numbers after user entered answer with checking level (same as before)
                if (interval == 1) {
                    num1 = (int)(Math.random() * 6);
                    num2 = (int)(Math.random() * 6);
                } else if (interval == 2) {
                    num1 = (int)(Math.random() * 7 + 3);
                    num2 = (int)(Math.random() * 7 + 3);
                } else if (interval == 3) {
                    num1 = (int)(Math.random() * 21);
                    num2 = (int)(Math.random() * 21);
                } else if (interval == 4) {
                    int doubleOfInterval1 = Integer.parseInt(interval1.getText());
                    int doubleOfInterval2 = Integer.parseInt(interval2.getText());

                    num1 = (int)(Math.random() * (doubleOfInterval2 - doubleOfInterval1 + 1) + doubleOfInterval1);
                    num2 = (int)(Math.random() * (doubleOfInterval2 - doubleOfInterval1 + 1) + doubleOfInterval1);
                } else {
                    num1 = (int)(Math.random() * 100);
                    num2 = (int)(Math.random() * 100);
                }

                //re-generating formula
                if (operator == 1) {
                    result = num1+num2;
                    question = ("" + num1 + "+" + num2);
                } else if (operator == 2) {
                    result = num1-num2;
                    question = ("" + num1 + "-" + num2);
                } else if (operator == 3) {
                    result = num1*num2;
                    question = ("" + num1 + "*" + num2);
                } else if (operator == 4) {
                    result =(double)num1/(++num2);
                    result*=100;
                result=(int)result;
                result/=100;
                    //result=((int)(result*10))/100;
                    question = ("" + num1 + "/" + num2);
                }else {
                    question=("Select a type");
                }

                shownLabel.setText(question); //setting new question

            }
        }

        // implementation
        //other method1
        public void keyReleased(KeyEvent e) {}
        //other method2
        public void keyTyped(KeyEvent e) {}
    }

    //after user press stop button
    class stopListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            finishTime = System.currentTimeMillis(); // getting stopped time
            timeSpent = finishTime - startTime; // calculating time spent
            long realTime = timeSpent / 1000; // converting to readible time (because it is miliseconds)
            String stringtimeSpent = Long.toString(realTime); // converting float to string
            timeLabel.setText(stringtimeSpent + " seconds"); // setting timeLabel

            if (interval == 4) // if there is interval
                radioButton8.setText("Select the interval"); // cleaning radio button of interval


            correctAnswer.setText("" + correctCount); // showing correct for both jframes
            wrongAnswer.setText("" + wrongCount); // showing correct for new jframes

            input.setText(""); // clearing input after user pressed stop button  	
            shownLabel.setText("Question will be shown :"); // clearing label after user pressed stop button  

            gameOver.setVisible(true); //showing gameover frame

        }
    }
    public static void main(String[] args) {
        MathQuiz frame = new MathQuiz();
        frame.pack();
        frame.setTitle("Math Quiz");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}