package PaooGame.States;

import PaooGame.Items.*;
import PaooGame.Items.Types.Item_Types;
import PaooGame.RefLinks;
import PaooGame.Maps.Map;

import java.awt.*;
import java.util.ArrayList;

/*! \class public class PlayState extends State
    \brief Implementeaza/controleaza jocul.
 */
public class PlayState extends State
{
    private Hero hero;  /*!< Referinta catre obiectul animat erou (controlat de utilizator).*/
    private Map map;    /*!< Referinta catre harta curenta.*/
    private ArrayList<Gun> guns = new ArrayList<>();
    private ArrayList<Enemy> enemies = new ArrayList<>();
    int score=0;


    /*! \fn public PlayState(RefLinks refLink)
        \brief Constructorul de initializare al clasei

        \param refLink O referinta catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.
     */
    public PlayState(RefLinks refLink)
    {
            ///Apel al constructorului clasei de baza
        super(refLink);
            ///Construieste harta jocului
        map = new Map(refLink);
            ///Referinta catre harta construita este setata si in obiectul shortcut pentru a fi accesibila si in alte clase ale programului.
        refLink.SetMap(map);
            ///Construieste eroul
        hero = new Hero(refLink,200, 200); ///pozitia eroului pe harta

        enemies.add(new Enemy(refLink,800,200, Item_Types.Bear_Type.bear1)); //pozitia primului urs pe harta
        enemies.add(new Enemy(refLink,900,300, Item_Types.Bear_Type.bear1)); //pozitia ursului 2 pe harta
        enemies.add(new Enemy(refLink,700,400, Item_Types.Bear_Type.bear1)); //pozitia ursului 3  pe harta
        enemies.add(new Enemy(refLink,1000,500, Item_Types.Bear_Type.bear1)); // pozitia ursului 4 pe harta
    }


    /*! \fn public void Update()
        \brief Actualizeaza starea curenta a jocului.
     */
    @Override
    public void Update()
    {
        map.Update(); //actualizam mapa
        hero.Update(); //actualizam starea eroului


        for (Gun gun: guns) gun.Update(); // Updatare proiectile
        for (Enemy enemy: enemies) enemy.Update(); // Updatare ursi

        // Collisions of bullets with enemies
        for (Gun gun: guns) {
            for (Enemy enemy: new ArrayList<>(enemies)) {
                if (enemy.getRectangle().intersects(gun.getRectangle())) {
                    enemy.setRemoveFlag();
                    gun.setRemoveFlag();

                }
            }
        }

        guns.removeIf(Gun::getRemoveFlag);
        enemies.removeIf(Enemy::getRemoveFlag);








    }

    /*! \fn public void Draw(Graphics g)
        \brief Deseneaza (randeaza) pe ecran starea curenta a jocului.

        \param g Contextul grafic in care trebuie sa deseneze starea jocului pe ecran.
     */
    @Override
    public void Draw(Graphics g)
    {
        map.Draw(g);
        hero.Draw(g);
        hero.setGraphics(g);

        for (Gun gun: guns) gun.Draw(g);
        for (Enemy enemy: enemies) enemy.Draw(g);


    }

    public void addGun(Gun gun) {
        this.guns.add(gun);
    }




}
