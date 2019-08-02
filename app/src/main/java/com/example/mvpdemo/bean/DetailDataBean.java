package com.example.mvpdemo.bean;

import com.example.mvpdemo.base.bean.BaseBean;

/**
 * @Author: xingyan
 * @Date: 2019/8/2
 * @Desc:
 */
public class DetailDataBean extends BaseBean {
    public String title;
    public String collect_count;
    public String original_title;

    @Override
    public String toString() {
        return "HomeDataBean{" +
                "title=" + title +
                ", collect_count=" + collect_count +
                ", original_title=" + original_title +
                '}';
    }
}
