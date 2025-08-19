package com.balitechy.spacewar.factory;
import com.balitechy.spacewar.main.Game;
import com.balitechy.spacewar.models.interfaces.*;
import com.balitechy.spacewar.models.vector.VectorPlayer;
import com.balitechy.spacewar.models.vector.VectorBullet;
import com.balitechy.spacewar.models.vector.VectorBackground;

public class VectorFactory extends AGameFactory {
    @Override
    public IPlayer createPlayer(Game game) {
        return new VectorPlayer(game);
    }

    @Override
    public IBullet createBullet(int x, int y) {
        return new VectorBullet(x, y);
    }

    @Override
    public IBackground createBackground() {
        return new VectorBackground();
    }
}