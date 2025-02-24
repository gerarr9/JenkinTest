package extensions;


import config.ConfigReader;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;


public class RestExtensions implements BeforeAllCallback {

    @Override
    public void beforeAll(ExtensionContext context) {
        ConfigReader.readProperties();
    }
}
