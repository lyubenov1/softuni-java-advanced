package OOP.TestDrivenDevelopment.Lab.src.main.java;

public interface ProductStock extends Iterable<Product> {
    int getCount();

    boolean contains(Product product);

    void add(Product product);
    void changeQuantity(String product, int quantity);

    //Retrievals
    Product find(int index);
    Product findByLabel(String label);
    Iterable<Product> findFirstByAlphabeticalOrder(int count);

    //Querying
    Iterable<Product> findAllInRange(double lo, double hi);
    Iterable<Product> findAllByPrice(double price);
    Iterable<Product> findFirstMostExpensiveProducts(int count);
    Iterable<Product> findAllByQuantity(int quantity);
}
