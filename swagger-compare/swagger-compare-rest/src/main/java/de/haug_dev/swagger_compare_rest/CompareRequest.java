package de.haug_dev.swagger_compare_rest;

import java.util.Objects;

public class CompareRequest {
    String urlLeft;
    String urlRigth;

    public CompareRequest() {}

    public CompareRequest(String urlLeft, String urlRigth) {
        this.urlLeft = urlLeft;
        this.urlRigth = urlRigth;
    }

    public String getUrlLeft() {
        return urlLeft;
    }

    public void setUrlLeft(String urlLeft) {
        this.urlLeft = urlLeft;
    }

    public String getUrlRight() {
        return urlRigth;
    }

    public void setUrlRight(String urlRigth) {
        this.urlRigth = urlRigth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CompareRequest)) return false;
        CompareRequest that = (CompareRequest) o;
        return Objects.equals(getUrlLeft(), that.getUrlLeft()) &&
                Objects.equals(getUrlRight(), that.getUrlRight());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUrlLeft(), getUrlRight());
    }

    @Override
    public String toString() {
        return "CompareRequest{" +
                "urlLeft='" + urlLeft + '\'' +
                ", urlRigth='" + urlRigth + '\'' +
                '}';
    }
}
