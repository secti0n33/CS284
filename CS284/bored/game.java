package bored;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class game extends JPanel implements KeyListener
{
	@Override
	public void paint(Graphics g2)
    {
		Graphics2D g = (Graphics2D) g2;
		g.setColor(Color.RED);
		g.fillOval(0, 0, 30, 30);
		g.drawOval(0, 50, 30, 30);		
		g.fillRect(50, 0, 30, 30);
		g.drawRect(50, 50, 30, 30);

		g.draw(new Ellipse2D.Double(0, 100, 30, 30));
	}

    public void keyPressed(KeyEvent e)
    {
        int c=e.getKeyCode();
        

    }

    public void keyTyped(KeyEvent e){}

    public void keyReleased(KeyEvent e){}
	
	public static void main(String[] args)
    {
		JFrame frame = new JFrame("Ultimate Tic Tac Toe");
		frame.add(new game());
		frame.setSize(800, 800);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}