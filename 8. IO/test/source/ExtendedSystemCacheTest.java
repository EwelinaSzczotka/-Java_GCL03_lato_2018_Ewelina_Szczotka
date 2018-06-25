package source;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class ExtendedSystemCacheTest {
    
    private ExtendedSystemCache testing;
    private ExtendedSystemCache expected;
    
    @Before
    public void setUp() {
        testing = new ExtendedSystemCache();
        expected = new ExtendedSystemCache();
        double[] input = {10,20,30};
        Double output = 60.0;
        testing.put(input, output);
        expected.put(input, output);
    }
  
    @Test
    public void testCSV_File() throws Exception {
        String path = "C:" + File.separator + "Java" + File.separator + "IO" + File.separator + "file.csv";
        File file = new File(path);
        OutputStream os = new FileOutputStream(file);
        InputStream is = new FileInputStream(file);
        testing.exportCSV(path);
        testing.importCSV(path);
        testing.exportCSV(file);
        testing.importCSV(file);
        testing.exportCSV(os);
        testing.importCSV(is);
        assertEquals(testing.getMap(),expected.getMap());
    }
    
    @Test
    public void testSerialize()throws Exception{
        String path = "C:" + File.separator + "Java" + File.separator + "IO" + File.separator + "file.csv";
        File file = new File(path);
        testing.serialize(file);
        testing.deserialize(file);
        assertEquals(testing.getMap(),expected.getMap());
    }

}
