<%--
  Created by IntelliJ IDEA.
  User: Morn Wu
  Date: 2017/3/2
  Time: 下午 7:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户个人信息管理测试</title>
    <script type="text/JavaScript" src="/js/memberInfoManagement.js"></script>
</head>
<body>
<h1>部员升级为部长</h1>
<form id="memberUpgrade">
    <input type="text" name="readyMemberId"/>
</form>
<button onclick="memberUpgradeValidation()">提交人员</button>

<br/>
<h1>删除部员</h1>
<form id="deleteMemberSubmit">
    <input type="text" name="deletedLine"/>
    <p>（若有多个要删除者，请以   ，  隔开）</p>
</form>
<button onclick="deleteMemberSubmitValidation()">提交人员</button>
<font color="red"><span id="error_deleteMember"></span></font>
<font color="red"><span id="error_deleted"></span></font>
<br/>


<h1>面试者通过</h1>
<form id="personUpgrade">
    <input type="text" name="readyIntervieweeIdLine"/>
    <p>（若有多个通过者，请以   ，  隔开）</p>
</form>
<button onclick="personUpgradeValidation()">提交人员</button>
<font color="red"><span id="error_personUpgrade"></span></font>
<br/>


<h1>密码修改</h1>
<form id="changePassword">
    旧密码:<input type="password" name="oldpassword" onkeydown="checkCapsLock()" /><font color="red"><span id="error_oldpassword"></span></font><br/>
    密码:<input type="password" name="password" onkeydown="checkCapsLock()"/><br/>
    确认密码:<input type="password" name="repassword" onkeydown="checkCapsLock()" />
</form>
<button onclick="changePasswordValidation()">修改密码</button>
<font color="red"><span id="error_changePassword"></span></font>
<div id ="capStatus" style="visibility: hidden"><font color="red">已打开大写锁定</font></div>
<br>

<%--<h1>个人信息修改</h1>--%>
<%--<span id="curpersonid"></span>--%>
<%--<form id="modifyInfo" onsubmit="return false">--%>
    <%--姓名:<input type="text" name="name"/><font color="red"><span id="error_name"></span></font><br/>--%>
    <%--性别：<br/>--%>
    <%--<input type="radio" name="gender" value="true"> 男<br>--%>
    <%--<input type="radio" name="gender" value="false"> 女<br>--%>
    <%--生日：<input type="date" name="birthday" id="birthday"/><font color="red"><span id="error_birthday"></span></font><br/>--%>
    <%--手机号：<input type="text" name="phoneNumber"/><font color="red"><span id="error_phoneNumber"></span></font><br/>--%>
    <%--QQ：<input type="text" name="QQ"/><font color="red"><span id="error_QQ"></span></font><br/>--%>
<%--</form>--%>
<%--<button onclick="changeInfoValidation()">修改个人信息</button>--%>
<%--<font color="red"><span id="error_fetchPersonInfo"></span></font>--%>

<h1>您选择部门</h1>
<form id="chooseDept">
    <input type="number" name="dept"/>
</form>
<button onclick="chooseDeptValidation()">choice!</button>
<br>
<h1>取出生育面试者</h1>
<button onclick="getRestIntervieweesValidation()">choice!请先打开network响应界面</button>

<br>
<h1>部员添加</h1>
<span id="addpersonid"></span>
<form id="addMember" onsubmit="return false">
    学号:     <input type="text" name="id"/><font color="red"><span id="error_id"></span></font><br/>
    姓名:     <input type="text" name="name"/><font color="red"><span id="error_name"></span></font><br/>
    性别：<br/>
    <input type="radio" name="gender" value="true"> 男<br>
    <input type="radio" name="gender" value="false" checked> 女<br>
    生日：     <input type="date" name="birthday" id="birthday"/><font color="red"><span id="error_birthday"></span></font><br/>
    手机号：   <input type="text" name="phoneNumber"/><font color="red"><span id="error_phoneNumber"></span></font><br/>
    QQ：       <input type="text" name="QQ"/><font color="red"><span id="error_QQ"></span></font><br/>
    部门:      <input type="number" name="dept"><font color="red"><span id="error_dept"></span></font><br/>
    密码:      <input type="password" name="password" onkeydown="checkCapsLock()"/><font color="red"><span id="error_password"></span></font><br/>
    确认密码： <input type="password" name="repassword" onkeydown="checkCapsLock()" /><font color="red"><span id="error_repassword"></span></font><br/>
</form>
<button onclick="addMemberValidation()">部员添加</button>
<font color="red"><span id="error_addMember"></span></font>
<br>
<h1>查询该部门所有人</h1>
<form id="fetchAllPerson">
    <input type="text" name="dept"/>
</form>
<button onclick="fetchAllPersonValidation()">goahead</button>
</body>

</html>
