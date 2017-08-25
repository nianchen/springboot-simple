package org.jy.web.controller;

import com.alibaba.fastjson.JSON;
import org.jy.base.util.email.EmailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/email")
public class EmailController {
    @Autowired
    private EmailSender emailSender;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public Object send(){
        String to = "454255310@qq.com";
        String subject = "关于下午例会";
        String content = "Hello 关于下午例会 Spring boot Email.";
        System.out.println("-------------==emial====---------------");
        boolean result = emailSender.sender(to, subject, content);
        System.out.println("-------------======---------------"+result);
        Map m = new HashMap();
        m.put("result",200);
        return JSON.toJSON(m);
    }
}
