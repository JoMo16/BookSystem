package com.kinnong.web.controller;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.kinnong.web.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.kinnong.common.annotation.AuthIgnore;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/")
public class IndexController {
    @Autowired
    private JwtUtils jwtUtils;

    /**
     * 首页
     */
    @AuthIgnore
    @RequestMapping("")
    public String index() throws Exception {
//		return "admin/index.html";
        return "admin/login.html";
    }

    @AuthIgnore
    @RequestMapping("index")
    public String indexHtml(HttpServletRequest request) throws Exception {
        return "admin/index.html";
    }
    @AuthIgnore
    @RequestMapping("login")
    public String login(HttpServletRequest request) throws Exception {
        return "admin/login.html";
    }


    @AuthIgnore
    @RequestMapping("index2")
    public String index2Html() throws Exception {
        return "admin/index.html";
    }

    @AuthIgnore
    @RequestMapping("index.html")
    public String index3Html(@RequestParam("token") String token, HttpServletRequest request) throws Exception {
        String USER_KEY = "userId";
        DecodedJWT decoded = jwtUtils.getDecodedByToken(token);
        request.setAttribute(USER_KEY, Long.parseLong(decoded.getAudience().get(0)));
        return "admin/index.html";
    }

    @AuthIgnore
    @RequestMapping("getIdByToken")
    @ResponseBody
    public String getIdByToken(@RequestParam("token") String token){
        DecodedJWT decoded = jwtUtils.getDecodedByToken(token);
        return String.valueOf(Long.parseLong(decoded.getAudience().get(0)));
    }


    @AuthIgnore
    @GetMapping("/admin/advert/null")
    public void eqrq(){
        System.out.println("11111");
    }

}
