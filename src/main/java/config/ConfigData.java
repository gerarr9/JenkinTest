package config;

public enum ConfigData {
    BASE_URL {
        public String getValue() {
            return ConfigReader.getConfigProperty("pendrak.url");
        }
    };




    public abstract String getValue();

    @Override
    public String toString() {
        return this.getValue();
    }
}
