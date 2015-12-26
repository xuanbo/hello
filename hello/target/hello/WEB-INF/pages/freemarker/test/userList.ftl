<@c.html title="测试用户列表">
    <#list users?if_exists as user>
        <div>
            ${user_index}.${user.getName()}----${user.getPassword()}
        </div>
    </#list>
</@c.html>
