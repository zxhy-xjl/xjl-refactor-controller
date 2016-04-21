package com.zxhy.xjl.refactor.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zxhy.xjl.refactor.domain.Material;
import com.zxhy.xjl.refactor.service.MaterialService;

/**
 * 流程定义需要提交的要件材料控制器
 * @author leasonlive
 *
 */
@Controller
@RequestMapping("/material")
public class MaterialController {
	private static final Logger logger = LoggerFactory.getLogger(MaterialController.class);
	@Autowired
	private MaterialService materialService;
	/**
	 * 单独新增材料，不和任何流程关联
	 * @param material
	 */
	@ResponseBody
	@RequestMapping(value="/add",method=RequestMethod.POST,consumes = "application/json")
	public void add(@RequestBody Material material){
		if (logger.isDebugEnabled()){
			logger.debug("执行添加材料操作:" + material);
		}
		this.materialService.add(material);
	}
	/**
	 * 新增加一个材料，并关联到一个流程上面
	 * @param material
	 * @param flowId
	 */
	@ResponseBody
	@RequestMapping(value="/add/flow/{flowId}",method=RequestMethod.POST,consumes = "application/json")
	public void addToFlow(@RequestBody Material material, @PathVariable String flowId){
		this.materialService.add(flowId, material);
	}
	/**
	 * 关联到一个流程上面
	 * @param flowId
	 * @param materialId
	 */
	@ResponseBody
	@RequestMapping(value="/{materialId}/flow/{flowId}",method=RequestMethod.POST,consumes = "application/json")
	public void relatedToFlow(@PathVariable String flowId, @PathVariable String materialId){
		this.materialService.relatedToFlow(flowId, materialId);
	}
	/**
	 * 取消和流程的关联
	 * @param flowId
	 * @param materialId
	 */
	@ResponseBody
	@RequestMapping(value="/{materialId}/flow/{flowId}",method=RequestMethod.DELETE,consumes = "application/json")
	public void removeFromFlow(@PathVariable String flowId, @PathVariable String materialId){
		this.materialService.removeFromFlow(flowId, materialId);
	}
	/**
	 * 根据流程id获取所有材料
	 * @param flowId
	 */
	@ResponseBody
	@RequestMapping(value="/flow/{flowId}",method=RequestMethod.DELETE,consumes = "application/json")
	public List<Material> findByFlowId(@PathVariable String flowId){
		return this.materialService.findByFlowId(flowId);
	}
}
