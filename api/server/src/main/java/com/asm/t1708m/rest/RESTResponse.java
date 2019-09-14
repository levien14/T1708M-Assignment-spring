package com.asm.t1708m.rest;

import java.util.ArrayList;
import java.util.HashMap;

public class RESTResponse {

    private HashMap<String,Object> response;

    public RESTResponse() {
        this.response = new HashMap<>();
    }

    public HashMap<String, Object> getResponse() {
        return response;
    }

    public void addResponse(HashMap<String, Object> response) {
        this.response = response;
    }

    public void addResponse(String key, Object object) {
        this.response.put(key,object);
    }


    // Simple error
    public static class SimpleError{
        private int status;
        private String message;

        public SimpleError() {
            this.status = 0;
            this.message = "";
        }

        public SimpleError setStatus(int status) {
            this.status = status;
            return this;
        }

        public SimpleError setMessage(String message) {
            this.message = message;
            return this;
        }

        public HashMap<String,Object> build(){
            RESTResponse restResponse = new RESTResponse();
            restResponse.addResponse("status",this.status);
            restResponse.addResponse("message",message);
            return restResponse.getResponse();
        }
    }


    //    Success
    public static final class Success{
        private int status;
        private String message;
        private Object data;

        public Success setStatus(int status) {
            this.status = status;
            return this;
        }

        public Success setMessage(String message) {
            this.message = message;
            return this;
        }


        public Success setData(Object data) {
            this.data = data;
            return this;
        }

        public Success setData(Iterable listObj) {
            this.data = new ArrayList<>();
            this.data = listObj;
            return this;
        }

        public HashMap<String,Object> build(){
            RESTResponse restResponse = new RESTResponse();
            restResponse.addResponse("status",this.status);
            restResponse.addResponse("message",this.message);
            restResponse.addResponse("data",this.data);

            return restResponse.getResponse();
        }
    }
}
