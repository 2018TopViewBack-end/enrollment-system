package org.topview.util;

/**
 * @author Medwin。
 * 后台接口返回结果，标识了是否成功、消息以及返回的数据
 */
public class Result<T> {
    private boolean success;
    private String msg;
    private T data;

    private Result(boolean success, String msg) {
        this.success = success;
        this.msg = msg;
    }

    private Result(boolean success, String msg, T data) {
        this.success = success;
        this.msg = msg;
        this.data = data;
    }

    public static Result success() {
        return new Result(true, Constant.OK);
    }

    public static Result<Object> success(Object data) {
        return new Result<>(true, Constant.OK, data);
    }

    public static Result fail(String msg) {
        return new Result(false, msg);
    }

    public static Result fail(String msg, Object data) {
        return new Result<>(false, msg, data);
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "success=" + success +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
