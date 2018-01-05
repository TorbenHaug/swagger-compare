package de.haug_dev.swagger_compare_rest;

import java.util.Objects;

public class ErrorMessage {

    private String message;
    private String detailedMessage;

    public ErrorMessage(String message, String detailedMessage) {
        this.message = message;
        this.detailedMessage = detailedMessage;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetailedMessage() {
        return detailedMessage;
    }

    public void setDetailedMessage(String detailedMessage) {
        this.detailedMessage = detailedMessage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ErrorMessage)) return false;
        ErrorMessage that = (ErrorMessage) o;
        return Objects.equals(getMessage(), that.getMessage()) &&
                Objects.equals(getDetailedMessage(), that.getDetailedMessage());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getMessage(), getDetailedMessage());
    }

    @Override
    public String toString() {
        return "ErrorMessage{" +
                "message='" + message + '\'' +
                ", detailedMessage='" + detailedMessage + '\'' +
                '}';
    }
}
