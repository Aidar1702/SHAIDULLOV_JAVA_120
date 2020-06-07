package ru.itis.web.services;

import ru.itis.web.dto.CartForm;
import ru.itis.web.models.Cart;

import java.util.List;

public interface CartService {
    List<Cart> getProductsByUserId(Long userId);

    void addProductToUser(Long userId, CartForm form);
}
