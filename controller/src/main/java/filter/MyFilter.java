package filter;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器初始化");
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //转换request和response
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        String userId = null;
         Object o  = request.getSession().getAttribute("userId");
         if(o != null){
            userId = o.toString();
         }else {
             request.setAttribute("result","用户未登录");
             System.out.println(request.getContextPath());
             request.getRequestDispatcher("/login.jsp").forward(request,response);
             return;
         }

        if(userId == null ||userId.length() == 0){
            request.setAttribute("result","用户未登录");
            System.out.println(request.getContextPath());
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }else {
            filterChain.doFilter(request,response);
        }
    }

    public void destroy() {
        System.out.println("过滤器销毁");
    }
}
