package com.balitechy.spacewar.models.sprite;

import com.balitechy.spacewar.models.interfaces.IBullet;
import java.awt.Graphics;
import java.awt.Color;
public class SpriteBullet implements IBullet {
    private int x, y;
    private boolean visible = true;

    public SpriteBullet(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void tick() {
        y -= 7; // Velocidad de movimiento
        if (y < 0) visible = false;
    }

    @Override
    public void render(Graphics g) {
        // Implementación con sprite
        g.setColor(Color.RED);
        g.fillRect(x, y, 3, 10);
    }

    @Override
    public boolean isVisible() {
        return visible;
    }
}