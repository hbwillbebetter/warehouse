<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>讲解freemaker知识点</title>
</head>
<body>
<body>

    第一个freemarker页面
    <br />
    ${stu1.stuDate?string("yyyy-MM-dd")} <#--时间类型取值-->
    <br />
    ${stu1.stuSex?string("男","女")}  <#--boolean类型取值-->
    <br />
    ${stu1.stuAge!"20"} <#--如果属性是空 可以直接！默认为空，也可以！"xx" 默认为xx-->
    <br>
    ${stu1.stuName} <#--取值-->
    <br>
    <#assign num = 18><#--自定义变量-->
    ${num}
    <hr>
    <#list list1 as li> <#--遍历list集合-->
        ${li} <br>
    </#list>
    <hr>
    <#list map1?keys as key>    <#--遍历map集合-->
    ${key}: ${map1[key]}
    </#list>
    <hr>
    <#assign num1 = 18>
    <#if num1 < 18 >    <#--判断条件 -->
        你还小          <#--判断成立输出的内容-->
    <#else>
        你成年了
    </#if>

    <hr>
    <#if num1 lt 20>
        num1<20
    <#elseif num1 gt 20>        <#--注意 大于号不可以使用时,应转义 gt 小于可以使用（lt） -->
        num1>20
    <#else>
        num1=18
    </#if>
    <hr>

</body>

</html>
