<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>首页</title>
</head>
<body>
<h1>标题Index</h1>
<h2>用户名为${username}</h2>
<p>
    你好,
    <#if username=="Shiry">
        <h3>h3用户名为${username}</h3>
    <#elseif username == "example">
        <h4>h4用户名为${username}</h4>
    <#else>
        <h5>h5用户名为${username}</h5>
    </#if>
</p>
<ul>
    <#list userList as user>
        <li>用户名为${user.username},年龄为${user.age}</li>
    </#list>
</ul>

<#list userList>
    <ol>
        <#items as user>
            <li>用户名为${user.username},年龄为${user.age}</li>
        </#items>
    </ol>
</#list>

</body>
</html>