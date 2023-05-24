<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>个人信息</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="resources/css/layui.css">
<script src="resources/js/jquery.1.12.4.min.js"></script>
<script type="text/javascript" src="resources/js/layui.js"></script>
</head>
<body>
	<div class="layui-fluid">
		<div class="layui-row layui-col-space15">
			<div class="layui-col-md12">
				<div class="layui-card">
					<div class="layui-card-header">当前登录管理员</div>
					<div class="layui-card-body" pad15="">

						<div class="layui-form" lay-filter="">
							
							<div class="layui-form-item">
								<label class="layui-form-label">当前用户</label>
								<div class="layui-input-inline">
									<input type="text" name="username"  value="<%=request.getSession().getAttribute("name")%>" readonly=""
										class="layui-input">
								</div>
								<div class="layui-form-mid layui-word-aux">不可修改。一般用于后台登入名</div>
							</div>
							
							<div class="layui-form-item">
								<label class="layui-form-label">性别</label>
								<div class="layui-input-block">
									<input type="radio" name="sex" value="男" title="男" checked="">
									<div class="layui-unselect layui-form-radio">
										<i class="layui-anim layui-icon"></i>
										<div>男</div>
									</div>
									<input type="radio" name="sex" value="女" title="女">
									<div class="layui-unselect layui-form-radio layui-form-radioed">
										<i class="layui-anim layui-icon"></i>
										<div>女</div>
									</div>
								</div>
							</div>
							
							<div class="layui-form-item">
								<label class="layui-form-label">手机</label>
								<div class="layui-input-inline">
									<input type="text" name="cellphone" value="<%=request.getSession().getAttribute("phone")%>" lay-verify="phone"
										readonly="" autocomplete="off" class="layui-input">
								</div>
							</div>
							<div class="layui-form-item">
								<label class="layui-form-label">邮箱</label>
								<div class="layui-input-inline">
									<input type="text" name="email" value="lly@163.com" lay-verify="email" readonly=""
										autocomplete="off" class="layui-input">
								</div>
							</div>
							<!-- <div class="layui-form-item layui-form-text">
								<label class="layui-form-label">备注</label>
								<div class="layui-input-block">
									<textarea name="remarks" placeholder="请输入内容"
										class="layui-textarea"></textarea>
								</div>
							</div> -->
							<div class="layui-form-item">
								<div class="layui-input-block">
									<button class="layui-btn" lay-submit="" lay-filter="setmyinfo">管理员不可修改，请联系开发人员</button>
									<!-- <button type="reset" class="layui-btn layui-btn-primary">重新填写</button> -->
								</div>
							</div>
						</div>

					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<script>
	$(function() {
		layui
				.use(
						[ 'layer', 'table', 'form', 'upload' ],
						function() {
							var table = layui.table;
							var layer = layui.layer;
							var form = layui.form;
							var upload = layui.upload;
							var uploadInst = upload
									.render({
										elem : '#test1' //绑定元素
										,
										url : 'banner/uploadBannerImg' //上传接口
										,
										done : function(res) {
											layer.msg("上传图片成功！", {
												icon : 1,
												time : 1000
											});
											var str = "<img style='width:280px;height:160px;' src='upload/"+res.src+"' /><input type='hidden' value='"+res.src+"' name='bannerImg' />"
											$("#newImg").html(str);
										},
										error : function() {
											layer.msg("上传图片失败！请重试！", {
												icon : 5,
												anim : 6,
												time : 1000
											});
										}
									});
							form
									.on(
											'submit(*)',
											function() {
												$
														.ajax({
															type : "post",
															url : "banner/addBanner",
															data : $(
																	"#formData")
																	.serialize(),
															success : function(
																	data) {
																if (data == "success") {
																	layer
																			.msg(
																					"添加轮播图成功！",
																					{
																						icon : 1,
																						shade : 0.4,
																						anim : 1,
																						time : 1000
																					},
																					function() {
																						window.location.href = "view/bannerlist";
																					});
																} else {
																	layer
																			.msg(
																					"添加轮播图失败！请重试！",
																					{
																						icon : 5,
																						shade : 0.4,
																						anim : 6,
																						time : 1000
																					});
																}
															}
														});
												return false;
											});
						});
	});
</script>
</html>
