package com.rev.app.repository;

import com.rev.app.entity.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IFavoriteRepository extends JpaRepository<Favorite, Integer> {
    List<Favorite> findByUserUserId(Integer userId);
    List<Favorite> findByProductProductId(Integer productId);
}


