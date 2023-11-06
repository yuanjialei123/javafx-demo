package com.example.javafxdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: #{auth}
 * @Mail: #{email}
 * @Date: 2023/11/6 21:27
 * @Version: 1.0
 * @Description:
 */
@Service
public class YourService {

    private String url = "";
    public void saveDatabaseInfoToRedis(String databaseInfo) {
        url = databaseInfo;
        System.out.println("保存成功");
    }

    public String getDatabaseInfoFromRedis() {
        System.out.println("获取成功:"+url);
        return url;
    }
}
