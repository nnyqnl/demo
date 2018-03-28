package com.wenqi.demo.service;

import com.wenqi.demo.domain.CardRecords;
import com.wenqi.demo.dto.RequestModel;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface CardRecordsService {
    void record(RequestModel requestModel) throws ParseException;

    List<CardRecords> findYesterdayRecords(Date yesterday);
}
