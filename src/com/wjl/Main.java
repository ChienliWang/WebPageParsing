package com.wjl;

import com.wjl.Test;

import java.io.IOException;

public class Main {
    private Test test;
    /**
     * 从这里调用Test，先在这里比较News更新的时间和现在的时间（其实是日期）
     * 返回值为真就可以去得到列表,返回为假一般是正在查询数据
     */
    public boolean refreshList(){
        Test test = new Test();
        this.test = test;
        String refreshTime = test.getRefreshTime();
        if(refreshTime == null && test.isFlag()) {
            return true;
        }else if((Integer.parseInt(refreshTime.replace("-","")) < Integer.parseInt(new MyCollections().getDate().replace("-","")))){
            try {
                test.traversalDirectory("http://www.hzpt.edu.cn/Newslist.php?pernums=0&cid=315&page=1");
            } catch (IOException e) {
                e.printStackTrace();
                e.addSuppressed(new Exception("网址分析失败"));
                return false;
            }
            return true;
        }//if over
        return true;
    }

    public Test getTest() {
        return test;
    }
}
