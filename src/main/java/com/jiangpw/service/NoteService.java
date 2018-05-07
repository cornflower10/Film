package com.jiangpw.service;

import com.jiangpw.entity.Like;
import com.jiangpw.entity.Note;

import java.util.List;

public interface NoteService {
    List<Note> getList();

    void add(Note note);

    void like(Like like);

    void detail(int id);
}
