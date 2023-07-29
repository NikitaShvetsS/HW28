package org.example;

public class ApiResponse {
    private StatusResponse status;
    private Object data;

    public ApiResponse(StatusResponse status, Object data) {
        this.status = status;
        this.data = data;
    }
}
