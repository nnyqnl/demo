package com.wenqi.demo.dao;

import com.wenqi.demo.domain.Area;
import org.apache.ibatis.annotations.Delete;

import java.util.List;

public interface AreaDao {
    List<Area> getAll();

    Area getById(Integer id);

    Integer save(Area area);

    Integer update(Area area);

    Integer delete(Integer id);
}
