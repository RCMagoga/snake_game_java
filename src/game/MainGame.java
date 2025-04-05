
package game;

import java.awt.Component;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class MainGame {
    
    ArrayList<Component> componentsList;
    SnakePanel snakePanel;
        
    public MainGame(){
        componentsList = new ArrayList<>();
        snakePanel = new SnakePanel();
        componentsList.add(snakePanel);
    }
    
    public void update(double dt){
        snakePanel.update(dt);
    }
    
    public void draw(Graphics2D g2){
        snakePanel.repaint();
    }
    
    public ArrayList<Component> addComponentsInPanel(){
        return componentsList;
    }
    
    public void keyPressed(){
        snakePanel.keyPressed();
    }
    
}
