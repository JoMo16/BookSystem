package com.kinnong.modules.member.dao;

import java.math.BigDecimal;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.kinnong.modules.member.entity.MemberEntity;
import com.kinnong.modules.sys.dao.BaseDao;


/**
 * 会员
 *

 */
@Mapper
public interface MemberDao extends BaseDao<MemberEntity> {

	MemberEntity queryByOpenid(String openid);

	MemberEntity queryByLoginName(String loginName);
	
	void addDeposit(@Param("id")Long id, @Param("deposit")BigDecimal deposit);
}
