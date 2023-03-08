package PaooGame;

import PaooGame.GameWindow.GameWindow;
/*!
 \class Main
 \brief Clasa clientului ce apeleaza Game.getInstance().StartGame();
 */
public class Main
{
    public static void main(String[] args)
    {
        Game paooGame = new Game("Pandalend",1200 , 700);
        paooGame.StartGame();
    }
}
