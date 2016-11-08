package sk.cyklosoft.cykloservice.web.impl;

import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import sk.cyklosoft.cykloservice.config.annotation.WebController;

@WebController
@RequestMapping("/admin")
public class AdminController {
    

    
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getView(Model model, Locale locale) {
        // model.addAttribute("userList", userManager.findAllUsers());
        // model.addAttribute("confirm", messageSource.getMessage("delete.confirm", null, locale));
        //model.addAttribute("wholeName", userService.getWholeNameByUsername(AppHelper.getUsername()));
        //model.addAttribute("categoryList", productService.findAllCategories());
        return "adminRoleView";
    }
    
    
}
