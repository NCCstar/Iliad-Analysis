import java.util.*;
import javax.swing.*;
public class Analysis
{
   public static void main(String[] arg)
   {
      Book book = new Book("EntireIliad.txt");
      String[] putThese = {"blood","guts"};
      Map<Integer,String> words = new TreeMap();
      for(String i:putThese)
      {
         words.putAll(book.searchFor(i));
      }
      Set<Integer> keys = words.keySet();
      for(int i:keys)
      {
         //System.out.println(i+":"+words.get(i));
      }
      JFrame frame = new JFrame("Chart");
      frame.setSize(500,500);
      Visual visual = new Visual(book.getLength(),words);
      frame.setContentPane(visual);
   }
}