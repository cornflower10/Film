package com.jiangpw.controller;

import com.jiangpw.entity.*;
import com.jiangpw.service.NoteService;
import com.jiangpw.utils.Constants;
import com.jiangpw.utils.SessionUtil;
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

    @RequestMapping("/noteDetail")
    public String noteDetail(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String userid = request.getParameter("userid");
        List<Img> imgs = noteService.getImgByNoteId(Integer.parseInt(id));
        request.setAttribute("imgs", imgs);

        List<Comment> comments = noteService.getCommentByNoteId(Integer.parseInt(id));
        request.setAttribute("comments", comments);

        if (null != comments && comments.size() > 0) {
            for (Comment c :
                    comments) {
                if (null != noteService.getReplyByCommentId(c.getId()) && noteService.getReplyByCommentId(c.getId()).size() > 0) {
                    c.getReplies().addAll(noteService.getReplyByCommentId(c.getId()));
                }
            }
        }

        List<Note> notes = noteService.getNotesByUserId(Integer.parseInt(userid));
        request.setAttribute("notes", notes);

        User user = noteService.selectUserById(Integer.parseInt(userid));
        request.setAttribute("user", user);

        Note note = noteService.selectNote(Integer.parseInt(id));
        request.setAttribute("note", note);
        return "noteDetail";
    }

    @RequestMapping(value = "/addNote", method = RequestMethod.POST)
    @ResponseBody
    public BaseResult<String> addNote(MultipartFile file, HttpServletRequest request) {

        String categoryId = request.getParameter("categoryid");
        String content = request.getParameter("content");

        Favor favor = new Favor();
        favor.setLikecount(0);
        favor.setUnlikecount(0);
        noteService.addFavor(favor);

        Review review = new Review();
        review.setStatus(0);
        noteService.addReview(review);

        Note note = new Note();

        note.setCategoryid(Integer.valueOf(categoryId));
        note.setContent(content);
        User user = (User) SessionUtil.getSessionAttribute(request, Constants.SESSION_KEY);
        note.setUserid(user.getId());
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
        baseResult.setSuccess(true);

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

    @RequestMapping("/getFavorId")
    @ResponseBody
    public BaseResult<String> getFavorId(HttpServletRequest request, HttpServletResponse response) {
        int noteId = Integer.parseInt(request.getParameter("noteId"));

        int favorId = noteService.selectNote(noteId).getFavorid();

        BaseResult<String> baseResult = new BaseResult<String>();
        baseResult.setCode("0");
        baseResult.setMsg("OK");
        baseResult.setData("" + favorId);
        baseResult.setSuccess(true);

        return baseResult;
    }
}
