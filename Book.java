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
   public Map<Integer,String> searchFor(String goal)
   {
      Map<Integer,String> toFill = new TreeMap();
      StringBuilder buffer = new StringBuilder(fullText);
      int loc = buffer.indexOf(goal);
      while(loc!=-1)
      {
         toFill.put(loc,buffer.substring(loc,loc+goal.length()));
         buffer.delete(0,loc+1);
         loc = buffer.indexOf(goal);
      }
      return toFill;
   }
}