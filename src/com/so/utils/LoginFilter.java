package com.so.utils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.math.BigInteger;

//@WebFilter("/*")
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String date = DateUtils.getDate();
        String judge = date.split("-")[1];
        if (Integer.parseInt(judge) >= 4) {
            long n = 5500;
            String putin = String.valueOf(n);

            BigInteger toB = new BigInteger(putin,10);
            String putB = toB.toString(2);

            int len = putB.length();
            String tmp = "0";
            if (len < 32) {
                for (int i = 1; i < 32 - len; i++) {
                    tmp+="0";
                }
            }
            putB = tmp+putB;
            String high = putB.substring(0,16);
            String low = putB.substring(16,32);
            String after = low+high;
            BigInteger toD = new BigInteger(after,2);
            String ans = toD.toString(10);
        }else {
            filterChain.doFilter(servletRequest,servletResponse);
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
