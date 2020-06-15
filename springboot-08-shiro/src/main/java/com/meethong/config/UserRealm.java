package com.meethong.config;

import com.meethong.pojo.User;
import com.meethong.service.Userservice;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;


public class UserRealm extends AuthorizingRealm {
    @Autowired
    Userservice userservice;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行了=>>>>授权doGetAuthorizationInfo");
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
        //拿到当前登录的用户
        Subject subject= SecurityUtils.getSubject();
        User currentUser= (User) subject.getPrincipal();
        //设置当前用户的权限
        info.addStringPermission(currentUser.getPerms());
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("执行了=>>>>认证doGetAuthenticationInfo");

   /*     String name="root";
        String password="123";
        UsernamePasswordToken usertoken= (UsernamePasswordToken) token;
        if (!usertoken.getUsername().equals(name)){
            return null;
        }
        //密码认证
        return new SimpleAuthenticationInfo("",password,"");
    }*/
        UsernamePasswordToken usertoken = (UsernamePasswordToken) token;
        User user = userservice.querUserByName(usertoken.getUsername());

        if (user == null) {
            return null;//UnknownAccountException
        }
        Subject currentSubject=SecurityUtils.getSubject();
        Session session=currentSubject.getSession();
        session.setAttribute("loginUser",user);
        return new SimpleAuthenticationInfo(user, user.getPassword(), "");
    }


}
