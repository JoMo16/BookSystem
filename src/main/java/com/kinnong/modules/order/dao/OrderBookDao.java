package com.kinnong.modules.order.dao;

import org.apache.ibatis.annotations.Mapper;

import com.kinnong.modules.order.entity.OrderBookEntity;
import com.kinnong.modules.sys.dao.BaseDao;

/**
 * 
 *

 */
@Mapper
public interface OrderBookDao extends BaseDao<OrderBookEntity> {
	
}
