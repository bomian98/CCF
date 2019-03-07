import java.util.Scanner;

public class Java_201703_3 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String blockCode = "";
        String preLine = "";
        while (input.hasNextLine()) {
            String line = input.nextLine();
            //给此区间加头标签,当且仅当此行是区间首行且是非空行
            if (blockCode.length() == 0 && line.length() > 0) {
                if (line.charAt(0) == '#') {
                    int hn = 0;
                    for (int i = 0; i < line.length(); i++) {
                        if (line.charAt(i) == '#')
                            hn++;
                        else
                            break;
                    }
                    line = line.replaceFirst("#* *", "<h" + hn + ">");
                }
                else if (line.charAt(0) == '*')
                    blockCode += "<ul>\n";
                else
                    blockCode += "<p>";
            }

            //判断该行是否为列表
            if (line.contains("*"))
                line = "<li>" + line.replaceFirst("\\* *", "") + "</li>";

            //处理每行里面的行内标签
            line = transToEm(line);
            line = transToLink(line);

            //识别到区间分割，给此区间加尾标签,然后输出
            //当此行为空且前面行有内容，说明区间在此行开始分隔
            if (preLine.length() > 0 && line.length() == 0) {
                blockCode = addLast(blockCode);
                System.out.println(blockCode);
                blockCode = "";
            }

            //把非空行加入区间代码块中
            if (line.length() > 0)
                blockCode += line + "\n";

            preLine = line;
        }

        //最后一行因为没被识别到，要另外加尾标签然后输出
        blockCode = addLast(blockCode);
        System.out.println(blockCode);
    }

    static String addLast(String blockCode) {
        //去掉代码块最后的换行符
        blockCode = blockCode.substring(0, blockCode.length()-1);
        if (blockCode.contains("<h")) {
            int hn = blockCode.charAt(2) - '0';
            blockCode += "</h" + hn + ">";
        } else if (blockCode.contains("<ul>"))
            blockCode += "\n</ul>";
        else if (blockCode.contains("<p>"))
            blockCode += "</p>";
        return blockCode;
    }

    static String transToEm(String line) {
        while (line.contains("_")){
            line = line.replaceFirst("_", "<em>");
            line = line.replaceFirst("_", "</em>");
        }
        return line;
    }

    static String transToLink(String line) {
        while (line.contains("[")) {
            String text = "";
            String link = "";
            int tIndexf = line.indexOf("[");
            int tIndexl = line.indexOf("]");
            int lIndexf = line.indexOf("(");
            int lIndexl = line.indexOf(")");
            text = line.substring(tIndexf + 1, tIndexl);
            link = line.substring(lIndexf + 1, lIndexl);
            line = line.replace(line.substring(tIndexf, lIndexl + 1),
                    "<a href=\"" + link + "\">" + text + "</a>");
        }
        return line;
    }
}