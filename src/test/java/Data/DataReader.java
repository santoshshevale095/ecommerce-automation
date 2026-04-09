package Data;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

public class DataReader {



    public DataReader() throws IOException {
    }

    public List<HashMap<String, String>> getJsonDataMap(String filePath) throws IOException {

        String content = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8


        );


        //jackson databind

        ObjectMapper mapper = new ObjectMapper();

        List<HashMap<String, String>> data = mapper.readValue(content, new TypeReference<List<HashMap<String, String>>>() {
        });

        return data;
    }


}
