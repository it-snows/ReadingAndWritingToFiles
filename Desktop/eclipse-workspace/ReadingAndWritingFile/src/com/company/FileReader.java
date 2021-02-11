package com.company;

import java.io.File;
import java.io.InputStream;

public class FileReader {

	public InputStream getInputStreamFromFile(String fileName) {
		ClassLoader classLoader = getClass().getClassLoader();
		InputStream inputStream = classLoader.getResourceAsStream(fileName);
		return inputStream;
	}

	public InputStream getInputStreamFromFileFromSpecificClass(String fileName) {
		Class test = Main.class;
		InputStream inputStream = test.getResourceAsStream(fileName);
		return inputStream;
	}

	public File getFileFromSpecifiClass(String fileName) {
		Class test = Main.class;
		File file = new File(test.getResource(fileName).getFile());
		return file;
	}

	public File getFile(String fileName) {
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(fileName).getFile());
		return file;
	}
}
