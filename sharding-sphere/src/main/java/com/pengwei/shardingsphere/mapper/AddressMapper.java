package com.pengwei.shardingsphere.mapper;

import com.pengwei.shardingsphere.bean.Address;

public interface AddressMapper {
	/**
	 * 保存
	 */
	void save(Address address);
	
	/**
	 * 查询
	 * @param id
	 * @return
	 */
	Address get(Long id);
}
