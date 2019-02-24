<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/js/jquery.min1.3.5.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.easyui.min1.3.5.js"></script>
    <script src="${pageContext.request.contextPath}/js/easyui-lang-zh_CN1.3.5.js"></script>

    <link href="${pageContext.request.contextPath}/themes1.3.5/icon.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/themes1.3.5/default/easyui.css" rel="stylesheet" type="text/css"/>
</head>
    <script>
        //选项框个数
        var boxCount;

        $(function () {
            //表格====================================================开始
            $("#voteDTOTable").datagrid({
                title:"投票列表",
                url:"${pageContext.request.contextPath}/voteDTO/selectByTitle",
                rownumbers:true,
                pageSize:4,
                pageList:[4,6,8,10],
                columns:[[
                    //设置复选框
                    {checkbox:true},
                    {field:'vs_title',title:'投票标题'},
                    {field:'option_number',title:'选项数'},
                    {field:'user_number',title:'投票人数'},
                    {field:'vs_id',title:'操作',
                        formatter:function (value,rowData,index) {
                            var vs_id = rowData.vs_id;
                            var user_number = rowData.user_number;
                            var option_number = rowData.option_number;
                            console.info(vs_id);
                            console.info(user_number);
                            console.info(option_number);
                            return "<a href='${pageContext.request.contextPath}/voteSubject/selectOne?vs_id="+vs_id+"&user_number="+user_number+"&option_number="+option_number+"'>参与投票</a>";
                        }}
                ]],
                pagination:true,
                toolbar:"#myButton"
            })
            //表格结束==============================================================

            //点击搜索，重新搜索查询加载页面
            $("input[value='搜索']").click(function () {

                var title = $("#title").val();
                $("#voteDTOTable").datagrid("load",{
                    title:title
                });
            })

            //发布投票============================================================

            //格式化添加对话框,并关闭
            $("#addVote").dialog({
                title:"发布新投票",
                width:400,
                height:300,
                closed:true
            })

            //添加选项框
            $("input[value='添加选项']").click(function () {
                //选中选项框所有标签
                var ls = $("input[name='voteOptionList["+(boxCount-1)+"]\.vo_option']:last").next("br");
                console.log(ls);
                ls.after("<input name='voteOptionList["+boxCount+"]\.vo_option'/><br/>");
                boxCount +=1;
            })

            //取消发布投票
            $("input[value='取消操作']").click(function () {
                //关闭发布对话框
                $("#addVote").dialog("close");
            })

            //确认发布投票
            $("input[value='确定']").click(function () {
                console.log("+++++++++++++++++++++++++++");
                $("#addForm").form("submit",{
                    url:"${pageContext.request.contextPath}/voteSubject/addVoteSubject",
                    success:function (data) {
                        if(data=="true"){
                            //添加成功，提示用户，关闭发布对话框
                            $("#addVote").dialog("close");
                            $.messager.alert("添加提示","添加成功","info");
                            //刷新表格
                            $("#voteDTOTable").datagrid("reload");
                        }else {
                            //添加失败提示用户
                            $.messager.alert("添加提示","添加失败","warning");
                        }
                    }
                })
            });

        })

        // 打开发布投票对话框
        function openAddForm() {
            $("#addVote").dialog({
                title:"发布新投票",
                width:400,
                height:300,
                closed:false
            })
            //初始化框个数2
            boxCount = 2;
        }

        //发布投票============================================================end======

        //批量删除==================================================================
        function multiDelete() {
            //获取所有选中的行
            var selectRows = $("#voteDTOTable").datagrid("getSelections");
            if(selectRows.length==0){
                //如果为空，提示用户
                $.messager.alert("删除提示","请选中你要删除的行","info");
            }else{
                //不为空提示是否真的要删除
                $.messager.confirm("删除提示","确定要删除吗?",function (result) {
                    //结果为真
                    if(result){
                        var ids = new Array();
                        for (var i = 0; i < selectRows.length; i++) {
                            ids[i] = selectRows[i].vs_id;
                            //console.log(ids[i]);
                        }
                        //发送ajax请求进行删除
                        $.ajax({
                            url:"${pageContext.request.contextPath}/voteSubject/multiDelete",
                            data:"ids="+ids,
                            success:function (data) {
                                if(data=="true"){
                                    //删除成功，提示用户
                                    $.messager.alert("删除提示","删除成功","info");
                                    //刷新表格
                                    $("#voteDTOTable").datagrid("reload");
                                }else{
                                    $.messager.alert("删除提示","删除失败","warning");
                                }
                            }
                        })
                    }
                })
            }
        }
        //批量删除==================================================================end=====

        <%--function toVote(vs_id,user_number,option_number) {--%>
           <%--console.log(vs_id);--%>
           <%--console.log(user_number);--%>
           <%--console.log(option_number);--%>

            <%--$.ajax({--%>
                <%--url:"${pageContext.request.contextPath}/voteSubject/selectOne.do",--%>
                <%--type:"post",--%>
                <%--data:{--%>
                    <%--"vs_id":vs_id,--%>
                    <%--"user_number":user_number,--%>
                    <%--"option_number":option_number--%>
                <%--}--%>
            <%--})--%>
        <%--}--%>

    </script>
<body>
    <%--搜索框与数据展示表格--%>
    <input id="title" name="title" /><input type="button" value="搜索"/>
    <table id="voteDTOTable"></table>
    <%---搜索框与数据展示表格-------------end---------%>

    <%--给表格添加按钮--%>
    <div id="myButton">
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick="openAddForm()">发布投票</a>
        <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove'" onclick="multiDelete()">批量删除</a>
    </div>

    <%--------------------------------添加对话框------------------------------------%>
    <div id="addVote">
        <form id="addForm" method="post">
            投票内容：<input name="vs_title"/><br/>
            投票类型：<input name="vs_type" type="radio" value="0"/>单选&nbsp;<input name="vs_type" type="radio" value="1"/>多选<br/>
            投票选项：<input name="voteOptionList[0].vo_option"/><br/>
                      <input name="voteOptionList[1].vo_option"/><br/>
            <input type="button" value="确定"/>&nbsp;&nbsp;
            <input type="button" value="添加选项"/>&nbsp;&nbsp;
            <input type="button" value="取消操作"/><br/>
        </form>
    </div>
    <%--------------------------------添加对话框------------------------end------------%>
</body>
</html>
