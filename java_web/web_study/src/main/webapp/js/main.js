$(function () {
    $.ajax({
        url:"../data/articleList.ok.json",
        type:"get",
        success: function (r) {
            if(r.ok){//r={ok:true, data: [{id: 1, title: xxx}]}
                let content =   '<ul>';
                //根据响应数据拼接文章字符串
                for(let a of r.data){
                    content +=      '<li>';
                    content +=          a.title;
                    content +=      '</li>';
                }
                content +=      '</ul>';
                $("#article_list").html(content);
            }
        }
    })
})