package com.wsh.JNDI;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.rmi.RemoteException;

public class JNDIClient {
    public static void main(String[] args) throws NamingException, RemoteException {
        InitialContext ctx = new InitialContext();
//        RemoteObj remoteObj = (RemoteObj) ctx.lookup("rmi://localhost:1099/remoteObj");
        ctx.lookup("ldap://localhost:7778/Calc_");


    }
}
