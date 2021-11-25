package com.ecommerce.project.controller;

import com.ecommerce.project.entity.Category;
import com.ecommerce.project.service.CatTypeService;
import com.ecommerce.project.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private CatTypeService catTypeService;

    @GetMapping("/register")
    public String categoryRegister(@RequestParam(value = "message" ,required = false) String message,Model model)
    {
        commonUiMap(model);
        model.addAttribute("message",message);
        return "CategoryRegister";
    }
    @PostMapping("/save")
    public String saveCategory(@ModelAttribute Category category, Model model)
    {
        Integer catId=categoryService.saveCategory(category);
        model.addAttribute("message","category " +catId+ " saved");
      return "CategoryRegister";

    }
    @GetMapping("/all")
    public String getAllCategory(Model model)
    {
       List<Category> list=categoryService.getAll();
       model.addAttribute("list",list);
       return "CategoryData";
    }
    @GetMapping("/edit")
    public String editCategory(@RequestParam Integer catId, Model model)
    {
       Category category=categoryService.GetOneCategoryById(catId);
        model.addAttribute("category",category);
        return "CategoryUpdate";
    }
@PostMapping("/update")
    public String updateCategory(@ModelAttribute Category category, RedirectAttributes redirectAttributes)
{
    categoryService.saveCategory(category);
    redirectAttributes.addAttribute("message","category" +category.getCatId()+ "updated");
    return "redirect:all";


}
private void commonUiMap(Model model)
{
model.addAttribute("categoryTypes",catTypeService.getCatTypeIdAndName());

}
}
