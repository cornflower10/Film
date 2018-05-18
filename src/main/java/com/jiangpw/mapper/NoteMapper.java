package com.jiangpw.mapper;

import com.jiangpw.entity.Note;
import com.jiangpw.entity.NoteExample;

import java.util.List;

public interface NoteMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Note record);

    int insertSelective(Note record);

    List<Note> selectByExampleWithBLOBs(NoteExample example);

    List<Note> selectByExample(NoteExample example);

    Note selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Note record);

    int updateByPrimaryKeyWithBLOBs(Note record);

    int updateByPrimaryKey(Note record);

    List<Note> getNotes(int id);

    Note selectLast();

    List<Note> getNotesByUserId(int userid);
}