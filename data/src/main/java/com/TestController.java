package com;

import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by somebody on 2016/8/10.
 */
@RestController
public class TestController extends HttpServlet
{
    @RequestMapping("/")
    public String get(HttpServletRequest req,HttpServletResponse res){
     //  HttpSession s=req.getSession();
        return "aa";
    }


}
