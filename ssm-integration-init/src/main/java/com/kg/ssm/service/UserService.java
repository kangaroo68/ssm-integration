package com.kg.ssm.service;

import com.kg.ssm.pojo.TUser;

import java.util.Set;

/**
 * Created with IDEA
 * Created by ${jie.chen} on 2016/7/14.
 * 后台登录Service
 *
 * @author chenjie
 */
public interface UserService {
    /**
     * Shiro的登录验证，通过用户名查询用户信息
     *
     * @param username
     * @return
     */
    TUser findUserByUsername(String username);

    /**
     * 根据账号查找角色名称
     *
     * @param username
     * @return
     */
    Set<String> findRoles(String username);

    /**
     * 根据账号查找权限
     *
     * @param username
     * @return
     */
    Set<String> findPermissions(String username);
}
