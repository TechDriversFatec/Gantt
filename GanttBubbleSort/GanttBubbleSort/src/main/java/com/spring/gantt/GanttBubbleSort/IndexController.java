package com.spring.gantt.GanttBubbleSort;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IndexController {
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/ganttTasks")
	public String ganttTasks() {
		return "ganttTasks";
	}
	
}
