package techtest;

public class Error {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class Builder extends AbstractBuilder<Error> {
        @Override
        public Error create() {
            return new Error();
        }

        @Override
        public Error build() {
            return instance();
        }

        public Builder withMessage(String message) {
            instance().setMessage(message);
            return this;
        }
    }
}
