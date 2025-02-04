package com.kinnong.modules.book.dao;

import com.kinnong.modules.book.entity.HistoryEntity;
import com.kinnong.modules.sys.dao.BaseDao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

/**
 * 浏览记录
 *

 */
@Mapper
public interface HistoryDao extends BaseDao<HistoryEntity> {

	List<HistoryEntity> queryByUserId(Long userId);

	List<HistoryEntity> queryByBookId(Integer bookId);
	
}
