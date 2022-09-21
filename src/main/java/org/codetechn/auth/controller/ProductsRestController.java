package org.codetechn.auth.controller;

import org.codetechn.auth.entity.Product;
import org.codetechn.auth.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
 @RequestMapping("/product")
public class ProductsRestController {
    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/save")
    public ResponseEntity<Product> create(@Valid @RequestBody Product product){
        Product myProduct = productRepository.save(product);
        URI productUri=URI.create("/products/"+myProduct.getId());

        return ResponseEntity.created(productUri).body(myProduct);
    }
    @GetMapping("all")
    public List<Product> fetchAll (){
        return productRepository.findAll();
    }
}
