package com.rev.app.service;

import com.rev.app.entity.Favorite;

import java.util.List;

public interface IFavoriteService {
    Favorite addFavorite(Integer userId, Integer productId);
    void removeFavorite(Integer userId, Integer productId);
    List<Favorite> getUserFavorites(Integer userId);
}


