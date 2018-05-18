package com.jiangpw.service;

import com.jiangpw.entity.*;
import com.jiangpw.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("noteService")
public class NoteServiceImpl implements NoteService {
    @Autowired
    private NoteMapper noteMapper;

    @Autowired
    private FavorMapper favorMapper;

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private ReviewMapper reviewMapper;

    @Autowired
    private ImgMapper imgMapper;

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ReplyMapper replyMapper;

    public List<Note> getListByCategory(int id) {
        return noteMapper.getNotes(id);
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

    public List<Category> getAllCategory() {
        return categoryMapper.selectByExample(null);
    }

    public void addFavor(Favor favor) {
        favorMapper.insert(favor);
    }

    public void addReview(Review review) {
        reviewMapper.insert(review);
    }

    public Favor selectLastFavor() {
        return favorMapper.selectLast();
    }

    public Review selectLastReview() {
        return reviewMapper.selectLast();
    }

    public Note selectLastNote() {
        return noteMapper.selectLast();
    }

    public void addImg(Img img) {
        imgMapper.insert(img);
    }

    public List<Img> getImgByNoteId(int noteId) {
        return imgMapper.selectAllImgByNoteId(noteId);
    }

    public List<Comment> getCommentByNoteId(int noteId) {
        return commentMapper.selectAllCommentByNoteId(noteId);
    }

    public User selectUserById(int userid) {
        return userMapper.selectByPrimaryKey(userid);
    }

    public List<Reply> getReplyByCommentId(int commentId) {
        return replyMapper.getReplyByCommentId(commentId);
    }

    public List<Note> getNotesByUserId(int userid) {
        return noteMapper.getNotesByUserId(userid);
    }
}
