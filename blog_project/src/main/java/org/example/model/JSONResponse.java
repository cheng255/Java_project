package org.example.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * http相应json数据 前后端约定统一的json格式
 * 响应状态码都是200 进入ajax的success来使用
 * {success: true,data:xxx}
 * {success: false, code:xxx,message:xxx}
 * @author nuonuo
 * @create 2020-12-03 18:06
 */
@Getter
@Setter
@ToString
public class JSONResponse {

    //业务操作是否成功
    private boolean success;
    //业务操作的消息码，一般来说，出现错误时的错误码才有意义 给开发人员定位问题
    private String code;
    //业务操作的错误消息，给用户看的信息
    private String message;
    //业务数据，业务操作成功时，给前端ajax success方法使用，解析响应json数据，渲染网页内
    private Object data;

    @Override
    public String toString() {
        return "JSONResponse{" +
                "success=" + success +
                ", code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
