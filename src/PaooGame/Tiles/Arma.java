package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

public class Arma extends Tile{


    public Arma(int id)
    {

        /// Apel al constructorului clasei de baza
        super(Assets.arma, id);

    }

    /*! \fn public boolean IsSolid()
       \brief Suprascrie metoda IsSolid() din clasa de baza in sensul ca va fi luat in calcul in caz de coliziune.
    */
    public boolean IsSolid()
    {
        return false;
    }
    public boolean IsStopGame(){
        return true;
    }
}
