/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mediamics.test.exception;

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
