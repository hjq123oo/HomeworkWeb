<!DOCTYPE html>

<html>
    <head>
        <title>用户注册</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/register.css" rel="stylesheet" type="text/css"/>
        <script src="js/jquery-2.1.3.min.js"></script>
		<script src="js/register.js"></script>
    </head>
    <body  style="margin: 0px" onload="initInfo()">
        <div class="header">
            <div class="w">
                <div id="logo">
                    <a href="#">
                        <img src="images/logo.png" width="207" height="60" alt="五环作业网">
                    </a>
                </div>
            </div>
            <div class = "to_login">
                <a href="index.html">已有账号->登录</a>
            </div>

        </div>
        <div class="content">
            <div class = "reg_part">
				<p>用户注册</p>
                <label><input type = "radio" name = "role" id = "role_student" onclick = "checkRole()" checked>学生</label>
				<label><input type = "radio" name = "role" id = "role_teacher" onclick = "checkRole()">教师</label>
                <form method="post" class="reg_form" id="regForm" action="表单信息！！" onsubmit="return checkSubmit()">
					
                    <table class = "reg_table">
                        <tr>
                            <td class = "first_col"><span>*</span>帐号：</td>
                            <td><input type="text" name="stu_account" class="input-text" id="reg_account_stu" tabindex="1" 
                                oninput = "checkStuAccount(this.id)"></td>
                            <td class = "info_remind_required" ><label id = "reg_account_stu_text">6-18个字符，请使用字母加数字的组合</label></td>
                        </tr>
                        <tr>
                            <td class = "first_col"><span>*</span>密码：</td>
                            <td><input type="password" name="stu_pwd" class="input-text" id="reg_password_stu" tabindex="1"
                                oninput = "checkStuPassword(this.id, 1)"></td>
                            <td class = "info_remind_required"><label id = "reg_password_stu_text">6-18个字符，请使用字母加数字的组合</label></td>
                        </tr>
                        <tr>
                            <td class = "first_col"><span>*</span>确认密码：</td>
                            <td><input type="password" name="stu_pwd2" class="input-text" id="reg_password_stu2" tabindex="1"
                                oninput = "checkStuPassword(this.id, 2)"></td>
                            <td class = "info_remind_required"><label id = "reg_password_stu2_text">请再次输入密码</label></td>
                        </tr>
                        <tr>
                            <td class = "first_col"><span>*</span>学校：</td>
                            <td><input type="text" name="stu_school" class="input-text" id="reg_school_stu" tabindex="1" 
                                oninput = "checkStuInfo(this.id, 1)"></td>
                            <td class = "info_remind_required"><label id = "reg_school_stu_text">如：北京交通大学</label></td>
                        </tr>
                        <tr>
                            <td class = "first_col"><span>*</span>学院：</td>
                            <td><input type="text" name="stu_dept" class="input-text" id="reg_dept_stu" tabindex="1"
                                oninput = "checkStuInfo(this.id, 2)"></td>
                            <td class = "info_remind_required"><label id = "reg_dept_stu_text">如：软件学院</label></td>
                        </tr>
                        <tr>
                            <td class = "first_col"><span>*</span>班级：</td>
                            <td><input type="text" name="stu_class" class="input-text" id="reg_class_stu" tabindex="1"
                                oninput = "checkStuInfo(this.id, 3)"></td>
                            <td class = "info_remind_required"><label id = "reg_class_stu_text">如：1302</label></td>
                        </tr>
                        <tr>
                            <td class = "first_col"><span>*</span>学号：</td>
                            <td><input type="text" name="stu_number" class="input-text" id="reg_number_stu" tabindex="1"
                                oninput = "checkStuInfo(this.id, 4)" onkeyup="value=value.replace(/[^\w\.\/]/ig,'')" style="ime-mode:Disabled"></td>
                            <td class = "info_remind_required"><label id = "reg_number_stu_text">如：13301043</label></td>
                        </tr>
                        <tr>
                            <td class = "first_col"><span>*</span>姓名：</td>
                            <td><input type="text" name="stu_name" class="input-text" id="reg_name_stu" tabindex="1"
                                oninput = "checkStuInfo(this.id, 5)"></td>
                            <td class = "info_remind_required"><label id = "reg_name_stu_text">如：张三</label></td>
                        </tr>
                        <tr>
                            <td class = "first_col">常用邮箱：</td>
                            <td><input type="text" name="stu_email" class="input-text" id="reg_email_stu" tabindex="1"
                                oninput = "checkEmailInfo(this.id)"></td>
                            <td class = "info_remind"><label id = "reg_email_stu_text">请填写有效邮箱地址</label></td>
                        </tr>
                        <tr>
                            <td class = "first_col">联系电话：</td>
                            <td><input type="text" name="stu_phone" class="input-text" id="reg_phone_stu" tabindex="1" value=""></td>
                            <td class = "info_remind">请填写有效联系方式</td>
                        </tr>
                    </table>
                    <input type = "submit" class="reg_btn" id = "stu_reg" value="注册" />
                </form>
				
				<form method="post" class="reg_form" id="regForm2" action="表单信息！！"  style="display:none;">
                    <table class = "reg_table">
                        <tr>
                            <td class = "first_col"><span>*</span>帐号：</td>
                            <td><input type="text" name="email" class="input-text" id="reg_account_tea" tabindex="1" value=""></td>
                            <td class = "info_remind_required">6-18个字符，请使用字母加数字的组合</td>
                        </tr>
                        <tr>
                            <td class = "first_col"><span>*</span>密码：</td>
                            <td><input type="text" name="email" class="input-text" id="reg_password_tea" tabindex="1" value=""></td>
                            <td class = "info_remind_required">6-18个字符，请使用字母加数字的组合</td>
                        </tr>
                        <tr>
                            <td class = "first_col"><span>*</span>确认密码：</td>
                            <td><input type="text" name="email" class="input-text" id="reg_password2_tea" tabindex="1" value=""></td>
                            <td class = "info_remind_required">请再次输入密码</td>
                        </tr>
                        <tr>
                            <td class = "first_col"><span>*</span>学校：</td>
                            <td><input type="text" name="email" class="input-text" id="reg_school_tea" tabindex="1" value=""></td>
                            <td class = "info_remind_required">如：北京交通大学</td>
                        </tr>
                        <tr>
                            <td class = "first_col"><span>*</span>工号：</td>
                            <td><input type="text" name="email" class="input-text" id="reg_number_tea" tabindex="1" value=""></td>
                            <td class = "info_remind_required">如：13301043</td>
                        </tr>
                        <tr>
                            <td class = "first_col"><span>*</span>姓名：</td>
                            <td><input type="text" name="email" class="input-text" id="reg_name_tea" tabindex="1" value=""></td>
                        </tr>
                        <tr>
                            <td class = "first_col">常用邮箱：</td>
                            <td><input type="text" name="email" class="input-text" id="reg_email_tea" tabindex="1" value=""></td>
                            <td class = "info_remind">请填写有效邮箱地址</td>
                        </tr>
                        <tr>
                            <td class = "first_col">联系电话：</td>
                            <td><input type="text" name="email" class="input-text" id="reg_phone_tea" tabindex="1" value=""></td>
                            <td class = "info_remind">请填写有效联系方式</td>
                        </tr>
                    </table>
                    <div class="reg_btn" id = "tea_reg" value="注册"></div>
                    
                </form>
            </div>
        </div>
        <div class="footer"></div>
    </body>
</html>
