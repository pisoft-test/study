<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="${pageContext.request.contextPath}/js/lib/jquery-1.7.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/app/Area.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/app/AreaData_min.js" type="text/javascript"></script>
<script type="text/javascript">
$(function (){
	initComplexArea('seachprov', 'seachcity', 'seachdistrict', area_array, sub_array, '44', '0', '0');
});

//得到地区码
function getAreaID(){
	var area = 0;          
	if($("#seachdistrict").val() != "0"){
		area = $("#seachdistrict").val();                
	}else if ($("#seachcity").val() != "0"){
		area = $("#seachcity").val();
	}else{
		area = $("#seachprov").val();
	}
	return area;
}

function showAreaID() {
	//地区码
	var areaID = getAreaID();
	//地区名
	var areaName = getAreaNamebyID(areaID) ;
	alert("您选择的地区码：" + areaID + "      地区名：" + areaName);            
}

//根据地区码查询地区名
function getAreaNamebyID(areaID){
	var areaName = "";
	if(areaID.length == 2){
		areaName = area_array[areaID];
	}else if(areaID.length == 4){
		var index1 = areaID.substring(0, 2);
		areaName = area_array[index1] + " " + sub_array[index1][areaID];
	}else if(areaID.length == 6){
		var index1 = areaID.substring(0, 2);
		var index2 = areaID.substring(0, 4);
		areaName = area_array[index1] + " " + sub_array[index1][index2] + " " + sub_arr[index2][areaID];
	}
	return areaName;
}
</script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
<select id="seachprov" name="seachprov" onChange="changeComplexProvince(this.value, sub_array, 'seachcity', 'seachdistrict');"></select>&nbsp;&nbsp;
<select id="seachcity" name="homecity" onChange="changeCity(this.value,'seachdistrict','seachdistrict');"></select>&nbsp;&nbsp;
<span id="seachdistrict_div"><select id="seachdistrict" name="seachdistrict"></select></span>
<input type="button"  value="获取地区" onClick="showAreaID()"/>
</div>
<form>
<span>请输入订单号 </span><input type="text"/>
<select>
<option value="发送">发送</option>
<option value="接收">接收</option>
</select>
<input type="submit" value="确定"></input>
</form>
</body>
</html>