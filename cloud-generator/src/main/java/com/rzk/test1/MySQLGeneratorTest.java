package com.rzk.test1;


import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.OutputFile;

import java.util.HashMap;
import java.util.Map;

/**
 * MySQL 代码生成
 *
 * @author lanjerry
 * @since 3.5.3
 */
public class MySQLGeneratorTest extends BaseGeneratorTest {

    /**
     * 数据源配置
     */
    private static final DataSourceConfig DATA_SOURCE_CONFIG = new DataSourceConfig
            .Builder("jdbc:mysql://120.0.0.1:3310/cloud2021?characterEncoding=utf8&serverTimezone=UTC","root","密码")
            .schema("rzk")
            .build();


    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir");

        AutoGenerator generator = new AutoGenerator(DATA_SOURCE_CONFIG);
        generator.strategy(strategyConfig().build());

        generator.global(globalConfig().build());

        // 设置自定义路径
        Map<OutputFile, String> pathInfo = new HashMap<>();
        pathInfo.put(OutputFile.xml, projectPath+"/src/main/java/xml");
        pathInfo.put(OutputFile.entity, projectPath+"/src/main/java/pojo");
        pathInfo.put(OutputFile.mapper, projectPath+"/src/main/java/mapper");
        pathInfo.put(OutputFile.service, projectPath+"/src/main/java/service");
        pathInfo.put(OutputFile.serviceImpl, projectPath+"/src/main/java/service/Impl");
        pathInfo.put(OutputFile.controller, projectPath+"/src/main/java/controller");
        generator.packageInfo(packageConfig().pathInfo(pathInfo).build());

        generator.execute();
    }

}