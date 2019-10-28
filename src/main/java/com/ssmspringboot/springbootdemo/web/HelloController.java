package com.ssmspringboot.springbootdemo.web;

import com.ssmspringboot.springbootdemo.web.exception.MyException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class HelloController {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @ResponseBody
    @RequestMapping("/hello")
    public String hello() throws Exception {
        throw new Exception("发生错误");
    }

    @RequestMapping("/")
    public String index(ModelMap map) {
        map.addAttribute("host", "http://blog.didispace.com");
        return "index";
    }

    @RequestMapping("/thymeleaf")
    public String thymeleaf(Map<String, Object> map) {
        map.put("name", "fanfan");
        return "hello";
    }

    /**
     * 异常处理测试
     *
     * @return
     * @throws MyException
     */
    @RequestMapping("/json")
    public String json() throws MyException {
        throw new MyException("发生错误2");
    }
    @RabbitListener
    @RequestMapping("/mq")
    public String setMq() throws MyException {
        try {
            rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
            rabbitTemplate.setExchange("111111");//
            rabbitTemplate.setRoutingKey("2222");
        } catch (Exception e) {
            throw new MyException("");
        }
        return "index";
    }
}
