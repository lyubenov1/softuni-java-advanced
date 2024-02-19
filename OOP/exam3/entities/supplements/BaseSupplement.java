package robotService.entities.supplements;

public abstract class BaseSupplement implements Supplement{
    private int hardness;
    private double price;

    protected BaseSupplement(int hardness, double price) {
        setHardness(hardness);
        setPrice(price);
    }

    private void setPrice(double price) {
        this.price = price;
    }

    private void setHardness(int hardness) {
        this.hardness = hardness;
    }

    @Override
    public int getHardness() {
        return hardness;
    }

    @Override
    public double getPrice() {
        return price;
    }
}
