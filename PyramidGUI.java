import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.net.URL; 

public class PyramidGUI implements ActionListener
{
   // Add all components of GUI that are being used
     // Frame, Panels, buttons (for each of the cards(?) & undo), howTo button that opens up dialogBox / JInternalFrame
   private JFrame frame;
   private JPanel movesPanel, pyramidPanel, stacksPanel, mainPanel, pyramid1, pyramid2, pyramid3, pyramid4, pyramid5, pyramid6, pyramid7;
   private JButton stockButton, wasteButton, foundationButton, rulesButton;
   private JButton b1_1, b2_1, b2_2, b3_1, b3_2, b3_3, b4_1, b4_2, b4_3, b4_4, b5_1, b5_2, b5_3, b5_4, b5_5, b6_1, b6_2, b6_3, b6_4, b6_5, b6_6, b7_1, b7_2, b7_3, b7_4, b7_5, b7_6, b7_7;
   private JTextArea movesCounter;
   private int totalMoves;
   private JLayeredPane layeredPane, layeredStacksPane;
   private PlayCards game;
   private int screenWidth, screenHeight; 
   
   /* Panels:
          - frame has boxLayout with 3 stacked panels
          - top panel has flowLayout / borderLayout of rules (pop up box) and moves counter (JLabel / JTextArea)
          - second panel has pyramid of buttons as cards
          - 3rd panel has flowLayout of 3 buttons (stock, waste, undo) and picture(?) of foundation
   */
   
   // comment
   
   // constructor: create and set up entire frame
   public PyramidGUI()
   {      
      // creates a PlayCards object
      game = new PlayCards();
      
      
      // set up frame
      frame = new JFrame("Pyramid Solitaire");
      
      Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
      screenWidth = (int)size.getWidth();
      screenHeight = (int)size.getHeight();
      System.out.println("width: " + screenWidth + "  height: " + screenHeight); 
      
      
      frame.setSize(screenWidth,screenHeight);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      // set up main panel
      mainPanel = new JPanel();
      mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));
      frame.add(mainPanel);
      
      // set up moves panel
      movesPanel = new JPanel();
      movesPanel.setLayout(new FlowLayout());
      
      rulesButton = new JButton("Rules");
      movesPanel.add(rulesButton);
      rulesButton.addActionListener(this);
      rulesButton.setActionCommand("Rules");
      
      totalMoves = 0;      
      movesCounter = new JTextArea("Moves: " + totalMoves);
      movesPanel.add(movesCounter);
      movesPanel.setBackground(Color.orange);
      
      movesPanel.setPreferredSize( new Dimension( screenWidth, (int)(screenHeight/(-4.5))) );
      mainPanel.add(movesPanel);
      
      // sets up pyramid panel                                                         // color: red, orange, yellow, green, blue, purple, pink
      pyramidPanel = new JPanel();
      pyramidPanel.setBackground(Color.red);
      pyramidPanel.setPreferredSize(new Dimension(screenWidth, (int)(screenHeight*.45)));
   //   pyramidPanel.add(rulesButton);
   //   pyramidPanel.add(movesCounter);
      mainPanel.add(pyramidPanel);
      
      layeredPane = new JLayeredPane();
      layeredPane.setBorder(BorderFactory.createTitledBorder("Pyramid"));
    
      layeredPane.setPreferredSize(new Dimension((int)(screenWidth * .9375), (int)(screenHeight * .7)));
      
      //Initializing buttons 
      int width = (int)(screenWidth / 16); 
      int height = (int)(screenHeight / 7.5); 
      
      Image img; 
      //img = game.getCard(1,1).getIcon().getImage().getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH); 
      b1_1 = new JButton(game.getCard(1,1).getIcon(width, height));
      b1_1.addActionListener(this);
      b1_1.setActionCommand("1_1");
      
      b2_1 = new JButton(game.getCard(2,1).getIcon(width, height));
      b2_1.addActionListener(this);
      b2_1.setActionCommand("2_1");
      
      b2_2 = new JButton(game.getCard(2,2).getIcon(width, height));
      b2_2.addActionListener(this);
      b2_2.setActionCommand("2_2");
      
      b3_1 = new JButton(game.getCard(3,1).getIcon(width, height));
      b3_1.addActionListener(this);
      b3_1.setActionCommand("3_1");
      
      b3_2 = new JButton(game.getCard(3,2).getIcon(width, height));
      b3_2.addActionListener(this);
      b3_2.setActionCommand("3_2");
      
      b3_3 = new JButton(game.getCard(3,3).getIcon(width, height));
      b3_3.addActionListener(this);
      b3_3.setActionCommand("3_3");
      
      b4_1 = new JButton(game.getCard(4,1).getIcon(width, height));
      b4_1.addActionListener(this);
      b4_1.setActionCommand("4_1");
      
      b4_2 = new JButton(game.getCard(4,2).getIcon(width, height));
      b4_2.addActionListener(this);
      b4_2.setActionCommand("4_2");
      
      b4_3 = new JButton(game.getCard(4,3).getIcon(width, height));
      b4_3.addActionListener(this);
      b4_3.setActionCommand("4_3");
      
      b4_4 = new JButton(game.getCard(4,4).getIcon(width, height));
      b4_4.addActionListener(this);
      b4_4.setActionCommand("4_4");
      
      b5_1 = new JButton(game.getCard(5,1).getIcon(width, height));
      b5_1.addActionListener(this);
      b5_1.setActionCommand("5_1");
      
      b5_2 = new JButton(game.getCard(5,2).getIcon(width, height));
      b5_2.addActionListener(this);
      b5_2.setActionCommand("5_2");
      
      b5_3 = new JButton(game.getCard(5,3).getIcon(width, height));
      b5_3.addActionListener(this);
      b5_3.setActionCommand("5_3");
      
      b5_4 = new JButton(game.getCard(5,4).getIcon(width, height));
      b5_4.addActionListener(this);
      b5_4.setActionCommand("5_4");
      
      b5_5 = new JButton(game.getCard(5,5).getIcon(width, height));
      b5_5.addActionListener(this);
      b5_5.setActionCommand("5_5");
      
      b6_1 = new JButton(game.getCard(6,1).getIcon(width, height));
      b6_1.addActionListener(this);
      b6_1.setActionCommand("6_1");
      
      b6_2 = new JButton(game.getCard(6,2).getIcon(width, height));
      b6_2.addActionListener(this);
      b6_2.setActionCommand("6_2");
      
      b6_3 = new JButton(game.getCard(6,3).getIcon(width, height));
      b6_3.addActionListener(this);
      b6_3.setActionCommand("6_3");
      
      b6_4 = new JButton(game.getCard(6,4).getIcon(width, height));
      b6_4.addActionListener(this);
      b6_4.setActionCommand("6_4");
      
      b6_5 = new JButton(game.getCard(6,5).getIcon(width, height));
      b6_5.addActionListener(this);
      b6_5.setActionCommand("6_5");
      
      b6_6 = new JButton(game.getCard(6,6).getIcon(width, height));
      b6_6.addActionListener(this);
      b6_6.setActionCommand("6_6");
      
      b7_1 = new JButton(game.getCard(7,1).getIcon(width, height));
      b7_1.addActionListener(this);
      b7_1.setActionCommand("7_1");
      
      b7_2 = new JButton(game.getCard(7,2).getIcon(width, height));
      b7_2.addActionListener(this);
      b7_2.setActionCommand("7_2");
      
      b7_3 = new JButton(game.getCard(7,3).getIcon(width, height));
      b7_3.addActionListener(this);
      b7_3.setActionCommand("7_3");
      
      b7_4 = new JButton(game.getCard(7,4).getIcon(width, height));
      b7_4.addActionListener(this);
      b7_4.setActionCommand("7_4");
      
      b7_5 = new JButton(game.getCard(7,5).getIcon(width, height));
      b7_5.addActionListener(this);
      b7_5.setActionCommand("7_5");
      
      b7_6 = new JButton(game.getCard(7,6).getIcon(width, height));
      b7_6.addActionListener(this);
      b7_6.setActionCommand("7_6");
      
      b7_7 = new JButton(game.getCard(7,7).getIcon(width, height));
      b7_7.addActionListener(this);
      b7_7.setActionCommand("7_7");
   
            
   int mid = (int)(screenWidth * .46875) - (int)(width / 2); 
   int top = (int)(screenHeight / 45); 
   int incy = (int)(screenHeight / 11.25); 
   int incx = (int) (((screenWidth / 40) + width) / 2); 
   
      b1_1.setBounds(mid,top,width,height);
      b2_1.setBounds(mid - incx,top+incy,width,height);
      b2_2.setBounds(mid + incx,top+incy,width,height);
      b3_1.setBounds(mid - 2*incx,top+2*incy,width,height);
      b3_2.setBounds(mid,top+2*incy,width,height);
      b3_3.setBounds(mid + 2*incx,top+2*incy,width,height);
      b4_1.setBounds(mid - 3*incx,top+3*incy,width,height);
      b4_2.setBounds(mid - incx,top+3*incy,width,height);
      b4_3.setBounds(mid + incx,top+3*incy,width,height);
      b4_4.setBounds(mid + 3*incx,top+3*incy,width,height);
      b5_1.setBounds(mid - 4*incx,top+4*incy,width,height);
      b5_2.setBounds(mid - 2*incx,top+4*incy,width,height);
      b5_3.setBounds(mid,top+4*incy,width,height);
      b5_4.setBounds(mid + 2*incx,top+4*incy,width,height);
      b5_5.setBounds(mid + 4*incx,top+4*incy,width,height);
      b6_1.setBounds(mid - 5*incx,top+5*incy,width,height);
      b6_2.setBounds(mid - 3*incx,top+5*incy,width,height);
      b6_3.setBounds(mid - incx,top+5*incy,width,height);
      b6_4.setBounds(mid + incx,top+5*incy,width,height);
      b6_5.setBounds(mid + 3*incx,top+5*incy,width,height);
      b6_6.setBounds(mid + 5*incx,top+5*incy,width,height);
      b7_1.setBounds(mid - 6*incx,top+6*incy,width,height);
      b7_2.setBounds(mid - 4*incx,top+6*incy,width,height);
      b7_3.setBounds(mid - 2*incx,top+6*incy,width,height);
      b7_4.setBounds(mid,top+6*incy,width,height);
      b7_5.setBounds(mid + 2*incx,top+6*incy,width,height);
      b7_6.setBounds(mid + 4*incx,top+6*incy,width,height);
      b7_7.setBounds(mid + 6*incx,top+6*incy,width,height);
   
   
      layeredPane.add(b1_1, new Integer(0));
      layeredPane.add(b2_1, new Integer(1));
      layeredPane.add(b2_2, new Integer(2));
      layeredPane.add(b3_1, new Integer(3));
      layeredPane.add(b3_2, new Integer(4));
      layeredPane.add(b3_3, new Integer(5));
      layeredPane.add(b4_1, new Integer(6));
      layeredPane.add(b4_2, new Integer(7));
      layeredPane.add(b4_3, new Integer(8));
      layeredPane.add(b4_4, new Integer(9));
      layeredPane.add(b5_1, new Integer(10));
      layeredPane.add(b5_2, new Integer(11));
      layeredPane.add(b5_3, new Integer(12));
      layeredPane.add(b5_4, new Integer(13));
      layeredPane.add(b5_5, new Integer(14));
      layeredPane.add(b6_1, new Integer(15));
      layeredPane.add(b6_2, new Integer(16));
      layeredPane.add(b6_3, new Integer(17));
      layeredPane.add(b6_4, new Integer(18));
      layeredPane.add(b6_5, new Integer(19));
      layeredPane.add(b6_6, new Integer(20));
      layeredPane.add(b7_1, new Integer(21));
      layeredPane.add(b7_2, new Integer(22));
      layeredPane.add(b7_3, new Integer(23));
      layeredPane.add(b7_4, new Integer(24));
      layeredPane.add(b7_5, new Integer(25));
      layeredPane.add(b7_6, new Integer(26));
      layeredPane.add(b7_7, new Integer(27));

      pyramidPanel.add(layeredPane);
      
      // sets up stacks panel
      stacksPanel = new JPanel();
      stacksPanel.setPreferredSize(new Dimension(screenWidth,(int)(screenHeight/-9)));
      stacksPanel.setLayout(new FlowLayout());
      ImageIcon back = new ImageIcon("back.JPG"); 
      Image backk = back.getImage().getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
      stockButton = new JButton(new ImageIcon(backk));
      wasteButton = new JButton("Waste");
      foundationButton = new JButton("Foundation");

      layeredStacksPane = new JLayeredPane();
     // layeredStacksPane.setBorder(BorderFactory.createTitledBorder("Pyramid"));
      layeredStacksPane.setPreferredSize(new Dimension((int)(screenWidth * .75), (int)(screenHeight * .222)));
      
      stockButton.addActionListener(this);
      wasteButton.addActionListener(this);
      stockButton.setActionCommand("Stock");
      wasteButton.setActionCommand("Waste");

      
      layeredStacksPane.add(stockButton, new Integer(0));
      layeredStacksPane.add(wasteButton, new Integer(1));
      layeredStacksPane.add(foundationButton, new Integer(2));
      
      stockButton.setBounds((int)(screenWidth / 8),0,width,height);
      wasteButton.setBounds((int)(screenWidth / 4.6),0,width,height);
      foundationButton.setBounds((int)(screenWidth / 2),0,width,height);
      
      stacksPanel.add(layeredStacksPane);
      
      mainPanel.add(stacksPanel);
      stacksPanel.setBackground(Color.orange);
      frame.setVisible(true);
   }
   
   
   int tempRank;
   int counter = 0;
   JButton tempButton;
   int tempx;
   int tempy;
   
   
   // action performed method that increments moves and uses PlayCards class
   public void actionPerformed(ActionEvent evt)
   {
      int width = (int)(screenWidth / 16); 
      int height = (int)(screenHeight / 7.5);
      
      if(evt.getActionCommand().equals("Rules"))
      {
         JFrame rulesFrame = new JFrame("Rules");
         rulesFrame.setSize(620,550);
         JTextArea rules = new JTextArea(10,40);
         rulesFrame.add(rules);
         rules.setText("\nObjective: \n To get rid of all cards in the Pyramid by matching two cards whose ranks add up to 13.\n\n");
         rules.append("Game Play: \n Pyramid has 4 groups of cards.\n  - The Pyramid: made up of 28 cards in 7 rows. Each card is covered partially by two cards from the next row.");
         rules.append("\n  - The Stock: a face-down pile that is used to draw cards from and place on the Waste pile.");
         rules.append("\n  - The Waste: a face-up pile next to the Stock that can be matched to cards from the Pyramid.");
         rules.append("\n  - The Foundation: a face-down pile on which cards that have been removed from the Pyramid are placed.");
         rules.append("\nWhile matching cards in the pyramid, only cards that are completely uncovered are available. If a card is partially, it cannot be used until it is uncovered.");
         rules.append("\n\nAllowed Moves: ");
         rules.append("\n  - Use the Stock to place cards on Waste: the top card on the Waste pile can now be matched with cards from the Pyramid.");
         rules.append("\n  - Match the top card of Waste with an uncovered card in Pyramid: do this by selecting the pyramid card and the waste card whose ranks add up to 13.");
         rules.append("\n  - Match two Pyramid cards with each other: do this by simple: do this by simply selecting two cards that have ranks that add up to 13.");
         rules.append("\n  - Move a King to the Foundation: since a king ranks 13 by itself, it can simply be moved to the Foundation.");
         rules.append("\n  - Reset the Stock once it is empty: clicking on the reset button under the Stock pile will do this, but only as long as Stock is empty.");
         rules.append("\n\nWinning: \n A game is won by removing all cards from Pyramid. After winning the game once, try to ");
         rules.append("complete the game in a fewer number of moves."); 
         rules.append("\nHowever, not all games are winnable. This occurs when there is a limited number of cards uncovered and none of the cards in the stock / waste pile can help ");
         rules.append("move these cards move to foundation to uncover new cards.\n Therefore, play wisely!");
         
         //rules.setFont(//add font here
         rules.setLineWrap(true);
         rules.setWrapStyleWord(true); 
         rules.setEditable(false);
         rulesFrame.setVisible(true);
                        
      }
      else if(evt.getActionCommand().equals("Stock"))
      {
         counter = 0;
         totalMoves++;
         int num = game.addToWaste();
         if(num==1)
         {
            stockButton.setIcon(null);
            stockButton.setText("Reset");
            wasteButton.setIcon(game.getCardFromWaste().getIcon(width, height));            
         }
         if(num==0)
         {
            wasteButton.setIcon(null);
            wasteButton.setText("Waste");
            ImageIcon back = new ImageIcon("back.JPG"); 
            Image backk = back.getImage().getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
            stockButton.setIcon(new ImageIcon(backk));
            stockButton.setText(null);   
         }
         else
         {
            wasteButton.setIcon(game.getCardFromWaste().getIcon(width, height));
            wasteButton.setText(null);
         }
      }
      else if(evt.getActionCommand().equals("Waste"))
      {
         counter++;
         if(game.getCardFromWaste().getNum()==13)
         {
            totalMoves++;
            game.removeWaste();
            wasteButton.setIcon(game.getCardFromWaste().getIcon(width, height));
            counter = 0;
            ImageIcon back = new ImageIcon("back.JPG");
            Image backk = back.getImage().getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
            foundationButton.setIcon(new ImageIcon(backk));
            foundationButton.setText(null);
         }
         else if(counter==1)
         {
            tempRank = game.getCardFromWaste().getNum();
            tempButton = new JButton();
            //tempx = posx;
            //tempy = posy;
         }
         else     //counter==2
         {
            if(tempRank + game.getCardFromWaste().getNum() == 13)
            {
               totalMoves++;
               tempButton.setVisible(false);
               game.removeWaste();
               if(game.getWasteSize()==0)
                  wasteButton.setIcon(null);
               else
                  wasteButton.setIcon(game.getCardFromWaste().getIcon(width, height));
               game.getCard(tempx, tempy).setSelected(false);
               
            }
            counter = 0;
            tempRank = 0;
            tempButton = null;
            tempx = 0;
            tempy = 0;
            ImageIcon back = new ImageIcon("back.JPG"); 
            Image backk = back.getImage().getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
            foundationButton.setIcon(new ImageIcon(backk));
            foundationButton.setText(null);
         }
      }
      else if(evt.getActionCommand().indexOf("_")==1)
      {
         int posx = Integer.parseInt(evt.getActionCommand().substring(0,1));
         int posy = Integer.parseInt(evt.getActionCommand().substring(2,3));
         
         if(game.checkCardAvailability(posx, posy)){
            counter++;
         
         
            if(counter == 1 && game.getCard(posx, posy).getNum() == 13)
            {
              totalMoves++;
              ((JButton)evt.getSource()).setVisible(false);
              game.getCard(posx, posy).setSelected(false);
              counter = 0;
              ImageIcon back = new ImageIcon("back.JPG"); 
              Image backk = back.getImage().getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
              foundationButton.setIcon(new ImageIcon(backk));
              foundationButton.setText(null);
            }
            else if(counter==1)
            {
               tempRank = game.getCard(posx, posy).getNum();
               tempButton = (JButton)evt.getSource();
               tempx = posx;
               tempy = posy;
            }
            else     //counter==2
            {
               if(tempRank + game.getCard(posx, posy).getNum() == 13)
               {
                  totalMoves++;
                  tempButton.setVisible(false);
                  ((JButton)evt.getSource()).setVisible(false);
                  game.getCard(posx, posy).setSelected(false);
                  if(tempx != 0)
                     game.getCard(tempx, tempy).setSelected(false);
                  else
                  {
                     game.removeWaste();
                     if(game.getWasteSize()==0)
                        wasteButton.setIcon(null);
                     else
                        wasteButton.setIcon(game.getCardFromWaste().getIcon(width, height));
                  }
                  
               }
               counter = 0;
               tempRank = 0;
               tempButton = null;
               tempx = 0;
               tempy = 0;
               ImageIcon back = new ImageIcon("back.JPG"); 
               Image backk = back.getImage().getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
               foundationButton.setIcon(new ImageIcon(backk));
               foundationButton.setText(null);
            }
         }
         
         // checks if all cards from Pyramid have been used
         boolean check = true;
         for(int r=0; r<7; r++)
         {
            for(int c=0; c<=r; c++)
            {
               if(game.getCard(r+1,c+1).getSelected())
                  check = false;
            }
         }
         if(check)
         {
            JFrame congrats = new JFrame("Congratulations!");
            congrats.setSize(250,150);
            JTextArea message = new JTextArea();
            congrats.add(message);
            message.setText("\n                         Congratulations! \n                You have won this game.\n ");
            message.append("\nDon't forget to try again and see if you can complete the game within a fewer number of moves.");
            message.setLineWrap(true);
            message.setWrapStyleWord(true); 
            message.setEditable(false);
            congrats.setVisible(true);
         }
      }


      movesCounter.setText("Moves: " + totalMoves);
      
      // other things to add: set bounds for all 4 last panel buttons (adjust size and positioning)
   } 
   
   public static void main(String[]args)
   {
      PyramidGUI trial = new PyramidGUI();
   }  
}