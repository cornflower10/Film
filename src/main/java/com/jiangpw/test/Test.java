package com.jiangpw.test;

import com.jiangpw.utils.JsonMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Test {
    public static void main(String[] args) {
//        String[] head = {"130","131","132","155","156","145","176","185","186","166"};
//
//        for (int j = 0; j < 10; j++) {
//            StringBuilder str=new StringBuilder();//定义变长字符串
//            Random random=new Random();
//            //随机生成数字，并添加到字符串
//            for(int i=0;i<8;i++){
//                str.append(random.nextInt(10));
//            }
//            String mStr = head[random.nextInt(10)];
//            String number =  mStr+ str.toString();
//            System.out.println(number);
//        }
        IMEI();
//        for (int i = 0; i <10 ; i++) {
//            System.out.println(getRandomString(16));
//        }
        List<Device> list =new ArrayList<Device>();
        Device device = new Device();
        device.setAPI("26");
        device.setNAME("huawei");
        list.add(device);
        JsonMapper jsonMapper =new JsonMapper();
       String str = jsonMapper.toJson(list);

    }



    private static void IMEI(){

        for (int j = 0; j <15 ; j++) {

            StringBuilder str=new StringBuilder();//定义变长字符串
            Random random=new Random();
            //随机生成数字，并添加到字符串
            for(int i=0;i<20;i++){
                str.append(random.nextInt(10));
            }
            String number =  str.toString();
            System.out.println(number);
        }

    }


    public static String getRandomString(int length){

        String str="abc14def23ghijk05lmnopq67rstuvw89xyz";

        Random random=new Random();

        StringBuffer sb=new StringBuffer();

        for(int i=0;i<length;i++){

            int number=random.nextInt(36);

            sb.append(str.charAt(number));

        }

        return sb.toString();

    }
}
