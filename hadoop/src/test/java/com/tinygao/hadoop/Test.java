package com.tinygao.hadoop;

import com.google.common.base.Charsets;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.io.Files;
import com.google.common.io.Resources;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Test {
    public static void main(String[] args) throws IOException {
        Splitter splitter = Splitter.on(';');
        List<String> txt =  Resources.readLines(Resources.getResource("spider.log"), Charsets.UTF_8);
        StringBuilder sb = new StringBuilder();
        for(String line: txt) {
            if(!line.contains("http://www.movie.com/dor/")) continue;
            Iterable<String> it = splitter.split(line);
            for(String str:it) {
                if(str.contains("《")) {
                    sb.append(str.substring(str.indexOf("《")+1, str.indexOf("》")));
                    sb.append(",");
                }
                if(str.matches("\\d{4}.\\d{1,2}.\\d{1,2}")) {
                    sb.append(str);
                    sb.append(",");
                }

                if(str.startsWith("票房（万）")) {
                    sb.append(str.substring(str.indexOf("票房（万）")+5, str.indexOf(" ")));
                }
            }
            sb.setLength(0);
        }
    }
}
