import java.io.FileReader;
import java.util.Scanner;
import java.util.Map;
import java.util.TreeMap;
public class Book
{
   private String fullText;
   public Book(String address)
   {
      try
      {
         StringBuilder build = new StringBuilder();
         Scanner scan = new Scanner(new FileReader(address));
         while(scan.hasNextLine())
         {
            build.append(scan.nextLine().toLowerCase()+"\n");
         }
         fullText = build.toString();
      }
      catch(Exception e)
      {
         e.printStackTrace(); 
      }
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