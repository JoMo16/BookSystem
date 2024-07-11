package com.kinnong.modules.book.service;

import java.util.List;
import java.util.Map;

import com.kinnong.modules.book.entity.CategoryEntity;

/**
 * 分类
 *

 */
public interface CategoryService {
	
	CategoryEntity queryObject(Integer id);
	
	List<CategoryEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(CategoryEntity category);
	
	void update(CategoryEntity category);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);

}
