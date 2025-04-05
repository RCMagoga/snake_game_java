
package game;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class SnakePanel extends JPanel{
    
    int snakePanelWidth = 640;
    int snakePanelHeight = 640;
    int x = 0;
    
    public SnakePanel(){
        setBounds(20, 120, snakePanelWidth + 1, snakePanelHeight + 1);
        setBackground(Color.black);
    }
    
    public void update(double dt){
        
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.green);
        g2.setStroke(new BasicStroke(5));
        g2.drawRect(0, 0, snakePanelWidth, snakePanelHeight);
    }
    
    public void keyPressed(){
        
    }
    
}
