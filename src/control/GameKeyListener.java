
package control;

import components.Panel;
import game.MainGame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameKeyListener implements KeyListener{
    
    MainGame game;
    
    public GameKeyListener(Panel panel) {
        this.game = panel.getGame();
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        game.keyPressed();
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        game.keyPressed();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        game.keyPressed();
        
    }
    
}
