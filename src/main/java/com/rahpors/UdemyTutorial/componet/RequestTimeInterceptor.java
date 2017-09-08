package com.rahpors.UdemyTutorial.componet;

import com.rahpors.UdemyTutorial.repository.LogRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * Created by ramon on 30/08/17.
 */

@Component("requestTimeInterceptor")
public class RequestTimeInterceptor extends HandlerInterceptorAdapter{

    @Autowired
    @Qualifier("logRepository")
    private LogRepository logRepository;

    private static final Log LOG = LogFactory.getLog(RequestTimeInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.setAttribute("startTime",System.currentTimeMillis());
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        long startTime = (long)request.getAttribute("startTime");
        String url=request.getRequestURL().toString();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = "";
        if(auth!=null && auth.isAuthenticated()){
            username=auth.getName();
        }
        com.rahpors.UdemyTutorial.entity.Log log = new com.rahpors.UdemyTutorial.entity.Log(new Date(),auth.getDetails().toString(),username,url);
        logRepository.save(log);
        LOG.info("URL TO: '"+url+"' IN: '"+ (System.currentTimeMillis()-startTime)+"' ms");
    }
}
