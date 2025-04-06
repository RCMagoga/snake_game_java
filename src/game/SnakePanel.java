
package game;

import entities.Snake;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;

public class SnakePanel extends JPanel{
    
    Snake snake;
    
    int snakePanelWidth, snakePanelHeight;
    int xPosition = 20;
    int yPosition = 120;
    int snakeSize = 32;
    
    boolean grid = false;
    
    public SnakePanel(int snakePanelWidth, int snakePanelHeight){
        this.snakePanelWidth = snakePanelWidth;
        this.snakePanelHeight = snakePanelHeight;
        setBounds(xPosition, yPosition, snakePanelWidth, snakePanelHeight);
        setBackground(Color.black);
        snake = new Snake(snakeSize);
    }
    
    public void update(double dt){
        snake.update(dt);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        drawBounds(g2);
        snake.draw(g2);
        if (grid) {
            drawGrid(g2);
        }
    }
    
    public void keyPressed(KeyEvent e){
        if (e.getKeyCode() == KeyEvent.VK_F1) {
            grid = !grid;
            return;
        }
        snake.keyPressed(e);
    }
    
    public void drawBounds(Graphics2D g2){
        g2.setColor(Color.green);
        g2.setStroke(new BasicStroke(5));
        g2.drawRect(0, 0, snakePanelWidth, snakePanelHeight);
    }
    
    public void drawGrid(Graphics2D g2){
        g2.setColor(Color.red);
        g2.setStroke(new BasicStroke(1));
        for (int i = 1; i < snakePanelWidth / snakeSize; i++) {
            int x = i * snakeSize;
            g2.drawLine(x, 0, x, snakePanelHeight);
        }
        for (int i = 1; i < snakePanelHeight / snakeSize; i++) {
            int y = i * snakeSize;
            g2.drawLine(0, y, snakePanelWidth, y);
        }
    }
    
}
