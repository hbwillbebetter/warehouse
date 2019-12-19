package cn.fahai.mybatis2.dao;

import cn.fahai.mybatis2.entity.UserInfoPO;

public interface UserInfoPOMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(UserInfoPO record);

    int insertSelective(UserInfoPO record);

    UserInfoPO selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(UserInfoPO record);

    int updateByPrimaryKey(UserInfoPO record);
}