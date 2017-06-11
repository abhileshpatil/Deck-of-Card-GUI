import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class CardDeck {
	
	String facename;
	String suit;
	BufferedImage cardImage;
	
	public CardDeck(String suit, String facename,BufferedImage card)
	{
		this.suit=suit;
		this.facename=facename;
		cardImage=card;
	}
	
	public String getfacename()
	{
		return facename;
	}
	
	public String getsuit()
	{
		return this.suit;
	}
	public BufferedImage getCardImage()
	{
		return cardImage;
	}
	
}
