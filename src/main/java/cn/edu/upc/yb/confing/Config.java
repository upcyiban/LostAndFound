package cn.edu.upc.yb.confing;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by yyljj on 2016/5/21.
 */
@Component
public class Config {
    @Value("${yibanoauth.lostandfound.APPID}")
    public  String client_id;

    @Value("${yibanoauth.lostandfound.APPURL}")
    public  String redirect_uri;

    @Value("${yibanoauth.lostandfound.APPkey}")
    public  String AppSecret;

    @Value("${yibanoauth.lostandfound.name}")
    public String adminUsername;

    @Value("${yibanoauth.lostandfound.password}")
    public  String adminPassword;
}
