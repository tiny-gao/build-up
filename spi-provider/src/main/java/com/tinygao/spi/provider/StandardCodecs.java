package com.tinygao.spi.provider;

import java.beans.Encoder;
import java.util.Base64.Decoder;

import com.tinygao.spi.spi.CodecSet;

public class StandardCodecs extends CodecSet {

	@Override
	public Encoder getEncoder(String encodingName) {
		System.out.println(encodingName);
		return null;
	}

	@Override
	public Decoder getDecoder(String encodingName) {
		System.out.println(encodingName);
		return null;
	}

}
