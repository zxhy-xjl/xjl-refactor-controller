package com.zxhy.xjl.refactor.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zxhy.xjl.refactor.business.FlowBusiness;
import com.zxhy.xjl.refactor.domain.Flow;
import com.zxhy.xjl.refactor.service.FlowService;

/**
 * 流程控制器
 *
 */
@Controller
@RequestMapping("/flow")
public class FlowController {
	@Autowired
	private FlowService flowService;
	/**
	 * 创建一个新的事项流程
	 * @param flowAddModel
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/add",method=RequestMethod.POST,consumes = "application/json")
	public void add(@RequestBody Flow flow){
		this.flowService.addFlow(flow);
	}
	/**
	 * 
	 * @param flow
	 */
	@ResponseBody
	@RequestMapping(value="/all",method=RequestMethod.GET,consumes = "application/json")
	public List<Flow> find(HttpServletRequest request){
		int page = NumberUtils.toInt(request.getParameter("page"));
		int pageSize = NumberUtils.toInt(request.getParameter("rows"));
		return this.flowService.find(page, pageSize);
	}
   
}
