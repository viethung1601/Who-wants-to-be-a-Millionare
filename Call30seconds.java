import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.Timer;

public class Call30seconds extends JFrame implements ActionListener {
    JTextField telefon;
    JButton callButton;
    int timer = 30;
    Timer swingTimer;
    JLabel timerLabel;
    
    Call30seconds() {
        // Set up the JFrame
        setTitle("30-Second Call");
        setSize(800, 400);
        setLayout(null); // Using absolute positioning
        
       //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); all windows are closed, so it may be doesn't suitable for my program
       setLocationRelativeTo(null) ; // Center the frame

        // Label
        JLabel whosCalling = new JLabel("Ban muon goi cho ai?");
        whosCalling.setBounds(310, 100, 300, 20);
        whosCalling.setFont(new Font("Mongolian Baiti", Font.BOLD, 18));
        add(whosCalling);

        // Text Field
        telefon = new JTextField();
        telefon.setBounds(250, 150, 300, 25);
        telefon.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        add(telefon);

        // Button to simulate calling
        callButton = new JButton("Goi");
        callButton.setBounds(350, 200, 100, 30);
        callButton.addActionListener(this);
        add(callButton);
        
        timerLabel = new JLabel("Thoi gian con lai: 30 giay");
        timerLabel.setFont(new Font("Arial", Font.BOLD, 18));
        timerLabel.setForeground(Color.RED);
        timerLabel.setBounds(290,250,300,30);
        add(timerLabel);

        swingTimer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (timer > 0) {
                    timer--;
                    timerLabel.setText("Thoi gian con lai: " + timer + " giay");
                } else {
                	timerLabel.setText("Het thoi gian");
                	swingTimer.stop();
                	dispose();
                	System.out.println("Het 30 giay!");
                }
            }
        });


        // Make JFrame visible
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == callButton) {
            String phoneNumber = telefon.getText();
            if(phoneNumber.equals("")) JOptionPane.showMessageDialog(callButton, "Please give us a name!");
            else {
            System.out.println("Dang goi " + phoneNumber + " trong 30 giay...");
            swingTimer.start();
            callButton.setEnabled(false);
            }
        }
    }
    public static void main(String[] args) {
        new Call30seconds();
    }
}
