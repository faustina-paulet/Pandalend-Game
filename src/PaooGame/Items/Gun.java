package PaooGame.Items;

import PaooGame.Graphics.Assets;
import PaooGame.RefLinks;

import java.awt.*;
import java.awt.image.BufferedImage;

/*!
\class Gun
\brief Clasa responsabila cu uciderea ursilor de pe harta

 */

public class Gun extends Character {


    private boolean hit;//lovitura

    boolean right;
    private BufferedImage[] sprites;//sprite-ul original
    private BufferedImage[] hitSprites;//animatia care se joaca

    private BufferedImage image;
    private boolean draw = false;

    private float distanceTravelled = 0;

    public Gun(RefLinks refLink, float x, float y, int width, int height) {
        super(refLink, x, y, width, height);



        image = Assets.arma;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;


        try {
            animation = new Animation();
            animation.setFrames(sprites);
            animation.setDelay(70);//intarziere

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void Update() {
        x = x + speed;
        distanceTravelled += Math.abs(speed);

        if (distanceTravelled > 400) {
            remove = true;
        }
    }


    //functie care afla daca gun a lovit sau nu ceva
    public void setHit() {
        if (hit) return;
        hit = true;//a lovit ceva
        animation.setFrames(hitSprites);
        animation.setDelay(70);
        x = 0;
    }

    //pentr a elimina daca ar trebui sau nu sa-l scoatem din joc
    public boolean shouldRemove1() {
        return remove;
    }

    public void setDraw(boolean val) {
        draw = val;
    }

    public boolean getDraw() {
        return draw;
    }


    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void Draw(Graphics g) {

        //if (collisionWithTile((int) x, (int) y)) {
        //draw = false;
        //}
        if (Math.abs(x - refLink.GetMap().getEnemyPosX()) < 30
                && Math.abs(y - refLink.GetMap().getEnemyPosY()) < 30 && x != 0 && y != 0) {
            System.out.println("You win");
            draw = false;
            remove = true;

        }

        g.drawImage(image, (int) x, (int) y, width, height, null);

    }
}











