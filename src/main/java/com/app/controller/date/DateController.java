package com.app.controller.date;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.app.dto.date.Date;
import com.app.service.date.DateService;

@Controller
public class DateController {
	
	@Autowired
	DateService dateService;
	
	@GetMapping("/date")
	public String date(Model model) {
		List<Date> dateList = dateService.findDateList();
		return "date/date";
	}
}
