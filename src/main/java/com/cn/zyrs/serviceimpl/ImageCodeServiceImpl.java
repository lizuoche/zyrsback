package com.cn.zyrs.serviceimpl;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.cn.zyrs.mapper.ImageCodeMapper;
import com.cn.zyrs.service.ImageCode;

@Service("imageCodeService")
public class ImageCodeServiceImpl implements ImageCode {

Logger log = Logger.getLogger(ImageCodeServiceImpl.class);
	
	@Resource(name = "imageCodeMapper")
	private ImageCodeMapper imageCodeMapper;
	
	@Override
	public String getImageName(String unitycode) {
		
		return this.imageCodeMapper.getImageName(unitycode);
	}

}
