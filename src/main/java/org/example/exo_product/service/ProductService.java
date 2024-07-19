package org.example.exo_product.service;


import org.example.exo_product.model.Product;
import org.example.exo_product.util.ProductType;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class ProductService {

    Map<UUID, Product> products;

    public ProductService() {
        this.products = new HashMap<>();
        UUID uuid1 = UUID.randomUUID();
        UUID uuid2 = UUID.randomUUID();
        UUID uuid3 = UUID.randomUUID();
        UUID uuid4 = UUID.randomUUID();
        UUID uuid5 = UUID.randomUUID();

        products.put(uuid1, new Product(uuid1, "jeans", ProductType.CLOTHE, 79.99));
        products.put(uuid2, new Product(uuid2, "débardeur", ProductType.CLOTHE, 19.99));
        products.put(uuid3, new Product(uuid3, "Bible", ProductType.BOOK, 25));
        products.put(uuid4, new Product(uuid4, "Bible2", ProductType.BOOK, 30));
        products.put(uuid5, new Product(uuid5, "poulet", ProductType.FOOD, 4));

        System.out.println("uuid1: " + uuid1);
        System.out.println("uuid2: " + uuid2);
        System.out.println("uuid3: " + uuid3);
        System.out.println("uuid4: " + uuid4);
        System.out.println("uuid5: " + uuid5);
    }

    public List<Product> getProducts() {
        return products.values().stream().toList();
    }

    public Product getProduct(UUID uuid) {
        return products.get(uuid);
    }

    public List<Product> getProductsByTypeAndPrice(ProductType ProductType, double price) {
        return products.values().stream().filter(c -> c.getCategory().equals(ProductType)).filter(c -> c.getPrice() <= price).toList();
    }
}
