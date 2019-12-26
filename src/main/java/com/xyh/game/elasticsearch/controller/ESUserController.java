package com.xyh.game.elasticsearch.controller;

import com.xyh.game.annotation.ParamsValid;
import com.xyh.game.comm.Constants;
import com.xyh.game.elasticsearch.bean.User;
import com.xyh.game.elasticsearch.service.EUserService;
import com.xyh.game.req.TestReq;
import com.xyh.game.res.Result;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;

@RestController
@RequestMapping("/es/api/user")
public class ESUserController {

    @Autowired
    private EUserService eUserService;


    @PostMapping("save")
    @ParamsValid
    public Result save(@Valid @RequestBody TestReq testReq, BindingResult result, HttpServletRequest request) throws IOException {
        Result resultEntity = new Result();
        resultEntity.setCode(Constants.ResultCode.ERROR);
        User user = new User();
        BeanUtils.copyProperties(testReq, user);
        if (eUserService.indexIsExist("logstash-2019.12.23-000001")) {
            resultEntity.setCode(Constants.ResultCode.OK);
            resultEntity.setDataBody(true);
            return resultEntity;
        } else {
            resultEntity.setDataBody(false);
            return resultEntity;
        }
    }
}
