import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class professor extends JFrame implements ActionListener {
	String advices[][] = new String[10][2];
	JButton prof1, prof2, back;
	JLabel advice, guide;
	professor(){
		
		advices[0][0] = "As i remember, RRQ has won the final against Gen G 3-1";
		advices[0][1] = "PRX is my answer";
		
		advices[1][0] = "I think chat GPT was established during COVID-19, 2021 is my answer ";
		advices[1][1] = "I have used ChatGPT since 2022, so 2022 is my advice";
		
		advices[2][0] = "Thai Binh Duong";
		advices[2][1] = "Thai Binh Duong";
		
		advices[3][0] = "An Indian Man, ALok, 42 years old";
		advices[3][1] = "Along definitely because i was there";
	
		advices[4][0] = "Hello";
		advices[4][1] = "Halli";
	
		advices[5][0] = "Hung won 3, ADuc won 0 => 3 won total";
		advices[5][1] = "sorry no info -_-";
		
		advices[6][0] = "Icecream? or Aiscream? i choose Aiscream";
		advices[6][1] = "Eiscream!!!";
		
		advices[7][0] = "I live near of this asia foodstore, Hanauer Landstr.30";
		advices[7][1] = "sorry no info -_-";
	
		advices[8][0] = "don't understand question, no advice";
		advices[8][1] = "same as prof.1, question too dumb";
	
		advices[9][0] ="don't understand question, no advice";
		advices[9][1] = "same as prof.1, question too dumb";
	
		
		setBounds(50,0,1440,850);
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		advice = new JLabel();
		advice.setBounds(810,100,400,100);
		advice.setFont(new Font("Mongolian Baiti",Font.BOLD,18));
		add(advice);
		
		guide = new JLabel();
		guide.setBounds(100,400,1300,400);
		guide.setFont(new Font("Mongolian Baiti",Font.BOLD,18));
		add(guide);
		
		JLabel heading = new JLabel("Choose your favorite Professor!");
		heading.setBounds(45,30,700,30);
		heading.setFont(new Font("Tahoma", Font.PLAIN,26));
		add(heading);
		
		prof1 = new JButton("Prof. 1");
		prof1.setBounds(140,140,200,100);
		prof1.setBackground(Color.DARK_GRAY);
		prof1.setForeground(Color.WHITE);
		prof1.setFont(new Font("Tahoma", Font.PLAIN,26));
		prof1.addActionListener(this);
		add(prof1);
		
		prof2 = new JButton("Prof. 2 ");
		prof2.setBounds(450,140,200,100);
		prof2.setBackground(Color.DARK_GRAY);
		prof2.setForeground(Color.WHITE);
		prof2.setFont(new Font("Tahoma", Font.PLAIN,26));
		prof2.addActionListener(this);
		add(prof2);
		/*
		back = new JButton("Back to Quiz");
		back.setBounds(800,700,200,100);
		back.setBackground(Color.DARK_GRAY);
		back.setForeground(Color.WHITE);
		back.setFont(new Font("Tahoma", Font.PLAIN,26));
		back.addActionListener(this);
		add(back);
		*/
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == prof1) {
			advice.setText(advices[Quiz.count][0]);
			prof1.setEnabled(false);
			prof2.setEnabled(false);
		} else if(ae.getSource() == prof2){
			advice.setText(advices[Quiz.count][1]);
			prof1.setEnabled(false);
			prof2.setEnabled(false);
		}
		/*
		if(ae.getSource() == back) {
			new Quiz(Quiz.count);
		}
		*/
		guide.setText("Your chance to get help from our professors has gone down! You have to close professor's tab and continue answering the current question! Thank Yiu");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new professor();
	}

}
