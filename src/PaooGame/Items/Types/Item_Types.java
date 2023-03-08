package PaooGame.Items.Types;

import PaooGame.Graphics.Assets;

import java.awt.image.BufferedImage;

public class Item_Types {

    public enum Bear_Type{
        bear1, bear2, hero;
    }

    public static Bear_Type GetBearByLevel(int level){
        return Bear_Type.hero;
    }

   public static float BearSpeed(Bear_Type e)
    {
        return 1f;
    }

    public static int BearHealth(Bear_Type e)
    {
        switch(e){
            case bear1:
                return 1;
            case bear2:
                return 2;
        }

        return 1;
    }

    public static BufferedImage BearImages(Bear_Type e)
    {
        switch(e)
        {
            case bear1:
                return Assets.urs_brun;
            case bear2:
                return Assets.urs_grizzly;
        }
        return Assets.urs_brun;
    }


}
