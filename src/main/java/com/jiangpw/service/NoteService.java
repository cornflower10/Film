package com.jiangpw.service;

import com.jiangpw.entity.Favor;
import com.jiangpw.entity.Note;

import java.util.List;

public interface NoteService {
    List<Note> getListByCategory(int id);

    void add(Note note);

    void favor(Favor favor);

    void detail(int id);
}
