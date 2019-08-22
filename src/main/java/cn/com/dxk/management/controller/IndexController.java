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
    /**
     * 首页
     * @return
     */
    @RequestMapping(value = "/index")
    public String index () {
        return "index";
    }
    /**
     * 控制台
     * @return
     */
    @RequestMapping(value = "/console")
    public String console () {
        return "console";
    }

    /**
     * 系统用户
     * @return
     */
    @RequestMapping(value = "/sysUser")
    public String sysUser () {
        return "user/sysUser";
    }

    /**
     * 系统管理员
     * @return
     */
    @RequestMapping(value = "/adminUser")
    public String adminUser () {
        return "user/adminUser";
    }
}
