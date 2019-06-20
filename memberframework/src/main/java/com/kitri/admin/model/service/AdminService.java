package com.kitri.admin.model.service;

import org.springframework.stereotype.Service;

@Service
public interface AdminService {

	public String getMemberList(String key, String word);
	
}
