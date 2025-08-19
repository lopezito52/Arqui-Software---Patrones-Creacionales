package com.balitechy.spacewar.models.interfaces;

import java.awt.Graphics;

public interface IBullet {
    void tick();
    void render(Graphics g);
    boolean isVisible();
}