
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


import javax.swing.*;
public class Quiz extends JFrame implements ActionListener {
	
	String questions[][] = new String[10][5];
	String answers[][] = new String[10][2];
	String userAnswers[][] = new String[10][1];
	JLabel qno, question, nameLabel ;
	JButton next, submit, fifty, prof, random;
	JRadioButton opt1, opt2, opt3, opt4;

	public static int count = 0;
	public static int bestRecord = 0;
	int temp = 0;
	List <JRadioButton> incorrectOptions;
	ButtonGroup groupOptions;
	String name;
	Quiz(String name){
		setName(name);
		setBounds(50,0,1440,850);
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(getClass().getResource("altp.jpeg"));
		JLabel image = new JLabel(i1);
		image.setBounds(0, 0, 1440, 390);
		add(image);
		
		nameLabel = new JLabel("Good luck, Bro " + 	name + "!!!");
		nameLabel.setBounds(20,0,400,200);
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN,18));
		nameLabel.setForeground(Color.red);
		add(nameLabel);
		
		qno = new JLabel("1");
		qno.setBounds(170,350,50,35);
		qno.setFont(new Font("Tahoma", Font.PLAIN,24));
		add(qno);
		
		question = new JLabel("Test Question");
		question.setBounds(190,350,400,35);
		question.setFont(new Font("Tahoma", Font.PLAIN,24));
		add(question);
		
		questions[0][0] = "Who won Stage 1 VLR Parcific?";
		questions[0][1] = "PRX";
		questions[0][2] = "RRQ";
		questions[0][3] = "GEN G";
		questions[0][4] = "DRX";
		
		questions[1][0] = "CHAT GPT co tu nam nao?";
		questions[1][1] = "2021";
		questions[1][2] = "2022";
		questions[1][3] = "2020";
		questions[1][4] = "2019";
		
		questions[2][0] = "Dai Duong to nhat the gioi?";
		questions[2][1] = "Thai Binh Duong";
		questions[2][2] = "Dai Tay Duong";
		questions[2][3] = "Bac Bang Duong";
		questions[2][4] = "An Do Duong";
		
		questions[3][0] = "Ai da thang VDV Hung tai tu ket ABC Open 2025?";
		questions[3][1] = "Along";
		questions[3][2] = "ALok";
		questions[3][3] = "APT";
		questions[3][4] = "APAC";
		
		questions[4][0] = "Tong so tran thang cua 2 vdv tai giai abc 2025?";
		questions[4][1] = "4";
		questions[4][2] = "3";
		questions[4][3] = "2";
		questions[4][4] = "0";
		
		questions[5][0] = "So tien thuong cua giai la bao nhieu?";
		questions[5][1] = "30";
		questions[5][2] = "20";
		questions[5][3] = "40";
		questions[5][4] = "35";
		
		questions[6][0] = "loi bai hat cua nhom nhac nao: Ruby-chan?\r\n"
				+ "Hai!\r\n"
				+ "Nani ga suki?\r\n"
				+ "Chokominto yori mo a-na-ta\r\n";
		questions[6][1] = "IceScream";
		questions[6][2] = "AiScream";
		questions[6][3] = "Aicream";
		questions[6][4] = "Eiscream";
		
		questions[7][0] = "AseanRiver mo co so 2 o dau?";
		questions[7][1] = "Hanauer Landstr. 30";
		questions[7][2] = "Hanauer Landstr. 32";
		questions[7][3] = "Hanauer Landstr. 31";
		questions[7][4] = "Hanauer Landstr. 35";
		
		questions[8][0] = "abc?";
		questions[8][1] = "a";
		questions[8][2] = "b";
		questions[8][3] = "c";
		questions[8][4] = "d";
		
		questions[9][0] = "hac?";
		questions[9][1] = "e";
		questions[9][2] = "f";
		questions[9][3] = "g";
		questions[9][4] = "h";
		
		answers[0][1] = "RRQ";
		answers[1][1] = "2019";
		answers[2][1] = "Thai Binh Duong";
		answers[3][1] = "ALok";
		answers[4][1] = "3";
		answers[5][1] = "30";
		answers[6][1] = "AiScream";
		answers[7][1] = "Hanauer Landstr. 35";
		answers[8][1] = "a";
		answers[9][1] = "g";
		
		opt1 = new JRadioButton("Option 1");
		opt1.setBounds(170,520,700,30);
		opt1.setBackground(Color.white);
		opt1.setFont(new Font("Dialog",Font.PLAIN,20));
		add(opt1);
	
		opt2 = new JRadioButton("Option 2");
		opt2.setBounds(170,560,700,30);
		opt2.setBackground(Color.white);
		opt2.setFont(new Font("Dialog",Font.PLAIN,20));
		add(opt2);
		
		opt3 = new JRadioButton("Option 3");
		opt3.setBounds(170,600,700,30);
		opt3.setBackground(Color.white);
		opt3.setFont(new Font("Dialog",Font.PLAIN,20));
		add(opt3);
		
		opt4 = new JRadioButton("Option 4");
		opt4.setBounds(170,640,700,30);
		opt4.setBackground(Color.white);
		opt4.setFont(new Font("Dialog",Font.PLAIN,20));
		add(opt4);
		
		groupOptions = new ButtonGroup();
		groupOptions.add(opt1);
		groupOptions.add(opt2);
		groupOptions.add(opt3);
		groupOptions.add(opt4);
		
		/*
		next = new JButton("Next");
		next.setBounds(1100,550,200,40);
		next.setFont(new Font("Tahoma",Font.BOLD,22));
		next.setForeground(Color.white);
		next.setBackground(Color.black);
		next.addActionListener((ActionListener)this);
		next.setEnabled(false);
		add(next);
		*/
		
		submit = new JButton("Submit");
		submit.setBounds(1100,630,200,40);
		submit.setFont(new Font("Tahoma",Font.BOLD,22));
		submit.setForeground(Color.white);
		submit.setBackground(Color.black);
		submit.setEnabled(true);
		submit.addActionListener(this);
		add(submit);
	
		fifty = new JButton("50/50");
		fifty.setBounds(950,450,100,40);
		fifty.setFont(new Font("Tahoma",Font.BOLD,12));
		fifty.setForeground(Color.white);
		fifty.setBackground(Color.black);
		fifty.addActionListener(this);
		add(fifty);
		
		prof = new JButton("Profs.");
		prof.setBounds(1070,450,100,40);
		prof.setFont(new Font("Tahoma",Font.BOLD,12));
		prof.setForeground(Color.white);
		prof.setBackground(Color.black);
		prof.addActionListener(this);
		add(prof);
		
		random = new JButton("Random");
		random.setBounds(1190,450,100,40);
		random.setFont(new Font("Tahoma",Font.BOLD,12));
		random.setForeground(Color.white);
		random.setBackground(Color.black);
		random.addActionListener(this);
		add(random);
		

		
		start(count);
		setVisible(true);
	
		}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == next) {
			if(groupOptions.getSelection() == null) {
				userAnswers[count][0] = "";
			} else {
				userAnswers[count][0] = groupOptions.getSelection().getActionCommand();
			}
			System.out.println(count);
			if(count == answers.length-1) {
				next.setEnabled(false);
			}	
			start(count);
			count++;
			
		
			if(!opt1.isEnabled()) {
				opt1.setEnabled(true);
			} if(!opt2.isEnabled()) {
				opt2.setEnabled(true);
			} if(!opt3.isEnabled()) {
				opt3.setEnabled(true);
			}  if(!opt4.isEnabled()) {
				opt4.setEnabled(true);
				
			}
			
			
			
			
			
		} else if(ae.getSource() == submit) {
			String selectedAnswer = null;
			if(opt1.isSelected()) selectedAnswer = opt1.getText();
			else if (opt2.isSelected()) selectedAnswer = opt2.getText();
			else if (opt3.isSelected()) selectedAnswer = opt3.getText();
			else if (opt4.isSelected()) selectedAnswer = opt4.getText();
			if(selectedAnswer == null) {
				JOptionPane.showMessageDialog(this, "Please select an answer.");
			} else if(selectedAnswer.equals(answers[count][1])) {
				JOptionPane.showMessageDialog(this, "Xin Chuc Mung, Ban da Tra loi Dung!");
				count++;
				if(count > answers.length-1) {
					JOptionPane.showMessageDialog(this, "Well done, you have completed this game!!!");
					setVisible(false);
					count = 0;
				} else {
					start(count);
				}
				
			} else {
				JOptionPane.showMessageDialog(this,"Ban tra loi sai, dap an la " + answers[count][1] + ". Ban da dung lai o cau so "+ count);
				bestRecord = count;
				count = 0;
				setVisible(false);
				new Login();
			}
			
			
			
		
		} else if(ae.getSource() == fifty) {
			String correctAnswer = answers[count][1];
			JRadioButton[] options = {opt1,opt2,opt3,opt4};
			List <JRadioButton> incorrectOptions = new ArrayList<>();
			for(JRadioButton opt : options) {
				if(!opt.getText().equals(correctAnswer)) {
					incorrectOptions.add(opt);
				}
			}
			
			Collections.shuffle(incorrectOptions);
			incorrectOptions.get(0).setEnabled(false);
			incorrectOptions.get(1).setEnabled(false);
			fifty.setEnabled(false);
	
		} else if (ae.getSource() == prof) {
			 new professor();
			 prof.setEnabled(false);
		} else if(ae.getSource() == random) {
			new Call30seconds();
			random.setEnabled(false);
		}
	}
	/*public void paint(Graphics g) {
		super.paint(g);
		
		String time = "Time left " + timer + " seconds";
		g.setColor(Color.RED);
		
		if(timer > 0) {
			g.drawString(time,1100,400);
		} else {
			g.drawString("no time more",1100,400);
		}
		timer--;
		
		try {
			Thread.sleep(1000);
			repaint();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		if(ans_given == 1) {
			ans_given = 0;
			timer = 15;
		} else if(timer < 0) {
			timer = 15;
			
			if(groupOptions.getSelection() == null) {
				userAnswers[count][0] = "";
			} else {
				userAnswers[count][0] = groupOptions.getSelection().getActionCommand();
			}
			count++;
			start(count);
		}
	}
	*/
	public void start(int count) {
		qno.setText(" " + count + ". ");
		question.setText("  " + questions[count][0]);
		
		opt1.setText(questions[count][1]);
		opt1.setActionCommand(questions[count][1]);
		
		opt2.setText(questions[count][2]);
		opt2.setActionCommand(questions[count][2]);

		opt3.setText(questions[count][3]);
		opt3.setActionCommand(questions[count][3]);
		
		opt4.setText(questions[count][4]);
		opt4.setActionCommand(questions[count][4]);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Quiz("");
		
	}

}
