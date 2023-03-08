package PaooGame.Tiles;

import PaooGame.Graphics.Assets;


public class Flori_niv2 extends Tile
{

    public Flori_niv2(int id)
    {
        /// Apel al constructorului clasei de baza
        super(Assets.flori_niv2, id);
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