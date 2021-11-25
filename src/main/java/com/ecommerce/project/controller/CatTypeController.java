package com.ecommerce.project.controller;

import com.ecommerce.project.entity.CategoryType;
import com.ecommerce.project.service.CatTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/catType")
public class CatTypeController {
    @Autowired
    private CatTypeService catTypeService;
    @GetMapping("/register")
    public String catTypeRegister()
    {

        return "CatTypeRegister";
    }
    @PostMapping("/save")
    public String saveCatType(@ModelAttribute CategoryType categoryType, Model model)
    {

        Integer id=catTypeService.saveCatType(categoryType);
        model.addAttribute("message","category type " +id+"  is saved");
        return "CatTypeRegister";
    }
    @GetMapping("/all")
    public String getAllCatType(Model model)
    {
      List<CategoryType> list= catTypeService.getAllCatType();
       model.addAttribute("list",list);
       return "CatTypeData";

    }
    @GetMapping("/getOneById")
    public String getOneCatType(@RequestParam Integer catTypeId,Model model)
    {
      catTypeService.getOneCatTypeById(catTypeId);
      return "CatTypeData";

    }
    @GetMapping("/edit")
    public String editCatType(@RequestParam Integer catTypeId,Model model,RedirectAttributes redirectAttributes)
    {
     CategoryType categoryType=catTypeService.getOneCatTypeById(catTypeId);
     model.addAttribute("catType",categoryType);
     return "EditCatType";

    }
    @PostMapping("/update")
    public String updateCatTypeById(@ModelAttribute CategoryType categoryType,RedirectAttributes redirectAttributes)
    {
      catTypeService.updateCatType(categoryType);
      redirectAttributes.addAttribute("message","catType " + categoryType.getCatType()+" updated successfully");
      return "redirect:all";

    }
    @GetMapping("/delete")
    public String deleteById(@RequestParam Integer catTypeId, RedirectAttributes redirectAttributes)
    {
        catTypeService.deleteCatType(catTypeId);
       redirectAttributes.addAttribute("message","category type " +catTypeId+ " is deleted");
        return "redirect:all";

    }

}
