package com.jiangpw.mapper;

import com.jiangpw.entity.Img;
import com.jiangpw.entity.ImgExample;

import java.util.List;

public interface ImgMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Img record);

    int insertSelective(Img record);

    List<Img> selectByExample(ImgExample example);

    Img selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Img record);

    int updateByPrimaryKey(Img record);

    List<Img> selectAllImgByNoteId(int noteId);
}