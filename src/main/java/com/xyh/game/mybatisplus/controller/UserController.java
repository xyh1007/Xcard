package com.xyh.game.mybatisplus.controller;


import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.xyh.game.annotation.ParamsValid;
import com.xyh.game.comm.Constants;
import com.xyh.game.mybatisplus.entity.User;
import com.xyh.game.mybatisplus.service.IUserService;
import com.xyh.game.req.TestReq;
import com.xyh.game.res.Result;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.RequestContext;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xyh
 * @since 2019-12-12
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private IUserService iUserService;

    @GetMapping("get")
    public User getUser(){
        return iUserService.getById(1);
    }

    @PostMapping("save")
    @ParamsValid
    public Result save(@Valid @RequestBody TestReq testReq, BindingResult result, HttpServletRequest request){
        Result resultEntity = new Result();
        RequestContext requestContext = new RequestContext(request);
        resultEntity.setCode(Constants.ResultCode.ERROR);
        User user = new User();
        BeanUtils.copyProperties(testReq,user);
        if(iUserService.saveOrUpdate(user)){
            resultEntity.setCode(Constants.ResultCode.OK);
            resultEntity.setDataBody(true);
            return resultEntity;
        }else{
            resultEntity.setDataBody(false);
            return resultEntity;
        }
//多主键
/*        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id",testReq.getId());
        if(iUserService.update(user,updateWrapper)){
            resultEntity.setCode(Constants.ResultCode.OK);
            resultEntity.setDataBody(true);
            return resultEntity;
        }else{

        }*/
    }

}
