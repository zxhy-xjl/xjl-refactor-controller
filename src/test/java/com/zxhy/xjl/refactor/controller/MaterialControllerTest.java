package com.zxhy.xjl.refactor.controller;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonParser;
import com.zxhy.xjl.refactor.domain.Material;
import com.zxhy.xjl.web.controller.BaseControllerTest;

public class MaterialControllerTest extends BaseControllerTest {
	@Autowired
	private MaterialController controller;
	@Override
	public Object getController() {
		return this.controller;
	}
	@Test
	public void add(){
		String uri = "/material/add";
		Material material = new Material();
		material.setName("身份证");
		material.setSamplePicUrl("http://img3.imgtn.bdimg.com/it/u=3900826695,3958900846&fm=206&gp=0.jpg");
		String json = "{\"name\":\"a\",\"samplePicUrl\":\"b\"}";
		//json = JSONObject.toJSONString(material);
		System.out.println(json);
		String resp = this.mockPost(uri, json);
		System.out.println("add:" + resp);
	}
	@Test
	public void addFlow(){
		String uri = "/material/add/flow/1234567890123456789012345678901234567890";
		Material material = new Material();
		material.setName("身份证zzzzzzz");
		material.setSamplePicUrl("http://img3.imgtn.bdimg.com/it/u=3900826695,3958900846&fm=206&gp=0.jpg");
		String json = JSONObject.toJSONString(material);
		System.out.println(json);
		String resp = this.mockPost(uri, json);
		System.out.println("add:" + resp);
	}
}
