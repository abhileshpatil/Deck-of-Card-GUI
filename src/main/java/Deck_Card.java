import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class Deck_Card {

	static ArrayList <CardDeck>deck;
	static ArrayList card3;
	
	public Deck_Card() throws IOException
	{
		String []suit={"clubs","Spades","heart","Diamond"};
		String []face={"Ace","2","3","4","5","6","7","8","9","10","Jack","Queen","King"};
		
		deck=new ArrayList();
		
	
	BufferedImage allCard= ImageIO.read(new File("deckofcard.png"));
	BufferedImage temp;
		int width=71;
		int height=95;

		for(int i=0;i<4;i++)
		{ 
			for(int j=0;j<13;j++)
			{
				temp=allCard.getSubimage(((j*width)+(j*2)),
						(i*height)+(i*4),
						width,
						height);
				deck.add(new CardDeck(suit[i],face[j],temp));
				
				
			}
		}
	}
	
	public List<CardDeck> shuffle(List<CardDeck> deck)
	{   
		Collections.shuffle(deck);
		return deck;
		
	}
	public List<CardDeck> dealOnecard(int m,ArrayList deck)
	{   
		int z=0;
		card3=new ArrayList();
		while(z<m)
		{
		shuffle(deck);
		card3.add(deck.get(deck.size()-1));                     
		deck.remove(deck.size()-1);
		z++;
		}
		return deck;
	}
	public void display(int m,List<CardDeck>card3)
	{
		int l=0;
		for(int z=0;z<m;z++)
		{
		System.out.println(""+(card3.get(l).getfacename())+" of "+(((CardDeck) card3.get(l)).getsuit()));
		l++;
		}
	}
	public static void main(String []args) throws IOException
	{   
		Deck_Card cd=new Deck_Card();
		int track=0;
		Scanner scan= new Scanner(System.in);
    	int i=0;
    	while(i<52)
    	{
    	System.out.println("Enter the number of cards to be drawn Randomly");
    	int m=scan.nextInt();
    	if(m==0)
    	{
    		System.out.println("Enter a valid input");
    	}
    	track=track+m;
    	if(track<=52)
    	{
         cd.dealOnecard(m, deck);
         cd.display(m,card3);
    	}
    	else
    	{
    		System.out.println("Does not have number of cards in the deck you are trying to withdraw.");
    		break;
    	}
    	
    	
		
		JFrame window=new JFrame("cards withdrawn by the caller");
		window.setSize(400,600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel=new JPanel();
		for(int y=0;y<m;y++)
		{
		JLabel label=new JLabel(new ImageIcon(((CardDeck) card3.get(y)).getCardImage()));
		label.setSize(400,500);
		panel.add(label);
		window.add(panel);
		window.setVisible(true);
		}		
    	}
		
	}

}
