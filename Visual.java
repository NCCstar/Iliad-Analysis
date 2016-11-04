import javax.swing.*;
import java.awt.*;
import java.util.*;
public class Visual extends JPanel
{
   private final int LENGTH;
   private Map<Integer,String> map;
   private int[] bookMarks;
   public Visual(int length,Map<Integer,String> map,int[] bkMrks)
   {
      LENGTH=length;
      this.map = map;
      this.bookMarks = bkMrks;
   }
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g);
      Set<Integer> allNums = map.keySet();
      int max=0;
      if(getWidth()>10)
      {
         int[] data = new int[getWidth()-20];
         int divX = LENGTH/data.length;// char per slot
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
            try{
            int index = i/divX-1;
            data[index]++;
            if(data[index]>max)
            {
               max = data[index];
            }
            }
            catch(Exception e)
            {
               Math.random();
            }
         }
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
      }
   }
}