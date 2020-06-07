package ru.itis.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.web.dto.CartForm;
import ru.itis.web.models.Cart;
import ru.itis.web.services.CartService;

import java.util.List;

@Controller
public class CartController {
    @Autowired
    private CartService cartService;

    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public ModelAndView getProductPage(@RequestParam("user") Long userId) {
        ModelAndView modelAndView = new ModelAndView("cart");
        List<Cart> carts = cartService.getProductsByUserId(userId);
        modelAndView.addObject("cart", carts);
        modelAndView.addObject("userId", userId);
        return modelAndView;
    }

    @RequestMapping(value = "/cart", method = RequestMethod.POST,
    produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public List<Cart> addProductToUser(@RequestParam("user") Long userId,
                                       @RequestBody CartForm form) {
        cartService.addProductToUser(userId, form);
        return cartService.getProductsByUserId(userId);
    }
}
