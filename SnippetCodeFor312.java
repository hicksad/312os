import java.util.*;

public class SnippetCodeFor312{
 
 public static void main (String[] args) {
   String[][] test= new String [32][128];
   memoryDisplay(test);
 }
   
 public static String memoryDisplay (String[][] currentMem) {
 //String [][] Mem= new String [32][128];
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
    System.out.print(result); 
     }
  return result;
 }
}