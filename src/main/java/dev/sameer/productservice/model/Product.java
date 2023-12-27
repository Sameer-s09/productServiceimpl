package dev.sameer.productservice.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product extends BaseProduct{

    private String title;
    private float price;
    private String category;
    private String description;
    private String image;
}
