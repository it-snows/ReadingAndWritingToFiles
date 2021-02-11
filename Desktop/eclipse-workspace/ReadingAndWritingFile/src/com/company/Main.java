package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Test;

public class Main {

	public static void main(String[] args) {
//		File myObj = new File("C:\\temp\\hangman.txt");
//
//		printFileInfo(myObj);
//
//		File localFile = new File("test1.txt");
//		printFileInfo(localFile);

		var fileReader = new FileReader();
//		var file = fileReader.getFile("test1.txt");

		var is = fileReader.getInputStreamFromFileFromSpecificClass("test1.txt");
		var file = fileReader.getFileFromSpecifiClass("test1.txt");
		printFileInfo(file);

	}

	// create separate method which is a test method, can execute separate from my
	// program
	@Test
	public void get_local_text1txt_file_using_bufferReader() throws IOException {
		String str = "Hello world!";
		Class fileTests = Main.class;
		InputStream inputStream = fileTests.getResourceAsStream("test1.txt");
		String data = readFromInputStream(inputStream);

		Assert.assertTrue(data.contains(str));

	}

	@Test
	public void get_local_text1txt_file_using_scanner() throws IOException {
		String str = "Hello world!";
		Class fileTests = Main.class;
		InputStream inputStream = fileTests.getResourceAsStream("test1.txt");
		String data = readFromInputStreamWithScanner(inputStream);

		Assert.assertTrue(data.contains(str));

	}

	@Test
	public void get_local_text1txt_file_using_scanner_and_class_loader() throws IOException {
		String str = "Hi!";
		ClassLoader classLoader = getClass().getClassLoader();
		Class fileTests = Main.class;
		InputStream inputStream = fileTests.getResourceAsStream("test1.txt");
		String data = readFromInputStreamWithScanner(inputStream);

		Assert.assertTrue(data.contains(str));

	}

	public static void printFileInfo(File myObj) {
		if (myObj.exists()) {
			System.out.println("File name: " + myObj.getName());
			System.out.println("Absolute path: " + myObj.getAbsolutePath());
			System.out.println("Writeable: " + myObj.canWrite());
			System.out.println("Readable " + myObj.canRead());
			System.out.println("File size in bytes " + myObj.length());
		} else {
			System.out.println("The file does not exist.");
		}
	}

	private static String readFromInputStream(InputStream inputStream) throws IOException {
		StringBuilder resultStringBuilder = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
			String line;
			while ((line = br.readLine()) != null) {
				resultStringBuilder.append(line).append("\n");
			}
		}
		return resultStringBuilder.toString();
	}

	private static String readFromInputStreamWithScanner(InputStream inputStream) {
		try (Scanner scanner = new Scanner(inputStream)) {
			var text = "";

			while (scanner.hasNextLine()) {
				text += scanner.nextLine().concat("\n");
			}
			return text;
		}
	}
}