package kr.or.ddit.file;

import static org.junit.Assert.*;

import org.junit.Test;

import kr.or.ddit.utill.FileUtil;

public class CookieUtilTest {
	
	
	@Test
	public void getFileNameTest() {
	
		/***Given***/
		String contentDisposition = "form-data; name=\"file\"; filename=\"brown.jpg\"";
		/***When***/
		String file = FileUtil.getFileName(contentDisposition);
		/***Then***/
		assertEquals("brown.jpg", file);
}
	@Test
	public void getFileExtensionTest() {
		/***Given***/
		String filename = "brown.png";
		
		/***When***/
		String extension = FileUtil.getFileExtension(filename);
		/***Then***/
		assertEquals(".png", extension);
	}
	
	@Test
	public void getFileExtensionTest2() {
		/***Given***/
		String filename = "line.brown.png";
		
		/***When***/
		String extension = FileUtil.getFileExtension(filename);
		/***Then***/
		assertEquals(".png", extension);
	}
	
	@Test
	public void getFileExtensionTest3() {
		/***Given***/
		String filename = "brown";
		
		/***When***/
		String extension = FileUtil.getFileExtension(filename);
		/***Then***/
		assertEquals("", extension);
	}
}