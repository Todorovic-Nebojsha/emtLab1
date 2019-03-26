package com.example.lab1.web;

import com.example.lab1.models.Category;
import com.example.lab1.models.Manufacturer;
import com.example.lab1.models.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")

public class ProductController {
    private long counter;
    private List<Product> productList=null;
    private List<Manufacturer> manufacturerList=null;
    private List<Category> categoryList=null;

    @PostConstruct
    public void init(){
        counter=1l;
        productList=new ArrayList<>();
        manufacturerList=new ArrayList<>();
        categoryList=new ArrayList<>();

        categoryList.add(new Category(1,"Trainers"));
        categoryList.add(new Category(2,"Gloves"));
        categoryList.add(new Category(3,"Shirts"));
        categoryList.add(new Category(4,"Bikes"));

        manufacturerList.add(new Manufacturer(1,"Nike"));
        manufacturerList.add(new Manufacturer(2,"Adidas"));
        manufacturerList.add(new Manufacturer(3,"Puma"));
        manufacturerList.add(new Manufacturer(4,"Reebok"));
        manufacturerList.add(new Manufacturer(5,"KTM"));

        Product product=new Product();
        product.setId(counter);
        product.setName("Great trainers");
        product.setDescription("Great trainers with lowest price, come and buy today");
        product.setImageLink("https://images.sportsdirect.com/images/products/21179840_4pl.jpg");
        product.setCategory(categoryList.get(0));
        product.setManufacturer(manufacturerList.get(0));

        productList.add(product);
        counter++;

        product=new Product();
        product.setId(counter);
        product.setName("Great bike for offroad");
        product.setDescription("Great bike with lowest price, come and buy today and get additional 20% discount");
        product.setImageLink("data:image/jpeg;base64,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");
        product.setCategory(categoryList.get(3));
        product.setManufacturer(manufacturerList.get(4));
        counter++;

        productList.add(product);
    }

    @GetMapping("/products")
    public String products(Model model) {
        model.addAttribute("productList",productList);
        return "products";
    }

    @GetMapping("/products/add")
    public String addProduct(Model model) {
        model.addAttribute("categoryList",categoryList);
        model.addAttribute("manufacturerList",manufacturerList);
        return "addNewProduct";
    }
    @GetMapping("/product/{id}")
    public String productById(Model model, @PathVariable("id")long id)throws Exception{
        Product product=productList.stream().filter(i->i.getId()==id).findFirst().orElseThrow(()->new Exception("Product id is not ok"));
        model.addAttribute("product",product);
        return "productInfo";
    }
    @PostMapping("/product")
    public void addProduct(HttpServletRequest request, HttpServletResponse response, Model model)throws Exception {
        String name = request.getParameter("name");
        String description=request.getParameter("description");
        String manufacturer=request.getParameter("manufacturer");
        String category=request.getParameter("category");
        String imgLink=request.getParameter("imageLink");

        Manufacturer manufacturerObj=manufacturerList.stream()
                .filter(i->i.getName().equals(manufacturer)).findFirst()
                .orElseThrow(()->new Exception("Invalid manufacturer"));
        Category categoryObj=categoryList.stream()
                .filter(i->i.getName().equals(category)).findFirst()
                .orElseThrow(()->new Exception("Invalid category"));

        Product p=new Product();
        p.setImageLink(imgLink);
        p.setId(getNextId());
        p.setName(name);
        p.setDescription(description);
        p.setManufacturer(manufacturerObj);
        p.setCategory(categoryObj);

        productList.add(p);

        response.sendRedirect("http://localhost:8080/products");
    }

    public long getNextId(){
        return counter++;
    }
}
