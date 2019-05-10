$.ajaxSetup({ //发送请求前触发
    complete: function (xhr) {
    },
    beforeSend: function (xhr) { //可以设置自定义标头
        let  token =     localStorage.getItem("token");//获取名称为“key”的值
        if (token)  {
            xhr.setRequestHeader('Authorization','Bearer ' + token);
        }
    }
})