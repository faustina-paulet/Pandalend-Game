
package PaooGame.Tiles;

import PaooGame.Graphics.Assets;


public class Flori_niv1 extends Tile
{

    public Flori_niv1(int id)
    {
        /// Apel al constructorului clasei de baza
        super(Assets.flori_niv1, id);
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