package com.jiangpw.service;

import com.jiangpw.entity.Category;
import com.jiangpw.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    public List<Category> getAll() {
        return categoryMapper.selectByExample(null);
    }
}
