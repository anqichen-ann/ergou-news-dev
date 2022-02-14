package com.ergou.user.mapper;

import com.ergou.api.my.mapper.mapper.MyMapper;
import com.ergou.pojo.AppUser;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserMapper extends MyMapper<AppUser> {
}