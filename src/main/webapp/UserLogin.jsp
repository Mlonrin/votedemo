<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>welcome</title>
    <script src="${pageContext.request.contextPath}/js/jquery.min1.3.5.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.easyui.min1.3.5.js"></script>
    <script src="${pageContext.request.contextPath}/js/easyui-lang-zh_CN1.3.5.js"></script>

    <link href="${pageContext.request.contextPath}/themes1.3.5/icon.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/themes1.3.5/default/easyui.css" rel="stylesheet" type="text/css"/>
</head>

    <script type="text/javascript">

        $(function () {

            $("#vu_user_name").validatebox({
                required:true,
                missingMessage:"用户名不能为空",
                validType:'length[3,15]',
                invalidMessage:"用户名为3~15位"
            })

            $("#vu_password").validatebox({
                required:true,
                missingMessage:"密码不能为空",
                validType:'length[6,18]',
                invalidMessage:"密码为6~18位"
            })



            $("#sub").click(function () {
                // console.log("+++++++++");
                $("#userLogin").form('submit',{
                    url:"${pageContext.request.contextPath}/user/login",
                    onSubmit:function () {
                        return $(this).form("validate");
                    },
                    success:function (data) {
                        var obj = JSON.parse(data);
                        if(obj.isLogin){

                            alert("登录成功");

                            /*$("#datagrid").html("<input id=\"title\" name=\"title\" /><input type=\"button\" value=\"搜索\"/>\n" +
                                "    <table id=\"voteDTOTable\"></table>");

                            $("#voteDTOTable").datagrid({
                                title:"投票列表",
                                url:"/voteDTO/selectByTitle",
                                rownumbers:true,
                                columns:[[
                                    {field:'vs_title',title:'投票标题'},
                                    {field:'option_number',title:'选项数'},
                                    {field:'user_number',title:'投票人数'},
                                    {field:'vs_id',title:'操作',
                                        formatter:function (value,row,index) {
                                            return "<a href='/"+value+"'>参与投票</a>";
                                        }}
                                ]],
                                pagination:true
                            })

                            $("input[value='搜索']").click(function () {

                                var title = $("#title").val();
                                $("#voteDTOTable").datagrid("load",{
                                    title:title
                                });
                            })*/

                            window.location.replace("${pageContext.request.contextPath}/voteList.jsp");

                        }else {
                            alert("账号或密码不正确");
                        }
                    }
                })
            })
        })

    </script>

<body>
    <div id="datagrid">
    <form id="userLogin" method="post">
        用户名：<input type="text" id="vu_user_name" name="vu_user_name" /><br/>
        密码：<input type="password" id="vu_password" name="vu_password"/><br/>
        <input type="button" id="sub" value="登录"/>
    </form>
    </div>
</body>
</html>
