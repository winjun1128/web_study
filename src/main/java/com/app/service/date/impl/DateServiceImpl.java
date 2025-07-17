package com.app.service.date.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.date.DateDAO;
import com.app.dto.date.Date;
import com.app.service.date.DateService;

@Service
public class DateServiceImpl implements DateService {

	@Autowired
	DateDAO dateDAO;
	
	@Override
	public List<Date> findDateList() {
		List<Date> dateList = dateDAO.findDateList();
		return dateList;
	}

}
