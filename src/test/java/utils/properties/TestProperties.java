package utils.properties;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import static utils.LogUtil.info;

public class TestProperties {

    private static Config conf;
    private static String PROP_FILE_ARG = FrameworkConstants.TEST_PROPFILE_ARG;

    public static void loadTestParameters() {
        if (conf == null) {
            String propFile = (System.getProperty(PROP_FILE_ARG) == null) ? "test.properties" : System.getProperty(PROP_FILE_ARG);
            conf = ConfigFactory.load(propFile)
                    .withFallback(ConfigFactory.load(propFile));

        }
    }

    public static String getProperty(String paramName) {
        loadTestParameters();
        String value = conf.getString(paramName);
        if (paramName != null && !paramName.toLowerCase().contains("pwd") && !paramName.toLowerCase().contains("password")) {
            info("Retrieved Property: key [" + paramName + "], value [" + value + "]");
        } else {
            info("Retrieved Property: key [" + paramName + "], value [DON'T SHOW PASSWORDS]");
        }

        return (String) conf.getAnyRef(paramName);
    }

    public static Config getConfigSection(String sectionName) {
        return conf.getConfig(sectionName);
    }
}