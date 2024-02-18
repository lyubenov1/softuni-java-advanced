package climbers.models.climber;

public class RockClimber extends BaseClimber {
    private static final double INITIAL_STRENGTH = 120;

    public RockClimber(String name) {
        super(name, INITIAL_STRENGTH);
    }

    @Override
    public void climb() {
        modifyStrength(60);
    }

    private void modifyStrength(int amount) {
        this.setStrength(this.getStrength() - amount);
        if (this.getStrength() < 0) {
            this.setStrength(0);
        }
    }
}
