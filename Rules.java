import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

public class Rules extends JFrame implements ActionListener{

	JButton back;
	String name;
	Rules(String name){
		this.name = name;
		getContentPane().setBackground(new Color(49,62,181));
		setLayout(null);
		
		JLabel heading = new JLabel("Hello Bro " + name + " den voi Ai La Trieu Phu");
		heading.setBounds(50,20,700,30);//x-Co, y-Co, width,height
		heading.setFont(new Font("Mongolian Baiti",Font.BOLD,28));
		heading.setForeground(Color.WHITE);
		//heading.setForeground(new Color(30,144,254));
		add(heading);
		
		JLabel rules = new JLabel();
		rules.setBounds(20,90,700,350);//x-Co, y-Co, width,height
		rules.setFont(new Font("Mongolian Baiti",Font.BOLD,16));
		rules.setText(
			"<html>" + 
					"1. Tra loi tat ca 15 cau hoi" + "<br><br>" +
					"2. Se co 3 su tro giup (Vi cau hoi de vcl): 50/50, hoi chuyen gia va danh lo" + "<br><br>" +
					"3. Moi cau hoi tra loi bao lau cung duoc" + "<br><br>" +
					"<p>Chuc Bro " + name + " thuong lo binh an!" + "</p>" +
			"</html>"
		);
		rules.setForeground(Color.WHITE);
		add(rules);
		
		back = new JButton("Back");
		back.setBounds(330,400,120,50);
		back.setBackground(Color.DARK_GRAY);
		back.setForeground(Color.WHITE);
		back.addActionListener(this);
		add(back);
		
		setSize(800,500);
		setLocation(300,150);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == back) {
			setVisible(false);
			new Login();
		} else {
			setVisible(false);
		}
	}
	public static void main(String[]args) {
		new Rules("unknown -_-");
	}
}
