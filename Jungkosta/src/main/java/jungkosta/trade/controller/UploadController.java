package jungkosta.trade.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import jungkosta.commons.util.MediaUtils;
import jungkosta.commons.util.UploadFileUtils;


@Controller
public class UploadController {
	
	//tradeServlet에 설정한 이미지를 upload할 경로
	@Resource(name= "uploadPath")
	private String uploadPath;
	
	//
	private String uploadFile(String originalName, byte[] fileData) throws Exception{
		UUID uid = UUID.randomUUID();
		String savedName = uid.toString() + "_" + originalName;
		
		File target = new File(uploadPath, savedName);
		FileCopyUtils.copy(fileData, target);
		
		return savedName;
	}
	
	@RequestMapping(value= "/uploadAjax", method= RequestMethod.GET)
	public void uploadAjax() {
		System.out.println("uploadAjax");
	}
	
	@ResponseBody
	@RequestMapping(value= "/uploadAjax", method= RequestMethod.POST, 
								produces= "text/plain;charset=UTF-8")
	public ResponseEntity<String> uploadAjax(MultipartFile file) throws Exception {
		System.out.println("originalName : " + file.getOriginalFilename());
		System.out.println("size : " + file.getSize());
		System.out.println("contentType : " + file.getContentType());
		
		return new ResponseEntity<String>(UploadFileUtils.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes()), 
							HttpStatus.CREATED);
	}
	
	/*@ResponseBody
	@RequestMapping("/displayFile")
	public ResponseEntity<byte[]> displayFile(String fileName) throws Exception{
		
		InputStream in = null;
		ResponseEntity<byte[]> entity = null;
		
		try {
			
			String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);
			
			MediaType mType = MediaUtils.getMediaType(formatName);
			
			HttpHeaders headers = new HttpHeaders();
			
			in = new FileInputStream(uploadPath + fileName);
			
			if(mType != null) {
				headers.setContentType(mType);
			} else {
				fileName = fileName.substring(fileName.indexOf("_") + 1);
				headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
				headers.add("Content-Disposition", "attachment); filename=\"" +
						new String(fileName.getBytes("UTF-8"), "ISO-8859-1") + "\"");
			}
			
			entity = new ResponseEntity<>(IOUtils.toByteArray(in), 
					headers,
					HttpStatus.CREATED);

		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		} finally {
			in.close();
		}
		return entity;
	}*/
	
		@ResponseBody
		@RequestMapping("/displayFile")
		public ResponseEntity<byte[]>  displayFile(String fileName)throws Exception{
	    
			System.out.println(fileName);
			InputStream in = null; 
			ResponseEntity<byte[]> entity = null;
	    
			//logger.info("FILE NAME: " + fileName);
	    
			try{
	      
				String formatName = fileName.substring(fileName.lastIndexOf(".")+1);
	      
				MediaType mType = MediaUtils.getMediaType(formatName);
	      
				HttpHeaders headers = new HttpHeaders();
	      
				in = new FileInputStream(uploadPath+fileName);
				System.out.println("uploadPath : " + uploadPath);
	      
				if(mType != null){
					headers.setContentType(mType);
				}else{
	        
					fileName = fileName.substring(fileName.indexOf("_")+1);       
					headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
					headers.add("Content-Disposition", "attachment; filename=\""+ 
							new String(fileName.getBytes("UTF-8"), "ISO-8859-1")+"\"");
				}

				entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
	        
			}catch(Exception e){
				e.printStackTrace();
				entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
			}finally{
				in.close();
			}
			return entity;    
		}
	
}
