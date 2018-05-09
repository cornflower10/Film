package com.jiangpw.controller;

import com.jiangpw.entity.Note;
import com.jiangpw.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/note")
public class NoteController {
    @Autowired
    private NoteService noteService;

    private final static String[] CATEGORY = {"fashion", "makeups", "food", "movement", "video", "travel", "beauty", "reading"};

    @RequestMapping("/indexNote")
    public String indexNote(HttpServletRequest request, HttpServletResponse response) {
        List<Note> notes;

        notes = noteService.getListByCategory(1);

        request.setAttribute("categorys", CATEGORY);
        request.setAttribute("notes", notes);

        return "indexNote";
    }

    @RequestMapping("/getNotesByCategory")
    @ResponseBody
    public List<Note> getNotesByCategory(HttpServletRequest request, HttpServletResponse response) {
        List<Note> notes;
        if (null == request.getParameter("id")) {
            notes = noteService.getListByCategory(1);
        } else {
            notes = noteService.getListByCategory(Integer.parseInt(request.getParameter("id")));
        }
        return notes;
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
