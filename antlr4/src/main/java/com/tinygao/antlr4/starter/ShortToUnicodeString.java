package com.tinygao.antlr4.starter;

public class ShortToUnicodeString extends  ArrayInitBaseListener {
    @Override
    public void enterInit(ArrayInitParser.InitContext ctx) {
        System.out.print('"');
    }
    /** Translate } to " */
    @Override
    public void exitInit(ArrayInitParser.InitContext ctx) {
        System.out.print('"');
    }
    @Override
    public void enterValue(ArrayInitParser.ValueContext ctx) {
        int value = Integer.valueOf(ctx.INT().getText());
        System.out.printf("\\u%04x", value);
    }

    public static void printByte(byte[] bt){
        for(int i=0; i<bt.length; i++){
            System.out.print(Integer.toHexString(bt[i]) + " ");
        }
        System.out.println();
    }

    /**
     * @param args
     */
    public static void main(String[] args)throws Exception {
        System.out.print(Integer.toHexString(2) + " ");
        String content = "1";
        printByte(content.getBytes("Unicode"));
        printByte(content.getBytes("UTF-16"));
        printByte(content.getBytes("UTF-16BE"));
        printByte(content.getBytes("UTF-16LE"));
    }
}
