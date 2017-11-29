import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JTable;
import java.util.*;

public class GUI {

	private JFrame frame;
	private JTextField textField = new JTextField(20);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 678, 621);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Operating System Simulator");
		
		
		
		
		
		
//		frmTerminal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frmTerminal.getContentPane().setLayout(null);
//		frmTerminal.setTitle("Terminal");
//		frmTerminal.setBounds(100, 100, 678, 621);
		
		
		
		JButton btnTerminal = new JButton("Terminal");
		btnTerminal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				Terminal terminal = new Terminal();
				terminal.setVisible(true);
			}
		});
		btnTerminal.setBounds(25, 84, 148, 158);
		frame.getContentPane().add(btnTerminal);
//		frmTerminal.getContentPane().add(textField);
		
		
		
		
		JButton btnScheduling = new JButton("Scheduling");
		btnScheduling.setBounds(25, 273, 148, 168);
		frame.getContentPane().add(btnScheduling);
	}
}