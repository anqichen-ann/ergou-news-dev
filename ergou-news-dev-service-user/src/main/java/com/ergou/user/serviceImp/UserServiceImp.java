package com.ergou.user.serviceImp;

import com.ergou.UserStatus;
import com.ergou.pojo.AppUser;
import com.ergou.user.mapper.AppUserMapper;
import com.ergou.user.service.UserService;
import com.ergou.utils.DateUtil;
import com.ergou.utils.DesensitizationUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {
    public AppUserMapper appUserMapper;

    @Override
    public AppUser queryMobileIfExist(String mobile) {
        Example userExample = new Example(AppUser.class);
        Example.Criteria userExampleCriteria = userExample.createCriteria();
        userExampleCriteria.andEqualTo("mobile", mobile);
        return appUserMapper.selectOneByExample(userExampleCriteria);
    }

    @Override
    public AppUser createUser(String mobile) {
        AppUser user = new AppUser();
        user.setActiveStatus(UserStatus.INACTIVE.type);
        user.setBirthday(DateUtil.convertToDate("2022-01-01"));
        user.setCreatedTime(new Date());
        user.setMobile(DesensitizationUtil.commonDisplay("12345678"));
        user.setNickname("二狗");
        appUserMapper.insert(user);
        return user;
    }
}
