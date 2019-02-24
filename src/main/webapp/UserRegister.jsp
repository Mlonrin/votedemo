<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <script src="${pageContext.request.contextPath}/js/jquery.min1.3.5.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.easyui.min1.3.5.js"></script>
    <script src="${pageContext.request.contextPath}/js/easyui-lang-zh_CN1.3.5.js"></script>

    <link href="${pageContext.request.contextPath}/themes1.3.5/icon.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/themes1.3.5/default/easyui.css" rel="stylesheet" type="text/css"/>

</head>
    <script>
        $(function () {

            $("#vu_user_name").validatebox({
                required:true,
                missingMessage:'用不能为空',
                validType:'length[3,15]',
                invalidMessage:'用户名为3~15位'
            })

            $("#vu_password").validatebox({
                required:true,
                missingMessage:"密码不能为空",
                validType:'length[6,18]',
                invalidMessage:"密码为6~18位"
            })

            $.extend($.fn.validatebox.defaults.rules, {
                checkRePwd: {
                    validator: function(value, param){
                        var pwd = $(param[0]).val();
                        //console.log(pwd)
                        //console.log(value)
                        return value==pwd;
                    },
                    message: '两次没密码不一致'
                }
            });

            $("#revu_password").validatebox({
                required:true,
                missingMessage:"确认密码不能为空",
                validType:"checkRePwd['#vu_password']"
            })

            $("input[value='注册']").click(function () {
                $("#register").form("submit",{
                    url:'${pageContext.request.contextPath}/user/register.do',
                    onSubmit:function () {
                      return $(this).form("validate");
                    },
                    success:function (data) {
                        //var obj = JSON.parse(data);
                        if(data==""){
                            alert("注册成功")
                        }
                    }
                })
            })

        })
    </script>
<body>
    <form id="register" method="post">
        用户名：<input type="text" id="vu_user_name" name="vu_user_name"/><br/>
        密码：<input type="password" id="vu_password" name="vu_password"/><br/>
        确认密码：<input type="password" id="revu_password"/><br/>
        <input type="button" value="注册"/>
    </form>
</body>
</html>
