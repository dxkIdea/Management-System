package cn.com.dxk.management.service.serviceImpl;

import cn.com.dxk.management.entity.User;
import cn.com.dxk.management.repository.UserRepository;
import cn.com.dxk.management.service.UserService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 〈用户操作-业务层〉
 *
 * @author Dingxk
 * @create 2019/8/15
 * @since 1.0.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    /**
     * 注册用户时，校验是否已存在手机号
     * @param iphone
     * @return
     */
    @Override
    public String checkIphone(String iphone) {
        String result = "success";
        List<User> userList;
        userList = userRepository.findByIphone(iphone);
        if (userList.size() > 0) {
            result = "手机号已存在";
        }
        return result;
    }

    /**
     * 注册新用户
     * @param iphone
     * @param passWord
     * @param smsCode
     * @param nickName
     * @return
     */
    @Override
    public User insertUser(String iphone,String passWord,String smsCode,String nickName) {
        User user = null;
        String msg = "success";
        try{
            user = new User(UUID.randomUUID().toString(),null,nickName,passWord,iphone,null);
            userRepository.save(user);
        }catch (Exception e) {
            e.printStackTrace();
            msg = "注册失败！";
        }
        return user;
    }

    /**
     * 通过手机号或者昵称登录校验
     * @param accountNumber
     * @param passWord
     * @return
     */
    @Override
    public Map<String,Object> userLogin(String accountNumber, String passWord) {
        User user = null;
        List<User> userList;
        Map<String,Object> resultMap = new HashMap<>();
        userList = userRepository.findByIphoneOrNickName(accountNumber);
        if (userList.size() > 0 ) {
            for (User u : userList) {
                if (u.getPassWord().equals(passWord)) {
                    user = u;
                    resultMap.put("user",u);
                    resultMap.put("msg","success");
                }
            }
            if (null == user) {
                resultMap.put("user",null);
                resultMap.put("msg","密码不正确");
            }
        } else {
            resultMap.put("msg","用户不存在");
            resultMap.put("user",null);
        }
        return resultMap;
    }
}
