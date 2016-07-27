package com.jd.hackason.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/image")
public class PicController {
	@RequestMapping(value = "/save.action", method = RequestMethod.POST)
	public ResponseEntity<Object> save_image(@RequestParam("file") MultipartFile file,HttpServletRequest request) throws Exception {
		String file_name=file.getOriginalFilename(); //文件名
		//获取session
		ServletRequestAttributes attrs=(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpSession session=attrs.getRequest().getSession();
		String username=(String) session.getAttribute("user");
		//用户名+当前时间作为图片名字
		Calendar calendar=Calendar.getInstance();
		Date date=new Date();
		calendar.setTime(date);
		long time=calendar.getTimeInMillis();
		String new_name=username+time;
		String s[]=file_name.split("\\.");	//通过.分隔符得到上传图片的格式
		String path=new_name+"."+s[s.length-1];//把图片重命名，加上存放路径
		File f=new File("E://",path);
		file.transferTo(f);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/get.action", method = RequestMethod.GET)
	public ResponseEntity<Object> get_imge(@RequestParam("path") String path,HttpServletResponse response) throws Exception {
		System.out.println(path);
		File file=new File(path);
		OutputStream out=response.getOutputStream();
		FileInputStream in=new FileInputStream(file);
		int n;
		while(true){
			n=in.read();
			if(n==-1) break;
			out.write(n);
		}
		out.flush();
		out.close();
		in.close();
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
}
