package com.pengwei.shardingsphere.service.impl;

import com.pengwei.shardingsphere.bean.Address;
import com.pengwei.shardingsphere.mapper.AddressMapper;
import com.pengwei.shardingsphere.service.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements IAddressService {
	
	@Autowired
	private AddressMapper addressMapper;

	@Override
	public void save(Address address) {
		// TODO Auto-generated method stub
		addressMapper.save(address);	
	}

	@Override
	public Address get(Long id) {
		// TODO Auto-generated method stub
		return addressMapper.get(id);
	}

}
