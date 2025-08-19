package com.balitechy.spacewar.models.interfaces;

import java.awt.Graphics;

public interface IPlayer {
    void tick();
    void render(Graphics g);
    void shoot();
    void setVelX(int x);
    void setVelY(int y);
    int getX();
    int getY();
}