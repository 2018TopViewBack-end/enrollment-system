package org.topview.config.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.topview.entity.organization.bo.OrganizationBo;
import org.topview.util.Result;

import java.util.ArrayList;
import java.util.List;

@Aspect
@Component
@EnableAspectJAutoProxy
public class PageAspect<T extends List> {

    /*@Pointcut("execution(* org.topview.service.organization.serviceImpl.OrganizationServiceImpl.select*(..))")
    public void pointcut() {
    }*/

    @Around("execution(* org.topview.controller.organization.OrganizationController.se*(..))")
    public Result around(ProceedingJoinPoint joinPoint) throws Throwable {
        Result<List> result = (Result<List>) joinPoint.proceed();
        List resultData = result.getData();
        return Result.success(PageInfo.of(resultData));
    }

    @Before("execution(* org.topview.service.organization.serviceImpl.OrganizationServiceImpl.select*(..))")
    public void pageHelperBefore(JoinPoint joinPoint) {
        PageHelper.startPage((int)joinPoint.getArgs()[0],2);
    }


}
