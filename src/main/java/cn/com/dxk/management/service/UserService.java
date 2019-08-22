package cn.com.dxk.management.service;


import cn.com.dxk.management.entity.User;
import cn.com.dxk.management.vo.LayUITableResponseVO;

import java.util.Map;


public interface UserService {
    String checkIphone(String iphone);

    User insertUser(String userName, String passWord, String smsCode, String nickName);

    Map<String,Object> userLogin(String accountNumber, String passWord);

    LayUITableResponseVO<User> findPageUser(int page, int limit);

    void deleteOneUser(String userId);

}
