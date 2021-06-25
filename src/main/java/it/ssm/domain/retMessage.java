package it.ssm.domain;

public class retMessage<T> {
    private int statusCode;
    private T data;
    private T reqData;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public T getReqData() {
        return reqData;
    }

    public void setReqData(T reqData) {
        this.reqData = reqData;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("retMessage{");
        sb.append("statusCode=").append(statusCode);
        sb.append(", data=").append(data);
        sb.append(", reqData=").append(reqData);
        sb.append('}');
        return sb.toString();
    }
}
