//java. => java standard library


import javax.swing.*; // Swing for creating GUI, javax.swing: package ; components: JFrame, JButton, JLabel
import java.awt.*; //import Abstract Window Toolkit(AWT) classes; basic windowing and drawing functionality
import java.awt.event.*;  // event-handling
import javax.sound.sampled.*; // playing and handling audio
import java.io.File; //Input, Output
import java.io.IOException; //import IOExceptiom class. exception type

  

public class Login extends JFrame implements ActionListener { //ActionListener ís an interface => have to override the functions in thís interface
	
	JButton rules,start;
	JTextField tfname;
	Clip clip;
	int LoginVisible = 0;
	String name;
	
	Login(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
		    public void windowClosing(WindowEvent e) {
		        if (clip != null && clip.isRunning()) {
		            clip.stop();
		            clip.close(); // optional but cleaner
		        }
		    }
		});
		setSize(1250,700);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null); //no Layout manager helps me out 
		ImageIcon i1 = new ImageIcon(getClass().getResource("ALTP_LOGO_2021.png"));
		JLabel image = new JLabel(i1);
		image.setBounds(0, 0, 600, 500);
		add(image);
		
		JLabel heading = new JLabel("Ai La Trieu Phu");
		heading.setBounds(785,60,300,45);
		heading.setFont(new Font("Mongolian Baiti",Font.BOLD,30));
		//heading.setForeground(Color.BLUE);
		//heading.setForeground(new Color(30,144,254));
		add(heading);
		
		JLabel name = new JLabel("Vi huynh dai ten gi: ");
		name.setBounds(810,150,300,20);
		name.setFont(new Font("Mongolian Baiti",Font.BOLD,18));
		//heading.setForeground(Color.BLUE);
		//heading.setForeground(new Color(30,144,254));
		add(name);
		
		JLabel bestRecordLabel = new JLabel("Best Record: " + Quiz.bestRecord);
		bestRecordLabel.setBounds(900,400,300,20);
		bestRecordLabel.setFont(new Font("Mongolian Baiti",Font.BOLD,18));
		//heading.setForeground(Color.BLUE);
		//heading.setForeground(new Color(30,144,254));
		add(bestRecordLabel);
		
		tfname = new JTextField();
		tfname.setBounds(735,200,300,25);
		tfname.setFont(new Font("Times New Roman", Font.PLAIN , 20));
		add(tfname);
		
		rules = new JButton("Rules");
		rules.setBounds(735,270,120,25);
		rules.setBackground(Color.DARK_GRAY);
		rules.setForeground(Color.WHITE);
		rules.addActionListener(this);
		add(rules);
		
		start = new JButton("Start");
		start.setBounds(915,270,120,25);
		start.setBackground(Color.DARK_GRAY);
		start.setForeground(Color.WHITE);
		start.addActionListener(this);
		add(start);
		
		//setLocation(200,200);
		setVisible(true);
		if(isVisible()) {
			playBackgroundMusic("ALTP.wav");
		} else {
			if(clip.isRunning()) {
			clip.stop();
			}
		}
	}
	public void playBackgroundMusic(String filepath) {
		try {
			AudioInputStream bgmusic = AudioSystem.getAudioInputStream(new File(filepath));
			clip = AudioSystem.getClip();
			clip.open(bgmusic);
			clip.loop(Clip.LOOP_CONTINUOUSLY);
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			e.printStackTrace();
		}
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == rules) {
			name = tfname.getText();
			setVisible(false);
			stopMusic();
			new Rules(name);
		} else if (ae.getSource () == start) {
			name = tfname.getText();
			setVisible(false);
			stopMusic();
			new Quiz(name);
		}
	}
	public void stopMusic() {
	
	    if (clip != null && clip.isRunning()) {
	        clip.stop();
	        clip.close();
	    }
	

	}
	public static void main(String[]args) {
		
		new Login();
		
	}
}
