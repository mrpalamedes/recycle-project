package com.project.demo.repository;

import com.project.demo.entity.Cart;
import com.project.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
    List<Cart> deleteByUser(User user);
    List<Cart> findAllByUserOrderByCreatedDateDesc(User user);

}
