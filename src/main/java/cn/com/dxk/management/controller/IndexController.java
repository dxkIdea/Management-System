package cn.com.dxk.management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 〈首页控制层〉
 *
 * @author Dingxk
 * @create 2019/8/14
 * @since 1.0.0
 */
@Controller
public class IndexController {
    @RequestMapping(value = "/index")
    public String index () {
        return "index";
    }
    @RequestMapping(value = "/login")
    public String login () {
        return "login";
    }
}
