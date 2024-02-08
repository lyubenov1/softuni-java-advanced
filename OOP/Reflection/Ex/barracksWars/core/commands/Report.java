package OOP.Reflection.Ex.barracksWars.core.commands;

import OOP.Reflection.Ex.barracksWars.interfaces.Repository;
import OOP.Reflection.Ex.barracksWars.interfaces.UnitFactory;

public class Report extends Command{

    public Report(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        String output = getRepository().getStatistics();
        return output;
    }
}