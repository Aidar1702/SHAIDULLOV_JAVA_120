package ru.itis.web.repositories;

import ru.itis.web.models.Cart;

import java.util.List;

public interface CartRepository extends CrudRepository<Cart> {
    List<Cart> findAllByUser_Id(Long userId);
}
