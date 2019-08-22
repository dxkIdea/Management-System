package cn.com.dxk.management.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
@Data
@AllArgsConstructor
@NoArgsConstructor
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
}
