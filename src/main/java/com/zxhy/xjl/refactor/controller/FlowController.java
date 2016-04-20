package com.zxhy.xjl.refactor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zxhy.xjl.refactor.business.FlowBusiness;
import com.zxhy.xjl.refactor.controller.model.FlowAddModel;

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
	public String add(@RequestBody FlowAddModel flowAddModel){
		return this.flowBusiness.addFlow(flowAddModel.getFlowName());
	}
   
}
