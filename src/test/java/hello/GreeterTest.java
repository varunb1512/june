import static org.junit.Assert.assertEquals;
import org.junit.Test;
import hello.Greeter;
public class GreeterTest {

    @Test
    public void testSayHello() {
        Greeter greeter = new Greeter();
        assertEquals("DevOps Project for Bosch Global Software Technology", greeter.sayHello());
    }
}

