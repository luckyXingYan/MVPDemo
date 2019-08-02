package com.example.mvpdemo.base.bean;

/************************************************************
 *  @author     : zhouwenhao@yingu.com Hale
 *  @date       : 2018/10/25
 *  description : 
 ************************************************************/
public class ResultBean<T> {

    private String count;
    private String start;
    private String total;
    private String title;


    public static final int STATE_SUCCESS = 0;
    public static final int STATE_FAILURE = 1;


    private int code = 0;//模拟成功
    //    private T data;
    private T subjects;

    //    private ErrorObject errorObj;
//
//
    public int getCode() {
        return code;
    }

    //
//    public void setCode(int code) {
//        this.code = code;
//    }
//
//    public T getData() {
//        return data;
//    }
    public T getData() {
        return subjects;
    }

//    public void setData(T data) {
//        this.data = data;
//    }
//
//    public ErrorObject getErrorObj() {
//        return errorObj;
//    }
//
//    public void setErrorObj(ErrorObject errorObj) {
//        this.errorObj = errorObj;
//    }
//
//    @Override
//    public String toString() {
//        return "ResultBean{" +
//                "code=" + code +
//                ", data=" + data +
//                ", errorObj=" + errorObj +
//                '}';
//    }
//
//    public class ErrorObject{
//        private int code;
//        private String msg;
//
//        public int getCode() {
//            return code;
//        }
//
//        public void setCode(int code) {
//            this.code = code;
//        }
//
//        public String getMsg() {
//            return msg;
//        }
//
//        public void setMsg(String msg) {
//            this.msg = msg;
//        }
//
//        @Override
//        public String toString() {
//            return "ErrorObject{" +
//                    "code=" + code +
//                    ", msg='" + msg + '\'' +
//                    '}';
//        }
//    }

    @Override
    public String toString() {
        return "ResultBean{" +
                "code=" + code +
                ", subjects=" + subjects +
                ", title=" + title +
                '}';
    }


}
