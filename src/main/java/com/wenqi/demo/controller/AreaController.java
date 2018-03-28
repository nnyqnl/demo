package com.wenqi.demo.controller;

import com.wenqi.demo.domain.Area;
import com.wenqi.demo.dto.ResultModel;
import com.wenqi.demo.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/area")
public class AreaController {
    @Autowired
    private AreaService areaService;
    @GetMapping("/getAll")
    public ResultModel getAll(){
        ResultModel ResultModel=new ResultModel();
        List<Area> areas=areaService.getAll();
        ResultModel.setCode("000");
        ResultModel.setMsg("成功");
        ResultModel.setData(areas);
        return ResultModel;
    }
    @GetMapping("/getById")
    public ResultModel getById(@RequestParam Integer areaId){
        ResultModel ResultModel=new ResultModel();
        Area area=areaService.getById(areaId);
        ResultModel.setCode("000");
        ResultModel.setMsg("成功");
        ResultModel.setData(area);
        return ResultModel;
    }
    @PostMapping("/insert")
    public ResultModel insert(@RequestBody Area area){
        ResultModel ResultModel=new ResultModel();
        areaService.save(area);
        ResultModel.setCode("000");
        ResultModel.setMsg("成功");

        return ResultModel;
    }
    @PostMapping("/update")
    public ResultModel update(@RequestBody Area area){
        ResultModel ResultModel=new ResultModel();
        areaService.update(area);
        ResultModel.setCode("000");
        ResultModel.setMsg("成功");
        return ResultModel;
    }
    @PostMapping("/delete")
    public ResultModel delete(@RequestBody Area area){
        ResultModel ResultModel=new ResultModel();
        areaService.delete(area.getAreaId());
        ResultModel.setCode("000");
        ResultModel.setMsg("成功");
        return ResultModel;
    }
}
