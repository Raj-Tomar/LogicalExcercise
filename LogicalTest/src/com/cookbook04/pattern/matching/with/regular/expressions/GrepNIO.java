package com.cookbook04.pattern.matching.with.regular.expressions;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GrepNIO {

	public static void main(String[] args) throws IOException {
		if (args.length < 2) {
			System.err.println("Usage: GrepNIO patt file [...]");
			System.exit(1);
		}
		Pattern p = Pattern.compile(args[0]);
		for (int i = 1; i < args.length; i++)
			process(p, args[i]);
	}

	@SuppressWarnings("resource")
	static void process(Pattern pattern, String fileName) throws IOException {
		// Get a FileChannel from the given file.
		FileChannel fc = new FileInputStream(fileName).getChannel();
		// Map the file's content
		ByteBuffer buf = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size());
		// Decode ByteBuffer into CharBuffer
		CharBuffer cbuf = Charset.forName("ISO-8859-1").newDecoder().decode(buf);
		Matcher m = pattern.matcher(cbuf);
		while (m.find()) {
			System.out.println(m.group(0));
		}
	}

}
