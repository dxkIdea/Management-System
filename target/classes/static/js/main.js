//获取图片验证码
getVerCode = function (obj) {
    obj.src = "/getVerCode?"+Math.random();
};
//用户登录
login = function () {
    $.ajax({
        url: "/userLogin",
        data : {
            userName : $("#name").val(),
            passWord : $("#password").val()
        },
        type: "post",
        success: function (data) {
            alert(data);
        },
        error: function () {

        }
    })
};

//用户重复校验
checkIphone = function (data) {
    //当前验证对象的name
    var name = data.name;
    $.ajax({
        url: "/checkIphone",
        data : {
            iphone : data.value
        },
        type: "post",
        success: function (data) {
            if (data !== "success") {
                if (data == "手机号已存在") {
                    $("#iphoneError").attr("hidden",false);
                    $("#iphoneError").text("手机号已存在");
                    $("#iphone").focus();
                }
            } else {
                $("#iphoneError").attr("hidden",true);
            }
        },
        error: function () {
            console.log('校验手机号重复存在，GG了~');
        }
    })
};