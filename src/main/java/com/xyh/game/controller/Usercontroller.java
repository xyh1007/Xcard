package com.xyh.game.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.xyh.game.annotation.ParamsValid;
import com.xyh.game.annotation.RCache;
import com.xyh.game.freemarker.base.SpringBeanFactory;
import com.xyh.game.req.UserLoginReq;
import com.xyh.game.res.*;
import freemarker.template.Configuration;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
/*import org.springframework.cache.annotation.Cacheable;*/
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import com.xyh.game.comm.Constants;
import com.xyh.game.dao.UserDao;
import com.xyh.game.dao2.CardDao;
import com.xyh.game.model.User;
import com.xyh.game.req.TestReq;
import org.springframework.web.servlet.support.RequestContext;

import java.util.Optional;

@Controller
@RequestMapping("/user")
public class Usercontroller {
	@Autowired
	UserDao userDao;
/*	@Autowired
	CardDao cardDao; */
	@RequestMapping(value = "/api/user/test", method = RequestMethod.POST)
	@ResponseBody
	//@Cacheable(value="user-key")
	@ParamsValid
	public Result test(@Valid @RequestBody TestReq reqEntity,BindingResult result,
			HttpServletRequest request) {
		//RequestContext requestContext = new RequestContext(request);
		Result resultEntity = new Result();
		User user = userDao.findByUsername(reqEntity.getUsername());
		resultEntity.setDataBody(user);
		resultEntity.setCode(Constants.ResultCode.OK);
		return resultEntity;
	}
/*	@GetMapping("")
	public String testthy(){
		return "testim";
	}*/

	@GetMapping("/info")
	@ResponseBody
	public BaseRes<ImRes> info(@RequestParam Long id){
		BaseRes<ImRes> res = new BaseRes<>();

		User user = userDao.findById(id).get();
		MineRes mine = new MineRes();
		BeanUtils.copyProperties(user, mine);
		ImRes imRes = new ImRes();
		imRes.setMine(mine);
		res.setCode(0);
		res.setData(imRes);
		return res;
	}

	@GetMapping("/getftl")
	public String getFtlDemo(Model model){
		model.addAttribute("f","Ftl");
		return "FtlTest";

	}

	@PostMapping("/login")
	@ResponseBody
	public ResResultEntity login(@Valid @RequestBody UserLoginReq reqEntity,BindingResult result,HttpServletRequest request){
		RequestContext requestContext = new RequestContext(request);
		UserRes resultEntity = new UserRes();

		resultEntity.setCode(Constants.ResultCode.ERROR);
		if (result.hasErrors()) {
			resultEntity.setMessage(result.getAllErrors().get(0).getDefaultMessage());
			return resultEntity;
		}
		User user = userDao.findByUsernameAndPassword(reqEntity.getUserName(),reqEntity.getPassword());
		if(null != user) {
			resultEntity.setId(user.getId());
			resultEntity.setUsername(user.getUsername());
			resultEntity.setCode(Constants.ResultCode.OK);
		}else{
			resultEntity.setMessage(requestContext.getMessage("valid.login.failed"));
		}
		return resultEntity;
	}


}
