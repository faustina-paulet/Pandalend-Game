package PaooGame.Maps;

//import PaooGame.Items.Animation.AnimationManager;
import PaooGame.Items.Hero;
//import PaooGame.Items.ItemManager;
import PaooGame.RefLinks;
import PaooGame.Tiles.Tile;

import java.awt.*;

/*! \class public class Map
    \brief Implementeaza notiunea de harta a jocului.
 */
public class Map
{
    private RefLinks refLink;   /*!< O referinte catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.*/
    private int width;          /*!< Latimea hartii in numar de dale.*/
    private int height;         /*!< Inaltimea hartii in numar de dale.*/
    private int [][] tiles;     /*!< Referinta catre o matrice cu codurile dalelor ce vor construi harta.*/
    //private AnimationManager animationManager;

    //private ItemManager itemManager;

    private int heroPosX;
    private int heroPosY;
    public int getheroPosX(){return heroPosX;}
    public int getheroPosY(){return heroPosY;}
    public void setheroPosX(int x){heroPosX = x;}
    public void setheroPosY(int y){heroPosY = y;}

    private int enemyPosX;
    private int enemyPosY;
    public int getEnemyPosX(){return enemyPosX;}
    public void setEnemyPosX(int x){enemyPosX = x;}
    public int getEnemyPosY(){return enemyPosY;}
    public void setEnemPosY(int x){enemyPosY = x;}






    //  private AnimationManager animationManager;


    /*! \fn public Map(RefLinks refLink)
        \brief Constructorul de initializare al clasei.

        \param refLink O referinte catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.
     */
    public Map(RefLinks refLink)
    {
            /// Retine referinta "shortcut".
        this.refLink = refLink;

            ///incarca harta de start. Functia poate primi ca argument id-ul hartii ce poate fi incarcat.
        LoadWorld();
    }

    /*! \fn public  void Update()
        \brief Actualizarea hartii in functie de evenimente (un copac a fost taiat)
     */
    public  void Update()
    {

    }

    /*! \fn public void Draw(Graphics g)
        \brief Functia de desenare a hartii.

        \param g Contextl grafi in care se realizeaza desenarea.
     */
    public void Draw(Graphics g)
    {
            ///Se parcurge matricea de dale (codurile aferente) si se deseneaza harta respectiva
        for(int y = 0; y < refLink.GetGame().GetHeight()/Tile.TILE_HEIGHT; y++)
        {
            for(int x = 0; x < refLink.GetGame().GetWidth()/Tile.TILE_WIDTH; x++)
            {
                GetTile(x, y).Draw(g, (int)x * Tile.TILE_HEIGHT, (int)y * Tile.TILE_WIDTH);
            }
        }


    }



    public Tile GetTile(int x, int y)
    {
        if(x < 0 || y < 0 || x >= width || y >= height)
        {
            return Tile.iarba2;
        }
        Tile t = Tile.tiles[tiles[x][y]];
        if(t == null)
        {
            return Tile.flori_niv1;
        }
        return t;
    }

    /*! \fn private void LoadWorld()
        \brief Functie de incarcare a hartii jocului.
        Aici se poate genera sau incarca din fisier harta. Momentan este incarcata static.
     */
    private void LoadWorld()
    {
        //atentie latimea si inaltimea trebuiesc corelate cu dimensiunile ferestrei sau
        //se poate implementa notiunea de camera/cadru de vizualizare al hartii
            ///Se stabileste latimea hartii in numar de dale.
        width = 12;
            ///Se stabileste inaltimea hartii in numar de dale
        height = 7;
            ///Se construieste matricea de coduri de dale
        tiles = new int[width][height];
            //Se incarca matricea cu coduri
        for(int y = 0; y < height; y++)
        {
            for(int x = 0; x < width; x++)
            {
                tiles[x][y] = MiddleEastMap(y, x);
            }
        }
    }


    private int MiddleEastMap(int x ,int y)
    {
            ///Definire statica a matricei de coduri de dale.
        final int map[][] =
                {
                        {4, 4, 4, 4, 4, 4, 4, 4, 4, 4,4, 4},
                        {4, 3, 0, 1, 0, 1, 0, 1, 0, 1, 0, 4},
                        {4, 2, 1, 0, 1, 0, 1, 0, 1, 0, 1, 4},
                        {4, 3, 0, 1, 0, 1, 0, 1, 0, 1, 0, 4},
                        {4, 2, 1, 0, 1, 0, 1, 0, 1, 0, 1, 4},
                        {4, 3, 0, 1, 0, 1, 0, 1, 0, 1, 0, 4},
                        {4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4}};
        return map[x][y];
    }



}