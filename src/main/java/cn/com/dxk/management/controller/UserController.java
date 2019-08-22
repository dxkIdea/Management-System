package cn.com.dxk.management.controller;

import cn.com.dxk.management.entity.User;
import cn.com.dxk.management.repository.UserRepository;
import cn.com.dxk.management.service.UserService;
import cn.com.dxk.management.util.RandomValidateCodeUtil;
import cn.com.dxk.management.vo.LayUITableResponseVO;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 〈用户操作-控制层〉
 *
 * @author Dingxk
 * @create 2019/8/15
 * @since 1.0.0
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 注册新用户时，校验手机号是否存在
     * @param iphone 手机
     * @return
     */
    @ResponseBody
    @PostMapping(value = "checkIphone")
    public String checkIphone (@RequestParam("iphone") String iphone) {
        return  userService.checkIphone(iphone);
    }

    /**
     * 注册用户
     * @param iphone
     * @param passWord
     * @param smsCode
     * @param nickName
     * @param request
     * @param model
     * @return
     * @throws IOException
     */
    @PostMapping(value = "registUser")
    public String registUser(@RequestParam(name = "iphone") String iphone,
                             @RequestParam(name = "passWord") String passWord,
                             @RequestParam(name = "smsCode") String smsCode,
                             @RequestParam(name = "nickName") String nickName,
                             HttpServletRequest request,
                             Model model) throws IOException {
        User user =  userService.insertUser(iphone,passWord,smsCode,nickName);
        if (user != null) {
            request.getSession().setAttribute("loginUser",user);
            return "redirect:/index";
        } else {
            model.addAttribute("msg", "验证码输入不正确");
            return "forward:/regist";
        }
    }

    /**
     * 登录
     * @param userName
     * @param passWord
     * @param verCode
     * @param request
     * @param response
     * @param model
     * @return
     * @throws IOException
     */
    @GetMapping(value = "userLogin")
    public String userLogin(@RequestParam(name = "userName") String userName,
                            @RequestParam(name = "passWord") String passWord,
                            @RequestParam(name = "verCode") String verCode,
                            HttpServletRequest request,
                            HttpServletResponse response,
                            Model model) throws IOException {
        User user;
        Map<String,Object> resultMap;
        HttpSession session = request.getSession();
        //获取session中的实体信息
        user = (User) session.getAttribute("loginUser");
        if (null != user) {
            return "redirect:/index";
        }else {
            String verCodeSession = (String) session.getAttribute(RandomValidateCodeUtil.RANDOMCODEKEY);
            //首先判断验证码是否正确
            if (null != verCodeSession && verCode != null &&  verCodeSession.equals(verCode)) {
                //如果session中没有登录信息,数据库验证
                resultMap = userService.userLogin(userName, passWord);
                user = (User) resultMap.get("user");
                if (null != user) {
                    //session有效期
                    session.setMaxInactiveInterval(15 * 60);
                    request.getSession().setAttribute("loginUser", user);
                    return "redirect:/index";
                } else {
                    model.addAttribute("msg", resultMap.get("msg").toString());
                    return "login";
                }
            } else {
                model.addAttribute("msg", "验证码输入不正确");
                return "forward:/login";
            }
        }
    }

    /**
     * 用户退出
     * @param request
     * @return
     */
    @RequestMapping(value = "loginout")
    public String loginOut (HttpServletRequest request) {
        HttpSession httpSession = request.getSession();
        httpSession.removeAttribute("loginUser");
        return "/login";
    }

    @ResponseBody
    @RequestMapping(value = "findPageUser")
    public LayUITableResponseVO<User> getAllUser (@RequestParam("page") int page, @RequestParam("limit") int limit) {
        return userService.findPageUser(page,limit);
    }

    @ResponseBody
    @PostMapping(value = "deleteOneUser")
    public void deleteOneUser (@RequestParam(value = "userId") String userId) {
        userService.deleteOneUser(userId);
    }

}
