package com.example.mall.common;

import java.util.*;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.querys.MySqlQuery;
import com.baomidou.mybatisplus.generator.config.rules.IColumnType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.mysql.cj.jdbc.Driver;

/**
 * 代码生成器演示
 *
 * @author hubin
 * @since 2016-12-01
 */
public class MysqlGenerator {

    /**
     * MySQL 生成演示
     */
    public static void main(String[] args) {

        String moduleName = "test";
        String parent = "com.baomidou";
        String dir = "D:/develop/" + parent.replaceAll("\\.", "/") + "/" + moduleName;


        int result = 1;
        // 自定义需要填充的字段
        List<TableFill> tableFillList = new ArrayList<>();
        tableFillList.add(new TableFill("ASDD_SS", FieldFill.INSERT_UPDATE));

        FileOutConfig entityDTOOutConfig = new FileOutConfig(
                "/templates/entityDTO.java.ftl") {
            // 自定义输出文件目录
            @Override
            public String outputFile(TableInfo tableInfo) {
                String[] tableNames = tableInfo.getName().split("_");
                StringBuffer sb = new StringBuffer();
                int i = 0;
                for (String string : tableNames) {
                    if (i == 0) {
                        i++;
                        continue;
                    }
                    sb.append(string);
                }
                return dir + "/dto/"+sb.toString()+"/" + tableInfo.getEntityName() + "DTO.java";
            }
        };

        FileOutConfig entityQueryDTOOutConfig = new FileOutConfig(
                "/templates/entityQueryDTO.java.ftl") {
            // 自定义输出文件目录
            @Override
            public String outputFile(TableInfo tableInfo) {
                String[] tableNames = tableInfo.getName().split("_");
                StringBuffer sb = new StringBuffer();
                int i = 0;
                for (String string : tableNames) {
                    if (i == 0) {
                        i++;
                        continue;
                    }
                    sb.append(string);
                }
                return dir + "/dto/"+sb.toString()+"/" + tableInfo.getEntityName() + "QueryDTO.java";
            }
        };

        FileOutConfig commonAttributeOutConfig = new FileOutConfig(
                "/templates/CommonAttribute.java.ftl") {
            // 自定义输出文件目录
            @Override
            public String outputFile(TableInfo tableInfo) {
                String[] tableNames = tableInfo.getName().split("_");
                StringBuffer sb = new StringBuffer();
                int i = 0;
                for (String string : tableNames) {
                    if (i == 0) {
                        i++;
                        continue;
                    }
                    sb.append(string);
                }
                return dir + "/controller/vo/"+sb.toString()+"/CommonAttribute.java";
            }
        };

        FileOutConfig entityAddReqOutConfig = new FileOutConfig(
                "/templates/entityAddReq.java.ftl") {
            // 自定义输出文件目录
            @Override
            public String outputFile(TableInfo tableInfo) {
                String[] tableNames = tableInfo.getName().split("_");
                StringBuffer sb = new StringBuffer();
                int i = 0;
                for (String string : tableNames) {
                    if (i == 0) {
                        i++;
                        continue;
                    }
                    sb.append(string);
                }
                return dir + "/controller/vo/"+sb.toString()+"/" + tableInfo.getEntityName() + "AddReq.java";
            }
        };

        FileOutConfig entityUpdateReqOutConfig = new FileOutConfig(
                "/templates/entityUpdateReq.java.ftl") {
            // 自定义输出文件目录
            @Override
            public String outputFile(TableInfo tableInfo) {
                String[] tableNames = tableInfo.getName().split("_");
                StringBuffer sb = new StringBuffer();
                int i = 0;
                for (String string : tableNames) {
                    if (i == 0) {
                        i++;
                        continue;
                    }
                    sb.append(string);
                }
                return dir + "/controller/vo/"+sb.toString()+"/" + tableInfo.getEntityName() + "UpdateReq.java";
            }
        };

        FileOutConfig entityListReqOutConfig = new FileOutConfig(
                "/templates/entityListReq.java.ftl") {
            // 自定义输出文件目录
            @Override
            public String outputFile(TableInfo tableInfo) {
                String[] tableNames = tableInfo.getName().split("_");
                StringBuffer sb = new StringBuffer();
                int i = 0;
                for (String string : tableNames) {
                    if (i == 0) {
                        i++;
                        continue;
                    }
                    sb.append(string);
                }
                return dir + "/controller/vo/"+sb.toString()+"/" + tableInfo.getEntityName() + "ListReq.java";
            }
        };

        FileOutConfig entityRespOutConfig = new FileOutConfig(
                "/templates/entityResp.java.ftl") {
            // 自定义输出文件目录
            @Override
            public String outputFile(TableInfo tableInfo) {
                String[] tableNames = tableInfo.getName().split("_");
                StringBuffer sb = new StringBuffer();
                int i = 0;
                for (String string : tableNames) {
                    if (i == 0) {
                        i++;
                        continue;
                    }
                    sb.append(string);
                }
                return dir + "/controller/vo/"+sb.toString()+"/" + tableInfo.getEntityName() + "Resp.java";
            }
        };

        // 代码生成器
        AutoGenerator mpg = new AutoGenerator().setGlobalConfig(
                // 全局配置
                new GlobalConfig()
                        .setOutputDir("D:/develop")//输出目录
                        .setFileOverride(true)// 是否覆盖文件
                        .setActiveRecord(false)// 开启 activeRecord 模式
                        .setEnableCache(false)// XML 二级缓存
                        .setBaseResultMap(false)// XML ResultMap
                        .setBaseColumnList(false)// XML columList
                        //.setKotlin(true) 是否生成 kotlin 代码
                        .setAuthor("fuwei")
                        .setSwagger2(true)
                // 自定义文件命名，注意 %s 会自动填充表实体属性！
                // .setEntityName("%sEntity");
                // .setMapperName("%sDao")
                // .setXmlName("%sDao")
                .setServiceName("%sService")
                // .setServiceImplName("%sServiceDiy")
                // .setControllerName("%sAction")
        ).setDataSource(
                // 数据源配置
                new DataSourceConfig()
                        .setDbType(DbType.MYSQL) // 数据库类型
                        .setTypeConvert(new MySqlTypeConvert() {
                            // 自定义数据库表字段类型转换【可选】
                            @Override
                            public IColumnType processTypeConvert(GlobalConfig globalConfig, String fieldType) {
                                System.out.println("转换类型：" + fieldType);
                                // if ( fieldType.toLowerCase().contains( "tinyint" ) ) {
                                //    return DbColumnType.BOOLEAN;
                                // }
                                return super.processTypeConvert(globalConfig, fieldType);
                            }
                        })
                        .setDbQuery(new MySqlQuery() {

                            /**
                             * 重写父类预留查询自定义字段<br>
                             * 这里查询的 SQL 对应父类 tableFieldsSql 的查询字段，默认不能满足你的需求请重写它<br>
                             * 模板中调用：  table.fields 获取所有字段信息，
                             * 然后循环字段获取 field.customMap 从 MAP 中获取注入字段如下  NULL 或者 PRIVILEGES
                             */
                            @Override
                            public String[] fieldCustom() {
                                return new String[]{"NULL", "PRIVILEGES"};
                            }
                        })
                        .setDriverName(Driver.class.getName())
                        .setUsername("root")
                        .setPassword("123456")
                        .setUrl("jdbc:mysql://127.0.0.1:3306/mall?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true&useSSL=false&zeroDateTimeBehavior=convertToNull&serverTimezone=UTC")
        ).setStrategy(
                // 策略配置
                new StrategyConfig()
                        // .setCapitalMode(true)// 全局大写命名
                        // .setDbColumnUnderline(true)//全局下划线命名
                        .setTablePrefix(new String[]{"t_", "mp_"})// 此处可以修改为您的表前缀
                        .setNaming(NamingStrategy.underline_to_camel)// 表名生成策略
                        .setInclude(new String[] { "t_order" }) // 需要生成的表
                        // .setExclude(new String[]{"test"}) // 排除生成的表
                        // 自定义实体父类
                        // .setSuperEntityClass("com.baomidou.demo.TestEntity")
                        // 自定义实体，公共字段
                        .setSuperEntityColumns(new String[]{"test_id"})
                        .setTableFillList(tableFillList)
                        .setEntityBooleanColumnRemoveIsPrefix(true)
                // 自定义 mapper 父类
                // .setSuperMapperClass("com.baomidou.demo.TestMapper")
                // 自定义 service 父类
                // .setSuperServiceClass("com.baomidou.demo.TestService")
                // 自定义 service 实现类父类
                // .setSuperServiceImplClass("com.baomidou.demo.TestServiceImpl")
                // 自定义 controller 父类
                // .setSuperControllerClass("com.baomidou.demo.TestController")
                // 【实体】是否生成字段常量（默认 false）
                // public static final String ID = "test_id";
                // .setEntityColumnConstant(true)
                // 【实体】是否为构建者模型（默认 false）
                // public User setName(String name) {this.name = name; return this;}
                // .setEntityBuilderModel(true)
                // 【实体】是否为lombok模型（默认 false）<a href="https://projectlombok.org/">document</a>
                // .setEntityLombokModel(true)
                // Boolean类型字段是否移除is前缀处理
                // .setEntityBooleanColumnRemoveIsPrefix(true)
                // .setRestControllerStyle(true)
                // .setControllerMappingHyphenStyle(true)
        ).setPackageInfo(
                // 包配置
                new PackageConfig()
                        .setModuleName(moduleName)
                        .setParent(parent)// 自定义包路径
                        .setController("controller")// 这里是控制器包名，默认 web
        ).setCfg(
                // 注入自定义配置，可以在 VM 中使用 cfg.abc 设置的值
                new InjectionConfig() {
                    @Override
                    public void initMap() {
                        Map<String, Object> map = new HashMap<>();
                        map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
                        this.setMap(map);
                    }
                }.setFileOutConfigList(Arrays.asList(entityDTOOutConfig, entityQueryDTOOutConfig, commonAttributeOutConfig,
                        entityAddReqOutConfig, entityUpdateReqOutConfig, entityListReqOutConfig, entityRespOutConfig))
        ).setTemplate(
                // 关闭默认 xml 生成，调整生成 至 根目录
                new TemplateConfig().setXml(null)
                // 自定义模板配置，模板可以参考源码 /mybatis-plus/src/main/resources/template 使用 copy
                // 至您项目 src/main/resources/template 目录下，模板名称也可自定义如下配置：
                // .setController("...");
                // .setEntity("...");
                // .setMapper("...");
                // .setXml("...");
                // .setService("...");
                //.setServiceImpl("src/main/resources/template/serviceImpl.java")
        );
        // 执行生成
        if (1 == result) {
            mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        }
        mpg.execute();

        // 打印注入设置，这里演示模板里面怎么获取注入内容【可无】
        System.err.println(mpg.getCfg().getMap().get("abc"));
    }

}
