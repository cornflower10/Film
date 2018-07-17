package com.jiangpw.service.film;

import com.jiangpw.entity.BaseResult;
import com.jiangpw.entity.film.DBDataPram;
import com.jiangpw.entity.film.DouBan;
import com.jiangpw.entity.film.Info;
import com.jiangpw.filmDao.FilmInfoMapper;
import com.jiangpw.utils.HttpUtils;
import com.jiangpw.utils.JsonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("filmInfoService")
public class FilmInfoServiceImpl implements FilmInfoService{
    private static final String DOU_BAN_URL = "https://movie.douban.com/j/search_subjects";
    @Autowired
    private FilmInfoMapper infoMapper;

    public Info findById(int id) {
        return null;
    }

    public void addInfo(Info info) {
        infoMapper.insert(info);
    }

    public synchronized BaseResult<String> getDataFromDouBan(DBDataPram dbDataPram) {

        Map<String,String> parameters=new HashMap<String,String>();
        parameters.put("sort", dbDataPram.getSort());
        parameters.put("type", dbDataPram.getType());
        parameters.put("tag", dbDataPram.getTag());
        parameters.put("page_limit", String.valueOf(dbDataPram.getPage_limit()));
        parameters.put("page_start", String.valueOf(dbDataPram.getPage_start()));
       String result =  HttpUtils.sendPost(DOU_BAN_URL,parameters,true);
//       System.out.println(result);
//        ObjectMapper mapper = new ObjectMapper();
//        mapper.readValue(result,);
        JsonMapper jsonMapper = new JsonMapper();
        DouBan douBan = jsonMapper.fromJson(result, DouBan.class);
        List<Info> list =new ArrayList<Info>();
        for (DouBan.SubjectsBean bean:douBan.getSubjects()) {
            Info info =new Info();
            info.setTitle(bean.getTitle());
            info.setCover(bean.getCover());
            info.setCover_x(String.valueOf(bean.getCover_x()));
            info.setCover_y(String.valueOf(bean.getCover_y()));
            info.setDouban_id(Integer.parseInt(bean.getId()));
            info.setRate(bean.getRate());
            info.setUrl(bean.getUrl());
            list.add(info);
        }
        if(list.size()>0)
          infoMapper.insertList(list);

        return new BaseResult<String>("success");
    }

    public List<Info> selectByRate(String rate) {
        return infoMapper.selectByRate(rate);
    }
}
