package com.balitechy.spacewar.main;

import com.balitechy.spacewar.factory.*;
import com.balitechy.spacewar.models.interfaces.*;
import com.balitechy.spacewar.utils.SpritesImageLoader;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Properties;
import java.io.FileInputStream;

public class Game extends Canvas implements Runnable {
    // Constantes del juego
    public static final int WIDTH = 320;
    public static final int HEIGHT = WIDTH / 12 * 9;
    public static final int SCALE = 2;
    public final String TITLE = "Space War 2D";
    
    // Componentes del juego
    private AGameFactory factory;
    private IPlayer player;
    private IBackground background;
    private BulletController bullets;
    private SpritesImageLoader sprites;
    
    // Game loop
    private boolean running = false;
    private Thread thread;
    private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
    
    public void init() {
        try {
            // Cargar configuración
            Properties props = new Properties();
            props.load(new FileInputStream("config.properties"));
            String style = props.getProperty("game.style", "sprite");
            
            // Configurar fábrica según el estilo
            this.factory = "vector".equals(style) ? 
                new VectorFactory() : new SpriteFactory();
                
            // Inicializar componentes
            this.player = factory.createPlayer(this);
            this.background = factory.createBackground();
            this.bullets = new BulletController();
            
            // Cargar sprites si es necesario
            if ("sprite".equals(style)) {
                this.sprites = new SpritesImageLoader("/sprites.png");
                sprites.loadImage();
            }
            
            // Configurar controles
            addKeyListener(new InputHandler(this));
            setFocusable(true);
            requestFocus();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // Métodos para el control del juego
    public synchronized void start() {
        if (running) return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }
    
    public synchronized void stop() {
        if (!running) return;
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }
    
    @Override
    public void run() {
        init();
        long lastTime = System.nanoTime();
        final double nsPerTick = 1000000000.0 / 60.0;
        double delta = 0;
        
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / nsPerTick;
            lastTime = now;
            
            while (delta >= 1) {
                tick();
                delta--;
            }
            
            render();
        }
        stop();
    }
    
    private void tick() {
        player.tick();
        bullets.tick();
    }
    
    private void render() {
        BufferStrategy bs = getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
            return;
        }
        
        Graphics g = bs.getDrawGraphics();
        g.clearRect(0, 0, getWidth(), getHeight());
        
        // Renderizar componentes
        background.render(g);
        player.render(g);
        bullets.render(g);
        
        g.dispose();
        bs.show();
    }
    
    // Métodos para manejo de teclado
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        
        switch(key) {
            case KeyEvent.VK_RIGHT:
                player.setVelX(5);
                break;
            case KeyEvent.VK_LEFT:
                player.setVelX(-5);
                break;
            case KeyEvent.VK_UP:
                player.setVelY(-5);
                break;
            case KeyEvent.VK_DOWN:
                player.setVelY(5);
                break;
            case KeyEvent.VK_SPACE:
                player.shoot();
                break;
        }
    }
    
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        
        switch(key) {
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_LEFT:
                player.setVelX(0);
                break;
            case KeyEvent.VK_UP:
            case KeyEvent.VK_DOWN:
                player.setVelY(0);
                break;
        }
    }
    
    // Getters
    public AGameFactory getFactory() {
        return factory;
    }
    
    public SpritesImageLoader getSprites() {
        return sprites;
    }
    
    public BulletController getBullets() {
        return bullets;
    }
    
    // Método principal
    public static void main(String[] args) {
        Game game = new Game();
        game.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        game.setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        game.setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        
        JFrame frame = new JFrame(game.TITLE);
        frame.add(game);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        game.start();
    }
}