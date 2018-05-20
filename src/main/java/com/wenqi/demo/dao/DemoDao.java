package com.wenqi.demo.dao;

import com.wenqi.demo.domain.Area;
import com.wenqi.demo.domain.Demo;

import java.util.List;
import java.util.Map;

public interface DemoDao {
//    List<Area> getAll();
//
//    Integer save(Area area);
//
//    Integer update(Area area);
//
//    Integer delete(Integer id);

    Map<String,Object> getById(Integer id);

    Demo getDemoById(Integer id);

    List<Map> getByOther(String other);

    Map<String,String> getMapById(Integer id);
}
