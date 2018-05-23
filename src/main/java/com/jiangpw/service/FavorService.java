package com.jiangpw.service;

import com.jiangpw.entity.Favor;

public interface FavorService {
    void update(Favor favor);

    Favor selectById(int id);
}
