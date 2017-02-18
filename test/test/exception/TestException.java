package test.exception;

import com.mediamics.common.exception.ServiceRuntimeException;
import com.mediamics.common.logger.Log;

/**
 *
 * @author Matsu
 */
public class TestException {
    
    public static void main(String[] args) {
        try {
            new TestException().test();
        } catch (ServiceRuntimeException ex) {
            new Log().error(ex);
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
