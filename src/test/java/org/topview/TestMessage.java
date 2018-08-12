package org.topview;

import com.sun.imageio.plugins.common.ImageUtil;
import org.junit.Test;
import org.topview.util.MessageUtil;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.topview.util.ImgUtil.cut;
import static org.topview.util.ImgUtil.resize;

public class TestMessage {

    @Test
    public void test1(){
//        Map<String, String> params = new HashMap<String, String>();//请求参数集合
        List<String> mobile = new ArrayList<String>();
//        mobile.add("15521070771");
        mobile.add("15521079814");//清林
        mobile.add("15521301561");
        mobile.add("15521212294");//学委
        mobile.add("18476977625");//上荣
        mobile.add("15521055850");//zh
        String text = "【邓哲睿】您购买的topview订单已成功消费，祝您生活愉快！";
        MessageUtil.send(text,mobile);

//     * @param apikey 成功注册后登录云片官网,进入后台可查看
//     * @param text   需要使用已审核通过的模板或者默认模板
//     * @param mobile 接收的手机号,多个手机号用英文逗号隔开
//        String apikey ="43f2b89fa9fa0febc89a4baf0d8ed35b";
//        String text = "【邓哲睿】您购买的100订单已成功消费，祝您生活愉快！";
//        String mobile = "18024140716,15521301561";
//        String mobile = "15521301561";
//        params.put("apikey", apikey);
//        params.put("text", text);
//        params.put("mobile", mobile);
//        MessageUtil.post(MessageUtil.URL_SEND,params);
    }

    @Test
    public void test2() {
       List<String> mobile = new ArrayList<String>();

       StringBuffer sb = new StringBuffer();
       //将号码列表转换为以逗号分隔的字符串形式
       for (int i = 0; i < mobile.size() ;i++){
           sb.append(mobile.get(i));
           if (i == mobile.size() - 1){
               break;
           }
           sb.append(",");
       }
       String nums = sb.toString();

       System.out.println(nums);
    }

    @Test
    public void test3(){
        String srcImg = "d:/img/1.jpg";
        String tarDir = "d:/img/";
        URL url = ImageUtil.class.getResource("1.jpg");
        File srcfile = null;

            srcfile = new File(srcImg);

        System.out.println(url);
        System.out.println(srcfile.exists() + ", dir=" + srcfile.getParent());
        tarDir = srcfile.getParent();
        srcImg = srcfile.getPath();
//        System.out.println("srcImg=" + srcImg);
        long startTime = new Date().getTime();
//        resize(srcImg, tarDir + "car_1_maxLength_1-200px.jpg", 200);
//        cut(srcfile, tarDir+ "car_1_maxLength_3.jpg",300,300,300, 264654);
//        Tosmallerpic(srcImg, tarDir + "car_1_maxLength_2.jpg", 0.5F);
//        resize(srcImg, tarDir + "car_1_maxLength_3.jpg", 400, 500);
//        resize(srcImg, tarDir + "car_1_maxLength_4-400x400.jpg", 220, 220);
//        resize(srcImg, tarDir + "car_1_maxLength_11-220px-yinhui.jpg", 220, 0.7F);
//        Tosmallerpic(srcImg, tarDir + "car_1_maxLength_22.jpg", 0.5F, 0.8F);
//        resize(srcImg, tarDir + "car_1_maxLength_33.jpg", 400, 500, 0.8F);

        System.out.println(new Date().getTime() - startTime);
    }
}
