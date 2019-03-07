import java.util.Scanner;

public class Java_201703_3 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String blockCode = "";
        String preLine = "";
        while (input.hasNextLine()) {
            String line = input.nextLine();
            //���������ͷ��ǩ,���ҽ��������������������Ƿǿ���
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

            //�жϸ����Ƿ�Ϊ�б�
            if (line.contains("*"))
                line = "<li>" + line.replaceFirst("\\* *", "") + "</li>";

            //����ÿ����������ڱ�ǩ
            line = transToEm(line);
            line = transToLink(line);

            //ʶ������ָ���������β��ǩ,Ȼ�����
            //������Ϊ����ǰ���������ݣ�˵�������ڴ��п�ʼ�ָ�
            if (preLine.length() > 0 && line.length() == 0) {
                blockCode = addLast(blockCode);
                System.out.println(blockCode);
                blockCode = "";
            }

            //�ѷǿ��м�������������
            if (line.length() > 0)
                blockCode += line + "\n";

            preLine = line;
        }

        //���һ����Ϊû��ʶ�𵽣�Ҫ�����β��ǩȻ�����
        blockCode = addLast(blockCode);
        System.out.println(blockCode);
    }

    static String addLast(String blockCode) {
        //ȥ����������Ļ��з�
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