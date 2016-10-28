import javax.swing.*;
import java.awt.*;
import java.util.*;
public class Visual extends JPanel
{
   private final int LENGTH;
   private Map<Integer,String> map;
   public Visual(int length,Map<Integer,String> map)
   {
      LENGTH=length;
      this.map = map;
   }
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g);
      int[] data = new int[getX()];
      int divX = LENGTH/getX();// char per slot
      for(int i=0;i<LENGTH;i+=divX)
      {
         
      }
   }
}