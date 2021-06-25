package it.ssm.service.impl;

import it.ssm.service.okHttpService;
import it.ssm.tools.urlCheck;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class okHttpServiceImpl implements okHttpService {

    private final OkHttpClient client = new OkHttpClient();

    @Override
    public String getUrl(String url) throws IOException {
        //输入过滤
//        Boolean urlIsValid = urlCheck.isValid(url);
//
//        if (!urlIsValid){
//            return "非法URL";
//        }

        Request request = new Request.Builder().url(url).build();

        Response response = client.newCall(request).execute();
        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

        return response.body().string();
    }
}
