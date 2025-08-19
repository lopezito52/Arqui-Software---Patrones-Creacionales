package com.balitechy.spacewar.models.vector;

import com.balitechy.spacewar.main.Game;
import com.balitechy.spacewar.models.interfaces.IPlayer;
import java.awt.Graphics;
import java.awt.Color;

public class VectorPlayer implements IPlayer {
    private Game game;
    private int x, y;
    private int velX, velY;
    private static final int SIZE = 20;

    public VectorPlayer(Game game) {
        this.game = game;
        this.x = (Game.WIDTH * Game.SCALE - SIZE) / 2;
        this.y = Game.HEIGHT * Game.SCALE - 50;
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;
        
        // Limites de pantalla
        x = Math.max(0, Math.min(x, Game.WIDTH * Game.SCALE - SIZE));
        y = Math.max(0, Math.min(y, Game.HEIGHT * Game.SCALE - SIZE));
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(x, y, SIZE, SIZE);
        
        // Detalles del jugador
        g.setColor(Color.RED);
        g.drawLine(x + SIZE/2, y, x + SIZE/2, y + SIZE/2);
    }

    @Override
    public void shoot() {
        game.getBullets().addBullet(
            game.getFactory().createBullet(x + SIZE/2, y)
        );
    }

    @Override
    public void setVelX(int velX) {
        this.velX = velX;
    }

    @Override
    public void setVelY(int velY) {
        this.velY = velY;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }
}