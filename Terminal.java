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
					textField.requestFocus();
					frame.setTitle("Terminal");
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

		
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				commandLineInput = textField.getText().toLowerCase();
				textArea.append(commandLineInput + "\n");
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
//					textArea.append("LOAD was typed" + "\n");
					if(commandLineInput.contains(" "))
					{
//						textArea.append("Has a space" + "\n");
						
						String procName;
						int allocMem;
						int spc = commandLineInput.indexOf(" ");
						String command = commandLineInput.substring(0, spc);
						textArea.append("Command is " + command.toUpperCase() + "\n");
						String fileName = commandLineInput.substring(spc + 1, commandLineInput.length());
						textArea.append("The file name is " + fileName + "\n");
							try {
								file1 = FileReaders.fileToArray(fileName);
								
								for(int i = 0; i < (file1.length - 1); i++)
								{
									String space[] = new String[2];
									space = file1[i].split(" ");
									procName = space[0];
									allocMem = Integer.parseInt(space[1]);
									textArea.append("The process name is " + procName + "\n");
									textArea.append("The memory requirement is " + allocMem + "\n");
									programList.add(new Process(procName, allocMem));
//									textArea.append(programList.toString() + "\n");

									
									
//									System.out.println(procName);
									
									try{
								        // check and read command line argument for file name
								          
//								    System.out.println("The file name is " + fileName);
								    
								    // verify file and create file Scanner
									System.out.println(procName);
//								    Scanner fileReader = openFile(procName);
//									 programArray = FileReaders.fileToArray(procName);
//									 programArray = FileReaders.fileToArray(programList.get(i).getName());
									 programList.get(i).setProgram(FileReaders.fileToArray(programList.get(i).getName()));               
									 programList.get(i).printProgram();
									 
									 
									 
//									 LOOP TO PRINT PROCESS	 
//									 for(int j = 0; j < programArray.length; j++)
//									 {
//										 System.out.println(programArray[j]);
//									 }
									 
									 
//									 System.out.println(programArray.length);

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
					textArea.append("EXE was typed" + "\n");
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