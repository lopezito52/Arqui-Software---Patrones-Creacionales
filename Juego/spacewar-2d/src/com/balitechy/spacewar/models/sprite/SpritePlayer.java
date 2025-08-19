package com.balitechy.spacewar.models.sprite;

import com.balitechy.spacewar.main.Game;
import com.balitechy.spacewar.models.interfaces.IPlayer;
import java.awt.Graphics;

public class SpritePlayer implements IPlayer {
    private Game game;
    private int x, y;
    private int velX, velY;
    public static final int WIDTH = 32;
    public static final int HEIGHT = 32;

    public SpritePlayer(Game game) {
        this.game = game;
        this.x = (Game.WIDTH * Game.SCALE - WIDTH) / 2;
        this.y = Game.HEIGHT * Game.SCALE - 50;
    }

    @Override
    public void tick() {
        // Lógica de movimiento
        x += velX;
        y += velY;
        
        // Limites de pantalla
        x = Math.max(0, Math.min(x, Game.WIDTH * Game.SCALE - WIDTH));
        y = Math.max(0, Math.min(y, Game.HEIGHT * Game.SCALE - HEIGHT));
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(
            game.getSprites().getImage(0, 0, WIDTH, HEIGHT),
            x, y, WIDTH, HEIGHT, 
            null
        );
    }

    @Override
    public void shoot() {
        game.getBullets().addBullet(
            game.getFactory().createBullet(x + WIDTH/2, y)
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