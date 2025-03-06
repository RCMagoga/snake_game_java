
package components;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class Panel extends JPanel implements Runnable{
    
    Thread loop_controller;
    
    public Panel(){
        init();
    }
    
    private void init(){
        loop_controller = new Thread(this);
        loop_controller.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
    }

    @Override
    public void run() {
        
        double drawInterval = 1000000000 / 60;
        double nextDrawTime = System.nanoTime() + drawInterval;
        
        boolean isLooping = true;
        
        while(isLooping){
            
            double remainingTime = nextDrawTime - System.nanoTime();
            remainingTime = remainingTime / 1000000;
            if(remainingTime < 0) remainingTime = 0;
            
            nextDrawTime += drawInterval;
            
            try {
                loop_controller.sleep((long)remainingTime);
            } catch (Exception e) {
                System.out.println("Erro in loop_controller");
            }
        }
    }
    
}
