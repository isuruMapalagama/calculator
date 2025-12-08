import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.border.LineBorder;




public class Calculator {
    int boardWidth = 360;
    int boardHeight = 540;

    Color CustomBeige = new Color(250, 243, 225);
    Color CustomLightGold = new Color(245, 231, 198);
    Color CustomOrange = new Color(255, 109, 31);
    Color CustomBlack = new Color(34, 34, 34);


    String[] buttonValues ={
        "AC", "+/-", "%", "÷",
        "7", "8", "9", "×",
        "4", "5", "6", "-",
        "1", "2", "3", "+",
        "0", ".", "√", "=",
    };
    String[] rightSymbols = {"÷", "×", "-", "+", "="};
    String[] topSymbols = {"AC", "+/-", "%"};


    JFrame frame = new JFrame("Calculator");
    JLabel displayLabel = new JLabel();
    JPanel displayPanel = new JPanel();
    JPanel buttonsPanel = new JPanel();

    String A = "0";
    String oprator = null;
    String B = null;

    Calculator(){
        frame.setVisible(true);
        frame.setSize(boardWidth,boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
 
        displayLabel.setBackground(CustomBlack);
        displayLabel.setForeground(Color.white);
        displayLabel.setFont(new Font("Arial",Font.PLAIN, 80));
        displayLabel.setHorizontalAlignment(JLabel.RIGHT);
        displayLabel.setText("0");
        displayLabel.setOpaque(true);

        displayPanel.setLayout(new BorderLayout());
        displayPanel.add(displayLabel);
        frame.add(displayPanel, BorderLayout.NORTH);

        buttonsPanel.setLayout(new GridLayout(5,4));
        buttonsPanel.setBackground(CustomLightGold);
        frame.add(buttonsPanel);

        for (int i =0; i<buttonValues.length; i++){
            JButton button = new JButton();
            String buttonValue = buttonValues[i];
            button.setFont(new Font("Arial", Font.PLAIN, 30));
            button.setText(buttonValue);
            button.setFocusable(false);
            button.setBorder(new LineBorder(CustomLightGold));
            if(Arrays.asList(topSymbols).contains(buttonValue)){
                button.setBackground(CustomBeige);
                button.setForeground(Color.BLACK);
            }
            else if(Arrays.asList(rightSymbols).contains(buttonValue)){
                button.setBackground(CustomOrange);
                button.setForeground(Color.white);
            }
            else{
                button.setBackground(CustomLightGold);
                button.setForeground(Color.BLACK);
            }
            buttonsPanel.add(button);

           
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    JButton button = (JButton) e.getSource();
                    String buttonValue = button.getText();
                    if (Arrays.asList(rightSymbols).contains(buttonValue)){

                    }
                    else if (Arrays.asList(topSymbols).contains(buttonValue)) {
                        if (buttonValue == "AC"){
                            clearAll();
                            displayLabel.setText("0");
                        }

                    }
                    else {
                        if (buttonValue == ".") {
                            if (!displayLabel.getText().contains(buttonValue)){
                                displayLabel.setText(displayLabel.getText() + buttonValue);
                            }
                        }
                        else if("0123456789".contains(buttonValue)){
                            if (displayLabel.getText()=="0") {
                                displayLabel.setText(buttonValue);
                            }
                            else{
                                displayLabel.setText(displayLabel.getText() + buttonValue );
                            }
                        }
                    }
                }
            });

        }

        }

        void clearAll(){
            A="0";
            oprator = null;
            B = null;
    }

    
}
