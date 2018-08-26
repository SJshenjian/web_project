package com.haotu369.jvm.test;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.haotu369.jvm.engine.MiniJVM;

import org.junit.Test;

public class MiniJVMTest {

    static final String path = "E:\\JAVA\\MyEclipse2016\\miniJVM\\bin";

    @Test
    public void testEmployeeV1Main() throws FileNotFoundException, IOException {
        String[] classPaths = {path};
        MiniJVM miniJVM = new MiniJVM();
        miniJVM.run(classPaths, "jvm.test.EmployeeV1");
    }
	
    @Test
    public void testHourlyEmployeeMain() throws Exception {
        String[] classPaths = {path};
        MiniJVM jvm = new MiniJVM();
        jvm.run(classPaths, "jvm.test.HourlyEmployee");
    }
}
