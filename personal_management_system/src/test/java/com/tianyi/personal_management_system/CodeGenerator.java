package com.tianyi.personal_management_system;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

public class CodeGenerator {
    public static void main(String[] args) {
        CodeGenerator codeGenerator=new CodeGenerator();
        codeGenerator.generate();
    }
    public void generate(){
        //代码生成器
        AutoGenerator autoGenerator=new AutoGenerator();

        //全局配置
        GlobalConfig globalConfig=new GlobalConfig();
        String projectPath=System.getProperty("user.dir");
        globalConfig.setOutputDir(projectPath+"/src/main/java");
        globalConfig.setAuthor("chen");
        globalConfig.setOpen(false);
        globalConfig.setSwagger2(true);
        autoGenerator.setGlobalConfig(globalConfig);

        //数据源配置
        DataSourceConfig dsc=new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/pms?serverTimezone=GMT%2B8");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("970628");
        autoGenerator.setDataSource(dsc);

        //包配置
        PackageConfig pc=new PackageConfig();
        pc.setModuleName("");
        pc.setParent("com.tianyi.personal_management_system");
        autoGenerator.setPackageInfo(pc);

//        // 自定义配置
//        InjectionConfig cfg = new InjectionConfig() {
//            @Override
//            public void initMap() {
//                // to do nothing
//            }
//        };
//
//        //模板引擎
//        String templatePath="/templates/mapper.xml.vm";

//        //自定义输出配置
//        List<FileOutConfig> focList=new ArrayList<FileOutConfig>();
//        //自定义配置会被优先
//        focList.add(new FileOutConfig(templatePath) {
//            @Override
//            public String outputFile(TableInfo tableInfo) {
//                //自定义输出文件名,如果你Entity 设置了前后缀,此处注意xml的名称会跟着发生变化
//                return projectPath+"/src/main/resource/mapper/"+pc.getModuleName()
//                        +"/"+tableInfo.getEntityName()+"Mapper"+ StringPool.DOT_XML;
//            }
//        });
//        cfg.setFileOutConfigList(focList);
//        autoGenerator.setCfg(cfg);

        //配置模板
        TemplateConfig templateConfig=new TemplateConfig();
        templateConfig.setXml(null);
        autoGenerator.setTemplate(templateConfig);

        //策略配置
        StrategyConfig strategy=new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
       // strategy.setSuperEntityClass("com.baomidou.ant.common.BaseEntity");
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        //公共父类
       // strategy.setSuperControllerClass("");
        // 写于父类中的公共字段
        strategy.setSuperEntityColumns("id");
        strategy.setInclude("employee_security");   //scanner("表名，多个英文逗号分割").split(",")
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix(pc.getModuleName() + "_");
        autoGenerator.setStrategy(strategy);
        autoGenerator.setTemplateEngine(new FreemarkerTemplateEngine());
        autoGenerator.execute();
    }
}
