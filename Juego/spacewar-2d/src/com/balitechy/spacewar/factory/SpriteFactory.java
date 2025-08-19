package com.balitechy.spacewar.factory;
import com.balitechy.spacewar.main.Game;
import com.balitechy.spacewar.models.interfaces.*;
import com.balitechy.spacewar.models.sprite.SpritePlayer;
import com.balitechy.spacewar.models.sprite.SpriteBullet;
import com.balitechy.spacewar.models.sprite.SpriteBackground;

public class SpriteFactory extends AGameFactory {
    @Override
    public IPlayer createPlayer(Game game) {
        return new SpritePlayer(game);
    }

    @Override
    public IBullet createBullet(int x, int y) {
        return new SpriteBullet(x, y);
    }

    @Override
    public IBackground createBackground(Game game) {
        return new SpriteBackground(game);
    }
}