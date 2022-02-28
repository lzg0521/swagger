package com.li.swagger.controller;

import com.li.swagger.model.Users;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

@Api
@RestController

public class UserController {

    @RequestMapping(value = "user/user", method = RequestMethod.GET)

    @ApiOperation(value = "获取用户信息", notes = "根据用户id获取用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户的id",dataType = "int",required = true,defaultValue = "0",example = "110"),
            @ApiImplicitParam(name = "phone", value = "用户的手机号",required = true,defaultValue = "111",example = "120"),

            @ApiImplicitParam(paramType = "path",name = "status", value = "用户的状态",dataType = "int",required = true,defaultValue = "1",example = "1"),
            @ApiImplicitParam(paramType = "header",name = "token", value = "用户的令牌",required = true,defaultValue = "123",example = "321"),
            @ApiImplicitParam(paramType = "body",name = "users1", value = "用户的实体类对象",required = true)
    })
    public Users getUser(@RequestParam("id") Integer id,
                         @RequestParam("phone") String phone,

                         @PathVariable("status") Integer status,
                         @RequestHeader("token") String token,
                         @RequestBody Users users1) {
        Users users = new Users();
        users.setId(id);
        users.setPhone(phone);
        users.setEmail("13@qq.com");
        return users;
    }

    //@ApiIgnore
    @RequestMapping(value = "user/user2", method = RequestMethod.GET)
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "请求成功"),
            @ApiResponse(code = 400,message = "缺失参数"),
            @ApiResponse(code = 401,message = "没有权限"),
            @ApiResponse(code = 403,message = "被隐藏了"),
            @ApiResponse(code = 404,message = "页面找不到"),
            @ApiResponse(code = 405,message = "方法不支持"),
            @ApiResponse(code = 500,message = "服务器错误"),
            @ApiResponse(code = 502,message = "服务器暂时不可用"),
            @ApiResponse(code = 503,message = "服务器不可用"),
            @ApiResponse(code = 504,message = "网关超时"),
    })
    @ApiOperation(value = "获取用户信息2", notes = "根据用户id获取用户信息2")
    public Users getUser2(
            @ApiParam(name = "id", value = "用户的id",type = "int",required = true,defaultValue = "0",example = "110")
            @RequestParam("id") Integer id,
            @ApiParam(name = "phone", value = "用户的手机号",required = true,defaultValue = "111",example = "120")
            @RequestParam("phone") String phone) {
        Users users = new Users();
        users.setId(id);
        users.setPhone(phone);
        users.setEmail("13@qq.com");
        return users;
    }
}
