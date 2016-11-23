import java.util.*;
import java.awt.event.*;
import javax.swing.*;
public class Analysis
{
   public static Book book;
   public static Visual visual;
   public static void main(String[] arg)
   {
      book = new Book("EntireIliad.txt");
      Set<String> putThese = getSet();
      Map<Integer,String> words = new HashMap();
      for(String i:putThese)
      {
         words.putAll(book.searchFor(i));
      }
      JFrame frame = new JFrame("(A)ppend | (R)eset | (N)ext Term");
      frame.setSize(600,500);
      visual = new Visual(book.getLength(),words,book.getBookMarks(),book);
      frame.setContentPane(visual);
      frame.setVisible(true);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.addKeyListener(new MyListener());
   }
   public static Set<String> getSet()
   {
      Set<String> ans = new TreeSet();
      String input = "";
      while(true)
      {
         String add = "";
         if(!ans.isEmpty())
         {
            for(String i:ans)
               add+=i+", ";
            add = add.substring(0,add.length()-2);
         }
         input = JOptionPane.showInputDialog(null,"What word/phrase to search for?\nSo far: "+add,"Input",JOptionPane.QUESTION_MESSAGE);
         if(input==null||input.equals(""))
            break;
         ans.add(input);
      }
      return ans;
   }
   public static class MyListener implements KeyListener 
   {
      public void keyTyped(KeyEvent e)
      {}   
      public void keyPressed(KeyEvent e)
      {
         visual.keyTyped(e);
      }
      public void keyReleased(KeyEvent e)
      {}
   }
}