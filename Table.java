import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;

public class Table extends JFrame {

	private JPanel contentPane;
	private Terminal terminal;
	CPU cpu = new CPU();
	Scheduler sch = new Scheduler();
	int xx, yy;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Table frame = new Table();
					frame.setTitle("Table");
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
	

	public Table() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		System.out.println(xx + " " + yy);
		
		
		
		//headers for the table
        String[] columns = new String[] {
            "Name", "State", "Time", "IO", "Memory used", "Time"
        };
         
        //actual data for the table in a 2d array
        Object[][] rowData = new Object[][] {
            {1, "numPrograms: ", 40.0, false, 0, 0 },
            {2, "Rambo", 70.0, false, 0, 0 },
            {3, "Zorro", 60.0, true, 0, 0 },
        };
        //create table with data
        JTable table = new JTable(rowData, columns);
        //add the table to the frame
        this.add(new JScrollPane(table));
         
      
        this.pack();
        this.setVisible(true);
	}
	

	
	

}
