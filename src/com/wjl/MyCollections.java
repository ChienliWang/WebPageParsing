package com.wjl;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyCollections {
    public String getDate(){
        return new SimpleDateFormat("yyyy.MM.dd").format(new Date()).replace(".","-");
    }
}
