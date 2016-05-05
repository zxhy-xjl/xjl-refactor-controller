package com.zxhy.xjl.refactor.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zxhy.xjl.refactor.domain.Review;
import com.zxhy.xjl.refactor.service.ReviewService;

@Controller
@RequestMapping("/review")
public class ReviewController {
	@Autowired
	private ReviewService reviewService;
	@ResponseBody
	@RequestMapping(value="/add",method=RequestMethod.POST,consumes = "application/json")
	public void add(@RequestBody Review review){
		this.reviewService.add(review);
	}
	@ResponseBody
	@RequestMapping(value="/all",method=RequestMethod.GET,consumes = "application/json")
	public List<Review> find(){
		return this.reviewService.find();
	}
	@ResponseBody
	@RequestMapping(value="/{reviewId}",method=RequestMethod.GET,consumes = "application/json")
	public List<Review> findByReviewId(@PathVariable String reviewId){
		return this.reviewService.findByReviewId(reviewId);
	}
	@ResponseBody
	@RequestMapping(value="/material/{materialId}",method=RequestMethod.GET,consumes = "application/json")
	public List<Review> findByMaterialId(@PathVariable String materialId, HttpServletRequest request){
		int page = NumberUtils.toInt(request.getParameter("page"));
		int pageSize = NumberUtils.toInt(request.getParameter("rows"));
		return this.reviewService.findByMaterialId(materialId,page,pageSize);
	}
	
}
