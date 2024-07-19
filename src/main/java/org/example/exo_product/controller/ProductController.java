package org.example.exo_product.controller;

import org.example.exo_product.model.Product;
import org.example.exo_product.service.ProductService;
import org.example.exo_product.util.ProductType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

@Controller
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String index() {
        return "home";
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<Product> allProducts = productService.getProducts();
        model.addAttribute("products", allProducts);
        return "productList";
    }

    @GetMapping("/detail/{uuid}")
    public String detail(@PathVariable UUID uuid, Model model) {
        Product product = productService.getProduct(uuid);
        model.addAttribute("product", product);
        return "detail";
    }

    @GetMapping("/search")
    public String search (@RequestParam("cat") String cat, @RequestParam("priceMax") double price, Model model) {  //
        ProductType catProductType;
        switch (cat){
            case "vetement" -> catProductType = ProductType.CLOTHE;
            case "nourriture" -> catProductType = ProductType.FOOD;
            case "livre" -> catProductType = ProductType.BOOK;
            default -> {return "home";}
        }


        List<Product> filteredProducts = productService.getProductsByTypeAndPrice(catProductType, price);
        model.addAttribute("products", filteredProducts);
        return "productList";
    }


}
