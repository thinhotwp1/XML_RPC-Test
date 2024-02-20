package org.example.server_local;

import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XmlRpcClientExample {
    public static void main(String[] args) {
        try {
            // Cấu hình client
            XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
            config.setServerURL(new URL("http://10.212.9.108:10011/Air")); // Thay đổi URL cho phù hợp
            config.setEnabledForExtensions(true);
            config.setConnectionTimeout(60 * 1000);
            config.setReplyTimeout(60 * 1000);

            // Khởi tạo client
            XmlRpcClient client = new XmlRpcClient();
            client.setConfig(config);

            // Tạo tham số cho yêu cầu XML-RPC
            Map<String, Object> params = new HashMap<>();
            Map<String, Object> struct = new HashMap<>();
            struct.put("originNodeType", "EXT");
            struct.put("originHostName", "vxToolbox");
            struct.put("originTransactionID", "2024020316584557");
            struct.put("originTimeStamp", "20240203T16:58:45+0700");
            struct.put("subscriberNumberNAI", 1);
            List<Integer> capabilities = Arrays.asList(805642820, 163752);
            struct.put("negotiatedCapabilities", capabilities);
            struct.put("subscriberNumber", "842439990167");
            params.put("param", struct);

            // Gửi yêu cầu XML-RPC
            Object result = client.execute("GetGlobalParameterValues", new Object[]{params});
            System.out.println("Response: " + result.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
