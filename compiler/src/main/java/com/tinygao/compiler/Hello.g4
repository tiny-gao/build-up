grammar Hello; // 定义一个名为Hello的文法
r : 'hello' ID ; // 匹配关键字hello和后面的标识符号
ID : [a-z]+ ; // 匹配小写字母组成的标识符号
WS : [ \t\r\n]+ -> skip ; // 过滤空格、Tab、换行以及 \r (Windows)