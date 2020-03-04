package cn.e3mall.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.e3mall.common.utils.FastDFSClient;
import cn.e3mall.common.utils.JsonUtils;

@Controller
public class PictureController {
	
	@Value("${IMAGE_SERVER_URL}")
	private String IMAGE_SERVER_URL;
	
	@RequestMapping("/pic/upload")
	@ResponseBody
	public String uploadFile(MultipartFile uploadFile) {
		try {
			FastDFSClient fastDFSClient = new FastDFSClient("classpath:conf/client.conf");
			String originalFilename = uploadFile.getOriginalFilename();
			String extName=originalFilename.substring(originalFilename.lastIndexOf(".")+1);
			String url = fastDFSClient.uploadFile(uploadFile.getBytes(), extName);
			url = IMAGE_SERVER_URL+url;
			Map res = new HashMap<>();
			res.put("error", 0);
			res.put("url",url);
			return JsonUtils.objectToJson(res);
		} catch (Exception e) {
			e.printStackTrace();
			Map res = new HashMap<>();
			res.put("error", 1);
			res.put("message","image upload failed");
			return JsonUtils.objectToJson(res);
		}
	}
}
