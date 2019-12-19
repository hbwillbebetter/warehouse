package cn.fahai.mybatis.dao;

import cn.fahai.mybatis.entity.UserInfoPO;

public interface UserInfoPOMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(UserInfoPO record);

    int insertSelective(UserInfoPO record);

    UserInfoPO selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(UserInfoPO record);

    int updateByPrimaryKey(UserInfoPO record);
}