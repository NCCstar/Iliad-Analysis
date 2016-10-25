import java.util.Map;
import java.util.TreeMap;
import java.util.Set;
public class Analysis
{
   public static void main(String[] arg)
   {
      Book book = new Book("EntireIliad.txt");
      String[] putThese = {"rage","anger"};
      Map<Integer,String> words = new TreeMap();
      for(String i:putThese)
      {
         words.putAll(book.searchFor(i));
      }
      Set<Integer> keys = words.keySet();
      for(int i:keys)
      {
         System.out.println(i+":"+words.get(i));
      }
   }
}