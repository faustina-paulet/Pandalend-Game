package PaooGame.States;

import PaooGame.Graphics.Assets;
import PaooGame.Graphics.ImageLoader;
import PaooGame.RefLinks;
import PaooGame.ui.ClickListener;
import PaooGame.ui.UIImageButton;
import PaooGame.ui.UIManager;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;

import PaooGame.ui.UIManager;

import javax.swing.*;

/*! \class public class MenuState extends State
    \brief Implementeaza notiunea de menu pentru joc.
 */
public class MenuState extends State
{
    private UIManager uiManager;
    private BufferedImage menu;
    private BufferedImage help;
    /*! \ fn public MenuState(RefLinks refLink)
        \brief Constructorul de initializare al clasei.

        \param refLink O referinta catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.
     */
    public MenuState(RefLinks refLink)
    {
            ///Apel al constructorului clasei de baza.
        super(refLink);
        menu=ImageLoader.LoadImage("/meniu/Background.png");
        //help=ImageLoader.LoadImage("/Resources/back_help.png");

        uiManager=new UIManager(refLink);
        refLink.GetMouseManager().setUiManager(uiManager);

        /////Adaugarea diverselor butoane specifice starii MenuState managerului de obiecte UI
        uiManager.addObject(new UIImageButton(800, 100, 200, 100, Assets.btn_start, new ClickListener() {
            @Override
            public void onClick() {
                refLink.GetMouseManager().setUiManager(null);

                State.SetState(refLink.GetGame().getPlayState());
            }
        }));

        uiManager.addObject(new UIImageButton(800, 300, 200, 100, Assets.btn_help, new ClickListener() {
            @Override
            public void onClick() {
                refLink.GetMouseManager().setUiManager(null);
                State.SetState(refLink.GetGame().getAboutState());


            }
        }));

        uiManager.addObject(new UIImageButton(800, 500, 200, 100, Assets.btn_exit, new ClickListener() {
            @Override
            public void onClick() {
              System.exit(0);




            }
        }));

    }
    /*! \fn public void Update()
        \brief Actualizeaza starea curenta a meniului.
     */
    @Override
    public void Update()
    {
        if (refLink.GetMouseManager().getUiManager() == null)
            refLink.GetMouseManager().setUiManager(uiManager);

        uiManager.Update();

    }

    /*! \fn public void Draw(Graphics g)
        \brief Deseneaza (randeaza) pe ecran starea curenta a meniului.

        \param g Contextul grafic in care trebuie sa deseneze starea jocului pe ecran.
     */
    @Override
    public void Draw(Graphics g)
    {
        g.drawImage(menu,0,0,null);
        uiManager.render(g);

    }
}
