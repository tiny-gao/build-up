package com.tinygao.spi.service;

import java.io.UnsupportedEncodingException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws UnsupportedEncodingException
    {
        System.out.println(CodecSetFactory.getCodecSet().getClass().getName());
        CodecSetFactory.getCodecSet().getDecoder("test decode");
    }
}
