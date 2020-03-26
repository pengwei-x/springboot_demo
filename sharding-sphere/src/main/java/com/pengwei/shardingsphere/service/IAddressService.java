package com.pengwei.shardingsphere.service;

		import com.pengwei.shardingsphere.bean.Address;

public interface IAddressService {

	void save(Address address);

	Address get(Long id);
}
