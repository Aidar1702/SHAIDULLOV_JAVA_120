package ru.itis.web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.web.dto.CartForm;
import ru.itis.web.models.Cart;
import ru.itis.web.models.User;
import ru.itis.web.repositories.CartRepository;

import java.util.List;

@Component
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Override
    public List<Cart> getProductsByUserId(Long userId) {
        return cartRepository.findAllByUser_Id(userId);
    }

    @Override
    public void addProductToUser(Long userId, CartForm form) {
        Cart cart = Cart.builder()
                .owner(User.builder().id(userId).build())
                .build();
        cartRepository.save(cart);
    }
}
