package sk.cyklosoft.cykloservice.web.impl;

import java.util.Locale;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import sk.cyklosoft.cykloservice.config.annotation.WebController;

@WebController
@RequestMapping("/user")
public class UserController {
	
	@RequestMapping(value = "", method = RequestMethod.GET)
    public String getView(Model model, Locale locale) {
        return "userIndexView";
    }


}
