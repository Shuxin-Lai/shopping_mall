package com.vmall;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

public class CodeGenerator {
  public static void main(String[] args) {
    FastAutoGenerator.create("jdbc:mysql://127.0.0" +
        ".1:3306/v_mall?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull&autoReconnect" +
        "=true&useSSL=false&serverTimezone=Asia/Shanghai&allowPublicKeyRetrieval=true", "root", "mysql")
        .globalConfig(builder -> {
          builder.author("me") // 设置作者
              .enableSwagger() // 开启 swagger 模式
              .fileOverride() // 覆盖已生成文件
              .outputDir("D://tmp"); // 指定输出目录
        })
        .packageConfig(builder -> {
          builder.parent("com.vmall") // 设置父包名
              .moduleName("demo") // 设置父包模块名
              .pathInfo(Collections.singletonMap(OutputFile.xml, "D://__tmp__//vmall")); // 设置mapperXml生成路径
        })
        .strategyConfig(builder -> {
          builder.addInclude("tb_content",
              "tb_content_category",
              "tb_item",
              "tb_item_cat",
              "tb_item_desc",
              "tb_item_param",
              "tb_item_param_item",
              "tb_manager",
              "tb_order",
              "tb_order_item",
              "tb_order_shipping",
              "tb_test",
              "tb_user"); // 设置需要生成的表名
        })
        .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
        .execute();
  }
}
