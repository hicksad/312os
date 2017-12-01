import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
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
		frame.setBounds(1000, 200, 850, 650);
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
				frame.setVisible(true);
				Terminal terminal = new Terminal();
				terminal.setTitle("Terminal");
				terminal.setVisible(true);
				Terminal.textField.requestFocus();
			}
		});
		btnTerminal.setBounds(25, 56, 148, 168);
		frame.getContentPane().add(btnTerminal);
		
		JButton btnGraph = new JButton("Graph");
		btnGraph.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(true);
				PagingGraph graph = new PagingGraph();
				graph.setTitle("Graph");
				graph.setVisible(true);
			}
		});
		btnGraph.setBounds(484, 122, 199, 113);
		frame.getContentPane().add(btnGraph);
//		frmTerminal.getContentPane().add(textField);
		
		
		
	}
}