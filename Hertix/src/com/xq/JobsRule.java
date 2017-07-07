package com.xq;

/**
 * Created by sunqilong on 2017/6/29.
 */

import org.archive.modules.CrawlURI;
import org.archive.modules.deciderules.DecideResult;
import org.archive.modules.deciderules.DecideRule;

public class JobsRule extends DecideRule{
    private static final long serialVersionUID = 1L;

    @Override
    protected DecideResult innerDecide(CrawlURI uri) {
        String u = uri.getURI();
        //只抓取http://news.163.com/17/0628/网易新闻
//        if(u.indexOf(",") != -1 || u.indexOf(";") != -1)
//            return DecideResult.REJECT;
//        if(u.indexOf("product.pconline.com.cn/") != -1 && u.indexOf("_") == -1)
//            return DecideResult.ACCEPT;
//        if(u.indexOf("product.pconline.com.cn/") != -1 && u.indexOf("_detail.html") != -1)
//            return DecideResult.ACCEPT;
//        if(u.indexOf("img") != -1 && u.indexOf("_cn.jpg") != -1)
//            return DecideResult.ACCEPT;
//        return DecideResult.REJECT;


        if(u.indexOf("http://product.pconline.com.cn/mobile/") != -1
                && u.indexOf("_detail.html") != -1
                || u.indexOf("_cn.jpg") != -1
                || u.indexOf("robots.txt") != -1
                || u.indexOf("dns:") != -1)
            return DecideResult.ACCEPT;
        else
            return DecideResult.REJECT;
    }
}

