package com.ciyou.edu.controller

import org.springframework.boot.autoconfigure.web.ErrorController
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

import javax.servlet.http.HttpServletRequest

/**
 * @Author C.
 * @Date 2018-03-08 12:15
 */
@Controller
class MainsiteErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request){
        //获取statusCode:401,404,500
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code")
        if(statusCode == 401){
            return "/401"
        }else if(statusCode == 404){
            return "/404"
        }else if(statusCode == 403){
            return "/403"
        }else{
            return "/500"
        }

    }
    @Override
    public String getErrorPath() {
        return "/error"
    }
}