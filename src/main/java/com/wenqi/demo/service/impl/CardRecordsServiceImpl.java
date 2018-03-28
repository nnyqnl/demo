package com.wenqi.demo.service.impl;

import com.wenqi.demo.dao.CardRecordsDao;
import com.wenqi.demo.domain.CardRecords;
import com.wenqi.demo.dto.RequestModel;
import com.wenqi.demo.service.CardRecordsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class CardRecordsServiceImpl implements CardRecordsService {
    @Autowired
    private CardRecordsDao cardRecordsDao;
    @Override
    public void record(RequestModel requestModel) throws ParseException {
        Date now = new Date();
        SimpleDateFormat fmt1=new SimpleDateFormat("yyyy-MM-dd");


        CardRecords cardRecords = new CardRecords();
        cardRecords.setemployeeNumber((String) requestModel.getParams().get("employeeNumber"));
        cardRecords.setCardRecordsDate(fmt1.parse(fmt1.format(now)));//打卡日期
        CardRecords records=cardRecordsDao.getbyemployeeNumberAndtoday(cardRecords);

        if(null==records){
            //上班打卡
            cardRecords.setStartTime(now);
            cardRecordsDao.insert(cardRecords);
        }
        cardRecords.setEndTime(now);
        cardRecordsDao.update(cardRecords);
    }

    @Override
    public List<CardRecords> findYesterdayRecords(Date yesterday) {
        return cardRecordsDao.findByCardRecordDate(yesterday);
    }

}
