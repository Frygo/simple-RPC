import com.frygo.rpc.codec.JsonEncoder;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author frygo
 * @Create 2020--05-11 14:26
 */
public class JsonEncoderTest {

    @Test
    public void encode() {
        JsonEncoder encoder = new JsonEncoder();
        TestBean testBean = new TestBean();
        testBean.setName("hello");
        testBean.setNum(99);
        byte[] bytes = encoder.encode(testBean);
        assertNotNull(bytes);

    }
}