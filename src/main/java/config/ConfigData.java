package config;

public enum ConfigData {
    BASE_URL {
        public String getValue() {
            return ConfigReader.getConfigProperty("pendrak.url");
        }
    },
    JWT_TOKEN {
        public String getValue() {
            return ConfigReader.getConfigProperty("jwt.token");
        }
    };





    public abstract String getValue();

    @Override
    public String toString() {
        return this.getValue();
    }
}
