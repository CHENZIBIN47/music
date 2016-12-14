package cn.chan.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "music_user")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userid;//主键
    private String username;//用户名
    private String password;//密码
    private String repassword;//确认密码
    private String sex;//性别
    private String email;//邮箱
    private Date brithday;//出生日期
    @Transient
    private String code;//激活码
    private boolean state;//状态码
    @Transient      //忽略某个字段
    private String vercode;//验证码

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "userid")
    private Set<UserCollection> userCollectionSet = new HashSet<UserCollection>();

    public Set<UserCollection> getUserCollectionSet() {
        return userCollectionSet;
    }

    public void setUserCollectionSet(Set<UserCollection> userCollectionSet) {
        this.userCollectionSet = userCollectionSet;
    }

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepassword() {
        return repassword;
    }

    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBrithday() {
        return brithday;
    }

    public void setBrithday(Date brithday) {
        this.brithday = brithday;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getVercode() {
        return vercode;
    }

    public void setVercode(String vercode) {
        this.vercode = vercode;
    }
}
