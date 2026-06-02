package com.wsh.JNDI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteObj extends Remote {
    public String hello(String str)  throws RemoteException;
}
