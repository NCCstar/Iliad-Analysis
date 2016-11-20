import java.io.FileReader;
import java.util.Scanner;
import java.util.Map;
import java.util.TreeMap;
public class Book
{
   private String fullText;
   private int length;
   public Book(String address)
   {
      try
      {
         StringBuilder build = new StringBuilder();
         Scanner scan = new Scanner(new FileReader(address));
         while(scan.hasNextLine())
         {
            String inLine = scan.nextLine().toLowerCase();
            length+=inLine.length();
            build.append(inLine+"\n");
         }
         fullText = build.toString();
      }
      catch(Exception e)
      {
         e.printStackTrace(); 
      }
   }
   public int getLength()
   {
      return length;
   }
   public int[] getBookMarks()
   {
      int[] ans = new int[24];
      StringBuilder buffer = new StringBuilder(fullText);
      int loc = buffer.indexOf("book");
      int i=0;
      while(loc!=-1)
      {
         if(i==0)
            ans[i] = loc;
         else
            ans[i] = ans[i-1]+loc;
         i++;
         buffer.delete(0,loc+4);
         loc = buffer.indexOf("book");
      }
      return ans;
   }
   public Map<Integer,String> searchFor(String goal)
   {
      Map<Integer,String> toFill = new TreeMap();
      StringBuilder buffer = new StringBuilder(fullText);
      int loc = buffer.indexOf(goal);
      int soFar = 0;
      while(loc!=-1)
      {
         toFill.put(loc+soFar,buffer.substring(loc,loc+goal.length()));
         soFar+=loc;
         buffer.delete(0,loc+1);
         loc = buffer.indexOf(goal);
      }
      return toFill;
   }
}