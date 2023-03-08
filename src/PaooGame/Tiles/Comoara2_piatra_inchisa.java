package PaooGame.Tiles;

import PaooGame.Graphics.Assets;


public class Comoara2_piatra_inchisa extends Tile {


    public Comoara2_piatra_inchisa(int id)
    {
        /// Apel al constructorului clasei de baza
        super(Assets.comoara2_piatra_inchisa, id);
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