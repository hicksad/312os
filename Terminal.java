import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JScrollBar;

public class Terminal extends JFrame {

	private JPanel contentPane;
	public static JTextField textField;
	public String commandLineInput;
	private  JTextArea textArea;
	public String fileName;
	FileReaders fileReader = new FileReaders();
	String file1[];
	public ArrayList<Process> programList = new ArrayList<Process>();
	JScrollPane scroll;

	
	
	Scheduler sch = new Scheduler();
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Terminal frame = new Terminal();
					frame.setTitle("Terminal");
					frame.setVisible(true);
					textField.requestFocus();
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
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(400, 150, 714, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		textField = new JTextField();
		contentPane.add(textField, BorderLayout.SOUTH);
		textField.setColumns(10);
		textArea = new JTextArea();
		scroll = new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		textArea.setEditable(false);
		contentPane.add(scroll, BorderLayout.CENTER);
		
		
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				commandLineInput = textField.getText().toLowerCase();
//				textArea.append(commandLineInput + "\n");
				textField.setText("");
				System.out.println(commandLineInput);

				if(commandLineInput.contains("proc"))            //				IF PROC IS ENTERED
				{
					textArea.append("PROC was typed" + "\n");
				}
				else if(commandLineInput.contains("mem"))        //				IF MEM IS ENTERED
				{
					textArea.append("MEM was typed" + "\n");
				}
				else if(commandLineInput.contains("load"))       //				IF LOAD IS ENTERED
				{
					if(commandLineInput.contains(" "))
					{
						
						String procName;
						int arrivalTime;
						int spc = commandLineInput.indexOf(" ");
						String command = commandLineInput.substring(0, spc).toUpperCase();
//						textArea.append("Command is " + command.toUpperCase() + "\n");
						String fileName = commandLineInput.substring(spc + 1, commandLineInput.length());
						textArea.append("LOAD " + fileName + "\n");
							try {
								file1 = FileReaders.fileToArray(fileName);
								
								for(int i = 0; i < (file1.length - 1); i++)
								{
									String space[] = new String[2];
									space = file1[i].split(" ");
									procName = space[0].toLowerCase().trim();
									arrivalTime = Integer.parseInt(space[1]);
									textArea.append("LOAD " + procName + " " + arrivalTime + "\n");
									programList.add(new Process(procName, arrivalTime));
//									textArea.append(programList.toString() + "\n");

									
									
//									System.out.println(procName);
									
									try{
								        // check and read command line argument for file name
								          
								    System.out.println("The job file name is " + fileName);
								    
									System.out.println("The program name is " + procName);
									programList.get(i).setProgram(FileReaders.fileToArray(programList.get(i).getName()));               
									programList.get(i).printProgram();
									 
									sch.addProcess(programList.get(i));
									
									

								 	}
								 	catch(FileNotFoundException noFile){
									 	System.out.println("There was an error opening or reading from the file.");
								 	}
									
								}
								
								
							} catch (FileNotFoundException e1) {
								textArea.append("File was not found" + "\n");
//								e1.printStackTrace();
							}
					}
					else
					{
						textArea.append("Nothing to load" + "\n");
					}

				}
				else if(commandLineInput.contains("exe"))         //				IF EXE IS ENTERED
				{
					textArea.append("EXE");
					sch.FCFS();
				}
				else if(commandLineInput.contains("reset"))       //				IF RESET IS ENTERED
				{
//					textArea.append("RESET was typed" + "\n");
					textArea.setText("");
					for(int clear = 0; clear < 100; clear++)
					{
						System.out.println("\n");
					}
				}
				else if(commandLineInput.contains("exit"))        //				IF EXIT IS ENTERED
				{
					System.exit(0);
				}
				else
				{
					textArea.append("INVALID INPUT" + "\n");
				}
				
				
					
			}
		});
		
		
		
	}
	


	
	public void clear()
	{
		
	}
	
	
	
	
	
}