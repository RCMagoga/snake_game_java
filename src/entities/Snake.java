package entities;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

public class Snake {

    int size;
    int x = 0;
    int y = 0;
    int vel = 8;
    String dir = "right";
    String nextDir = "";

    public Snake(int size) {
        this.size = size;
    }

    public void update(double dt) {
        snakeMove();
    }

    public void draw(Graphics2D g2) {
        g2.setColor(Color.green);
        g2.fillRect(x, y, size, size);
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_D && dir != "left") {
            nextDir = "right";
        } else if (e.getKeyCode() == KeyEvent.VK_A && dir != "right") {
            nextDir = "left";
        } else if (e.getKeyCode() == KeyEvent.VK_W && dir != "down") {
            nextDir = "up";
        } else if (e.getKeyCode() == KeyEvent.VK_S && dir != "up") {
            nextDir = "down";
        }
    }

    public void snakeMove() {
        switch (dir) {
            case "right":
                x += vel;
                break;
            case "left":
                x -= vel;
                break;
            case "down":
                y += vel;
                break;
            case "up":
                y -= vel;
                break;
        }
        if (x % size == 0 && nextDir != "" && y % size == 0) {
            dir = nextDir;
            nextDir = "";
        }
    }

}
