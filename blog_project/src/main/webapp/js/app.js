$(function () { //页面加载完成之后执行function里的逻辑
    //$("#")//jquery：使用$("#id")通过元素id获取某个页面
    $("#login_form").submit(function () {
        //ajax自己发请求
        $.ajax({
            url: "../login", //请求的服务路径
            type: "post", //请求方法
            // contentType: "";//请求的数据类型 默认表单格式
            data: $("#login_form").serialize(), //请求数据:序列化表单的数据
            dataType: "json", //响应的数据类型，不使用默认为表单提交的格式
            success: function (r) { //响应体的json字符串 会解析为方法参数
                if (r.success) {
                    //前端页面url直接跳转到某个路径
                    window.location.href = "../jsp/articleList.jsp";
                } else {
                    alert("错误码：" + r.code + "\n错误消息：" + r.message);
                }

            }
        })

        //统一不执行默认的表单提交
        return false;
    })
})