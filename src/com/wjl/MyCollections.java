package com.wjl;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyCollections {
    public String getDate(){
        Date dNow = new Date( );
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy.MM.dd");
        String date = ft.format(dNow).replace('.','-');
        return date;
    }
}
