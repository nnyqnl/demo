package com.wenqi.demo.service;

import com.wenqi.demo.domain.Area;

import java.util.List;

public interface AreaService {
    List<Area> getAll();

    Area getById(Integer id);

    void save(Area area);

    void update(Area area);

    void delete(Integer id);
}
