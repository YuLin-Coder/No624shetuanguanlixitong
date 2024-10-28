package com.so.test;

import com.so.system.bean.User;
import com.so.system.service.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * @author 郭丽然
 * @program: Project
 * @date 2020/6/8 10:46
 * 功能：
 */
public class UserServiceImplTest {


    private UserServiceImpl userService;

    @Test
    public void add() {
        User user=new User();
        user.setId("123456");
        user.setUsername("郭");
        user.setPassword("18230233005");
        user.setPic("xx.jpg");
        user.setRole("1");
        user.setIsBolck("2");

        userService.add(user);

    }

    @Test
    public void delete() {
        userService.delete("123456");
    }

    @Test
    public void update() {
        User user=new User();
        user = userService.getById("123456");
        user.setRole("0");
        userService.update(user);
    }

    @Test
    public void getById() {
        userService.getById("123456");
    }
}