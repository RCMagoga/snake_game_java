
package components;

import control.GameKeyListener;
import javax.swing.JFrame;
import utils.Contants;

public class Frame extends JFrame{
    
    Panel panel = new Panel();
    
    public Frame(Panel panel){
        this.panel = panel;
        init();
        add(panel);
        addKeyListener(new GameKeyListener(panel));
    }
    
    private void init(){
        setTitle("Snake Game");
        setSize(Contants.GAME_WITDH, Contants.GAME_HEIGHT);
        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
}
