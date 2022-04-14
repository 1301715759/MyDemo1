package util;

import entity.User;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyUtil {
    public static String getStringID() {
        String id = null;
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        id = sdf.format(date);
        return  id;
    }

    public static Integer getUserId(HttpSession session) {
        User user = (User)session.getAttribute("user");
        return user.getId();
    }
}
