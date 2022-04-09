package lesson13;

import java.util.Objects;

public class Product3 implements Comparable<Product3> {
    private Integer id;
    private String name;
    private double price;

    public Product3(Integer id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product3 product = (Product3) o;
        return Double.compare(product.price, price) == 0 /*&& Objects.equals(id, product.id)*/ && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(/*id, */name, price);
    }

    @Override
    public int compareTo(Product3 o) {
        return this.getId().compareTo(o.getId());
    }
}
