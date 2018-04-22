package com.tinygao.spi.service;

import java.io.UnsupportedEncodingException;
import java.util.ServiceLoader;

import com.tinygao.spi.spi.CodecSet;

public class CodecSetFactory {
	private static ServiceLoader<CodecSet> loader = ServiceLoader.load(CodecSet.class);
	
	public static CodecSet getCodecSet() throws UnsupportedEncodingException {
		for(CodecSet obj : loader) {
			return obj;
		}
		 throw new UnsupportedEncodingException();  
	}
}
