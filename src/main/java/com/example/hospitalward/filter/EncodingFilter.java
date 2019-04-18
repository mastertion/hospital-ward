package com.example.hospitalward.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * 
 * @ClassName:  EncodingFilter   
 * @Description:TODO描述：字符编码设置为urf-8   
 * @author:
 * @date:   2018年10月6日 上午9:02:25
 */
@WebFilter(dispatcherTypes = {
				DispatcherType.REQUEST, 
				DispatcherType.FORWARD
		}, urlPatterns = { "/*" })
@SuppressWarnings(value="all")
public class EncodingFilter implements Filter {
	 
    private FilterConfig filterConfig = null;
    private String encode = null;
    private boolean isNotEncode = true;
    /**
     * 过滤器初始化
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
 
        this.filterConfig = filterConfig;
        encode = filterConfig.getInitParameter("encode") == null ?"utf-8":filterConfig.getInitParameter("encode");
    }
    /**
     *编码设置为utf-8.放行
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
 
	servletResponse.setContentType("text/html;charset=" + encode);
        filterChain.doFilter(new MyHttpRequest((HttpServletRequest) servletRequest),servletResponse);
    }
 
    @Override
    public void destroy() {
 
    }
    class MyHttpRequest extends HttpServletRequestWrapper {
 
        private HttpServletRequest httpServletRequest = null;
 
        public MyHttpRequest(HttpServletRequest request) {
            super(request);
            this.httpServletRequest = request;
        }
 
        public Map getParameterMap() {
 
            if (httpServletRequest.getMethod().equalsIgnoreCase("POST")) {
                try {
                    httpServletRequest.setCharacterEncoding(encode);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                return super.getParameterMap();
            } else if (httpServletRequest.getMethod().equalsIgnoreCase("GET")) {
 
                Map<String, String[]> map = httpServletRequest.getParameterMap();
                if(isNotEncode) {
                    for (Map.Entry<String, String[]> m : map.entrySet()) {
                        String[] v = m.getValue();
                        for (int i = 0; i < v.length; i++) {
                            try {
                                v[i] = new String(v[i].getBytes("iso8859-1"), encode);
                            } catch (UnsupportedEncodingException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    isNotEncode = false;   //第二次是查询缓存 防止再次编码
                }
                return map;
            }
            else {
                return super.getParameterMap();
            }
 
        }
 
        public String[] getParameterValues(String name) {
 
            return (String[]) this.getParameterMap().get(name);
        }
 
        public String getParameter(String name) {
 
            return getParameterValues(name) == null ? null : getParameterValues(name)[0];
        }
 
    }
}
