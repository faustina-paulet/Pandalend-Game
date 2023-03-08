package PaooGame.States;

import PaooGame.Graphics.Assets;
import PaooGame.Graphics.ImageLoader;
import PaooGame.RefLinks;
import PaooGame.ui.ClickListener;
import PaooGame.ui.UIImageButton;
import PaooGame.ui.UIManager;
import PaooGame.States.MenuState;
import java.awt.*;

/*! \class public class AboutState extends State
    \brief Implementeaza notiunea de credentiale (about)
 */
public class AboutState extends State
{
    private UIManager uiManager;


    /*! \fn public AboutState(RefLinks refLink)
        \brief Constructorul de initializare al clasei.

        \param refLink O referinta catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.
     */
    public AboutState(RefLinks refLink)
    {


        ///Apel al constructorului clasei de baza.
        super(refLink);
        ///Se construieste un nou manager de obiecte UI
        uiManager = new UIManager(refLink);
        ///Adauga diverse obiecte specifice starii Highscores
        uiManager.addObject(new UIImageButton(800, 580, 200, 100, Assets.btn_back, new ClickListener() {
            @Override
            public void onClick() {
                refLink.GetMouseManager().setUiManager(null);
                State.SetState(refLink.GetGame().getMenuState());
            }
        } ));

    }
    /*! \fn public void Update()
        \ brief Actualizeaza starea curenta a meniu about.
     */
    @Override
    public void Update()
    {
        if (refLink.GetMouseManager().getUiManager() == null)
            refLink.GetMouseManager().setUiManager(uiManager);
        uiManager.Update();



    }




    /*! \fn public void Draw(Graphics g)
        \brief Deseneaza (randeaza) pe ecran starea curenta a meniu about.

        \param g Contextul grafic in care trebuie sa deseneze starea jocului pe ecran.
     */
    @Override
    public void Draw(Graphics g)
    {
        g.drawImage(ImageLoader.LoadImage("/meniu/Help.png"),0,0,null);
        uiManager.render(g);
    }
}
