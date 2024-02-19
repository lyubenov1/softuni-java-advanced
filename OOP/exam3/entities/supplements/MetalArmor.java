package robotService.entities.supplements;

public class MetalArmor extends BaseSupplement {
    private final static int BASE_HARDNESS = 5;
    private final static double BASE_PRICE = 15;
    public MetalArmor() {
        super(BASE_HARDNESS, BASE_PRICE);
    }
}