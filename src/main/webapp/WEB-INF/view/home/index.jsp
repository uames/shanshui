<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common.jsp" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib  prefix="date" uri="/tags"%>
<%@ taglib prefix="page"  uri="/pages"%>
<t:layout >
	<jsp:attribute name="header">
		<title>账户总览-藏金街</title>
		<link rel="stylesheet" type="text/css" href="${path}/content/css/mytransaction.css" />
		<script src="${path}/content/js/lib/require.mini.js" defer async="async" data-main="${path}/content/js/home/record.js"></script>
        <script>
<!--		//扩展标签
			document.createElement('header');
			document.createElement('nav');
			document.createElement('figcaption');
			document.createElement('figure');
			document.createElement('section');
			document.createElement('article');
			document.createElement('aside');
			document.createElement('footer');
			document.createElement('hgroup');
-->        </script>
	</jsp:attribute>
	<jsp:body>
    <t:notice />
		<t:header />
		<t:nav current="3"/>
	<!--header end-->
    <div class="my_gold">
        我的藏金 > <span class="current">账户总览</span>
    </div>
    <div class="contant">
    	<t:home_left_menu cur_home="0"/>
        <div class="my_index">
        	<em class="patch_top"></em>
            <em class="patch_bottom"></em>
        	<div class="income_all">
            	<div class="income_l">
                	<h3>累计净收益</h3>
                    <p class="money">
                    	<span class="number">${interest }</span>
                        <span class="unit">${interestT }<label>元</label></span>
                    </p>
                </div>
                <div class="income_r">
                  
                	 <c:if test="${lisize<1}">
            		 	<div class="no-invest">
                        	暂无回款中的投资记录 <a href="goods/list" class="invest-btn">马上去投资</a>      
                        </div>
                     </c:if>
                 	<c:if test="${lisize>0}">
	                	<ul>
		                	 <c:forEach items="${rord}" var="rordd" varStatus="loop"> 
		                    	<li>
		                        	<span class="income_name">藏金街-<label>${rordd.po.goods_name}</label></span>
		                            <span class="income"><label>${rordd.interestMoney }</label>元/收益</span>
		                            <span class="time">
		                            	<date:date pattern="yyyy-MM-dd" value="${rordd.po.add_time}"></date:date> 
		                            </span>
		                        </li>
		                    </c:forEach>
	                    </ul>
                    </c:if>
                </div>
            </div>
            <div class="effect_pic">
            	<div class="pic">
                	<p class="number"><span class="money">${totalm}</span>${totalmT}</p>
                    <p class="total">总资产</p>
                </div>
                <div class="capital">
                	<p class="e_top">待收本金<span>${reamount}${reamountT}</span></p>
                    <p class="e_bottom">
                    	<a href="javascript:;">新的投资计划</a>
                    	<a href="home/autoinvest">设置自动续投</a>
                    </p>
                </div>
                <div class="income">
                	<p class="e_top">收益<span>${repro}${reproT}</span></p>
                    <p class="e_bottom">
                    	<a href="home/record/1">查看投资详情</a>
                    </p>
                </div>
                <div class="gold">
                	<p class="e_top">黄金币<span>${tk.user.po.score} 个</span></p>
                    <p class="e_bottom">
                    	<a href="home/scoreflow">查看黄金币记录</a>
                    </p>
                </div>
            </div>
            <div class="trading_record">
            	<h4>最近交易记录</h4>
                <p class="record_name">
                	<span class="re_name">名称</span>
                	<span class="income">预期年化收益</span>
                	<span class="deadline">理财期限</span>
                	<span class="trading_hour">交易时间</span>
                	<span class="invest_amount">投资金额（元）</span>
                	<span class="state">状态</span>
                	<span class="operation">操作</span>
                </p>
                <ul class="record_ul">
                	<c:forEach items="${ord}" var="ordd" varStatus="loop">
                	<li>
                    	<span class="pro_name">藏金街-${ordd.po.goods_name }</span>
                        <span class="pro_income">${ordd.po.annual_rate }<label>%</label></span>
                        <span class="pro_deadline">${ordd.po.term }天</span>
                        <span class="pro_time">
                        	<c:if test="${ordd.po.add_time>0}">
                                <date:date pattern="yyyy-MM-dd HH:mm:ss" value="${ordd.po.add_time}"></date:date> 
                            </c:if>
                        </span>
                        <span class="pro_invest">${ordd.po.amount}</span>
                        <span class="pro_state">${ordd.statusTip }</span>
                        <span class="pro_operation">
                               <a href="javascript:;" class="handle viewOrder" id="viewOrder_${ordd.po.id}" data-id="${ordd.po.id}">查看</a>
                           	
                            <c:if test="${ordd.po.is_locked==0 && ordd.statusTip=='未付款'}">
                               <a href="trade/pay?id=${ordd.po.id}">支付</a>
                               <a href="javascript:void(0);" data-id="home/del?id=${ordd.po.id}&type=0" class="delete">删除</a>
                      	    </c:if>
                           	<c:if test="${ordd.po.is_locked==0 && ordd.statusTip=='续投中'}">
                               <a href="trade/pay?id=${ordd.po.id}">修改</a>
                           	</c:if> 
                        </span>
                    </li>
                    </c:forEach>
                </ul>
                <section class="page_height" style="display:none;">
               		<span id="page" data-main="${page }" style="display:none;"></span>
                    <page:page url="home/index" count="${pcount }" page="${page }"></page:page>
                </section>
                <a class="read_move" href="home/record/1">查看更多+</a>
            </div>
        </div>
    </div>
	<!--con-->
	
	<div id="showdetail">
		<div class="detail_bg"></div>
	    <div class="detail_cont">
	       <p class="title">项目详情</p>
			
	       	<p>订单号：<span id=orderno></span></p>
	       <div class="left">
	       		<p>产品名称：<span id="goods_name"></span></p>
	       		<p>理财周期：<span id="term"></span>天</p>
	       </div>
	       <div class="right">
	       		<p>起息日期：<span id="val_day"></span></p>
	       		<p>到期日期：<span id="sel_time" ></span></p>
	       </div>
	       <div style="clear:both;"></div>
	       <div class="detail-header">
	       	<table>
	       		<tr>
	       			<th class="pl20">合同金额(元)</th>
	       			<th>年利率</th>
	       			<th>奖励(元)</th>
	       			<th>到期收益(元)</th>	
	       		</tr>
	       		<tr>
	       			<td class="pl20" id="amount"></td>
	       			<td><span id="rate"></span><span class="per-icon">%</span></td>
	       			<td id="panic_reward"></td>
	       			<td ><span id="interestm"></span></td>
	       		</tr>
	       	</table>
	       </div>
<div id="order_chg" class="changeOrder">
		       	<p class="order-title">订单变更：</p>
		       	<div class="ordersCon">
		       		<div class="orders" id="order_change1">
		       			<div>
			       			<label id="num0" class="fl"></label>
			       			<table class="fl">
			       				<tbody>
			       					<tr>
			       						<th>日期</th>
			       						<th class="widshort">产品名称</th>
			       						<th class="widshort">理财期限(天)</th>
			       						<th>预期年化收益率(%)</th>
			       						<th>收益余额(元)</th>
			       					</tr>
			       					<tr>
			       						<td id="date0"></td>
			       						<td id="goods_name0"></td>
			       						<td id="term0"></td>
			       						<td id="annual_rate0"></td>
			       						<td id="profit_left0"></td>
			       					</tr>
			       				</tbody>
			       			</table>
			       			<div class="clear"></div>
			       		</div>
			       		<div class="orderIll">
		       				<label class="fl">订单说明：</label>
		       				<div id="des0" class="fl illCon"></div>
		       				<div class="clear"></div>
		       			</div>
		       		</div>
		       		<div id="order_change2" class="orders no-border">
		       			<div>
			       			<label id="num1" class="fl"></label>
			       			<table class="fl">
			       				<tbody>
			       					<tr>
			       						<th>日期</th>
			       						<th class="widshort">产品名称</th>
			       						<th class="widshort">理财期限</th>
			       						<th>预期年化收益率</th>
			       						<th>收益余额</th>
			       					</tr>
			       					<tr>
			       						<td id="date1"></td>
			       						<td id="goods_name1"></td>
			       						<td id="term1"></td>
			       						<td id="annual_rate1"></td>
			       						<td id="profit_left1"></td>
			       					</tr>
			       				</tbody>
			       			</table>
			       			<div class="clear"></div>
			       		</div>
			       		<div class="orderIll">
		       				<label class="fl">订单说明：</label>
		       				<div id="des1" class="fl illCon"></div>
		       				<div class="clear"></div>
		       			</div>
		       		</div>
		       	</div>
		       	<div class="moreOrders"><ul id="page_show"></ul></div>
	       </div>	       
	       <div class="close"></div>
	        <div id="howget"></div>
	    </div>
	</div>		
	<!-- 
	<div class="detail_bg"></div>
	    <div class="detail_cont">
	       <p class="title">项目详情</p>
			
	       	<p>订单号：<span id="order">20141105814888</span></p>
	       	<p>资金包号：<span id="fpackage">20141105814888</span></p>
	       <div class="left">
	       		<p>产品名称：<span id="goods_name">藏金街—月汇金</span></p>
	       		<p>理财周期：<span id="term">30</span>天</p>
	       </div>
	       <div class="right">
	       		<p>起息日期：<span id="val_day">2014-10-20</span></p>
	       		<p>到期日期：<span id="sel_time" >2014-11-20</span></p>
	       </div>
	       <div style="clear:both;"></div>
	       <div class="detail-header">
	       	<table>
	       		<tr>
	       			<th class="pl20">合同金额(元)</th>
	       			<th>年利率</th>
	       			<th>奖励</th>
	       			<th>到期收益</th>	
	       		</tr>
	       		<tr>
	       			<td class="pl20" id="amount">20,000</td>
	       			<td><span id="rate">10</span><span class="per-icon">%</span></td>
	       			<td id="panic_reward">100</td>
	       			<td ><span id="interestm"></span></td>
	       		</tr>
	       	</table>
	       </div>
        
	       <div class="close"></div>
	</div> -->
	    
	    
	<t:footer />
	</jsp:body>
</t:layout>