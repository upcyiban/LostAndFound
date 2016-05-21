package cn.edu.cup.yb.util;

/**
 * Created by echao on 2016/2/24.
 * Gson解析json,将易班返回的json解析为该类的对象
 */
public class SessionUser {
    public int visit_time;
    public VisitUser visit_user;
    public VisitOauth visit_oauth;

    public class VisitUser {
        public int userid;
        public String username;
        public String usernick;
        public char usersex;
    }

    public class VisitOauth {
        public String access_token;
        public int token_expires;
    }
}
