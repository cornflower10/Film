package com.jiangpw.service;

import com.jiangpw.entity.Favor;
import com.jiangpw.entity.Note;

import java.util.List;

public interface NoteService {
    List<Note> getList();

    void add(Note note);

    void favor(Favor like);

    void detail(int id);
}
