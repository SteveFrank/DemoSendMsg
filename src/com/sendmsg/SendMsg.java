package com.sendmsg;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

public class SendMsg {
	
    public static void main(String[] args) throws Exception {  
    	
        HttpClient client = new HttpClient();
        PostMethod post = new PostMethod("http://gbk.sms.webchinese.cn");
        post.addRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=gbk");
        
        NameValuePair[] data = { new NameValuePair("Uid", "SteveFrank2015"),//账户号
                new NameValuePair("Key", "==============================="), //短信秘钥
                new NameValuePair("smsMob", "============================"), //需要发送的短信号码
                new NameValuePair("smsText", "您好,订单信息更新成功")
        };
        
        post.setRequestBody(data); 
        client.executeMethod(post);
        
        Header[] headers = post.getResponseHeaders();
        int statusCode = post.getStatusCode();
        System.out.println("statusCode:" + statusCode);
        
        for (Header h : headers) {
            System.out.println(h.toString());
        }
        
        String result = new String(post.getResponseBodyAsString().getBytes("gbk"));
        System.out.println(result);
        post.releaseConnection();
        
    }  
}  