
package PaooGame.Tiles;

import PaooGame.Graphics.Assets;


public class Comoara1_iarba_deschisa extends Tile {


    public Comoara1_iarba_deschisa(int id)
    {
        /// Apel al constructorului clasei de baza
        super(Assets.comoara1_iarba_deschisa, id);
    }

    /*! \fn public boolean IsSolid()
        \brief Suprascrie metoda IsSolid() din clasa de baza in sensul ca va fi luat in calcul in caz de coliziune.
     */
    @Override
    public boolean IsSolid()
    {
        return true;
    }
}