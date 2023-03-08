package PaooGame.Items;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import PaooGame.Items.Gun;
import PaooGame.Maps.Map;
import PaooGame.RefLinks;
import PaooGame.Graphics.Assets;
import PaooGame.States.PlayState;

/*! \class public class Hero extends Character
    \brief Implementeaza notiunea de erou/player (caracterul controlat de jucator).

    Elementele suplimentare pe care le aduce fata de clasa de baza sunt:
        imaginea (acest atribut poate fi ridicat si in clasa de baza)
        deplasarea
        atacul (nu este implementat momentan)
        dreptunghiul de coliziune
 */
public class Hero extends Character
{
    private BufferedImage image;    /*!< Referinta catre imaginea curenta a eroului.*/
    private int foc;
    private ArrayList<Gun> guns;
    private Graphics g;

    private boolean enemyCollision = true;

    /*! \fn public Hero(RefLinks refLink, float x, float y)
        \brief Constructorul de initializare al clasei Hero.

        \param refLink Referinta catre obiectul shortcut (obiect ce retine o serie de referinte din program).
        \param x Pozitia initiala pe axa X a eroului.
        \param y Pozitia initiala pe axa Y a eroului.
     */

    private int gunCooldown = 0;

    public Hero(RefLinks refLink, float x, float y)
    {
            ///Apel al constructorului clasei de baza
        super(refLink, x,y, Character.DEFAULT_CREATURE_WIDTH, Character.DEFAULT_CREATURE_HEIGHT);
            ///Seteaza imaginea de start a eroului
        image = Assets.panda_mic;
            ///Stabilieste pozitia relativa si dimensiunea dreptunghiului de coliziune, starea implicita(normala)
        //normalBounds.x = 60;
        normalBounds.y = 5;
        normalBounds.width = 60;
        //normalBounds.height = 90;

            ///Stabilieste pozitia relativa si dimensiunea dreptunghiului de coliziune, starea de atac
        //attackBounds.x = 10;
        attackBounds.y = 10;
       // attackBounds.width = 38;
        attackBounds.height = 38;
    }

     //refLink.GetMap().setheroPosX((int) x);
    // refLink.GetMap().setheroPosY((int) y);

      //foc= 2500;
      //guns = new ArrayList<Gun>();
    /*! \fn public void Update()
        \brief Actualizeaza pozitia si imaginea eroului.
     */

    public void disableEnemyCollision() {
        enemyCollision = false;
    }

    public void Move() {
        MoveX();
        MoveY();

        if (enemyCollision) {
            if (Math.abs(x - refLink.GetMap().getEnemyPosX())<200 ){
                System.out.println("Game Over");
                refLink.GetGame().StopGame();
            }

        }
    }

    @Override
    public void Update()
    {
            ///Verifica daca a fost apasata o tasta
        GetInput();
            ///Actualizeaza pozitia
        Move();

        if (refLink.GetKeyManager().up) {
            image = Assets.panda_mic;
        }
        if (refLink.GetKeyManager().down) {
            image = Assets.panda_mic;
        }

        if (refLink.GetKeyManager().space && gunCooldown <= 0) {
            gunCooldown = 45;
            image = Assets.panda_mic;
            Gun newGun = new Gun(refLink, refLink.GetMap().getheroPosX() + 50, refLink.GetMap().getheroPosY(), 90, 140); //pozitionarea armei pe harta
            ((PlayState) refLink.GetGame().getPlayState()).addGun(newGun);
        }

        gunCooldown--;
    }
    public void setGraphics(Graphics g) {
        this.g = g;
    }
    /*! \fn private void GetInput()
        \brief Verifica daca a fost apasata o tasta din cele stabilite pentru controlul eroului.
     */
    private void GetInput()
    {
            ///Implicit eroul nu trebuie sa se deplaseze daca nu este apasata o tasta
        //xMove = 0;
        yMove = 0;
            ///Verificare apasare tasta "sus"
        if(refLink.GetKeyManager().up)
        {
            yMove = -speed;
        }
            ///Verificare apasare tasta "jos"
        if(refLink.GetKeyManager().down)
        {
            yMove = speed;
        }

    }

    /*! \fn public void Draw(Graphics g)
        \brief Randeaza/deseneaza eroul in noua pozitie.

        \brief g Contextul grafi in care trebuie efectuata desenarea eroului.
     */
    @Override
    public void Draw(Graphics g)
    {
        g.drawImage(image, (int)x, (int)y, width, height, null);


    }


}
