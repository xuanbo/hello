<@c.htmlHead title="测试用户列表">
    <#-- 引入分页js -->
    <@c.paginator/>
    <#-- 引入userList css -->
    <link rel="stylesheet" type="text/css" href="/assets/custom/test/userList.css">
    <script type="text/javascript" src="/assets/custom/test/userList.js"></script>
</@c.htmlHead>

<@c.htmlBody>

    <div id="userList">
        <#-- 不为null,则执行xxxx
        <#if target??>
            xxxx
        </#if>
        -->
        <#if users.getList()??>
            <table class="table">
                <tr>
                    <td>序号</td>
                    <td>用户名</td>
                    <td>密码</td>
                    <td>用户名和密码是否相同</td>
                </tr>
                <#list users.getList() as user>
                    <tr>
                        <td>${user_index + 1}</td>
                        <td>${user.getName()}</td>
                        <td>${user.getPassword()}</td>
                        <td>
                            <#-- if else -->
                            <#if user.name == user.password>
                                相同
                            <#else>
                                不相同
                            </#if>
                        </td>
                    </tr>
                </#list>
            </table>
        </#if>
    </div>

    <#-- 分页 -->
    <div id="page" data-current="${users.getCurrent()}"
         data-size="${users.getSize()}"
         data-totalPage="${users.getPageCount()}">
    </div>

    <p>下面是对freemarker的一些用法的简单测试</p>
    <#-- freemarker的一些简单用法 -->
    <div>
        <#-- 对字符串进行HTML编码 -->
        <#assign htm = "<b>颜色</b>">
        <h1>${htm?html}</h1>

        <#-- 为空时默认 -->
        <#assign name="周二蛋蛋">
            <h1>${name!"周二蛋"}</h1>
            <h1>${namenull!"周二蛋"}</h1>

        <#-- if else -->
        <#assign name="周三蛋">
        ${name}
            <#if name == "周二蛋">
                是我们的老师
            <#else>
                不是我们的老师
            </#if>

            <#assign date="2015">
        <@c.copyright name="周二蛋测试freemarker" data="${date}"/>
    </div>
</@c.htmlBody>
