package com.tinygao.spi.spi;

import java.beans.Encoder;
import java.util.Base64.Decoder;

public abstract class CodecSet {
	public abstract Encoder getEncoder(String encodingName);
	public abstract Decoder getDecoder(String encodingName);
}
