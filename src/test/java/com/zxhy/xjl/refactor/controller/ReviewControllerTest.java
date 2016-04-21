package com.zxhy.xjl.refactor.controller;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;
import com.zxhy.xjl.refactor.domain.Material;
import com.zxhy.xjl.refactor.domain.Review;
import com.zxhy.xjl.refactor.service.MaterialService;
import com.zxhy.xjl.web.controller.BaseControllerTest;

public class ReviewControllerTest  extends BaseControllerTest {
	@Autowired
	private ReviewController reviewController;
	@Autowired
	private MaterialService materialService;
	@Override
	public Object getController() {
		return reviewController;
	}
	@Test
	public void add(){
		Material material = this.materialService.find().get(0);
		String uri = "/review/add";
		Review review = new Review();
		review.setMaterialId(material.getId());
		review.setReviewName("身份证有效性核对");
		review.setReviewRule("跟公安库进行对接核对身份证是否在公安库中存在");
		review.setReviewImpl("people.checkId");
		String json = JSONObject.toJSONString(review);
		String resp = this.mockPost(uri, json);
		Assert.assertNull(resp);
	}
	@Test
	public void find(){
		String uri = "/review/all";
		String json = null;
		String resp = this.mockGet(uri, json);
		List<Review> list = JSONObject.parseArray(resp, Review.class);
		for (Review review : list) {
			System.out.println(review.getReviewName() + " " + review.getReviewId());
		}
		
	}
	@Test
	public void findByReviewId(){
		String uri = "/review/a427658b-2eea-4371-bab8-a566598bb692";
		String json = null;
		String resp = this.mockGet(uri, json);
		System.out.println(resp);
	}
	@Test
	public void findByMaterialId(){
		String uri = "/review/material/d1f1991a-a7bb-41ee-a545-7c18e7b148c1";
		String json = null;
		String resp = this.mockGet(uri, json);
		System.out.println(resp);
	}

}
