package com.wenqi.demo.service.impl;

import com.wenqi.demo.dao.AppUpdateDao;
import com.wenqi.demo.service.AppUpdateService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 *
 */
@Service
public class AppUpdateByVersionService implements AppUpdateService {

    @Autowired
    private AppUpdateDao appUpdateDao;
    @Override
    public String updateApp(Map map) {
        String update=appUpdateDao.searchIsUpdate(map);
        if(StringUtils.isEmpty(update)){
            return "N";
        }
        return "Y";
    }
}
