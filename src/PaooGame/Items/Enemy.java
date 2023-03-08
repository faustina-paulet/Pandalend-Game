package PaooGame.Items;
import PaooGame.Graphics.Assets;
import PaooGame.Items.Types.Current_Direction;
import PaooGame.Items.Types.Item_Types;
import PaooGame.RefLinks;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;
/*!
\class Enemy
\brief Clasa Enemy implementeaza notiunea de inamic al jocului
 */
public class Enemy extends Character {
    private BufferedImage image;    /*!< Referinta catre imaginea curenta a inamicului.*/
    private Random random = new Random();
    protected Current_Direction current_direction;
    Item_Types.Bear_Type bear_type;

    ///Boolean ce transmite informatii despre starea inamicului (Dead sau alive)

    public Enemy(RefLinks refLink, float x, float y, Item_Types.Bear_Type bear_type) {
        super(refLink, x, y, Character.DEFAULT_CREATURE_WIDTH, Character.DEFAULT_CREATURE_HEIGHT);
        image = Assets.urs_brun;
        current_direction = Current_Direction.right;
        this.bear_type = bear_type;
        //init();
    }


    /*! \fn     public void Update() {
   Se incearca depistarea unor items din imprejurimi si daca se gasesc, in functie de cat timp a trecut de la ultimul atac ataca sau nu.
   Daca nu gaseste itemuri de distrus in jur, se plimba.
    */




    @Override
    public void Update() {

        if (xMove > 0) {
            xMove--;
        } else {
            xMove = 2; //speed
            if (x > 170) {
                x -= speed;
            }
        }



    }

    public void destroy()
    {
        image = Assets.del;
    }

    @Override
    public void Draw(Graphics g) {

        g.drawImage(image, (int) x, (int) y, width, height, null);

    }


    private void GetInput() {


    }}



