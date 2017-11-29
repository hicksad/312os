import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

public class Terminal extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	public String commandLineInput;
	private  JTextArea textArea;
	public String fileName;
	JScrollPane scroll = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Terminal frame = new Terminal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Terminal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		textField = new JTextField();
		
		
		
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				commandLineInput = textField.getText().toLowerCase();
				textArea.append(commandLineInput + "\n");
				textField.setText("");
				System.out.println(commandLineInput);

				
				
				
				switch(commandLineInput)
				{
//				If PROC is typed
				case "proc":
//					HANDLE PROC CODE HERE
					break;
					
//				If MEM is typed
				case "mem":
//					HANDLE MEM CODE HERE
					break;

//				If LOAD is typed
				case "load":
//					HANDLE LOAD CODE HERE
					break;
					
//				If EXE is typed
				case "exe":
//					HANDLE EXE CODE HERE
					break;
					
//				If RESET is typed	
				case "reset":
//					HANDLE RESET CODE HERE
					break;
					
//				If EXIT is typed	
				case "exit":
//					HANDLE EXIT CODE HERE
					break;
					
				default:
					textArea.append("INVALID INPUT" + "\n");
					break;
				}
				
			}
		});
		contentPane.add(textField, BorderLayout.SOUTH);
		textField.setColumns(10);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		contentPane.add(textArea, BorderLayout.CENTER);
		
		
		
		
		
		
	}
	
	

	
	
	
	
	
}