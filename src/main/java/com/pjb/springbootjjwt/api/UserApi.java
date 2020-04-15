package com.pjb.springbootjjwt.api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONWriter;
import com.pjb.springbootjjwt.annotation.UserLoginToken;
import com.pjb.springbootjjwt.entity.User;
import com.pjb.springbootjjwt.service.TokenService;
import com.pjb.springbootjjwt.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.TimeZone;

/**
 * @author jinbin
 * @date 2018-07-08 20:45
 */
@RestController
//@RequestMapping("users")
public class UserApi {
    @Autowired
    UserService userService;
    @Autowired
    TokenService tokenService;
    //注册
    @PostMapping("/users")
    public Object sign_in(@RequestBody User user){
//        SimpleDateFormat dateFormatGmt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//        dateFormatGmt.setTimeZone(TimeZone.getTimeZone("UTC"));
//        System.out.println(dateFormatGmt.format(new Date()));
        JSONObject jsonObject=new JSONObject();
        User userForBase=userService.findByUsername(user);
        if(userForBase==null){
            userService.addUser(user.getUsername(),user.getPassword());
            jsonObject.put("message","注册成功");
            return jsonObject;
        }else {

                jsonObject.put("message","注册失败，用户存在");
                return jsonObject;

        }
    }
    //登录
    @PostMapping("/users/login")
    @ResponseBody
    public Object login( @RequestBody User user){
        System.out.println(user);
        JSONObject jsonObject=new JSONObject();
        User userForBase=userService.findByUsername(user);
        if(userForBase==null){
            jsonObject.put("message","登录失败,用户不存在");
            return jsonObject;
        }else {
            if (!userForBase.getPassword().equals(user.getPassword())){
                jsonObject.put("message","登录失败,密码错误");
                return jsonObject;
            }else {
                String token = tokenService.getToken(userForBase);
                jsonObject.put("token", token);
               // jsonObject.put("user", userForBase);
                return jsonObject;
            }
        }
    }
    
    @UserLoginToken
    @GetMapping("/getMessage")
    public String getMessage(){
        return "你已通过验证";
    }
}
