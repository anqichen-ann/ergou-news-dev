package com.ergou.user.service;

import com.ergou.pojo.AppUser;

public interface UserService {

    public AppUser queryMobileIfExist(String mobile);

    public AppUser createUser(String mobile);
}
