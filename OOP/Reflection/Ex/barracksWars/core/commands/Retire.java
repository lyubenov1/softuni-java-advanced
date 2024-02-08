package OOP.Reflection.Ex.barracksWars.core.commands;

import OOP.Reflection.Ex.barracksWars.interfaces.Repository;
import OOP.Reflection.Ex.barracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

public class Retire extends Command{


    public Retire(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() throws ExecutionControl.NotImplementedException {
        String unitType = getData()[1];
        getRepository().removeUnit(unitType);
        return unitType + " retired!";
    }
}