package org.example.filter;

import org.example.model.JSONResponse;
import org.example.util.JSONUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author nuonuo
 * @create 2020-12-07 17:15
 * <p>
 * 配置用户统一会话管理的过滤器：匹配所有请求路径
 * 1.服务器资源：/login不用校验Session,其他都要校验
 * 如果不通过 返回401响应码
 * 2.前端资源：/jsp/*需要校验Session，不通过重定向到登录页面
 * 3./js/* /static/* /view/*全部不校验
 */

@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    /**
     * 每次http请求匹配到过滤器路径时，会执行该过滤器的doFilter()
     * 如果往下执行，调用chain.doFilter(request,response)
     * 否则需要自行处理相应
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        //1.先处理不需要登录就允许访问的 ：直接往下执行
        String servletPath = req.getServletPath();//获取当前请求的服务路径
        if (servletPath.startsWith("/js/") ||
                servletPath.startsWith("/static/") ||
                servletPath.startsWith("/view/") ||
                servletPath.equals("/login")) {
            chain.doFilter(request,response);
        } else {
            //获取Session对象，没有就返回null
            HttpSession session = req.getSession(false);
            //验证用户是否登录
            if (session == null || session.getAttribute("user") == null) {
                //如果没有登录
                if (servletPath.startsWith("/jsp/")) {
                    //重定向到登录页面
                    resp.sendRedirect(basePath(req) + "/view/login.html");
                } else {
                    //剩下的全是需要登录才能访问的敏感资源，且当前没有登录
                    //返回401响应码
                    resp.setStatus(401);
                    resp.setCharacterEncoding("UTF-8");
                    resp.setContentType("application/json");
                    JSONResponse json = new JSONResponse();
                    json.setCode("LOG000");
//                    json.setSuccess(false);
                    json.setMessage("用户没有登录，不允许访问");
                    PrintWriter writer = resp.getWriter();
                    writer.println(JSONUtil.serialize(json));
                    writer.flush();
                    writer.close();
                }
            } else {
                //用户登录了 敏感资源但用户登录，所以放行
                chain.doFilter(request,response);
            }
        }

    }

    /**
     * 根据http请求 动态获取访问路径（服务路径之前的部分）
     * @param req
     * @return
     */
    public static String basePath(HttpServletRequest req) {
        String schema = req.getScheme();//获取http
        String host = req.getServerName();//主机ip或域名
        int port = req.getServerPort();//服务器端口号
        String contextPath = req.getContextPath();//应用上下文路径
        return schema + "://" + host + ":" + port + contextPath;
    }
    @Override
    public void destroy() {

    }
}
