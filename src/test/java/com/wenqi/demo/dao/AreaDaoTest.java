package com.wenqi.demo.dao;

import com.wenqi.demo.domain.Area;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaDaoTest {

    @Autowired
    private AreaDao areaDao;
    @Test
    public void getAll() {
        List<Area> list=areaDao.getAll();
        assertEquals(2,list.size());
    }

    @Test
    public void getById() {
        Area area = areaDao.getById(1);
        assertEquals("东街",area.getAreaName());
    }

    @Test
    public void save() {
        Area area=new Area();
        area.setAreaName("南街");
        area.setAreaPriority(3);
        Integer i = areaDao.save(area);
        assertEquals(1,i.intValue());
    }

    @Test
    public void update() {
        Area area=new Area();
        area.setAreaId(3);
        area.setAreaName("北街");
        area.setAreaPriority(3);
        Integer i = areaDao.update(area);
        assertEquals(1,i.intValue());
    }

    @Test
    public void delete() {
        Area area=new Area();
//        area.setAreaId(3);
        Integer i = areaDao.delete(3);
        assertEquals(1,i.intValue());
    }
}