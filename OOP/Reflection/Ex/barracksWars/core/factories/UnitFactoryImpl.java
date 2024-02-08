package OOP.Reflection.Ex.barracksWars.core.factories;

import OOP.Reflection.Ex.barracksWars.interfaces.Unit;
import OOP.Reflection.Ex.barracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"barracksWars.models.units.";

	@Override
	public Unit createUnit(String unitType) throws ExecutionControl.NotImplementedException {
		// TODO: implement for problem 3
		try {
			Class unitClass = Class.forName(UNITS_PACKAGE_NAME + unitType);
			Constructor<Unit> unitConstructor = unitClass.getDeclaredConstructor();
			return unitConstructor.newInstance();
		} catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException |
				 InvocationTargetException e) {
			e.printStackTrace();
			return null;
		}


		//	switch (unitType) {
	//		case "Archer":
	//			return new Archer();
    //       case "Swordsman":
	//			return new Swordsman();
	//		case "Pikeman":
	//			return new Pikeman();
	//		case "Gunner":
	//			return new Gunner();
    //       case "Horseman":
	//			return new Horseman();
	//	}
	//	throw new ExecutionControl.NotImplementedException("message");

	}
}
