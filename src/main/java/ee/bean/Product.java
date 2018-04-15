package ee.bean;

/**
 * Created by Administrator on 2018/4/11.
 */
public class Product {
    private int id;
    private int count;
    private ProductType productType;

    public Product() {

    }

    public Product(int count) {
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
