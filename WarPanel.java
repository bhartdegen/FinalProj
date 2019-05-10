import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class WarPanel extends JPanel {

	private ArrayList<Cards> Deck1 = new ArrayList<>(56);
	private ArrayList<Cards> Deck2 = new ArrayList<>(56);
	private ArrayList<Cards> warDeck = new ArrayList<>(9);	

	private int temp;
	private int play = 1;
	private String roundWinner;
	private boolean winner = false;
	/**
	 * Create the panel.
	 */
	public WarPanel() {
		initializeUI();
	}
	
	private void initializeUI() {
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(500, 300));
		
		JLabel label1 = new JLabel();
		label1.setBounds(159, 11, 100, 32);
		this.add(label1);
		
		
		JTextArea textArea = new JTextArea();
		String text = "War results.... ";
		textArea.setText(text);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		
		JScrollPane pane = new JScrollPane(textArea);
		pane.setPreferredSize(new Dimension(500, 400));
		pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		JButton btnPlayButton = new JButton("~PLAY~");
		btnPlayButton.setBounds(5, 233, 424, 23);
		btnPlayButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//label1.setText(displayContent());
				String contents = textArea.getText();

		
			}
		});
		this.add(pane, BorderLayout.CENTER);
		this.add(btnPlayButton, BorderLayout.SOUTH);
	}

	public static void warFrame() {
		JPanel panel = new WarPanel();
		panel.setOpaque(true);
		
		JFrame frame = new JFrame("Final Project");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);
        
	}
	
	public String displayContent() {
		 while (!winner) { 
			 System.out.printf("%20s %15d %20s %15d ", Deck1.get(0) , Deck1.size() , Deck2.get(0) ,Deck2.size());
			 for (int i = 0; i < warDeck.size(); i++ ) {
				 int x = 1;
				 if (x == 1) {
					 Deck1.add(Deck2.get(i));
					 Deck1.add(Deck1.get(i));
					 Deck1.remove(i);
					 Deck2.remove(i);
					 roundWinner = "Player 1 wins!";
					 return roundWinner;
				 }
				 if (x == 2) {
					 Deck2.add(Deck1.get(i));
					 Deck2.add(Deck2.get(i));
					 Deck2.remove(Deck2.get(i));
					 Deck1.remove(i);
					 roundWinner = "player 2 Wins!";
					 return roundWinner;
				 }
				 if (x == 3) {
					 roundWinner = "*****WAR******";
					 return roundWinner;
				 }
			 }
			 winner = false;
		 }
		 return "no";
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable( ) {
			public void run() {
				WarPanel.warFrame();

			}
		});
	}
}
