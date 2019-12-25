<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>讲解freemaker知识点</title>
</head>
<body>
讲解freemaker知识点
<h2>获取值</h2>
<#--如果没有值则用未知代替-->
${loginName!"未知"}
<h2>遍历</h2>
<table border="1" width="70%">
    <tr><td>角色ID</td><td>角色名</td></tr>
    <#list roleList as role>
    <tr>
        <td>${role.uid}</td>
        <td>${role.rname}</td>
    </tr>
    </#list>
    <#list lqmxMap?keys as key>
    	<tr>
    		<td>${key}:${lqmxMap[key]}</td>
    	</tr>
    </#list>
</table>
<h2>导页面</h2>
<#--导入整个-->
<#include 'common/head.ftl'>
<#--导入部分-->
<div th:replace="foreground/common/head :: navbar" ></div>

<h2>全局变量和局部变量</h2>

<#--局部变量-->
 <#assign ctx1>
     ${springMacroRequestContext.contextPath}
 </#assign>
<#--全局变量-->
<#global ctx2>
    ${springMacroRequestContext.contextPath}
</#global>
<#--使用变量-->
${ctx1}
${ctx1}
</body>
</html>
