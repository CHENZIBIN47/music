package cn.chan.interceptor;


import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;

public class LoginInterceptor extends MethodFilterInterceptor{
    @Override
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();

        Object username = request.getSession().getAttribute("username");

        if(username != null)
        {

            //username存在执行action
            return actionInvocation.invoke();

        }else {

            //username不存在返回到登录页面
            return "toLogin";
        }


    }
}
