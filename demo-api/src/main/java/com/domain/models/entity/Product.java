package com.domain.models.entity;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "tbl_product")
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 

   @NotEmpty(message = "Nama tidak boleh kosong")
    @Column(name="product_name", length = 100)
    private String name;
    
    @NotEmpty(message = "Deskripsi tidak boleh kosong")
    @Column(name="product_description", length = 500)
    private String description;

    private Double price;

    @ManyToOne
    private Category category;

    @ManyToMany
     @JoinTable(
        name= "tbl_product_supplier",
        joinColumns= @JoinColumn(name= "product_id"),
        inverseJoinColumns= @JoinColumn(name= "supplier_id"))
    private Set<Supplier> suppliers;

    // Konstruktor kosong (default)
    public Product() {
    }

    // Konstruktor dengan parameter
    public Product(Long id, String name, String description, Double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<Supplier> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(Set<Supplier> suppliers) {
        this.suppliers = suppliers;
    } 

    
}