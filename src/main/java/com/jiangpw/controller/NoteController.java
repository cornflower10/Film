package com.jiangpw.controller;

import com.jiangpw.entity.Note;
import com.jiangpw.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/note")
public class NoteController {
    @Autowired
    private NoteService noteService;

    @RequestMapping("/indexNote")
    public String indexNote(HttpServletRequest request, HttpServletResponse response) {
        List<Note> notes = noteService.getList();
        if (notes.size() == 0) {
            request.setAttribute("message", "没有数据");
        } else {
            request.setAttribute("notes", notes);
        }

        return "indexNote";
    }

    @RequestMapping("/addNote")
    public String addNote(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }

    @RequestMapping("/likeNote")
    public String likeNote(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }

    @RequestMapping("detailNote")
    public String detailNote(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }
}
