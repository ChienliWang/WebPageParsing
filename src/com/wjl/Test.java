package com.wjl;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class Test {
    private ArrayList<News> newsList = new ArrayList<News>();

    private static final String HOST = "http://www.hzpt.edu.cn/";

    private static int index = 1;

    private String refreshTime;

    private boolean flag;

    /**
     * 这个方法是用来获取当前页面的Document对象
     * 并调用getPageDate方法存储数据，在数据存储完成之后
     * 将判断还有没有下一页，有的话继续获取下一页的Document对象
     */
    public void traversalDirectory(String url) throws IOException {//遍历目录
        flag = false;
        if(url==null){url="http://www.hzpt.edu.cn/Newslist.php?pernums=0&cid=315&page=1";}//
        Document doc = Jsoup.connect(url).get();
        getPageDate(doc);//这一步已经当前页页面的数据存储到newsList中

        Elements nextPage = doc.select("a:matches(下一页)");
        Elements lastPage = doc.select("a:matches(尾页)");
        if(/*nextPage.attr("href").equals(lastPage.attr("href"))*/index==3){
            String nowDate = new MyCollections().getDate();
            System.out.println(nowDate + "：已经遍历完成");
            refreshTime = new MyCollections().getDate();
            flag = true;
        }else{
            traversalDirectory("http://www.hzpt.edu.cn/Newslist.php?pernums=0&cid=315&page=" + index++);
            System.out.println("已经访问了目录的第"+(index-1)+"页");
        }
    }

    /**
     * 这个方法将现在当前页面的数据存入对应的数组列表中，
     * 一页需要循环12次,本页获取的数据是标题，时间，URL
     * 并调用方法得到text的数据，并在这里存储News对象到
     * newsList中
     * @throws IOException
     * @param doc
     */
    public void getPageDate(Document doc) throws IOException {
        for (int i=0; i<12; i++){
            //缩小范围到目录的范围
            Elements directory = doc.select("table.xx tr");//directory（目录）
            //遍历
            for (Element e : directory){
                String title, url, date, text;
                title = e.select("td a").html();
                //获得标题
                url = HOST + e.select("td a").attr("href");
                //获得URL
                date = e.select("td span").html();
                //获得日期
                text = getPageTextByURL(url);
                //获得文本内容

                News news = new News(title, url, date, text);
                //将该文本存储到类中
                newsList.add(news);
                //将新建的类存储到newsList中
            }//foreach over
        }//for over
    }//getPageDate over

    /**
     * 由于标题和链接地址以及时间信息可以在目录就可以获取
     * 但是对应的标题的文本内容就没法获取，我们得到对应的
     * URL，通过URL获取Document对象，然后获取对应的文本内
     * 容而且文本的内容都是先文字，然后是图片，我们将图片
     * 的地址记录下来追加在文本内容的后面，不是存储一张图
     * 片
     * @param url
     */
    public String getPageTextByURL(String url) throws IOException {
        Document doc = Jsoup.connect(url).get();
        Elements text = doc.select("table [width=710] tbody tr:eq(3) td p span span");
        return text.html();
    }//getPageTextByURL over

    public ArrayList<News> getNewsList(){
        return newsList;
    }

    public String getRefreshTime() {
        return refreshTime;
    }

    public boolean isFlag() {
        return flag;
    }
}
