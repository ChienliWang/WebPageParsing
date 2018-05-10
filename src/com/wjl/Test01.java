package com.wjl;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

import static org.jsoup.Jsoup.*;

public class Test01 {

    ArrayList<String> titleList = new ArrayList<String>();
    ArrayList<String> urlList = new ArrayList<String>();
    static final String host = "http://www.hzpt.edu.cn/";

    public static void main(String[] args) throws IOException{
        new Test01().mothed();
    }

    /**
     * @throws IOException
     * 'table.xx tr'是得到当前对应的标题的地址与URL的选择器，一页有12个，下标从0到11
     * 'table.xx tr:eq(0) td:eq(1) a'是包含了链接地址与标题内容
     */
    private void mothed() throws IOException{
        //通过url获取Docment对象
        Document doc = Jsoup.connect("http://www.hzpt.edu.cn/Newslist.php?pernums=0&cid=315&page=1").get();

        //获取对应的a标签对象
        Elements a1 = doc.select("table.xx tr:eq(0) td:eq(1) a");
        //System.out.println(a1.toString());

        //判断是否是最后一页
        Elements a2 = doc.select("a:matches(下一页)");
        Elements a3 = doc.select("a:matches(尾页)");
        System.out.println(a2.attr("href"));
        System.out.println(a2);
        
        int index = 1;
        System.out.println(index++);
        System.out.println(++index);

        //获取对应标题的发生时间
        Elements a4 = doc.select("table.xx tr:eq(0) td:eq(2) span");
        //System.out.println(a4.html());

        //通过URL地址获取对应的文本内容
        String url = "http://www.hzpt.edu.cn/Newsdetail.php?id=31345";
        Document doc1 = Jsoup.connect(url).get();
        Elements t1 = doc1.select("table [width=710] tbody tr:eq(3) td p span span");
        Elements t2 = doc1.select("table [width=710] tbody tr:eq(3) td p span span img[src$=.jpg]");
        for (Element e : t1){
            //System.out.println(e.html());
        }

    }

    /**
     * 得到目录下的数据
     * @throws IOException
     */
    private void mothed01() throws IOException {
        //通过url获取Docment对象
        Document doc = Jsoup.connect("http://www.hzpt.edu.cn/Newslist.php?pernums=0&cid=315&page=1").get();
        //缩小范围
        Elements e1 = doc.select("table.xx tr");
        for (Element e : e1){
            System.out.print(e.select("td a").html()+"\t");//标题
            System.out.print(host+e.select("td a").attr("href")+"\t");//URL地址
            System.out.print(e.select("td span").html()+"\r\n");//时间
        }
        //System.out.println(e1);
    }


}
