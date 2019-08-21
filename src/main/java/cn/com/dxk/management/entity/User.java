package cn.com.dxk.management.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 〈用户实体〉
 *
 * @author Dingxk
 * @create 2019/8/15
 * @since 1.0.0
 */
@Entity
@Table(name = "user")
public class User implements Serializable {

    /**
     * 主键ID
     */
    @Id
    @GeneratedValue
    private Integer id;
    /**
     * 用户ID
     */
    private String userId;
    /**
     * 用户真实名称
     */
    private String userName;
    /**
     * 昵称
     */
    @Column(name ="nickName")
    private String nickName;
    /**
     * 密码
     */
    private String passWord;
    /**
     * 电话
     */
    @Column(name ="iphone")
    private String iphone;
    /**
     * 生日
     */
    private Date birthday;
    /**
     * 性别 1-男 2-女
     */
    private String sex = "1";

    public User() {
    }

    public User(String userId, String userName, String nickName, String passWord, String iphone, Date birthday) {
        this.userId = userId;
        this.userName = userName;
        this.nickName = nickName;
        this.passWord = passWord;
        this.iphone = iphone;
        this.birthday = birthday;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getIphone() {
        return iphone;
    }

    public void setIphone(String iphone) {
        this.iphone = iphone;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
