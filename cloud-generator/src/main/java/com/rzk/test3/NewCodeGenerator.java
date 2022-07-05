package com.rzk.test3;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.fill.Column;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class NewCodeGenerator {

    public static void main(String[] args) {

//    new DataSourceConfig.Builder("jdbc:mysql://120.0.0.1:3310/cloud2021?characterEncoding=utf8&serverTimezone=UTC","root","密码")
//            .build();
        String projectPath = System.getProperty("user.dir");
    FastAutoGenerator.create("jdbc:mysql://120.0.0.1:3310/cloud2021?characterEncoding=utf8&serverTimezone=UTC","root","密码")
            .globalConfig(builder -> {
        builder.author("rzk") // 设置作者
                .enableSwagger() // 开启 swagger 模式
                .fileOverride() // 覆盖已生成文件
                .outputDir(projectPath+"/src/main/java"); // 指定输出目录
    })
            .packageConfig(builder -> {
        builder.parent("com.rzk") // 设置父包名
                .moduleName("springcloud") // 设置父包模块名
                .pathInfo(Collections.singletonMap(OutputFile.xml, "/src/main/resources/com/rzk/mapper/")); // 设置mapperXml生成路径
    })
            .strategyConfig((scanner, builder)  -> {
        builder.addInclude(scanner.apply("表名，多个英文逗号分割").split(",")) // 设置需要生成的表名
                .addTablePrefix("t_", "c_")
                .controllerBuilder().enableFileOverride()//开启重新生成覆盖  官方源码说fileOverride后续会做删除 ,后续用这个替换enableFileOverride
                .serviceBuilder().enableFileOverride()//开启重新生成覆盖
                .entityBuilder().enableFileOverride()//开启重新生成覆盖
                .mapperBuilder().enableFileOverride()//开启重新生成覆盖
        ; // 设置过滤表前缀
    })
            .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
            .execute();
    }


/**
    FastAutoGenerator.create("jdbc:mysql://120.0.0.1:3310/cloud2021?characterEncoding=utf8&serverTimezone=UTC","root","密码")
            // 全局配置
            .globalConfig((scanner, builder) -> builder.author(scanner.apply("请输入作者名称？")).fileOverride())
            // 包配置
            .packageConfig((scanner, builder) -> builder.parent(scanner.apply("请输入包名？")))
            // 策略配置
            .strategyConfig((scanner, builder) -> builder.addInclude(getTables(scanner.apply("请输入表名，多个英文逗号分隔？所有输入 all")))
            .controllerBuilder().enableRestStyle().enableHyphenStyle()
                        .entityBuilder().enableLombok().addTableFills(
                                new Column("create_time", FieldFill.INSERT)
                        ).build())

        模板引擎配置，默认 Velocity 可选模板引擎 Beetl 或 Freemarker
       .templateEngine(new BeetlTemplateEngine())
       .templateEngine(new FreemarkerTemplateEngine())

            .execute();



    }


    // 处理 all 情况
    protected static List<String> getTables(String tables) {
        return "all".equals(tables) ? Collections.emptyList() : Arrays.asList(tables.split(","));
    }
    **/

}
