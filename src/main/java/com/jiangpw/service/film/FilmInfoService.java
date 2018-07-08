package com.jiangpw.service.film;

import com.jiangpw.entity.BaseResult;
import com.jiangpw.entity.film.DBDataPram;
import com.jiangpw.entity.film.Info;

public interface FilmInfoService {
    Info findById(int id);

    void addInfo(Info info);

    BaseResult<String> getDataFromDouBan(DBDataPram dbDataPram);

}
