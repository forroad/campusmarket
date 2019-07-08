package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;

public class SessionScanerListener implements HttpSessionListener, ServletContextListener, ServletRequestListener {
    private List<HttpSession> list = Collections.synchronizedList(new LinkedList<HttpSession>());

    private Object lock = new Object();

    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("session被创建了!!");
        HttpSession session = se.getSession();
        synchronized (lock){
            list.add(session);
        }
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("session被销毁");
    }

    public void contextInitialized(ServletContextEvent sce) {
           System.out.println("web应用初始化");
           //创建定时器
           Timer timer = new Timer();
           //每隔30秒就定时执行任务
           timer.schedule(new Mytask(list,lock), 0, 1000*30);
    }

    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("web应用关闭");
    }

    public void requestInitialized(ServletRequestEvent sre) {
        HttpServletRequest request = (HttpServletRequest)sre.getServletRequest();
        try{
            request.setCharacterEncoding("UTF-8");
        }catch (Exception e){
            System.out.println("不支持的编码");
            e.printStackTrace();
        }

    }

    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
    }
}
