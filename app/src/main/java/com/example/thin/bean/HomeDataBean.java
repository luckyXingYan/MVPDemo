package com.example.thin.bean;

import com.example.thin.base.bean.BaseBean;

/**
 * @Author: xingyan
 * @Date: 2019/7/31
 * @Desc:
 */
public class HomeDataBean extends BaseBean {
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
