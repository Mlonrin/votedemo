<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>参与投票</title>
    <script src="${pageContext.request.contextPath}/js/jquery.min1.3.5.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.easyui.min1.3.5.js"></script>
    <script src="${pageContext.request.contextPath}/js/easyui-lang-zh_CN1.3.5.js"></script>

    <link href="${pageContext.request.contextPath}/themes1.3.5/icon.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/themes1.3.5/default/easyui.css" rel="stylesheet" type="text/css"/>
</head>
    <script>
        $(function () {
            $("input[value='投票']").click(function () {
                $("#optionForm").form("submit",{
                    url:"${pageContext.request.contextPath}/voteItem/addVoteItem.do",
                    success:function (data) {
                        if(data=="true"){
                            $.messager.alert("投票结果提示","投票成功","info");
                        }else {
                            $.messager.alert("投票结果提示","投票失败","warning");
                        }
                    }
                })

            })
        })
    </script>
<body>

        主题：${voteSubject.vs_title}<br/>
        共有${option_number}个选项,已有${user_number}个网友参与了投票<br/>
        <form id="optionForm" method="post">
            <input type="hidden" name="vs_id" value="${voteSubject.vs_id}"/>
            <c:forEach items="${voteSubject.voteOptionList}" var="voteOption" varStatus="vs">
                <c:if test="${voteSubject.vs_type==0}">
                    ${voteOption.vo_order}. &nbsp;<input type="radio" name="voteItemList[0].voteOption.vo_id" value="${voteOption.vo_id}"/>${voteOption.vo_option}<br/>
                </c:if>
                <c:if test="${voteSubject.vs_type==1}">
                    ${voteOption.vo_order}. &nbsp;<input type="checkbox" name="voteItemList[${vs.index}].voteOption.vo_id" value="${voteOption.vo_id}"/>${voteOption.vo_option}<br/>
                </c:if>
            </c:forEach>
            <input type="button" value="投票"/>
        </form>
    </div>
</body>
</html>
