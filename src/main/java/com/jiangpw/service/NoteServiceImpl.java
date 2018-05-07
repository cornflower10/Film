package com.jiangpw.service;

import com.jiangpw.entity.Like;
import com.jiangpw.entity.Note;
import com.jiangpw.entity.NoteExample;
import com.jiangpw.mapper.LikeMapper;
import com.jiangpw.mapper.NoteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("noteService")
public class NoteServiceImpl implements NoteService {
    @Autowired
    private NoteMapper noteMapper;

    @Autowired
    private LikeMapper likeMapper;

    public List<Note> getList() {
        NoteExample noteExample = new NoteExample();
        NoteExample.Criteria criteria = noteExample.createCriteria();
        noteExample.setOrderByClause("id desc");
        return noteMapper.selectByExample(noteExample);
    }

    public void add(Note note) {
        noteMapper.insertSelective(note);
    }

    public void like(Like like) {
        likeMapper.insertSelective(like);
    }

    public void detail(int id) {
        noteMapper.selectByPrimaryKey(id);
    }
}
