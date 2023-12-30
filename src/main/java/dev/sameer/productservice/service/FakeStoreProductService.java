package dev.sameer.productservice.service;

import dev.sameer.productservice.dto.GenericDto;
import dev.sameer.productservice.exceptions.NotFoundException;
import dev.sameer.productservice.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService{


    String getProductURL = "https://fakestoreapi.com/products/{id}";
    String getAllProductsURL = "https://fakestoreapi.com/products";

    @Autowired
    RestTemplateBuilder restTemplateBuilder;

    @Override
    public Product getProductById(long ID) throws NotFoundException {

        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<GenericDto> responseDto = restTemplate.getForEntity(getProductURL, GenericDto.class,ID);
        Product fakestoreproduct = new Product();

        GenericDto respObj = responseDto.getBody();

        if (respObj == null) {
            throw new NotFoundException("Product not found");
        }
        if(responseDto.getStatusCode().value() == 200)
        {
                //return "product details " + ID;
                fakestoreproduct.setPrice(responseDto.getBody().getPrice());
                fakestoreproduct.setID(responseDto.getBody().getID());
                fakestoreproduct.setTitle(responseDto.getBody().getTitle());
                fakestoreproduct.setDescription(responseDto.getBody().getDescription());
                fakestoreproduct.setCategory(responseDto.getBody().getCategory());
                fakestoreproduct.setImage(responseDto.getBody().getImage());
                return fakestoreproduct;
        }


        return fakestoreproduct;
    }



    @Override
    public List<Product> getAllProducts(){
        Product fakeStoreData = new Product();
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<GenericDto[]> responseDto = restTemplate.getForEntity(getAllProductsURL, GenericDto[].class);

        List<Product> returnData = new ArrayList<>();

        for (GenericDto i: responseDto.getBody()){
                fakeStoreData.setID(i.getID());
                fakeStoreData.setPrice(i.getPrice());
                fakeStoreData.setTitle(i.getTitle());
                fakeStoreData.setImage(i.getImage());
                fakeStoreData.setDescription(i.getDescription());
                fakeStoreData.setCategory(i.getCategory());
                returnData.add(fakeStoreData);
        }
        return returnData;
        //return "All products";
    }
}
