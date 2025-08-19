package com.balitechy.spacewar.models.sprite;

import com.balitechy.spacewar.models.interfaces.IBackground;
import com.balitechy.spacewar.main.Game;
import com.balitechy.spacewar.utils.SpritesImageLoader;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class SpriteBackground implements IBackground {
    private BufferedImage backgroundImage;
    private Game game;

    public SpriteBackground(Game game) {
        this.game = game;
        try {
            SpritesImageLoader loader = new SpritesImageLoader("/bg.png");
            loader.loadImage();
            this.backgroundImage = loader.getImage(0, 0, 640, 480);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void render(Graphics g) {
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, game.getWidth(), game.getHeight(), null);
        }
    }
}