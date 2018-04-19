package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * The type Deal.
 */
@Entity(name = "Item")
@Table(name = "item")
public class Item {

    private String brand;
    private String product;
    private String size;
    private String storeName;
    private String salePrice;
    private String savingsAmount;
    private String saleEndDate;

    private boolean active;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    /**
     * Instantiates a new grocery item.
     */
    public Item() {
    }

    /**
     * Instantiates a new item.
     *
     * @param brand         the brand
     * @param product       the product
     * @param size          the size
     * @param storeName     the store name
     * @param salePrice     the sale price
     * @param savingsAmount the savings amount
     * @param saleEndDate   the sale end date
     * @param active        the active
     */
    public Item(String brand, String product, String size, String storeName, String salePrice, String savingsAmount, String saleEndDate, boolean active) {
        this.brand = brand;
        this.product = product;
        this.size = size;
        this.storeName = storeName;
        this.salePrice = salePrice;
        this.savingsAmount = savingsAmount;
        this.saleEndDate = saleEndDate;
        this.active = active;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets brand.
     *
     * @return the brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Sets brand.
     *
     * @param brand the brand
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * Gets product name.
     *
     * @return the product name
     */
    public String getProduct() {
        return product;
    }

    /**
     * Sets name.
     *
     * @param product the name of the product
     */
    public void setProduct(String product) {
        this.product = product;
    }

    /**
     * Gets size.
     *
     * @return the size
     */
    public String getSize() {
        return size;
    }

    /**
     * Sets size.
     *
     * @param size the size
     */
    public void setSize(String size) {
        this.size = size;
    }

    /**
     * Gets store name.
     *
     * @return the store name
     */
    public String getStoreName() {
        return storeName;
    }

    /**
     * Sets store name.
     *
     * @param storeName the store name
     */
    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    /**
     * Gets sale price.
     *
     * @return the sale price
     */
    public String getSalePrice() {
        return salePrice;
    }

    /**
     * Sets sale price.
     *
     * @param salePrice the sale price
     */
    public void setSalePrice(String salePrice) {
        this.salePrice = salePrice;
    }

    /**
     * Gets savings amount.
     *
     * @return the savings amount
     */
    public String getSavingsAmount() {
        return savingsAmount;
    }

    /**
     * Sets savings amount.
     *
     * @param savingsAmount the savings amount
     */
    public void setSavingsAmount(String savingsAmount) {
        this.savingsAmount = savingsAmount;
    }

    /**
     * Gets sale end date.
     *
     * @return the sale end date
     */
    public String getSaleEndDate() {
        return saleEndDate;
    }

    /**
     * Sets sale end date.
     *
     * @param saleEndDate the sale end date
     */
    public void setSaleEndDate(String saleEndDate) {
        this.saleEndDate = saleEndDate;
    }

    /**
     * Gets sale end date.
     *
     * @return the sale end date
     */
    public boolean getActive() {
        return active;
    }

    /**
     * Sets sale end date.
     *
     * @param active the active
     */
    public void setActive(boolean active) {
        this.active = active;
    }

}

