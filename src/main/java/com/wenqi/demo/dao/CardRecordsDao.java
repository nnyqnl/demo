package com.wenqi.demo.dao;

import com.wenqi.demo.domain.CardRecords;

import java.util.Date;
import java.util.List;

public interface CardRecordsDao {
    CardRecords getbyemployeeNumberAndtoday(CardRecords cardRecords);

    void insert(CardRecords cardRecords);

    void update(CardRecords cardRecords);

    List<CardRecords> findByCardRecordDate(Date yesterday);
}
