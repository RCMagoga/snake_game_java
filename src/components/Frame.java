
package components;

import javax.swing.JFrame;

public class Frame extends JFrame {
    
    public Frame(){
        init();
    }
    
    private void init(){
        setTitle("Snake Game");
        setSize(800, 800);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
}
