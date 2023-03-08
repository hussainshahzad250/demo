package com.hussain.utils;

import java.util.List;

public class DataBeanList {

    public static List<DataBean> getDataBeanList() {
        return List.of(new DataBean("Shahzad", "India"), new DataBean("Stephen", "India"), new DataBean("Suraj", "US"), new DataBean("Paul", "US"));
    }

}