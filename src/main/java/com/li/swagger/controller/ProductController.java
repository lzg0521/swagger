package com.li.swagger.controller;

import com.li.swagger.model.Product;

import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@Api
@RestController
public class ProductController {
    @RequestMapping(value = "product/product",method = RequestMethod.GET)
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
    @ApiOperation(value = "获取商品信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "商品的id",dataType = "int",required = true,defaultValue = "0",example = "110"),
            @ApiImplicitParam(name = "name", value = "商品的名称",dataType = "String",required = true,defaultValue = "华为",example = "小米"),
    })
    public Product getUser(@RequestParam("id") Integer id,
                           @RequestParam("name") Integer name){
        Product product=new Product();
        product.setId(id);
        product.setName("苹果18");
        return product;
    }
}
