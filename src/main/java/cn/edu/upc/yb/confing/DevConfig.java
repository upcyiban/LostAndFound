package cn.edu.upc.yb.confing;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by yyljj on 2016/5/21.
 */
@Component
public class DevConfig {
    @Value("${yibanoauth.lostandfound.APPID}")
    public static String client_id;

    @Value("${yibanoauth.lostandfound.APPURL}")
    public static String redirect_uri;

    @Value("${yibanoauth.lostandfound.APPkey}")
    public static String AppSecret;

    @Value("${yibanoauth.lostandfound.name}")
    public static String adminUsername;

    @Value("${yibanoauth.lostandfound.password}")
    public static String adminPassword;
}
