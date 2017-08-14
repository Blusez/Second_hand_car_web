<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="style/common.jsp"%>
<!doctype html>
<html class="no-js">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="这是一个 table 页面">
<meta name="keywords" content="table">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="icon" type="image/png" href="<%=path%>/assets/i/favicon.png">
<link rel="apple-touch-icon-precomposed"
	href="<%=path%>/assets/i/app-icon72x72@2x.png">
<meta name="apple-mobile-web-app-title" content="Amaze UI" />
<link rel="stylesheet" href="<%=path%>/assets/css/amazeui.min.css" />
<link rel="stylesheet" href="<%=path%>/assets/css/admin.css">
</head>
<script>
//$(function(){
	function checkIn(btn){
		var remark=btn.getAttribute("remark");
		location.href="CarInforController/updateStatusByid?id="+remark+"&status=0";
		alert("审核通过！");
			
	}
//});
</script>
<body>
	<!--[if lte IE 9]>
<p class="browsehappy">你正在使用<strong>过时</strong>的浏览器，Amaze UI 暂不支持。 请 <a href="http://browsehappy.com/" target="_blank">升级浏览器</a>
  以获得更好的体验！</p>
<![endif]-->

	<!-- content start -->
	<div class="admin-content">
		<div class="admin-content-body">
			<!-- <div class="am-cf am-padding am-padding-bottom-0">
					<div class="am-fl am-cf">
						<strong class="am-text-primary am-text-lg">表格</strong> / <small>Table</small>
					</div>
				</div> -->

			<hr>

			<div class="am-g">
				<div class="am-u-sm-12 am-u-md-6">
					<div class="am-btn-toolbar">
						<div class="am-btn-group am-btn-group-xs">
							<button type="button" class="am-btn am-btn-default">
								<span class="am-icon-plus"></span> 新增
							</button>
							<button type="button" class="am-btn am-btn-default">
								<span class="am-icon-save"></span> 保存
							</button>
							<button type="button" class="am-btn am-btn-default">
								<span class="am-icon-archive"></span> 审核
							</button>
							<button type="button" class="am-btn am-btn-default">
								<span class="am-icon-trash-o"></span> 删除
							</button>
						</div>
					</div>
				</div>
				<div class="am-u-sm-12 am-u-md-3">
					<div class="am-form-group">
						<select data-am-selected="{btnSize: 'sm'}">
							<option value="option1">所有类别</option>
							<option value="option2">IT业界</option>
							<option value="option3">数码产品</option>
							<option value="option3">笔记本电脑</option>
							<option value="option3">平板电脑</option>
							<option value="option3">只能手机</option>
							<option value="option3">超极本</option>
						</select>
					</div>
				</div>
				<div class="am-u-sm-12 am-u-md-3">
					<div class="am-input-group am-input-group-sm">
						<input type="text" class="am-form-field"> <span
							class="am-input-group-btn">
							<button class="am-btn am-btn-default" type="button">搜索</button>
						</span>
					</div>
				</div>
			</div>

			<div class="am-g">
				<div class="am-u-sm-12">
					<form class="am-form">
						<table class="am-table am-table-striped am-table-hover table-main">
							<thead>
								<tr>
									<th class="table-check"><input type="checkbox" /></th>
									<th class="table-id">ID</th>
									<!-- <th class="table-title">车主id</th> -->
									<th class="table-title">车名</th>
									<!-- <th class="table-type">车牌</th> -->
									<th class="table-type">城市</th>
									<th class="table-type">价钱</th>
									<th class="table-type">上牌日期</th>
									<th class="table-type">行驶距离</th>
									<th class="table-type">上下架</th>

									<th class="table-set">操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${carInfors }" var="carInfo">


									<tr>
										<td><input type="checkbox" /></td>
										<td>${carInfo.cId}</td>
										<%-- <td>${carInfo.uId }</td> --%>
										<td>${carInfo.cName }</td>
										<%-- <td>${carInfo.bId }</td> --%>
										<td>${carInfo.cCity }</td>
										<td>${carInfo.cPrice }</td>
										<td>${carInfo.cLicensrtime }</td>
										<td>${carInfo.cDistance }</td>
										<td><c:if test="${carInfo.cStatus == 0 }">
										已上架（在售）
										</c:if> <c:if test="${carInfo.cStatus == 1 }">
										销售中
										</c:if> <c:if test="${carInfo.cStatus == 2 }">
										已卖出
										</c:if> <c:if test="${carInfo.cStatus == 3 }">
										已卖出
										</c:if> <c:if test="${carInfo.cStatus == 4 }">
										待审核
										</c:if> <c:if test="${carInfo.cStatus == 5 }">
										下架
										</c:if></td>
										<td class="am-hide-sm-only"></td>
										<td>
											<div class="am-btn-toolbar">
												<div class="am-btn-group am-btn-group-xs">
													<button
														class="am-btn am-btn-default am-btn-xs am-text-secondary">
														<span class="am-icon-pencil-square-o"></span> 编辑
													</button>
													<c:if test="${carInfo.cStatus == 4 }">
													<button remark="${carInfo.cId}" onclick="checkIn(this)"
														class="am-btn am-btn-default am-btn-xs am-hide-sm-only">
														<img alt="" src="<%=path%>/images/up.png"> 审核通过
													</button>
													</c:if>
													<c:if test="${carInfo.cStatus == 0 }">
													<button
														class="am-btn am-btn-default am-btn-xs am-hide-sm-only">
														<img alt="" src="<%=path%>/images/down.png"> 下架
													</button>
													</c:if>
													
													
													<button
														class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only">
														<span class="am-icon-trash-o"></span> 删除
													</button>
												</div>
											</div>
										</td>
									</tr>
								</c:forEach>


							</tbody>
						</table>
						<%-- <div class="am-cf">
							共${pageUtil.totalCount }条记录,当前第${pageUtil.currentPage}/${pageUtil.pageCount}页，每页${pageUtil.pageSize}条纪录
                            <div class="am-fr">
                                <ul class="am-pagination">
                                    <li><a href="adminselectByLimt.do?cStatus=0&start=${pageUtil.currentPage-1}">«</a></li>                               
                                    <li class="am-active"><a href="adminselectByLimt.do?cStatus=0&start=1">首页</a></li>
                                    <li class="am-active"><a href="adminselectByLimt.do?cStatus=0&start=${pageUtil.pageCount}">末页</a></li>                 
                                    <li><a href="adminselectByLimt.do?cStatus=0&start=${pageUtil.currentPage+1}">»</a></li>
                                </ul>
                            </div>
						</div> --%>
						<hr />
						<p>注：</p>
					</form>
				</div>

			</div>
		</div>

		<footer class="admin-content-footer">
			<hr>
			<p class="am-padding-left">© 2014 AllMobilize, Inc. Licensed
				under MIT license.</p>
		</footer>

	</div>
	<!-- content end -->
	</div>

	<a href="#"
		class="am-icon-btn am-icon-th-list am-show-sm-only admin-menu"
		data-am-offcanvas="{target: '#admin-offcanvas'}"></a>

	<footer>
		<hr>
		<p class="am-padding-left">© 2014 AllMobilize, Inc. Licensed under
			MIT license.</p>
	</footer>

	<!--[if lt IE 9]>
<script src="http://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
<script src="assets/js/amazeui.ie8polyfill.min.js"></script>
<![endif]-->

	<!--[if (gte IE 9)|!(IE)]><!-->
	<script src="<%=path%>/assets/js/jquery.min.js"></script>
	<!--<![endif]-->
	<script src="<%=path%>/assets/js/amazeui.min.js"></script>
	<script src="<%=path%>/assets/js/app.js"></script>
</body>


  
</html>
