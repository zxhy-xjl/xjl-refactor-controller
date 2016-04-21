package com.zxhy.xjl.refactor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zxhy.xjl.refactor.business.FlowBusiness;
import com.zxhy.xjl.refactor.domain.Flow;

/**
 * 流程控制器
 *
 */
@Controller
@RequestMapping("/flow")
public class FlowController {
	@Autowired
	private FlowBusiness flowBusiness;
	/**
	 * 创建一个新的事项流程
	 * @param flowAddModel
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/add",method=RequestMethod.POST,consumes = "application/json")
	public void add(@RequestBody Flow flow){
		this.flowBusiness.addFlow(flow);
	}
	/**
	 * 
	 * @param flow
	 */
	@ResponseBody
	@RequestMapping(value="/all",method=RequestMethod.GET,consumes = "application/json")
	public List<Flow> add(){
		return this.flowBusiness.getAll();
	}
   
}
