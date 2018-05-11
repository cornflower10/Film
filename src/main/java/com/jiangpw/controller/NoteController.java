package com.jiangpw.controller;

import com.jiangpw.entity.*;
import com.jiangpw.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

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

    @RequestMapping("/indexAddNote")
    public String indexAddNote(HttpServletRequest request, HttpServletResponse response) {
        List<Category> categories;
        categories = noteService.getAllCategory();
        request.setAttribute("categories", categories);
        return "indexAddNote";
    }

    @RequestMapping(value = "/addNote", method = RequestMethod.POST)
    @ResponseBody
    public BaseResult<String> addNote(MultipartFile file, HttpServletRequest request) {

        String categoryId = request.getParameter("categoryid");
        String content = request.getParameter("content");

        Favor favor = new Favor();
        favor.setLikecount(1000);
        favor.setUnlikecount(8);
        noteService.addFavor(favor);

        Review review = new Review();
        review.setStatus(0);
        noteService.addReview(review);

        Note note = new Note();

        note.setCategoryid(Integer.valueOf(categoryId));
        note.setContent(content);
        note.setUserid(1);
        note.setFavorid(noteService.selectLastFavor().getId());
        note.setReviewid(noteService.selectLastReview().getId());

        noteService.add(note);

        BaseResult<String> baseResult = new BaseResult<String>();
        baseResult.setCode("0");
        baseResult.setMsg("OK");
        baseResult.setData(noteService.selectLastNote().getId() + "");

        return baseResult;
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public BaseResult<String> upload(MultipartFile file, HttpServletRequest request) {

        int noteId = Integer.parseInt(request.getParameter("noteId"));
        String path = request.getSession().getServletContext().getRealPath("upload");
        String fileName = UUID.randomUUID().toString() + ".png";

        File dir = new File(path, fileName);

        if (!dir.exists()) {
            dir.mkdirs();
        }

        try {
            file.transferTo(dir);

            Img img = new Img();
            img.setUrl("http://localhost:8080" + "/upload/" + fileName);
            img.setNoteid(noteId);

            noteService.addImg(img);
        } catch (IOException e) {
            e.printStackTrace();
        }

        BaseResult<String> baseResult = new BaseResult<String>();
        baseResult.setCode("0");
        baseResult.setMsg("OK");
        baseResult.setData("");

        return baseResult;
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
