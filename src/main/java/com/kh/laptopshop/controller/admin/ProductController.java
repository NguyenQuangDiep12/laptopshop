package com.kh.laptopshop.controller.admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kh.laptopshop.domain.Products;
import com.kh.laptopshop.service.ProductService;
import com.kh.laptopshop.service.UploadService;

import jakarta.validation.Valid;

@Controller
public class ProductController {

    private final ProductService productService;
    private final UploadService uploadService;

    public ProductController(ProductService productService, UploadService uploadService) {
        this.productService = productService;
        this.uploadService = uploadService;
    }

    @GetMapping("/admin/product")
    public String getProductPage(Model model) {
        List<Products> products = this.productService.getAllProduct();
        model.addAttribute("products", products);
        return "admin/product/table-product";
    }

    // detail
    @GetMapping("/admin/product/{id}")
    public String getProductDetailPage(Model model, @PathVariable Long id) {
        Products product = this.productService.getProductById(id);
        model.addAttribute("product", product);
        model.addAttribute("id", id);
        return "admin/product/product-detail";
    }

    // create product
    @GetMapping("/admin/product/create")
    public String getCreateProductPage(Model model) {
        model.addAttribute("newProduct", new Products());
        return "admin/product/create";
    }

    @PostMapping("/admin/product/create")
    public String createProductPage(
            @ModelAttribute("newProduct") @Valid Products products,
            BindingResult newBindingResult,
            @RequestParam("ImageFile") MultipartFile file) {

        // validate
        if (newBindingResult.hasErrors()) {
            return "admin/product/create";
        }
        String productFile = this.uploadService.handleSaveUploadFile(file, "product");
        products.setImage(productFile);
        productService.handleSaveProduct(products);
        return "redirect:/admin/product";
    }

    // update product
    @GetMapping("/admin/product/update/{id}")
    public String getUpdateProductPage(Model model, @PathVariable Long id) {
        Products currentProduct = this.productService.getProductById(id);
        model.addAttribute("id", id);
        model.addAttribute("newProduct", currentProduct);
        return "admin/product/update";
    }

    @PostMapping("/admin/product/update")
    public String UpdateProductPage(Model model, @ModelAttribute("newProduct") Products products) {
        Products currentProduct = this.productService.getProductById(products.getId());
        if (currentProduct != null) {
            currentProduct.setName(products.getName());
            currentProduct.setPrice(products.getPrice());
            currentProduct.setDetailDesc(products.getDetailDesc());
            currentProduct.setShortDesc(products.getShortDesc());
            currentProduct.setQuantity(products.getQuantity());
        }
        this.productService.handleSaveProduct(currentProduct);
        return "redirect:/admin/product";
    }

    // delete

    @GetMapping("/admin/product/delete/{id}")
    public String getDeleteProductPage(Model model, @PathVariable Long id) {
        Products product = this.productService.getProductById(id);
        model.addAttribute("newProduct", product);
        return "admin/product/delete";
    }

    @PostMapping("/admin/product/delete")
    public String deleteProductPage(Model model, @ModelAttribute("newProduct") Products products) {
        this.productService.deleteProductById(products.getId());
        return "redirect:/admin/product";
    }

}