package my_demo.helloworld;

import java.util.Properties;

/**
 * Created by gao on 2018/6/10.
 */
public class DataSource {

    private Properties properties;


    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "DataSource{" +
                "properties=" + properties +
                '}';
    }
}
