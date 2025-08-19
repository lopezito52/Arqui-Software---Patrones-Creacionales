package com.balitechy.spacewar.models.vector;

import com.balitechy.spacewar.models.interfaces.IBackground;
import java.awt.Graphics;
import java.awt.Color;

public class VectorBackground implements IBackground {
    @Override
    public void render(Graphics g) {
        // Fondo negro con estrellas (ejemplo vectorial)
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 10000, 10000); // Tamaño grande para cubrir toda el área
        
        // Dibujar estrellas
        g.setColor(Color.WHITE);
        for (int i = 0; i < 100; i++) {
            int x = (int)(Math.random() * 1000);
            int y = (int)(Math.random() * 1000);
            g.fillRect(x, y, 2, 2);
        }
    }
}