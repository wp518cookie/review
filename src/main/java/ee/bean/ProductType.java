package ee.bean;

/**
 * Created by Administrator on 2018/4/15.
 */
public enum ProductType {
    MOUSE("1", "鼠标"), KEYWORD("2", "键盘");

    private String productId;
    private String productName;

    static {

    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    ProductType(String productId, String productName) {
        this.productId = productId;
        this.productName = productName;
    }
}
