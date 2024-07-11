package com.kinnong.modules.book.dao;

import org.apache.ibatis.annotations.Mapper;

import com.kinnong.modules.book.entity.CategoryEntity;
import com.kinnong.modules.sys.dao.BaseDao;

/**
 * 分类
 *

 */
@Mapper
public interface CategoryDao extends BaseDao<CategoryEntity> {

	
}
