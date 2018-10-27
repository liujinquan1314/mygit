<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String path=request.getContextPath();
    String basePath=request.getScheme()+"//"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/echarts.js"></script>
<script type="text/javascript" src="js/jquery-1.9.0.min.js"></script>
</head>
<body>
<div id="dy"  style="height: 600px;width: 1100px;margin-top: 50px;margin-left:20px;">
    <div id="mainChart" style="border: 1px solid #438FB9; width:100%; height:45%;"></div>
</div>


<script type="text/javascript">
    //使用ajax加载数据 
    $.ajax({
        method:'post',
        url:'${pageContext.request.contextPath}/echartsData',
        dataType:'json',
        success:function(data){
            initChat(data);
        }
    }); 
    function initChat(data){
    var myChart = echarts.init(document.getElementById('mainChart'));
        option = {
                title : {
                    text: '员工男女比例统计',
                    subtext: '内部数据',
                    x:'center'
                },
                tooltip : {
                    trigger: 'item',
                    formatter: "{a} <br/>{b} : {c} ({d}%)"
                },
                legend: {
                    orient: 'vertical',
                    left: 'left',
                    data: data
                },
                series : [
                    {
                        name: '男女数量',
                        type: 'pie',
                        radius : '55%',
                        center: ['50%', '60%'],
                        data:data,
                        itemStyle: {
                            emphasis: {
                                shadowBlur: 10,
                                shadowOffsetX: 0,
                                shadowColor: 'rgba(0, 0, 0, 0.5)'
                            }
                        }       
                    }
                ]
            },
           myChart.setOption(option);
    };
</script>

</body>

</html>