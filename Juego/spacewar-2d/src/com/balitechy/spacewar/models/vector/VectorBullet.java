package com.balitechy.spacewar.models.vector;

import com.balitechy.spacewar.models.interfaces.IBullet;
import java.awt.Graphics;
import java.awt.Color;

public class VectorBullet implements IBullet {
    private int x, y;
    private boolean visible = true;

    public VectorBullet(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void tick() {
        y -= 7;
        if (y < 0) visible = false;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(x, y, 2, 8);
    }

    @Override
    public boolean isVisible() {
        return visible;
    }
}