package com.lzq.controller;

import com.lzq.error.BusinessException;
import com.lzq.error.CommonErrorCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class errorController {

    @ResponseBody
    @RequestMapping("/test")
    public void test(){
        try{
            int curr = 10 / 1;
            System.out.println("输出值为：" + curr);
        }catch (Exception e){
            System.out.println("ExceptionTest");
            throw new BusinessException(CommonErrorCode.E_100115);
        }
    }
    @ResponseBody
    @RequestMapping("/test2")
    public String test2(@RequestParam("id")int id){
        int curr = 0;
        try{
            curr = 10 / id;
        }catch (Exception e){
            System.out.println("ExceptionTest");
            throw new BusinessException(CommonErrorCode.E_100115);
        }
        return ""+curr;
    }
    @ResponseBody
    @RequestMapping("/test3/{uid}")
    public void test3(@PathVariable("uid") int id){
        try{

            int curr = 10 / id;
            System.out.println("输出值为：" + curr);
        }catch (Exception e){
            System.out.println("ExceptionTest");
            throw new BusinessException(CommonErrorCode.E_100115);
        }
    }
}
