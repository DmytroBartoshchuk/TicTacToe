package com.ak.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DmytroBartoshchuk on 16.03.2017.
 *
 */

public class MainFrame extends JFrame implements ActionListener{

    private enum PLAYER{X, O}
    private List<JButton> buttons;
    private Container container;
    private int counter;

    public MainFrame(String title) {
        super(title);
        buttons = new ArrayList<JButton>();
        container = getContentPane();
        for(int i = 1; i<=9; i++){
            JButton b = new JButton("");
            b.addActionListener(this);
            buttons.add(b);
            container.add(b);
        }

        setLayout(new GridLayout(3,3));
        setMinimumSize(new Dimension(340,300));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        counter=0;

    }

    private boolean checkWinner(PLAYER player){
        String p = player.name();
        buttons.get(1).getText();

        for(int i = 0; i<3; i++){

            if(buttons.get(i).getText().equals(p) && buttons.get(i+3).getText().equals(p) && buttons.get(i+6).getText().equals(p))
                return true;
            if(buttons.get(i*3).getText().equals(p) && buttons.get(i*3+1).getText().equals(p) && buttons.get(i*3+2).getText().equals(p))
                return true;
        }
        if(buttons.get(0).getText().equals(p) && buttons.get(4).getText().equals(p) && buttons.get(8).getText().equals(p))
            return true;
        if(buttons.get(2).getText().equals(p) && buttons.get(4).getText().equals(p) && buttons.get(6).getText().equals(p))
            return true;

        return false;
    }

    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();

        if(counter%2 == 0){
            button.setText("X");
            button.setBackground(Color.GREEN);
        }
        else {
            button.setText("O");
            button.setBackground(Color.orange);

        }
        counter++;

        button.setEnabled(false);

        if(checkWinner(PLAYER.X)){
            JOptionPane.showMessageDialog(this, "Player X won");
            System.exit(0);
        } else if(checkWinner(PLAYER.O)) {
            JOptionPane.showMessageDialog(this, "Player O won");
            System.exit(0);
        }

        if(counter==9){
            JOptionPane.showMessageDialog(this, "Draw");
            System.exit(0);}
    }
}
