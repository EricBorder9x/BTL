    package com.runningman.controller.client;

import com.runningman.service.ProductCategoryService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.runningman.service.ProductService;

@Controller
@RequestMapping(value = "/client")
public class HomeClientController {

    @Autowired
    private ProductService productService;
    
    @Autowired
    private ProductCategoryService categoryService;

    /*
	* @RequestMapping(value = "/home", method = RequestMethod.GET) public
	* ModelAndView homePage() { ModelAndView mav = new ModelAndView("client/home");
	* return mav; }
     */
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String hotProducts(HttpServletRequest request, HttpSession session) {
        request.setAttribute("hotOne", productService.hotProducts(0, 11));
//        request.setAttribute("featuredOne", productService.featuredProducts(0, 4));
        session.setAttribute("categories", categoryService.findAll());
        return "/client/home";
    }

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public String showInfo(){
        return "/client/info";
    }
}
