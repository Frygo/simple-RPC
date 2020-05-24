import com.frygo.rpc.codec.JsonDecoder;
import com.frygo.rpc.codec.JsonEncoder;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author frygo
 * @Create 2020--05-11 14:26
 */
public class JsonDecoderTest {

    @Test
    public void decode() {
        JsonEncoder encoder = new JsonEncoder();
        TestBean testBean = new TestBean();
        testBean.setName("hello");
        testBean.setNum(99);
        TestBean testBean2 = new TestBean();
        testBean.setA(testBean2);
        byte[] bytes = encoder.encode(testBean);
        JsonDecoder decoder = new JsonDecoder();
        TestBean testBean1 = decoder.decode(bytes, TestBean.class);
        System.out.println(testBean1);
        assertEquals(testBean.getName(),testBean1.getName());
        assertEquals(testBean.getNum(),testBean1.getNum());
        assertEquals(testBean2,testBean1.getA());
    }
}