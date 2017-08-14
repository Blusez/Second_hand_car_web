<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
 
<html   style="width:260px">
<head>
  <script type="text/javascript" src="js/jquery-1.8.3.js"></script>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>二手车管理系统</title>
  <meta name="description" content="这是一个 index 页面">
  <meta name="keywords" content="index">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="renderer" content="webkit">
  <meta http-equiv="Cache-Control" content="no-siteapp" />
  <link rel="icon" type="image/png" href="assets/i/favicon.png">
  <link rel="apple-touch-icon-precomposed" href="assets/i/app-icon72x72@2x.png">
  <meta name="apple-mobile-web-app-title" content="Amaze UI" />
   <link rel="stylesheet" href="assets/css/amazeui.min.css"/>
  <link rel="stylesheet" href="assets/css/admin.css">
 
</head>
  
  <body style="overflow:scroll;">
    <!-- <div class="admin-sidebar am-offcanvas" id="admin-offcanvas"  style="float: right"> -->
   <!--  <div class="am-offcanvas-bar admin-offcanvas-bar"> -->
      <ul class="am-list admin-sidebar-list">
   
        <li>
        
        <a href="main.jsp" id="home" target="_parent"><span class="am-icon-home"></span> 首页</a></li>
        <li class="admin-parent">
        
          <a class="am-cf" data-am-collapse="{target: '#collapse-nav'}">
          <span class="am-icon-file"></span> 用户管理 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
          <div class="item">
          <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav">
           <!--  <li><a href="QuestionServlet?op=ToAddPage" class="am-cf" target="right"><span class="am-icon-check"></span>题库增加页<span class="am-icon-star am-fr am-margin-right admin-icon-yellow"></span></a></li>
            <li><a href="QuestionServlet?op=getQues" target="right"><span class="am-icon-puzzle-piece"></span> 题库删除页</a></li> -->
            <li><a href="UserController/adminselectByLimt.do?rid=2" target="right"><span class="am-icon-th"></span>管理员</a></li>
            <li><a href="UserController/adminselectByLimt.do?rid=1" target="right"><span class="am-icon-calendar"></span>普通用户</a></li>
            <li><a href="#" target="right"><span
									class="am-icon-calendar"></span> Splash界面设置</a></li>
            <li><a href="log.jsp" target="right"><span
									class="am-icon-calendar"></span> 系统日志</a></li>
							<li><a href="404.jsp" target="right"><span class="am-icon-bug"></span>
									404</a></li>
          </ul>
          </div>
          
          
          <a class="am-cf" data-am-collapse="{target: '#collapse-nav'}">
          <span class="am-icon-file"></span> 汽车信息管理 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
          <div class="item">
          <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav">
            <li><a href="CarInforController/adminselectByLimt.do?cStatus=0" class="am-cf" target="right"><span class="am-icon-check"></span>所有汽车<span class="am-icon-star am-fr am-margin-right admin-icon-yellow"></span></a></li>
            <li><a href="CarInforController/adminselectByLimt.do?cStatus=4" target="right"><span class="am-icon-puzzle-piece"></span> 待审核汽车</a></li>
            <!--<li><a href="questionUpdate.jsp" target="right"><span class="am-icon-th"></span> 试卷修改页</a></li>
            <li><a href="PaperCheckServlet" target="right"><span class="am-icon-calendar"></span> 试卷查看页</a></li>
              <li><a href="ExamServlet?op=EXAMPUBLISH" target="right"><span class="am-icon-calendar"></span> 试卷发布页</a></li> -->
          </ul>
          </div> 
          
            <a class="am-cf" data-am-collapse="{target: '#collapse-nav'}"><span class="am-icon-file"></span>订单管理 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
            <div class="item">
          <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav">
            <!-- <li><a href="CarInforController/adminselectByLimt.do?cStatus=0" class="am-cf" target="right"><span class="am-icon-check"></span>预定中<span class="am-icon-star am-fr am-margin-right admin-icon-yellow"></span></a></li> -->
            <li><a href="CarInforController/adminselectByLimt1.do?cStatus=1" class="am-cf" target="right"><span class="am-icon-puzzle-piece"></span>正在交易<span class="am-icon-star am-fr am-margin-right admin-icon-yellow"></span></a></li>
            <li><a href="CarInforController/adminselectByLimt1.do?cStatus=2" class="am-cf" target="right"><span class="am-icon-puzzle-piece"></span>交易完成<span class="am-icon-star am-fr am-margin-right admin-icon-yellow"></span></a></li>
          </ul> 
          </div>
          
           <a class="am-cf" data-am-collapse="{target: '#collapse-nav'}">
           <span class="am-icon-file"></span>图表汇总<span class="am-icon-angle-right am-fr am-margin-right"></span></a>
            <div class="item">
          <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav">
            <li><a href="eChat/addr-map.html" class="am-cf" target="right"><span class="am-icon-check"></span>全国二手车分布<span class="am-icon-star am-fr am-margin-right admin-icon-yellow"></span></a></li>
            <li><a href="eChat/pie_top15.html" target="right"><span class="am-icon-puzzle-piece"></span>品牌销售</a></li>
            <li><a href="eChat/second_price.html" target="right"><span class="am-icon-puzzle-piece"></span>售价汇总</a></li>
          </ul> 
          </div>
          
        </li>
        <li><a href="#"><span class="am-icon-envelope-o"></span>反馈信箱</a></li>        
        <li><a href="#" onclick="exit()"><span class="am-icon-sign-out"></span>注销</a></li>
      </ul>
  </body>
  <script>$(function(){
  $(".item").hide();
   $(".am-cf").click(function(){
   $(this).next(".item").slideToggle(300).siblings(".item").slideUp();
        });
   
  });
	function exit(){
	if(confirm("确定注销吗？")){
		window.location="UserController/adminExit.do";
	};
		
	}
	 
	
	</script>
  
</html>

