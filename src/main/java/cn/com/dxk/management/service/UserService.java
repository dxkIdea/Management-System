package cn.com.dxk.management.service;


import cn.com.dxk.management.entity.User;

import java.util.Map;


public interface UserService {
    String checkIphone(String iphone);

    User insertUser(String userName, String passWord, String smsCode, String nickName);

    Map<String,Object> userLogin(String accountNumber, String passWord);

}
