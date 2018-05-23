package com.jiangpw.service;

import com.jiangpw.entity.Favor;
import com.jiangpw.mapper.FavorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("favorService")
public class FavorServiceImpl implements FavorService {

    @Autowired
    private FavorMapper favorMapper;

    @Override
    public void update(Favor favor) {
        favorMapper.updateByPrimaryKeySelective(favor);
    }

    @Override
    public Favor selectById(int id) {
        return favorMapper.selectByPrimaryKey(id);
    }
}
