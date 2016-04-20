package com.zxhy.xjl.refactor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zxhy.xjl.refactor.controller.model.FlowAddModel;

/**
 * 流程控制器
 *
 */
@Controller
@RequestMapping("/flow")
public class FlowController {
	/**
	 * 创建一个新的事项流程
	 * @param flowAddModel
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/add",method=RequestMethod.POST,consumes = "application/json")
	public String add(@RequestBody FlowAddModel flowAddModel){
		if (true){
			throw new RuntimeException("名称已经存在");
		}
		return "flow_1";
	}
   
}
