package com.wenqi.demo.controller;

import com.wenqi.demo.domain.Area;
import com.wenqi.demo.dto.ResultDto;
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
    public ResultDto getAll(){
        ResultDto resultDto=new ResultDto();
        List<Area> areas=areaService.getAll();
        resultDto.setCode("000");
        resultDto.setMsg("成功");
        resultDto.setData(areas);
        return resultDto;
    }
    @GetMapping("/getById")
    public ResultDto getById(@RequestParam Integer areaId){
        ResultDto resultDto=new ResultDto();
        Area area=areaService.getById(areaId);
        resultDto.setCode("000");
        resultDto.setMsg("成功");
        resultDto.setData(area);
        return resultDto;
    }
    @PostMapping("/insert")
    public ResultDto insert(@RequestBody Area area){
        ResultDto resultDto=new ResultDto();
        areaService.save(area);
        resultDto.setCode("000");
        resultDto.setMsg("成功");

        return resultDto;
    }
    @PostMapping("/update")
    public ResultDto update(@RequestBody Area area){
        ResultDto resultDto=new ResultDto();
        areaService.update(area);
        resultDto.setCode("000");
        resultDto.setMsg("成功");
        return resultDto;
    }
    @PostMapping("/delete")
    public ResultDto delete(@RequestBody Area area){
        ResultDto resultDto=new ResultDto();
        areaService.delete(area.getAreaId());
        resultDto.setCode("000");
        resultDto.setMsg("成功");
        return resultDto;
    }
}
