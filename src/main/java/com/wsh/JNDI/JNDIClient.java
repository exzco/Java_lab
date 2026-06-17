package com.wsh.JNDI;

import com.dataflow.TraceContext;
import com.dataflow.model.TraceFlowReport;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.rmi.RemoteException;

public class JNDIClient {
    public static void main(String[] args) throws NamingException, RemoteException {
        InitialContext ctx = new InitialContext();
//        RemoteObj remoteObj = (RemoteObj) ctx.lookup("rmi://localhost:1099/remoteObj");
        TraceFlowReport report = TraceContext.trace("lookup", "${java:os}", () -> {
            try {
                ctx.lookup("ldap://localhost:7778/Calc_");
            } catch (NamingException e) {
                throw new RuntimeException(e);
            }
        });
        // 打印调用栈
        System.out.println(report.toTreeString());
    }
}
