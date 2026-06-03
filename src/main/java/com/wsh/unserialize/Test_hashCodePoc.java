package com.wsh.unserialize;

import java.io.*;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public class Test_hashCodePoc {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, InstantiationException {
        unsafe_Person p1 = new unsafe_Person("aaa",13);
//        p1.hashCode();
        HashMap<Object, Object> map = new HashMap<>();

        Class<?> nodeClass = Class.forName("java.util.HashMap$Node");
        Object[] table = (Object[]) Array.newInstance(nodeClass, 16);

        Constructor<?> nodeCons = nodeClass.getDeclaredConstructor(int.class, Object.class, Object.class, nodeClass);
        nodeCons.setAccessible(true);
        Object node = nodeCons.newInstance(1, p1, p1, null);
        table[0] = node;

        Field tableField = HashMap.class.getDeclaredField("table");
        tableField.setAccessible(true);
        tableField.set(map, table);

        Field sizeField = HashMap.class.getDeclaredField("size");
        sizeField.setAccessible(true);
        sizeField.set(map, 1);

        FileOutputStream fos = new FileOutputStream("ser.bin");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(map);
        oos.close();

        FileInputStream fis = new FileInputStream("ser.bin");
        ObjectInputStream ois = new ObjectInputStream(fis);
        ois.readObject();
    }
}
