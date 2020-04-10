package com.doublez.aop;

import com.doublez.bean.DBContextHolder;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DataSourceAop {

    @Pointcut("!@annotation(com.doublez.annotation.Master) " +
            "&& (execution(* com.doublez.service..*.select*(..)) " +
            "|| execution(* com.doublez.service..*.get*(..)))")
    public void readPointcut() {

    }

    @Pointcut("@annotation(com.doublez.annotation.Master) " +
            "|| execution(* com.doublez.service..*.insert*(..)) " +
            "|| execution(* com.doublez.service..*.add*(..)) " +
            "|| execution(* com.doublez.service..*.update*(..)) " +
            "|| execution(* com.doublez.service..*.edit*(..)) " +
            "|| execution(* com.doublez.service..*.delete*(..)) " +
            "|| execution(* com.doublez.service..*.remove*(..))")
    public void writePointcut() {

    }

    @Before("readPointcut()")
    public void read() {
        DBContextHolder.slave();
    }

    @Before("writePointcut()")
    public void write() {
        DBContextHolder.master();
    }


    /**
     * 另一种写法：if...else...  判断哪些需要读从数据库，其余的走主数据库
     */
//    @Before("execution(* com.cjs.example.service.impl.*.*(..))")
//    public void before(JoinPoint jp) {
//        String methodName = jp.getSignature().getName();
//
//        if (StringUtils.startsWithAny(methodName, "get", "select", "find")) {
//            DBContextHolder.slave();
//        }else {
//            DBContextHolder.master();
//        }
//    }
}