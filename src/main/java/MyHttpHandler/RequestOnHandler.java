package MyHttpHandler;

import Controller.UseController;
import app.Request;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import net.sf.json.JSONObject;

import java.io.*;
import Enum.*;

import javax.persistence.EnumType;

public class RequestOnHandler implements HttpHandler {
    private UseController useController;

    public RequestOnHandler(UseController useController){
        super();
        this.useController=useController;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String requestMethod = exchange.getRequestMethod();
        if (requestMethod.equalsIgnoreCase("POST")) {
            InputStream in = exchange.getRequestBody();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String str = reader.readLine();
            System.out.println(str);
            JSONObject resJson = JSONObject.fromObject(str);
            System.out.println("收到：" + resJson);
            //这里不是roomId
            int id=resJson.getInt("id");
            double targetTemperature=resJson.getDouble("targetTemperature");
            int fanSpeed=resJson.getInt("fanSpeed");
            //
            //从id取得房间id
            //
            useController.requestOn(new Request(id,targetTemperature, FanSpeed.values()[fanSpeed],0,useController.getMode()));

            Headers responseHeaders = exchange.getResponseHeaders();
            responseHeaders.set("Content-Type", "application/json");
            exchange.sendResponseHeaders(200, 0);

            OutputStream responseBody = exchange.getResponseBody();
            JSONObject json=new JSONObject();
            json.put("status",0);
            responseBody.write(json.toString().getBytes());
            responseBody.close();
        }
    }
}
