import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JScrollBar;

public class Terminal extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	public String commandLineInput;
	private  JTextArea textArea;
	public String fileName;
	FileReaders fileReader = new FileReaders();
	String file1[];
	ArrayList<Process> programList = new ArrayList<Process>();
	
	
	
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

				
				if(commandLineInput.contains("proc"))
				{
					textArea.append("PROC was typed" + "\n");
				}
				else if(commandLineInput.contains("mem"))
				{
					textArea.append("MEM was typed" + "\n");
				}
				else if(commandLineInput.contains("load"))
				{
//					textArea.append("LOAD was typed" + "\n");
					if(commandLineInput.contains(" "))
					{
//						textArea.append("Has a space" + "\n");
						String procName;
						int allocMem;
						int spc = commandLineInput.indexOf(" ");
						String command = commandLineInput.substring(0, spc);
						textArea.append("Command is " + command + "\n");
						String fileName = commandLineInput.substring(spc + 1, commandLineInput.length());
						textArea.append("The file name is " + fileName + "\n");
							try {
								file1 = FileReaders.fileToArray(fileName);
								
								for(int i = 0; i < (file1.length - 1); i++)
								{
//									textArea.append(file1[i] + "\n");
									String space[] = new String[2];
									space = file1[i].split(" ");
									procName = space[0];
									allocMem = Integer.parseInt(space[1]);
									textArea.append("The process name is " + procName + "\n");
									textArea.append("The memory requirement is " + allocMem + "\n");
									programList.add(new Process(procName, allocMem));
									textArea.append(programList.toString() + "\n");
//									programList.get(i).printProgram();
								}
							} catch (FileNotFoundException e1) {
								textArea.append("File was not found" + "\n");
//								e1.printStackTrace();
							}
							
							
//						textArea.append(Arrays.toString(file1));
						
					}
					else
					{
						textArea.append("Nothing to load" + "\n");
					}
				}
				else if(commandLineInput.contains("exe"))
				{
					textArea.append("EXE was typed" + "\n");
				}
				else if(commandLineInput.contains("reset"))
				{
					textArea.append("RESET was typed" + "\n");
				}
				else if(commandLineInput.contains("exit"))
				{
					System.exit(0);
				}
				else
				{
					textArea.append("INVALID INPUT" + "\n");
				}
				
				
				
				
				
			}
		});
		contentPane.add(textField, BorderLayout.SOUTH);
		textField.setColumns(10);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		contentPane.add(textArea, BorderLayout.CENTER);
		
		
		
		
		
		
	}
	
	
	public void clear()
	{
		
	}
	
	
	
	
	
}