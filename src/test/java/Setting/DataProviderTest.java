package Setting;

import org.testng.annotations.DataProvider;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


public class DataProviderTest {


    @DataProvider(name = "getData")
    public static Object[][] getData() throws ClassNotFoundException {

        Path resourceDirectory = Paths.get("src", "test", "java", "Setting");
        String absolutePath = resourceDirectory.toFile().getAbsolutePath();
        Data valMessage = new Data();
        List<String[]> dataMessage = valMessage.getData(absolutePath + "\\DEMO.csv");
        Object[][] data = new Object[dataMessage.size()][4];
        for (int i = 0; i < dataMessage.size(); i++) {
            String[] dataL = dataMessage.get(i);
            for (int j = 0; j < dataL.length; j++) {
                System.out.print(dataL[j] + " ");
                data[i][j] = dataL[j];

            }

            System.out.println();

        }


        return data;
    }


}
