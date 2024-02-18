package climbers.models.climber;

public class WallClimber extends BaseClimber {
    private static final double INITIAL_STRENGTH = 90;

    public WallClimber(String name) {
        super(name, INITIAL_STRENGTH);
    }

    @Override
    public void climb() {
        modifyStrength(30);
    }

    private void modifyStrength(int amount) {
        this.setStrength(this.getStrength() - amount);
        if (this.getStrength() < 0) {
            this.setStrength(0);
        }
    }
}
