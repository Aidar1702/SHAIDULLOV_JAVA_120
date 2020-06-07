package ru.itis.web.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import ru.itis.web.models.Cart;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

@Component
public class CartRepositoryJdbcTemplateImpl implements CartRepository {

    //language=SQL
    private static final String SQL_FIND_ALL_BY_OWNER_ID = "select * from cart where owner_id = ?;";

    //language=SQL
    private static final String SQL_INSERT_CART = "insert into cart(owner_id) values (?)";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<Cart> productRowMapper = (row, rowNumber) -> Cart.builder()
            .id(row.getLong("id"))
            .build();

    @Override
    public List<Cart> findAllByUser_Id(Long userId) {
        return jdbcTemplate.query(SQL_FIND_ALL_BY_OWNER_ID, productRowMapper, userId);
    }

    @Override
    public Optional<Cart> findOneById(Long id) {
        return Optional.empty();
    }

    @Override
    public Cart save(Cart model) {

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(con -> {
            PreparedStatement statement = con.prepareStatement(SQL_INSERT_CART, new String[]{"id"});
            statement.setLong(3, model.getOwner().getId());
            return statement;
        }, keyHolder);

        model.setId(keyHolder.getKey().longValue());
        return model;
    }

    @Override
    public void update(Cart model) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Cart> findAll() {
        return null;
    }
}
