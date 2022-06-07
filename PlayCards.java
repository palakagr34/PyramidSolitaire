import java.util.ArrayList;
import javax.swing.*;
import java.net.URL; 

public class PlayCards 
{
   private ArrayList<Cards> stock;
   private ArrayList<Cards> waste;
   private ArrayList<Cards> foundation;
   private Cards[][] pyramid;      

   public PlayCards()
   {
      // making the original deck
      stock = new ArrayList<Cards>(52);
      for(int i=1; i<=4; i++)
      {
         String symbol;
         if(i==1)
             symbol = "club";
         else if(i==2)
             symbol = "diamond";
         else if(i==3)
             symbol = "heart";
         else 
             symbol = "spade";

         for(int j=1; j<=13; j++)
         {
            URL urlToImg = this.getClass().getResource("/pics/" + symbol + j + ".JPG"); 
            ImageIcon temp = new ImageIcon(urlToImg);
            stock.add(new Cards(j, symbol, temp));                        
         }
      }
      
      waste = new ArrayList<Cards>();
      foundation = new ArrayList<Cards>();
      pyramid = new Cards[7][7];
      
      shuffle();
      addToPyramid();
   }

   public Cards getCard(int r, int c)
   {
      return pyramid[r-1][c-1];
   }
   
   public Cards getCardFromWaste()
   {
      return waste.get(waste.size()-1);
   }
   
   public int getWasteSize()
   {
      return waste.size();
   }
   
   // other methods: public play (starts the program), shuffle, dealToPyramid, 
   private void shuffle()
   {
     int n = stock.size();
     while(n>1)
     {
       int m = (int)(Math.random() * stock.size());
       Cards temp = stock.get(m);
       stock.set(m, stock.get(n-1));
       stock.set((n-1), temp);
       n--;
     }
   }

   
   private void addToPyramid()
   {
      
      for(int r=0; r<7; r++)
      {
         for(int c=0; c<=r; c++)
         {
            pyramid[r][c] = stock.remove(0);
            pyramid[r][c].setSelected(true);
            
         }
      }
   }
   
   public int addToWaste()
   {
      if(stock.size()==0)
      {
         for(int i=0; i<waste.size(); i++)
         {
            stock.add(waste.remove(waste.size()-1));
         }
         return 0;
      }
      else if(stock.size()==1)
      {
         waste.add(stock.remove(stock.size()-1));
         return 1;
      }
      else
      {
         waste.add(stock.remove(stock.size()-1));
         return 2;
      }
   }
   
   
   public boolean checkCardAvailability(int r, int c)
   {
      if(r==7)
         return true;
      boolean first = pyramid[r][c-1].getSelected();
      boolean second = pyramid[r][c].getSelected();
      if(!first && !second)
         return true;
      return false;

   }
   
   public void removeWaste ()
   {
      waste.remove(waste.size()-1);
   }
  
}
