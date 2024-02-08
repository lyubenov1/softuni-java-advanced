package OOP.Reflection.Ex.barracksWars.core.commands;

import OOP.Reflection.Ex.barracksWars.interfaces.Repository;
import OOP.Reflection.Ex.barracksWars.interfaces.UnitFactory;

public class Fight extends Command {

    public Fight(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        return "fight";
    }
}