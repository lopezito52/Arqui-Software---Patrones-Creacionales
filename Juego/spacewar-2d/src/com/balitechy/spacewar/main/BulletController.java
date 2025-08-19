package com.balitechy.spacewar.main;
import java.awt.Graphics;
import com.balitechy.spacewar.models.interfaces.IBullet;
import java.util.ArrayList;
import java.util.List;

public class BulletController {
    private List<IBullet> bullets = new ArrayList<>();

    public void addBullet(IBullet bullet) {
        bullets.add(bullet);
    }

    public void tick() {
        for (IBullet bullet : bullets) {
            bullet.tick();
        }
        bullets.removeIf(b -> !b.isVisible());
    }

    public void render(Graphics g) {
        for (IBullet bullet : bullets) {
            bullet.render(g);
        }
    }
}