package PaooGame.Graphics;

import java.awt.*;
import java.awt.image.BufferedImage;

/*! \class public class Assets
    \brief Clasa incarca fiecare element grafic necesar jocului.

    Game assets include tot ce este folosit intr-un joc: imagini, sunete, harti etc.
 */
public class Assets
{

    private static final int tileWidth = 100, tileHight = 100;
        /// Referinte catre elementele grafice (dale) utilizate in joc.
    public static BufferedImage iarba1;
    public static BufferedImage iarba2;
    public static BufferedImage comoara1_iarba_inchisa;
    public static BufferedImage comoara1_iarba_deschisa;
    public static BufferedImage flori_niv1;
    public static BufferedImage piatra1;
    public static BufferedImage piatra2;
    public static BufferedImage comoara2_piatra_inchisa;
    public static BufferedImage comoara2_piatra_deschisa;
    public static BufferedImage flori_niv2;
    public static BufferedImage panda_mic;
    public static BufferedImage urs_brun;
    public static BufferedImage urs_grizzly;
    public static BufferedImage[] btn_start;
    public static BufferedImage[] btn_help;
    public static BufferedImage[] btn_back ;
    public static BufferedImage[] btn_exit;
    public static BufferedImage arma;
    public static BufferedImage del;










    /*! \fn public static void Init()
        \brief Functia initializaza referintele catre elementele grafice utilizate.

        Aceasta functie poate fi rescrisa astfel incat elementele grafice incarcate/utilizate
        sa fie parametrizate. Din acest motiv referintele nu sunt finale.
     */
    public static void Init() {

        /// Se creaza temporar un obiect SpriteSheet initializat prin intermediul clasei ImageLoader
        SpriteSheet sheet = new SpriteSheet(ImageLoader.LoadImage("/textures/Pandalend.png"));
        /// Se obtin subimaginile corespunzatoare elementelor necesare.
        iarba1 = sheet.crop(0, 0);
        iarba2 = sheet.crop(1, 0);
        comoara1_iarba_inchisa = sheet.crop(2, 0);
        comoara1_iarba_deschisa = sheet.crop(3, 0);
        flori_niv1 = sheet.crop(0, 1);
        piatra1 = sheet.crop(1, 1);
        piatra2 = sheet.crop(2, 1);
        comoara2_piatra_inchisa = sheet.crop(3, 1);
        comoara2_piatra_deschisa = sheet.crop(0, 2);
        flori_niv2 = sheet.crop(1, 2);
        panda_mic = sheet.crop(2, 2);
        urs_brun = sheet.crop(3, 2);
        urs_grizzly = sheet.crop(0, 3);
        arma=sheet.crop(1,3);
        del=sheet.crop(3,3);

        //imagine care ne ajuta sa decupam imaginea corescunzatoare pentru fiecare buton din meniu
        SpriteSheet sheetMenu=new SpriteSheet((ImageLoader.LoadImage("/textures/butoane.png")));
        btn_start=new BufferedImage[2];
        btn_start[0]=sheetMenu.crop2(0,0);
        btn_start[1]=sheetMenu.crop2(0,1);

        btn_help=new BufferedImage[2];
        btn_help[0]=sheetMenu.crop2(1,0);
        btn_help[1]=sheetMenu.crop2(1,1);

        btn_exit=new BufferedImage[2];
        btn_exit[0]=sheetMenu.crop2(2,0);
        btn_exit[1]=sheetMenu.crop2(2,1);

        btn_back=new BufferedImage[2];
        btn_back[0]=sheetMenu.crop2(3,0);
        btn_back[1]=sheetMenu.crop2(3,1);





    }


}
