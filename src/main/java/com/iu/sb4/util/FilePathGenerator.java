package com.iu.sb4.util;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

@Component
public class FilePathGenerator {

	@Autowired
	private ResourceLoader resourceLoader;
	
	public File getUseResourceLoader(String filePath) throws Exception{
		//filePath : /static/ 제외하고 하위의 경로명
		
		String path="classpath:/static/";
		
		
		
		File file = new File(resourceLoader.getResource(path).getFile(), filePath);
		
		System.out.println(file.getAbsolutePath());
		
		if(!file.exists()) {
			file.mkdirs();
		}
		return file;
		
	}
	
	
	public Boolean setDeleteFile(String fileName,String filePath)throws Exception{
		Boolean check =false;
		String path="classpath:/static/";
		File file = new File(resourceLoader.getResource(path).getFile(), filePath);
		file= new File(file.getAbsolutePath(),fileName);
		if(file.exists()) {
			check=file.delete();
		}
		return check;
	}
}
