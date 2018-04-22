package com.tinygao.http.heatbeat;

import java.io.*;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by tinygao on 2017/9/17 0017.
 */
public class VariableSubstitution {
    protected static Pattern varPat = Pattern.compile("\\$\\{[^\\}\\$\u0020]+\\}");
    static  Properties properties = new Properties();
    static {

        Reader read = null;
        try {
            read = new FileReader("E:\\workspace\\spi\\http\\src\\main\\resources\\config.properties");
            properties.load(read);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    protected static final String substitute( String expr, int depth) {
        Matcher match = varPat.matcher("");
        String eval = expr;
        StringBuilder builder = new StringBuilder();
        int s = 0;
        for (; s <= depth; s++) {
            match.reset(eval);
            builder.setLength(0);
            int prev = 0;
            boolean found = false;
            while (match.find(prev)) {
                String group = match.group();
                String var = group.substring(2, group.length() - 1); // remove ${ .. }
                String substitute = getSubstitute(var);
                if (substitute == null) {
                    substitute = group;   // append as-is
                } else {
                    found = true;
                }
                builder.append(eval.substring(prev, match.start())).append(substitute);
                prev = match.end();
            }
            if (!found) {
                return eval;
            }
            builder.append(eval.substring(prev));
            eval = builder.toString();
        }
        if (s > depth) {
            throw new IllegalStateException(
                    "Variable substitution depth is deeper than " + depth + " for expression " + expr);
        }
        return eval;
    }
    public static String getSubstitute(String var) {
          String result = properties.getProperty(var);
          return result;
    }
    public static void main(String[] args) {

        System.out.println(VariableSubstitution.substitute("select * from ${ds} and ${week_day}", 10));
    }
}
