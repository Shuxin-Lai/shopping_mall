package com.vmall;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CodeGenerator {
  public static void main(String[] args) {
    String url = "jdbc:mysql://127.0.0" +
        ".1:3306/v_mall?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull&autoReconnect" +
        "=true&useSSL=false&serverTimezone=Asia/Shanghai&allowPublicKeyRetrieval=true";
    String name = "root";
    String password = "mysql";

    //数据库表的设置
    List<String> listTable = Arrays.asList(
        "tb_content",
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
        "tb_user"
    );  //设置需要自动代码生成的表名
    List<String> listTableSuffix = Arrays.asList();    //设置 过滤 表的后缀
    List<String> listTablePrefix = Arrays.asList(); //设置 过滤 表的后缀

    //基本信息
    String author = "me";    //作者
    String parent = "com";   //父包名
    String module = "vmall";   //模块包名
//    String outDir = "D://__tmp__//vmall";


    //1、配置数据源
    FastAutoGenerator.create(url, name, password)
        //2、全局配置
        .globalConfig(builder -> {
          builder.author(author) // 设置作者名
              .outputDir(System.getProperty("user.dir") + "/src/main/java")   //设置输出路径：项目的 java 目录下【System
              // .getProperty("user.dir")意思是获取到项目所在的绝对路径】
              .commentDate("yyyy-MM-dd hh:mm:ss")   //注释日期
              .dateType(DateType.ONLY_DATE)   //定义生成的实体类中日期的类型 TIME_PACK=LocalDateTime;ONLY_DATE=Date;
              .fileOverride();   //覆盖之前的文件
//              .enableSwagger();  //开启 swagger 模式
//              .disableOpenDir();   //禁止打开输出目录，默认打开
        })
        //3、包配置
        .packageConfig(builder -> {
          builder.parent(parent) // 设置父包名
              .moduleName(module)   //设置模块包名
              .entity("entity")   //pojo 实体类包名
              .service("service") //Service 包名
              .serviceImpl("service.impl") // ***ServiceImpl 包名
              .mapper("mapper")   //Mapper 包名
              .xml("mapper.xml")  //Mapper XML 包名
              .controller("controller") //Controller 包名
              .other("config")    //自定义包名(一般不在这里生成，而是后面编写的时候自己建包）
              .pathInfo(Collections.singletonMap(OutputFile.xml, System.getProperty("user.dir") + "/src/main" +
                  "/resources/mapper"));    //配置 mapper.xml 路径信息：项目的 resources 目录下
        })
        //4、策略配置
        .strategyConfig(builder -> {
          builder
              .enableCapitalMode()    //开启大写命名
              .enableSkipView()   //创建实体类的时候跳过视图
              .addInclude(listTable) // 设置需要生成的数据表名
              .addTableSuffix(listTableSuffix) //设置 过滤 表的后缀
              .addTablePrefix(listTablePrefix) // 设置 过滤 表的前缀

              //4.1、实体类策略配置
              .entityBuilder()
              .enableChainModel() //开启链式模型
              //.disableSerialVersionUID()  //默认是开启实体类序列化，可以手动disable使它不序列化。由于项目中需要使用序列化就按照默认开启了
              .enableTableFieldAnnotation()       // 开启生成实体时生成字段注解
              .enableLombok() //开启 Lombok
              .versionColumnName("version")   //乐观锁字段名(数据库)
              .versionPropertyName("version") //乐观锁属性名(实体)
              .logicDeleteColumnName("deleted")   //逻辑删除字段名(数据库)
              .logicDeletePropertyName("deleteFlag")  //逻辑删除属性名(实体)
              .naming(NamingStrategy.underline_to_camel)  //数据库表映射到实体的命名策略：默认是下划线转驼峰命。这里可以不设置
              .columnNaming(NamingStrategy.underline_to_camel)    //数据库表字段映射到实体的命名策略：下划线转驼峰命。（默认是和naming一致，所以也可以不设置）
//              .addTableFills(
//                  new Column("create_time", FieldFill.INSERT),
//                  new Column("modify_time", FieldFill.INSERT_UPDATE)
//              )   //添加表字段填充，"create_time"字段自动填充为插入时间，"modify_time"字段自动填充为插入修改时间
//              .idType(IdType.AUTO)    //设置主键自增

              //4.2、Controller策略配置
              .controllerBuilder()
              .enableHyphenStyle()    //开启驼峰连转字符
              .formatFileName("%sController") //格式化 Controller 类文件名称，%s进行匹配表名，如 UserController
              .enableRestStyle()  //开启生成 @RestController 控制器

              //4.3、service 策略配置
              .serviceBuilder()
              .formatServiceFileName("%sService") //格式化 service 接口文件名称，%s进行匹配表名，如 UserService
              .formatServiceImplFileName("%sServiceImpl") //格式化 service 实现类文件名称，%s进行匹配表名，如 UserServiceImpl

              //4.4、Mapper策略配置
              .mapperBuilder()
              .superClass(BaseMapper.class)   //设置父类
              .enableBaseResultMap()  //启用 BaseResultMap 生成
              .enableBaseColumnList() //启用 BaseColumnList
              .formatMapperFileName("%sMapper")   //格式化 mapper 文件名称
              .enableMapperAnnotation()       //开启 @Mapper 注解
              .formatXmlFileName("%sXml") //格式化Xml文件名称
              .formatMapperFileName("%sMapper");   //格式化Mapper文件名称

        })
        //5、模板
        .templateEngine(new VelocityTemplateEngine())
        /*
            模板引擎配置，默认 Velocity 可选模板引擎 Beetl 或 Freemarker(以下两个引擎用哪个就保留哪个)
           .templateEngine(new BeetlTemplateEngine())
           .templateEngine(new FreemarkerTemplateEngine())
         */
        .templateEngine(new FreemarkerTemplateEngine())  //本人选择了Freemarker
        //6、执行
        .execute();
  }
}
