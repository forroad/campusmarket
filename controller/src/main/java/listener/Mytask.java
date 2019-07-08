package listener;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.ListIterator;
import java.util.TimerTask;

public class Mytask extends TimerTask {
    private List<HttpSession> list;
    private Object lock;


    public Mytask(List<HttpSession> list, Object lock){
        this.list = list;
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
             System.out.println("定时器执行！！");
             ListIterator<HttpSession> it = list.listIterator();
             while(it.hasNext()) {
                 HttpSession session = (HttpSession) it.next();
                 if (System.currentTimeMillis() - session.getLastAccessedTime() > 1000 * 60 * 5) {
                     session.invalidate();
                     it.remove();
                 }
             }
        }
    }
}
