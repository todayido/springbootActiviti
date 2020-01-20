package com.redis.Resis;

import org.apache.poi.hssf.usermodel.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import redis.clients.jedis.Jedis;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;

public class Test {

    @org.junit.Test
    public void inserTestData() throws InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(RedisConfig.class);
        MysqlUtils mysqlUtils = context.getBean(MysqlUtils.class);
        CountDownLatch count = new CountDownLatch(10);
        long start = System.currentTimeMillis();

        for (int j = 0; j < 10; j++) {
            new Thread(()->{
                for (int i = 0; i < 100000; i++) {
                    mysqlUtils.insertData(UUID.randomUUID().toString());
                }
                count.countDown();
            }).start();
        }

        count.await();
        long end = System.currentTimeMillis();
        System.out.println("插入一百万数据，耗时：" + (end - start));
    }

    @org.junit.Test
    public void inserTestData2Resi() throws InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(RedisConfig.class);
        MysqlUtils mysqlUtils = context.getBean(MysqlUtils.class);
        RedisUtils redisUtils = context.getBean(RedisUtils.class);

        Jedis redis = redisUtils.getRedis();
        long start = System.currentTimeMillis();

        List<Map<String, String>> list = mysqlUtils.getData();
        for (int i = 0; i < list.size(); i++) {
            redis.set(list.get(i).get("value"), String.valueOf(list.get(i).get("id")));
        }


        long end = System.currentTimeMillis();
        System.out.println("插入一百万数据，耗时：" + (end - start));
    }

    @org.junit.Test
    public void test001(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(RedisConfig.class);
        RedisUtils redisUtils = context.getBean(RedisUtils.class);
        MysqlUtils mysqlUtils = context.getBean(MysqlUtils.class);
        Jedis redis = redisUtils.getRedis();

        // 查询数据库
        long start = System.currentTimeMillis();
        System.out.println("============================ redis size :" + redis.keys("*be229530-f8a3-4070-925b-bda8b6e3e6012222*").size());
        System.out.println("redis 耗时：" + (System.currentTimeMillis() - start));

        // 查询缓存
        start = System.currentTimeMillis();
        System.out.println("============================ mysql size :" + mysqlUtils.selectOne("be229530-f8a3-4070-925b-bda8b6e3e601").size());
        System.out.println("mysql 耗时：" + (System.currentTimeMillis() - start));

    }


    @org.junit.Test
    public void getTableInfo() throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(RedisConfig.class);
        MysqlUtils mysqlUtils = context.getBean(MysqlUtils.class);

        List<String> tableNames = mysqlUtils.getTableNames();



        String file = "d:\\xxxxxx.xls";
        //声明一个工作簿
        HSSFWorkbook hwb = new HSSFWorkbook();

        for (int i = 0; i < tableNames.size(); i++) {
            List<Map<String, String>> table = mysqlUtils.getTableInfo(tableNames.get(i));
            //声明一个单子并命名
            HSSFSheet sheet = hwb.createSheet(tableNames.get(i));
            //给单子名称一个长度
            sheet.setDefaultColumnWidth((short)15);
            //生成一个样式
            HSSFCellStyle style = hwb.createCellStyle();
            //创建第一行（也可以成为表头）
            HSSFRow row = sheet.createRow(0);
            //样式字体居中
            //style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
            //给表头第一行一次创建单元格
            HSSFCell cell = row.createCell((short) 0);
            cell.setCellValue("字段英文名");
            cell.setCellStyle(style);

            cell = row.createCell((short)1);
            cell.setCellValue("字段中文名");
            cell.setCellStyle(style);

            cell = row.createCell((short)2);
            cell.setCellValue("字段类型（含长度）");
            cell.setCellStyle(style);

            cell = row.createCell((short)3);
            cell.setCellValue("是否允许为空");
            cell.setCellStyle(style);

            cell = row.createCell((short)4);
            cell.setCellValue("主键");
            cell.setCellStyle(style);

            cell = row.createCell((short)5);
            cell.setCellValue("外键/索引");
            cell.setCellStyle(style);

            cell = row.createCell((short)6);
            cell.setCellValue("缺省值");
            cell.setCellStyle(style);

            cell = row.createCell((short)7);
            cell.setCellValue("字段说明");
            cell.setCellStyle(style);

            cell = row.createCell((short)8);
            cell.setCellValue("数据标准编号");
            cell.setCellStyle(style);

            cell = row.createCell((short)9);
            cell.setCellValue("数据标准中文名称");
            cell.setCellStyle(style);


            for (int k = 0; k < table.size(); k++) {
                row =sheet.createRow(k+1);
                Map<String, String> m = table.get(k);

                row.createCell(0).setCellValue(m.get("NAME"));
                row.createCell(1).setCellValue(m.get("COMMENT"));
                row.createCell(2).setCellValue(m.get("COLUMN_TYPE"));
                row.createCell(3).setCellValue(m.get("IS_NULLABLE"));
                row.createCell(4).setCellValue(m.get("COLUMN_KEY"));
                row.createCell(5).setCellValue("N");
                row.createCell(6).setCellValue(m.get("COLUMN_DEFAULT") == null ? "无" : m.get("COLUMN_DEFAULT"));
                row.createCell(7).setCellValue(m.get("COMMENT"));
                row.createCell(8).setCellValue("无");
                row.createCell(9).setCellValue("无");
            }
        }


        hwb.write(new File(file));
        hwb.close();
    }
}
