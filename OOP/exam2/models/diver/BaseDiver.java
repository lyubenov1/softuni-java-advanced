package harpoonDiver.models.diver;
import harpoonDiver.common.ExceptionMessages;
import harpoonDiver.models.seaCatch.BaseSeaCatch;
import harpoonDiver.models.seaCatch.SeaCatch;

public abstract class BaseDiver implements Diver{
    private String name;
    private double oxygen;
    private static final double DEFAULT_OXYGEN_CONSUMPTION = 30;
    private SeaCatch seaCatch;
    protected BaseDiver(String name, double oxygen) {
        setName(name);
        setOxygen(oxygen);
        seaCatch = new BaseSeaCatch();
    }

    private void setOxygen(double oxygen) {
        if (oxygen < 0) {
            throw new NullPointerException(ExceptionMessages.DIVER_OXYGEN_LESS_THAN_ZERO);
        }
        this.oxygen = oxygen;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.DIVER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getOxygen() {
        return oxygen;
    }

    @Override
    public boolean canDive() {
        return oxygen > 0;
    }

    @Override
    public SeaCatch getSeaCatch() {
        return seaCatch;
    }

    @Override
    public void shoot() {
        this.oxygen = Math.max(0, this.oxygen - DEFAULT_OXYGEN_CONSUMPTION);
    }
}
