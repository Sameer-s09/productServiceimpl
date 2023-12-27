package dev.sameer.productservice.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Bean;


@Getter
@Setter
public class GenericDto {

    private int ID;
    private String title;
    private float price;
    private String category;
    private String description;
    private String image;
}
