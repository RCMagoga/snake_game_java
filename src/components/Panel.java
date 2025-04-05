
package components;

import game.MainGame;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class Panel extends JPanel implements Runnable{
    
    private Thread loop_controller;
    private MainGame game;
    
    public Panel(){
        init();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        draw(g2);
    }
    
    // Responsável pelo loop do jogo
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
            
            update(remainingTime);
            repaint();
            
            try {
                loop_controller.sleep((long)remainingTime);
            } catch (Exception e) {
                System.out.println("Erro in loop_controller");
            }
        }
    }    
    
    // Responsável por inicializar os objetos
    private void init(){
        game = new MainGame();
        setLayout(null);
        setBackground(Color.black);
        addComponentList();
        loop_controller = new Thread(this);
        loop_controller.start();
    }
    
    // Responsável por atualizar as variáveis
    public void update(double dt){
        game.update(dt);
    }
    
    // Responsável por redesenhar    
    public void draw(Graphics2D g2){
        game.draw(g2);
    }
    
    public void addComponentList(){
        for (Component c : game.addComponentsInPanel()) {
            add(c);
        }
    }
    
    public MainGame getGame(){
        return this.game;
    }
    
}
