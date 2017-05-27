package com.example.ssm.inter;

import java.util.List;
import java.util.Map;

public interface AuthorMapper {

	List<Map<String,Object>> getAuthorByPointMsg(String msg);
	
}
