package vn.hdoan.laptopshop.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import vn.hdoan.laptopshop.domain.Product;
import vn.hdoan.laptopshop.service.ProductService;

import java.util.List;

@Controller
public class HomePageController {

    private final ProductService productService;

    public HomePageController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/")
    public String getHomePage(Model model){
        List<Product> products = this.productService.fetchProducts();
        model.addAttribute("products", products);
        return "client/homepage/show";
    }

}
