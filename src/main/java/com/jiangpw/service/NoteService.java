package com.jiangpw.service;

import com.jiangpw.entity.*;

import java.util.List;

public interface NoteService {
    List<Note> getListByCategory(int id);

    void add(Note note);

    void favor(Favor favor);

    void detail(int id);

    List<Category> getAllCategory();

    void addFavor(Favor favor);

    void addReview(Review review);

    Favor selectLastFavor();

    Review selectLastReview();

    Note selectLastNote();

    void addImg(Img img);
}
