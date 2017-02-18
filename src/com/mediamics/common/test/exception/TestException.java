package com.mediamics.common.test.exception;

import com.mediamics.common.exception.ServiceRuntimeException;

/**
 *
 * @author Matsu
 */
public class TestException {

    public static void main(String[] args) {
        try {
            new TestException().test();
        } catch (ServiceRuntimeException ex) {
            ex.getMessages().forEach(System.out::println);
            throw ex;
        }
    }

    public void test() {
        try {
            int i = 100 / 0;
        } catch (RuntimeException ex) {
            throw new ServiceRuntimeException("エラーが発生しました。", ex);
        }
    }

}
