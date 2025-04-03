package com.xk.util;


import com.alibaba.fastjson.JSON;
import com.cloud.apigateway.sdk.utils.Client;
import com.cloud.apigateway.sdk.utils.Request;
import net.sf.json.JSONObject;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 华为四要素认证
 *
 * @author jy
 */
public class HuaweiFourUtils {

    private static Logger logger = LoggerFactory.getLogger(HuaweiFourUtils.class);


    public static void main(String[] args) {
        //String realname = "何挺";
        //String bankcard = "623165029001801330";
        //String mobile = "18608000089";
        //String idcard = "610104198110076294";
        //String s = checkFourElements(bankcard, idcard, mobile, realname);
        //System.out.println(s);


        Map<String,String> cp=new HashMap<String,String>();
        cp.put("ck_cardno", "430124199308261715");//身份证号
        cp.put("ck_bankcard", "6222031901010801203");//银行卡号
        cp.put("ck_name", "陈志勇");//姓名
        Map<String,String> result=checkBankCardThree(cp);//姓名、手机号、身份证三要素
        System.out.println(JSON.toJSONString(result));
    }


    private static String AppKey = "dbcccaf73e534496abbe62bd0a1400db";
    private static String AppSecret = "25911f9b905d44cbbb089bbfc5db2df0";

    /**
     * 四要素认证、（银行卡号，身份证号，手机号，姓名）
     *
     * @param bankcard
     * @param idcard
     * @param mobile
     * @param realname
     * @return
     */
    public static String checkFourElements(String bankcard, String idcard, String mobile, String realname) {
        //Create a new request.
        Request request = new Request();
        try {
            //Set the AK/SK to sign and authenticate the request.
            request.setKey(AppKey);
            request.setSecret(AppSecret);

            //The following example shows how to set the request URL and parameters to query a VPC list.

            //Specify a request method, such as GET, PUT, POST, DELETE, HEAD, and PATCH.
            request.setMethod("POST");

            //Set a request URL in the format of https://{Endpoint}/{URI}.
            request.setUrl("https://bank4bzxsv1.apistore.huaweicloud.com/bank4bzxsv1");

            //Add header parameters, for example, x-domain-id for invoking a global service and x-project-id for invoking a project-level service.
            request.addHeader("Content-Type", "text/plain");

            //Add a body if you have specified the PUT or POST method. Special characters, such as the double quotation mark ("), contained in the body must be escaped.

            //Map<String, String> bodys = new LinkedHashMap<>();
            //bodys.put("bankcard", bankcard);
            //bodys.put("idcard", idcard);
            //bodys.put("mobile", mobile);
            //bodys.put("name", realname);
            //System.out.println(JSONObject.toJSON(bodys).toString());
            //request.setBody(JSONObject.toJSON(bodys).toString());
            request.addQueryStringParam("bankcard",bankcard);
            request.addQueryStringParam("idcard",idcard);
            request.addQueryStringParam("mobile",mobile);
            request.addQueryStringParam("realname",realname);


        } catch (Exception e) {
            e.printStackTrace();
            return "91096";
        }

        CloseableHttpClient client = null;
        try {
            //Sign the request.
            HttpRequestBase signedRequest = Client.sign(request);

            //Send the request.
            client = HttpClients.custom().build();
            HttpResponse response = client.execute(signedRequest);

            //Print the status line of the response.
            //System.out.println(response.getStatusLine().toString());

            //Print the header fields of the response.
            Header[] resHeaders = response.getAllHeaders();
            for (Header h : resHeaders) {
                System.out.println(h.getName() + ":" + h.getValue());
            }

            //Print the body of the response.
            HttpEntity resEntity = response.getEntity();
            String code ="";
            if (resEntity != null) {
                // EntityUtils.toString(resEntity, "UTF-8") 只能读取一次，读取一次后，流就关闭了
                //System.out.println(System.getProperty("line.separator") + EntityUtils.toString(resEntity, "UTF-8"));
                String jsonStr = EntityUtils.toString(resEntity,"utf-8");
                System.out.println(jsonStr);
                JSONObject jsonObject = JSONObject.fromObject(jsonStr);
                if (jsonObject.get("errcode").equals("00000")){
                    code = "00000";
                    return code;
                }else if(jsonObject.get("errcode").equals("000J4")){
                    code = "000J4";
                    return code;
                }else if(jsonObject.get("errcode").equals("00081")){
                    code = "00081";
                    return code;
                }else if(jsonObject.get("errcode").equals("000J7")){
                    code = "000J7";
                    return code;
                }else if(jsonObject.get("errcode").equals("21081")){
                    code = "21081";
                    return code;
                }else {
                    code = "91096";
                    return code;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (client != null) {
                    client.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "91096";
    }
    // 错误码
    //00000      验证通过
    //000J4      姓名与银行卡信息预留不一致
    //00070      银行卡未开通银联无卡服务
    //00081      银行卡号错误
    //000J7      银行卡状态异常
    //000J8      不允许进行的交易
    //01031      不支持的银行卡种
    //00061      验证次数超限
    //21081      请求银行卡号格式错误
    //21089      请求流水号重复
    //210J4      请求姓名格式错误
    //000J9      发卡方或交换中心不能操作
    //910 RE     系统交易超时
    //91096      系统其它错误
    //21005      该产品暂时无法使用

    /**
     * HuaWei Bank+idcard
     * 杭州安那其科技有限公司
     * https://bankardthree.apistore.huaweicloud.com/bankcard3/check
     * @param info_three  需要校验的信息集合
     * @return
     */
    public static Map<String,String> checkBankCardThree(Map<String,String> info_three) {
        Request request = new Request();
        Map<String,String> return_map=new HashMap<String,String>();
        return_map.put("code","fail");
        CloseableHttpClient client = null;
        try {
            request.setKey("183c0c1d27034baebe448fbeaed25c9c"); //创建应用时得到
            request.setSecret("99c706f5ac6e40c69884b49565497c68"); //创建应用时得到
            request.setMethod("POST");
            request.setUrl("https://bankardthree.apistore.huaweicloud.com/bankcard3/check");
            //url地址
            request.addQueryStringParam("bankcard", info_three.get("ck_bankcard"));
            request.addQueryStringParam("name", info_three.get("ck_name"));
            request.addQueryStringParam("idcard", info_three.get("ck_cardno"));
            request.addHeader("Content-Type", "text/plain");
            //request.addHeader("x-stage", "publish_env_name"); //如果API发布到非RELEASE环境，需要增加自定义的环境名称
            //request.setBody("demo");
            System.out.println(request.getQueryStringParams());
            HttpRequestBase signedRequest = Client.sign(request);

            client = HttpClients.custom().build();
            HttpResponse response = client.execute(signedRequest);
            System.out.println(response.getStatusLine().toString());
            Header[] resHeaders = response.getAllHeaders();
            for (Header h : resHeaders) {
                System.out.println(h.getName() + ":" + h.getValue());
            }
            HttpEntity resEntity = response.getEntity();
            if (resEntity != null) {
                String jsonStr=EntityUtils.toString(resEntity, "UTF-8");
                JSONObject result= JSONObject.fromObject(jsonStr);
                logger.info("华为银行卡，身份证、姓名要素认证["+info_three.get("ck_name")+"-"+info_three.get("ck_bankcard")+"-"+info_three.get("ck_cardno")+"]:"+ JSON.toJSONString(result));
                String code=result.getString("code");

                if(code.equals("200")){
                    JSONObject data = result.getJSONObject("data");
                    if(data.getString("result").equals("0")){
                        return_map.put("msg","一致");
                        return_map.put("code","success");
                        return_map.put("trueCode","00000");
                        return return_map;
                    }else {
                        return_map.put("msg",data.getString("msg"));
                        return_map.put("code","fail");
                        return_map.put("trueCode","99999");
                        return return_map;
                    }
                }else {
                    return_map.put("code","fail");
                    return_map.put("trueCode","99999");
                    return_map.put("msg",result.getString("msg"));
                    return return_map;
                }
            }else{
                return_map.put("trueCode","NULL");
                return_map.put("code","wait");
                return_map.put("msg","认证查询为空");
                return return_map;
            }
        } catch (Exception e) {
            return_map.put("trueCode","ERR");
            return_map.put("code","wait");
            return_map.put("msg","华为认证通道异常");
            e.printStackTrace();
            return return_map;
        } finally {
            logger.info("华为银行卡，身份证、姓名要素认证["+info_three.get("ck_bankcard")+"-"+info_three.get("ck_cardno")+"]:"+JSON.toJSONString(return_map));
            try {
                if (client != null) {
                    client.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
