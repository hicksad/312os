import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;

public class PagingGraph extends JFrame {

	private JPanel contentPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PagingGraph frame = new PagingGraph();
					frame.setTitle("Graph");
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
	public PagingGraph() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(1500, 100, 1645, 990);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTextArea textArea = new JTextArea();
		Font font = new Font(Font.MONOSPACED, Font.PLAIN, 20);
        textArea.setFont(font);
		textArea.setEditable(false);
		contentPane.add(textArea, BorderLayout.CENTER);
		textArea.setMargin(new Insets(20,25,10,10));
		
		String[][] test= new String [32][128];
//		memoryDisplay(test);
		
		for(int i = 0; i <test.length; i++)
		{
			textArea.append(memoryDisplay(test));
		}
		
		
		
		
		
	}
	
	
	
	 public static  String memoryDisplay (String[][] currentMem) {
		 //String [][] Mem= new String [32][
		 int i,j=1;
		 String temp ="";
		 String result="";
		 
		  for( int row=0;row< currentMem.length;row++)
		  {
		    for (int column=0;column< currentMem[row].length; column++)
		   {
		  currentMem[row][column]= null;
		   }
		  }
		 
		  for(i=0;i<currentMem.length;i++) { 
		        for(j=0;j<currentMem[i].length;j++) {
		          if (currentMem[i][j]==null){
		             temp = temp + "x";
		          }
		          if(currentMem[i][j]!= null ){
		            temp= temp + "o";
		          }
		            }
		    result = temp.format("%.128s\n",temp);
//		    System.out.print(result); 
		     }
		  return result;
		 }
	 


}
