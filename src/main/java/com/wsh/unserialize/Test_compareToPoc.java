package com.wsh.unserialize;

import java.io.IOException;
import java.util.Objects;
import java.util.PriorityQueue;

public class Test_compareToPoc {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        unsafe_Person p1 = new unsafe_Person("aac",19);
        unsafe_Person p2 = new unsafe_Person("aabc",19);
        PriorityQueue<Object> pq = new PriorityQueue<>();
        pq.add(p1);
        pq.add(p2);
        Method_u.serialize(pq,"ser2.bin");
        Method_u.unserialize("ser2.bin");
    }
}
