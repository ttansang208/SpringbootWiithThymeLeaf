package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springboot.entity.ProductEntity;
import com.springboot.exception.ProductNotFoundException;
import com.springboot.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductService productService;

	@GetMapping
	public String productsLsit(Model model) {
		List<ProductEntity> prodList = productService.findAll();
		model.addAttribute("prodList", prodList);
		model.addAttribute("pageTitle", "List of product");
		return "productsList";
	}

	@GetMapping("/createform")
	public String createNeW(Model model) {
		model.addAttribute("product", new ProductEntity());
		model.addAttribute("pageTitle", "Add new product");
		return "create_form";
	}

	@PostMapping("/save")
	public String saveProduct(ProductEntity product, RedirectAttributes ra) {
		productService.save(product);
		ra.addFlashAttribute("message", "Created successfully !");
		return "redirect:/product";
	}

	@GetMapping("/edit/{id}")
	public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
		try {
			ProductEntity product = productService.getById(id);
			model.addAttribute("product", product);
			model.addAttribute("pageTitle", "Edit product ID " + id);
			ra.addFlashAttribute("message", "Updated successfully !");
			return "create_form";

		} catch (ProductNotFoundException e) {
			ra.addFlashAttribute("message", e.getMessage());
			return "redirect:/product";
		}
	}

	@GetMapping("/delete/{id}")
	public String deleteProduct(@PathVariable("id") Integer id, RedirectAttributes ra) {
		try {
			productService.deleteById(id);
			ra.addFlashAttribute("message", "Deleted successfully product with ID "+id+ "!");
		} catch (Exception e) {
			ra.addFlashAttribute("message", e.getMessage());
		}
		return "redirect:/product";
	}
}
