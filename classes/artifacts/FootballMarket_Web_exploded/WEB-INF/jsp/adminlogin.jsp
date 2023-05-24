<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<head>
<base href="<%=basePath%>">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>足球俱乐部周边线上销售平台</title>
<link href="resources/css/style.css" rel="stylesheet">
<link href="resources/css/layui.css" rel="stylesheet">
<link href="resources/css/admin.css" rel="stylesheet">
<link href="resources/css/pro.css" rel="stylesheet">
<link href="resources/css/login.css" rel="stylesheet">
<script src="resources/js/jquery.min.js" type="text/javascript"></script>
<script src="resources/js/layui.js" type="text/javascript"></script>
<style type="text/css">
</style>
</head>
<body>
	<div class="container-fluid">
	<form id="loginForm">
		<div class="layadmin-user-login layadmin-user-display-show" style="padding-bottom:0px;padding-top:50px;height:250px;"
			id="LAY-user-login">
			<div class="layadmin-user-login-main" style="height:200px;">
				<div class="layadmin-user-login-box layadmin-user-login-header">
					<h2>足球俱乐部周边线上销售平台</h2>
				</div>
				<div
					class="layadmin-user-login-box layadmin-user-login-body layui-form" style="height:100px;">
					<div class="layui-form-item">
						<label
							class="layadmin-user-login-icon layui-icon layui-icon-username"
							for="LAY-user-login-username"></label> <input type="text"
							name="adminName"
							lay-verify="required" placeholder="用户名"
							class="layui-input layui-form-danger">
					</div>
					<div class="layui-form-item">
						<label
							class="layadmin-user-login-icon layui-icon layui-icon-password"
							for="LAY-user-login-password"></label> <input type="password"
							name="adminPass" id="userPass"
							lay-verify="required" placeholder="密码" class="layui-input">
					</div>
					
					<div class="layui-form-item">
						<label
							class="layadmin-user-login-icon layui-icon layui-icon-canvas"
							for="LAY-user-login-canvas"></label> <input type="code"
							name="code" id="code"
							lay-verify="required" placeholder="请输入验证码" class="layui-input" style="width:280px;">
							<canvas id="canvas" width="100" height="43"></canvas>
							
					</div>
					
					
					<div class="layui-form-item" style="height:50px;">
						<input type="checkbox" name="remember" lay-skin="primary"
							title="记住密码">
						<div class="layui-unselect layui-form-checkbox" lay-skin="primary">
							<span>记住密码</span><i class="layui-icon layui-icon-ok"></i>
						</div>
						<!-- <a lay-href="/user/forget"
							class="layadmin-user-jump-change layadmin-link"
							style="margin-top: 7px;">忘记密码？</a> -->
					</div>
					<div class="layui-form-item">
						<button class="layui-btn layui-btn-fluid" type="button" id="cod" lay-submit=""
							lay-filter="loginSubmit">登 录</button>
					</div>
				</div>
			</div>
		</div>
		</form>
	</div>
	<!--尾部-->
	<script type="text/javascript">
	$(function(){
	    var show_num = [];
	    draw(show_num);
	  
	    $("#canvas").on('click',function(){
	      draw(show_num);
	    })
	    $("#cod").on('click',function(){
	      var val = $("#code").val().toLowerCase();
	      var num = show_num.join("");
	      if(val==''){
	        alert('请输入验证码！');
	      }else if(val == num){
	       // alert('提交成功！');
	        $(".input-val").val('');
	        draw(show_num);
	  
	      }else{
	        alert('验证码错误！请重新输入！');
	        $(".input-val").val('');
	        draw(show_num);
	       return false;
	      }
	    })
		layui.use(['form','layer'], function() {
			var form = layui.form;
			var layer=layui.layer;
			form.on('submit(loginSubmit)',function(){
				$.ajax({
					type:"post",
					url:"admin/login",
					data:$("#loginForm").serialize(),
					success:function(data){
						if(data=="success"){
							layer.msg("登录成功！",{icon:1,anim:2,time:2000},function(){
								window.location.href="view/toAdminIndex";
							});
						}else{
							layer.msg("登录失败！请检查用户名和密码后重试！",{icon:5,anim:6,time:3000});
						}
					}
				});
			});
		});
	})
	  
	  function draw(show_num) {
	    var canvas_width=$('#canvas').width();
	    var canvas_height=$('#canvas').height();
	    var canvas = document.getElementById("canvas");//获取到canvas的对象，演员
	    var context = canvas.getContext("2d");//获取到canvas画图的环境，演员表演的舞台
	    canvas.width = canvas_width;
	    canvas.height = canvas_height;
	    var sCode = "A,B,C,E,F,G,H,J,K,L,M,N,P,Q,R,S,T,W,X,Y,Z,1,2,3,4,5,6,7,8,9,0";
	    var aCode = sCode.split(",");
	    var aLength = aCode.length;//获取到数组的长度
	     
	    for (var i = 0; i <= 3; i++) {
	      var j = Math.floor(Math.random() * aLength);//获取到随机的索引值
	      var deg = Math.random() * 30 * Math.PI / 180;//产生0~30之间的随机弧度
	      var txt = aCode[j];//得到随机的一个内容
	      show_num[i] = txt.toLowerCase();
	      var x = 10 + i * 20;//文字在canvas上的x坐标
	      var y = 20 + Math.random() * 8;//文字在canvas上的y坐标
	      context.font = "bold 23px 微软雅黑";
	  
	      context.translate(x, y);
	      context.rotate(deg);
	  
	      context.fillStyle = randomColor();
	      context.fillText(txt, 0, 0);
	  
	      context.rotate(-deg);
	      context.translate(-x, -y);
	    }
	    for (var i = 0; i <= 5; i++) { //验证码上显示线条
	      context.strokeStyle = randomColor();
	      context.beginPath();
	      context.moveTo(Math.random() * canvas_width, Math.random() * canvas_height);
	      context.lineTo(Math.random() * canvas_width, Math.random() * canvas_height);
	      context.stroke();
	    }
	    for (var i = 0; i <= 30; i++) { //验证码上显示小点
	      context.strokeStyle = randomColor();
	      context.beginPath();
	      var x = Math.random() * canvas_width;
	      var y = Math.random() * canvas_height;
	      context.moveTo(x, y);
	      context.lineTo(x + 1, y + 1);
	      context.stroke();
	    }
	  }
	  
	  function randomColor() {//得到随机的颜色值
	    var r = Math.floor(Math.random() * 256);
	    var g = Math.floor(Math.random() * 256);
	    var b = Math.floor(Math.random() * 256);
	    return "rgb(" + r + "," + g + "," + b + ")";
	  }
	</script>
</body>
</html>