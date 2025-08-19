package com.balitechy.spacewar.factory;
import com.balitechy.spacewar.main.Game;
import com.balitechy.spacewar.models.interfaces.IBackground;
import com.balitechy.spacewar.models.interfaces.IBullet;
import com.balitechy.spacewar.models.interfaces.IPlayer;

public abstract class AGameFactory {
    public abstract IPlayer createPlayer(Game game);
    public abstract IBullet createBullet(int x, int y);
    public abstract IBackground createBackground();
}