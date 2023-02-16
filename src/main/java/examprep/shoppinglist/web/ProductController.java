package examprep.shoppinglist.web;

import examprep.shoppinglist.domain.models.ProductModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products")
public class ProductController {

    @GetMapping("/add")
    public String getAddProduct(){
        return "product-add";
    }

    @PostMapping("/add")
        public String addProduct(ProductModel model){
        return "redirect:/home";
    }
}
