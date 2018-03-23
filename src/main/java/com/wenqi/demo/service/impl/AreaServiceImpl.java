package com.wenqi.demo.service.impl;

import com.wenqi.demo.dao.AreaDao;
import com.wenqi.demo.domain.Area;
import com.wenqi.demo.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AreaServiceImpl implements AreaService {
    @Autowired
    private AreaDao areaDao;
    @Override
    public List<Area> getAll() {
        List<Area> areas = areaDao.getAll();
        return areas;
    }

    @Override
    public Area getById(Integer id) {
        return areaDao.getById(id);
    }

    @Override
    public void save(Area area) {
        areaDao.save(area);
    }

    @Override
    public void update(Area area) {
        areaDao.update(area);
    }

    @Override
    public void delete(Integer id) {
        areaDao.delete(id);
    }
}
