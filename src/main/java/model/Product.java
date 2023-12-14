package model;

public class Product {
    private int id;
    private int category_id;
    private String name;
    private String image;
    private Double price;
    private String manufacturer;
    private String information;

    public Product() {
    }

    public Product(int id, int category_id, String name, String image, Double price, String manufacturer,
            String information) {
        this.id = id;
        this.category_id = category_id;
        this.name = name;
        this.image = image;
        this.price = price;
        this.manufacturer = manufacturer;
        this.information = information;
    }

    public int getProductID() {
        return this.id;
    }

    public void setProductID(int id) {
        this.id = id;
    }

    public int getCategoryID() {
        return this.category_id;
    }

    public void setCategoryID(int category_id) {
        this.category_id = category_id;
    }

    public String getProductName() {
        return this.name;
    }

    public void setProductName(String name) {
        this.name = name;
    }

    public String getProductImage() {
        return this.image;
    }

    public void setProductImage(String image) {
        this.image = image;
    }

    public Double getProductPrice() {
        return this.price;
    }

    public void setProductPrice(Double price) {
        this.price = price;
    }

    public String getManufacturer() {
        return this.manufacturer;
    }

    public void setProductManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getProductInformation() {
        return this.information;
    }

    public void setProductInformation(String information) {
        this.information = information;
    }
}
