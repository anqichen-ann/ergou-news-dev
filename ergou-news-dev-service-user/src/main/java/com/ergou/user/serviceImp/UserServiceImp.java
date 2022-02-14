package com.ergou.user.serviceImp;

import com.ergou.pojo.AppUser;
import com.ergou.user.mapper.AppUserMapper;
import com.ergou.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {
    public AppUserMapper appUserMapper;

    @Override
    public AppUser queryMobileIfExist(String mobile) {
        Example userExample = new Example(AppUser.class);
        Example.Criteria userExampleCriteria = userExample.createCriteria();
        userExampleCriteria.andEqualTo(mobile, mobile);
        return appUserMapper.selectOneByExample(userExampleCriteria);
    }

    @Override
    public AppUser createUser(String mobile) {
        return null;
    }
}
