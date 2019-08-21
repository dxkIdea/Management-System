package cn.com.dxk.management.interceptor;

import cn.com.dxk.management.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 〈登录拦截器〉
 *
 * @author Dingxk
 * @create 2019/8/16
 * @since 1.0.0
 */
@Component
public class LoginHandlerInterceptor implements HandlerInterceptor {
    //在业务处理器处理请求之前被调用。预处理，可以进行编码、安全控制、权限校验等处理
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user = (User) request.getSession().getAttribute("loginUser");
        if (null == user) {
            if("XMLHttpRequest".equalsIgnoreCase(request.getHeader("X-Requested-With"))){
                response.sendError(401);
            }
            //未登陆，返回登陆页面
            response.setHeader("Content-Type", "text/html;charset=UTF-8");
            response.sendRedirect("/login");
            System.out.println("----已拦截---");
            return false;
        }else {
            //已登录
            return true;
        }

    }
    //在业务处理器处理请求执行完成后，生成视图之前执行。后处理（调用了Service并返回ModelAndView，但未进行页面渲染），有机会修改ModelAndView；
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }
    //在DispatcherServlet完全处理完请求后被调用，可用于清理资源等。返回处理（已经渲染了页面）；
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

}
