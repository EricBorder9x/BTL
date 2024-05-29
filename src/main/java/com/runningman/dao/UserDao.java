/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.runningman.dao;

import com.runningman.entity.User;
import java.io.InputStream;
import java.util.List;

public interface UserDao {

    public void insert(User user, InputStream avatar);

    public void update(User user,InputStream avatar);

    public void delete(long userId);

    public User findById(long userId);

    public List<User> findAll(int pageIndex, int pageSize);

    public User findByEmailOrPhoneAndPassword(String email, String password, boolean verity);

    public User loadUserByUsername(String email);

    public User findByEmail(String email);

    int count();
}
