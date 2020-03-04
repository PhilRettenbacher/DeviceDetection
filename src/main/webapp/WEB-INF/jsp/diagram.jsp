<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript">
window.onload = function() {
	
var dataPoints = [];
var chart = new CanvasJS.Chart("chartContainer", {
	theme: "light2", // "light1", "dark1", "dark2"
	title: {
		text: "Energieverbrauch"
	},
	axisX: {
		title: "Zeit",
		suffix: " s"
	},
	axisY: {
		title: "Energieverbrauch",
		includeZero: false,
		valueFormatString: "#,##0.0",
		suffix: " °C"
	},
	data: [{
		type: "line",
		xValueFormatString: "After #,##0 s",
		yValueFormatString: "#,##0.0 °C",
		dataPoints: dataPoints
	}]
});
 
var yValue;
var xValue;
var updateInterval = 2000;
 
<c:forEach items="${dataPointsList}" var="dataPoints" varStatus="loop">
	<c:forEach items="${dataPoints}" var="dataPoint">
		yValue = parseFloat("${dataPoint.y}");
		xValue = parseInt("${dataPoint.x}");
		dataPoints.push({
			x : xValue,
			y : yValue,
		});
	</c:forEach>
</c:forEach>
 
chart.render();

 
}
</script>
</head>
<body>
<div id="chartContainer" style="height: 370px; width: 100%;"></div>
<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
</body>
</html>                              