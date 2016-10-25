import java.io.File;
import java.util.Scanner;
import java.util.Map;
public class Book
{
   private String fullText;
   public Book(String address)
   {
    /*
   	 try
     {
       StringBuilder build = new StringBuilder();
       Scanner scan = new Scanner(address);
       while(scan.hasNextLine())
       {
         build.append(scan.nextLine()+"\n");
         fullText = build.toString();
       }
     }
    catch(Exception e)
    {
     	e.printStackTrace(); 
    }
    //*/
      fullText = "abcdefgfhhfjdksjfiioifjusydff jfhuduf";
   }
   public void searchFor(String goal,Map toFill)
   {
         
   }
}