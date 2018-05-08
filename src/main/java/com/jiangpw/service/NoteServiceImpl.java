package com.jiangpw.service;

import com.jiangpw.entity.Favor;
import com.jiangpw.entity.Note;
import com.jiangpw.mapper.FavorMapper;
import com.jiangpw.mapper.NoteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("noteService")
public class NoteServiceImpl implements NoteService {
    @Autowired
    private NoteMapper noteMapper;

    @Autowired
    private FavorMapper favorMapper;

    public List<Note> getList() {
        return noteMapper.getNotes();
    }

    public void add(Note note) {
        noteMapper.insertSelective(note);
    }

    public void favor(Favor favor) {
        favorMapper.insertSelective(favor);
    }

    public void detail(int id) {
        noteMapper.selectByPrimaryKey(id);
    }
}
