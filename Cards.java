import javax.swing.*;
import java.awt.*;

public class Cards
{
   private int num;
   private String type;
   private ImageIcon icon;
   private boolean selected;
   
   public Cards(int n, String t, ImageIcon i)
   {
      num = n;
      type = t;
      icon = i;
      selected = false;
   }
   public int getNum()
   {      return num;
   }
   public String getType()
   {
      return type;
   }
   public ImageIcon getIcon(int w, int h)
   { 
      Image img = icon.getImage().getScaledInstance(w, h, java.awt.Image.SCALE_SMOOTH);
      return new ImageIcon(img);
   }
   public ImageIcon getIcon() {
      return icon; 
   }
   
   public boolean getSelected()
   {
      return selected;
   }
   
   public boolean setSelected(boolean s)
   {
      selected = s;
      return selected;
   }
}

