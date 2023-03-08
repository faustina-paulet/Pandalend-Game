package PaooGame.Items;
import PaooGame.Input.KeyManager;
import PaooGame.Tiles.Arma;
import PaooGame.RefLinks;
import PaooGame.Tiles.Tile;

import java.awt.*;
import java.awt.event.KeyEvent;

/*! \class public abstract class Character extends Item
    \brief Defineste notiunea abstracta de caracter/individ/fiinta din joc.

    Notiunea este definita doar de viata, viteza de deplasare si distanta cu care trebuie sa se
    miste/deplaseze in urma calculelor.
 */
public abstract class Character extends Item {

    public static final int DEFAULT_LIFE = 10;   /*!< Valoarea implicita a vietii unui caracter.*/
    public static final float DEFAULT_SPEED = 5.0f; /*!< Viteza implicita a unu caracter.*/
    public static final int DEFAULT_CREATURE_WIDTH = 100;   /*!< Latimea implicita a imaginii caracterului.*/
    public static final int DEFAULT_CREATURE_HEIGHT = 100;   /*!< Inaltimea implicita a imaginii caracterului.*/


    //protected Item_Types.Bear_Type bear_type;
    protected int life;
    protected float speed;  /*!< Retine viteza de deplasare caracterului.*/

    protected float yMove;  /*!< Retine noua pozitie a caracterului pe axa Y.*/
    protected float xMove;
    protected Animation animation;
    private Arma arma;

    protected float colWidth = 20f;
    protected float colheight = 20f;

    protected boolean remove = false;


    /*! \fn public Character(RefLinks refLink, float x, float y, int width, int height)
        \brief Constructor de initializare al clasei Character

        \param refLink Referinta catre obiectul shortcut (care retine alte referinte utile/necesare in joc).
        \param x Pozitia de start pa axa X a caracterului.
        \param y Pozitia de start pa axa Y a caracterului.
        \param width Latimea imaginii caracterului.
        \param height Inaltimea imaginii caracterului.
     */
    public Character(RefLinks refLink, float x, float y, int width, int height) {
        ///Apel constructor la clasei de baza
        super(refLink, x, y, width, height);
        //Seteaza pe valorile implicite pentru viata, viteza si distantele de deplasare
        life = DEFAULT_LIFE;
        speed = DEFAULT_SPEED;
        xMove = 0;
        yMove = 0;
    }

    protected boolean collisionWithTile(int x, int y){
        return refLink.GetMap().GetTile(x, y).IsSolid();
    }
    /*! \fn public void Move()
        \brief Modifica pozitia caracterului
     */
    public void Move() {

    }


    /*! \fn public void MoveX()
        \brief Modifica pozitia caracterului pe axa X.
     */
    public void MoveX()
    {
        ///Aduna la pozitia curenta numarul de pixeli cu care trebuie sa se deplaseze pe axa X.
        if(xMove > 0){//move right
            int tx = (int) (x + xMove + normalBounds.x + normalBounds.width) / Tile.TILE_WIDTH;

            if(!collisionWithTile(tx, (int) (y + normalBounds.y) / Tile.TILE_HEIGHT) && //check top right corner of hitbox
                    !collisionWithTile(tx, (int) (y + normalBounds.y + normalBounds.height) / Tile.TILE_HEIGHT)){ //check bottom right corner of hitbox
                x += xMove;
            }else{
                x = tx * Tile.TILE_WIDTH - normalBounds.x - normalBounds.width - 1;
            }

        }else if(xMove < 0){//move left
            int tx = (int) (x + xMove + normalBounds.x) / Tile.TILE_WIDTH;

            if(!collisionWithTile(tx, (int) (y + normalBounds.y) / Tile.TILE_HEIGHT) && //check top left corner of hitbox
                    !collisionWithTile(tx, (int) (y + normalBounds.y + normalBounds.height) / Tile.TILE_HEIGHT)){ //check bottom left corner of hitbox
                x += xMove;
            }else{
                x = tx * Tile.TILE_WIDTH + Tile.TILE_WIDTH - normalBounds.x;
            }
        }
        refLink.GetMap().setheroPosX((int) x);

    }
    public void MoveY()
    {
        //y += yMove;
        if(yMove < 0){//up
            int ty = (int) (y+ yMove + normalBounds.y) / Tile.TILE_HEIGHT;

            if(!collisionWithTile((int) (x + normalBounds.x) / Tile.TILE_WIDTH, ty) && !collisionWithTile((int) (x + normalBounds.x + normalBounds.width) / Tile.TILE_WIDTH,ty))
            {
                y += yMove;
            }else {
                y = ty * Tile.TILE_HEIGHT + Tile.TILE_HEIGHT - normalBounds.y;
            }

        }else if(yMove > 0){//down
            int ty = (int) (y+ yMove +normalBounds.y + normalBounds.getHeight()) /Tile.TILE_HEIGHT;

            if(!collisionWithTile((int) (x + normalBounds.x) / Tile.TILE_WIDTH,ty) &&
                    !collisionWithTile((int) (x +normalBounds.x + normalBounds.width) /   Tile.TILE_WIDTH,ty)){
                y += yMove;
            }else{
                y = ty * Tile.TILE_HEIGHT -normalBounds.y - normalBounds.height -1;
            }
        }
        refLink.GetMap().setheroPosY((int) y);
    }




    /*! \fn public int GetLife()
        \brief Returneaza viata caracterului.
     */
    public int GetLife()
    {
        return life;
    }

    /*! \fn public int GetSpeed()
        \brief Returneaza viteza caracterului.
     */
    public float GetSpeed()
    {
        return speed;
    }

    /*! \fn public void SetLife(int life)
        \brief Seteaza viata caracterului.
     */
    public void SetLife(int life)
    {
        this.life = life;
    }

    /*! \fn public void SetSpeed(float speed)
        \brief
     */
    public void SetSpeed(float speed) {
        this.speed = speed;
    }

    /*! \fn public float GetXMove()
        \brief Returneaza distanta in pixeli pe axa X cu care este actualizata pozitia caracterului.
     */
    public float GetXMove()
    {
        return xMove;
    }
    /*! \fn public float GetYMove()
        \brief Returneaza distanta in pixeli pe axa Y cu care este actualizata pozitia caracterului.
     */
    public float GetYMove()
    {
        return yMove;
    }

    /*! \fn public void SetXMove(float xMove)
        \brief Seteaza distanta in pixeli pe axa X cu care va fi actualizata pozitia caracterului.
     */
    public void SetXMove(float xMove)
    {
        this.xMove = xMove;
    }

    /*! \fn public void SetYMove(float yMove)
        \brief Seteaza distanta in pixeli pe axa Y cu care va fi actualizata pozitia caracterului.
     */
    public void SetYMove(float yMove)
    {
        this.yMove = yMove;
    }

    public Rectangle getRectangle() {
        return new Rectangle((int) x, (int) y, (int) colWidth, (int) colheight);
    }

    public boolean getRemoveFlag() {
        return remove;
    }

    public void setRemoveFlag() {
        remove = true;
    }

}

