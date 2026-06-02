package com.wsh.JNDI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RemoteObjImpl extends UnicastRemoteObject implements RemoteObj {
    public RemoteObjImpl() throws RemoteException {
        super();
    }

    @Override
    public String hello(String str) throws RemoteException {
        System.out.println("[+] 远程方法被调用");
        String result = "hello";
        return result+str;
    }
}
