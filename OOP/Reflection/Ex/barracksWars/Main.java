package OOP.Reflection.Ex.barracksWars;

import OOP.Reflection.Ex.barracksWars.core.Engine;
import OOP.Reflection.Ex.barracksWars.core.factories.UnitFactoryImpl;
import OOP.Reflection.Ex.barracksWars.data.UnitRepository;
import OOP.Reflection.Ex.barracksWars.interfaces.Repository;
import OOP.Reflection.Ex.barracksWars.interfaces.UnitFactory;


public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();


        //Repository -> holds the data of the application.
        //UnitFactory -> Used to create Units(Archers, Pikemans, Swordsmans)
        //Engine -> used to parse and execute commands
        //Units -> the characters in the game
    }
}
