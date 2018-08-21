package org.topview.util;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 此类为短信发送工具，使用时调用send方法传入对应参数即可
 *
 * @author Medwin。
 * @since 18/8/9
 */
public class MessageUtil {

    private static String URL_SEND = "https://sms.yunpian.com/v2/sms/batch_send.json";

    private static String ENCODING = "UTF-8";

    private static String API_KEY = "43f2b89fa9fa0febc89a4baf0d8ed35b";

    /**
     * @param text 短信内容
     * @param mobile 手机号码集合
     */
    public static void send(String text, List<String> mobile){
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

        Map<String, String> params = new HashMap<String, String>();//请求参数集合
        params.put("apikey", API_KEY);
        params.put("text", text);
        params.put("mobile", nums);

        System.out.println(post(URL_SEND,params));
    }


    /**
     * 基于HttpClient 的通用POST方法
     *
     * @param url       提交的URL
     * @param paramsMap 提交<参数，值>Map
     * @return 提交响应
     */

    public static String post(String url, Map < String, String > paramsMap) {
        CloseableHttpClient client = HttpClients.createDefault();
        String responseText = "";
        CloseableHttpResponse response = null;
        try {
            HttpPost method = new HttpPost(url);
            if (paramsMap != null) {
                List<NameValuePair> paramList = new ArrayList<NameValuePair>();
                for (Map.Entry < String, String > param: paramsMap.entrySet()) {
                    NameValuePair pair = new BasicNameValuePair(param.getKey(),
                            param.getValue());
                    paramList.add(pair);
                }
                method.setEntity(new UrlEncodedFormEntity(paramList,
                        ENCODING));
            }
            response = client.execute(method);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                responseText = EntityUtils.toString(entity, ENCODING);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != response){
                    response.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return responseText;
    }
}
