package com.example.ssm.inter;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface PressMapper {

	List<Map<String,Object>> getPressesByPointMsg(@Param("msg") String msg);
	
}
