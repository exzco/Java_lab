package com.wsh.unserialize;

import javax.management.BadAttributeValueExpException;
import java.io.IOException;

public class Test_toStringPoc {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        unsafe_Person p1 = new unsafe_Person("aaa",13);
        BadAttributeValueExpException badAttributeValueExpException = new BadAttributeValueExpException(null);
        Method_u.setFieldValue(badAttributeValueExpException,"val",p1);
        Method_u.serialize(badAttributeValueExpException,"ser1.bin");
        Method_u.unserialize("ser1.bin");
    }
}
