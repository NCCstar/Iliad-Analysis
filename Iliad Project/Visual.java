import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class Visual extends JPanel
{
   private final int LENGTH;
   private Map<Integer,String> map;
   private HashMap<Integer,String> archive;
   private String[] setArray;
   private int setIndex;
   private Book book;
   private int[] bookMarks;
   public Visual(int length,Map<Integer,String> map,int[] bkMrks,Book book)
   {
      LENGTH=length;
      this.book=book;
      this.map = map;
      archive = new HashMap(map);
      this.bookMarks = bkMrks;
      Set<String> tempVals = new TreeSet(map.values());
      setArray = new String[tempVals.size()];
      int i = 0;
      for(String ele:tempVals)
      {
         setArray[i++]=ele;
      }
      setIndex = -1;
   }
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g);
      Set<Integer> allNums = map.keySet();
      int max=0;
      if(getWidth()>10)
      {
         int[] data = new int[getWidth()-18];
         int divX = LENGTH/(data.length);// char per slot
         g.setFont(new Font("Arial",Font.PLAIN,10));
         for(int i=0;i<bookMarks.length;i++)
         {
            g.setColor(Color.red);
            g.fillRect(bookMarks[i]/divX+9,10,1,getHeight()-19);
            g.setColor(Color.black);
            g.drawString(i+1+"",bookMarks[i]/divX+10,8);
         }
         g.setColor(Color.black);
         for(int i:allNums)
         {
            int index=0;;
            try
            {
               index = i/divX;
               data[index]++;
               if(data[index]>max)
               {
                  max = data[index];
               } 
            }
            catch(ArrayIndexOutOfBoundsException e)
            {
               System.out.println(index+", "+i);
            }        
         }
         System.out.println("------------");
         if(max>0)
         {
            final int RELATE = (getHeight()-10)/max;
            for(int x=0;x<data.length;x++)
            {
               for(int y=10;y<data[x]*RELATE;y++)
               {
                  g.fillRect(x+10,getHeight()-y,1,1);
               }
            }
         }
         else
         {
            g.drawString("No instances found",11,21);
         }
         for(int i=9;i<getWidth()-9;i++)
         {
            g.fillRect(i,9,1,1);
            g.fillRect(i,getHeight()-9,1,1);
         }
         for(int i=9;i<getHeight()-9;i++)
         {
            g.fillRect(9,i,1,1);
            g.fillRect(getWidth()-9,i,1,1);
         }
         g.setColor(Color.blue);
         String searched = "";
         for(String i:new TreeSet<String>(map.values()))
         {
            searched+=i+", ";
         }
         g.drawString(searched,10,getHeight()-1);
      }
   }
   public void keyTyped(KeyEvent e)
   {
      int keyCode = e.getKeyCode();
      switch(e.getKeyCode())
      {
         case KeyEvent.VK_R:
            Set<String> putThese = Analysis.getSet();
            Map<Integer,String> words = new HashMap();
            for(String i:putThese)
            {
               words.putAll(Analysis.book.searchFor(i));
            }
            map = words;
            archive = new HashMap(map);
            Set<String> tempVals = new TreeSet(map.values());
            setArray = new String[tempVals.size()];
            int i = 0;
            for(String ele:tempVals)
            {
               setArray[i++]=ele;
            }
            setIndex = -1;
            repaint();
            break;
         case KeyEvent.VK_N:
            setIndex+=2;
            setIndex%=setArray.length+1;
            setIndex--;
            map.clear();
            map.putAll(archive);
            if(setIndex>-1)
            {
               Iterator<Integer> iter = map.keySet().iterator();
               while(iter.hasNext())
               {
                  Integer in = iter.next();
                  if(!map.get(in).equals(setArray[setIndex]))
                  {
                     iter.remove();
                  }
               }        
            }
            repaint();
            break;
         case KeyEvent.VK_A:
            String input = JOptionPane.showInputDialog(null,"What word/phrase to append to current search?","Input",JOptionPane.QUESTION_MESSAGE);
            map.put(book.searchFor(input));
            break;
         default:
            break;
      }
   }
}
