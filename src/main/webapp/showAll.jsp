<%@page pageEncoding="UTF-8" isELIgnored="false" contentType="text/html; UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <!--bootstrap的css样式-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css">
    <!--BootStrap与JQGRID整合后的css样式-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap-Jqgrid/css/trirand/ui.jqgrid-bootstrap.css">
    <!--jquery的js文件-->
    <script src="${pageContext.request.contextPath}/bootstrap/js/jquery-3.3.1.min.js"></script>
    <!--bootstrap的js样式-->
    <script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.js"></script>

    <!--jqgrid与bootstrap整合的国际化的js文件-->
    <script src="${pageContext.request.contextPath}/bootstrap-Jqgrid/js/trirand/i18n/grid.locale-cn.js"></script>
    <!--jqgrid与bootstrap整合的js文件-->
    <script src="${pageContext.request.contextPath}/bootstrap-Jqgrid/js/trirand/jquery.jqGrid.min.js"></script>
    <script type="application/javascript">
        $(function () {
            $("#table").jqGrid({
                styleUI:"Bootstrap",
                url:"${pageContext.request.contextPath}/user/showAll",
                datatype:"json",
                caption:"用户列表",
                autowidth:true,
                pager:"#pager",
                rowNum:"3",
                rowList:["3","6","9"],
                viewrecords:true,
                editurl:"${pageContext.request.contextPath}/user/edit",
                cellEdit:true,
                multiselect:true,

                colNames:["用户id","用户名","密码","手机号","邮箱","ip","来源","角色","状态"],
                colModel:[
                    {name:"id"},
                    {name:"username",editable:true},
                    {name:"password",editable:true},
                    {name:"phone",editable:true},
                    {name:"email",editable:true},
                    {name:"ip",editable:true},
                    {name:"source",editable:true},
                    {name:"role",editable:true},
                    {name:"status",editable:true}
                ]

            }).jqGrid("navGrid","#pager",{edit:true});
        });
    </script>
</head>
<body>
    <table id="table"></table>
    <div id="pager"></div>
</body>
</html>