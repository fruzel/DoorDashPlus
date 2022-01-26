package com.example.onlineOrder.controller;

import com.example.onlineOrder.entity.Cart;
import com.example.onlineOrder.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class CartController {

    @Autowired
    private CartService cartService;

    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    @ResponseBody
    public Cart getCart(){
        return cartService.getCart();
    }

    @RequestMapping(value = "/cart/remove/{menuId}", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public void removeMenuItemFromCart(@PathVariable int menuId) {
        cartService.removeItem(menuId);
    }

}
