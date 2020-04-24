<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Ger�teerkennung</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript">
window.onload = function() {

<%! int i = 0;%>
<%! int j = 0;%>
<c:forEach items="${names}" var="name" varStatus="loop">	
var name<%=i%> = "${name}";
<%i++;%>
</c:forEach>
<%i=0;%>
<c:forEach items="${dataPointsList}" var="dataPoints" varStatus="loop">	
var dataPoints<%=i%> = [];
<%i++;%>
</c:forEach>
<%i=0;%>
var chart = new CanvasJS.Chart("chartContainer", {
	theme: "dark2", // "light1", "dark1", "dark2"
	
	title: {
		text: "Energieverbrauch"
	},
	axisX: {
		valueFormatString: "DD.MMM.YYYY HH:mm"
	},
	axisY: {
		title: "Energieverbrauch",
		includeZero: false,
		valueFormatString: "#,##0.0",
		suffix: " W"
	},
	toolTip: {
		shared: true
	},
	legend: {
		cursor: "pointer",
		verticalAlign: "top",
		horizontalAlign: "center",
		dockInsidePlotArea: true,
	},
	data: [
		<%j=0;%>
		<c:forEach items="${dataPointsList}" var="dataPoints" varStatus="loop">
		<%j++;%>
		</c:forEach>
		<c:forEach items="${dataPointsList}" var="dataPoints" varStatus="loop">
		{
		type: "line",
		name: name<%=i%>,
		showInLegend: true,
		yValueFormatString: "#,##0.0 W",
		dataPoints: dataPoints<%=i%>
		<%i++;%>
		}<%=i<j?",":""%>
		</c:forEach>
	]
});
 
var yValue;
var xValue;
var updateInterval = 2000;
<%i=0;%>
<c:forEach items="${dataPointsList}" var="dataPoints" varStatus="loop">
	<c:forEach items="${dataPoints}" var="dataPoint">
		yValue = parseFloat("${dataPoint.y}");
		xValue = new Date(${dataPoint.x.getTime()});
		dataPoints<%=i%>.push({
			x : xValue,
			y : yValue,
		});
		
	</c:forEach>
	<%i++;%>
</c:forEach>
<%i=0;%>
chart.render();

 
}
</script>
</head>
<body>
<div id="chartContainer" style="height: 370px; width: 45%; float:right;"></div>
<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
<header>
<br>
            <input class="btn-bearbeiten" type="button" name="" value="Bearbeiten"><br></br>
			<input class="btn-speichern" type="button" name="" value="Speichern"><br></br>
			
			
			<select id="filterGebaeude">
				<option value="">Geb�ude ausw�hlen</option>
				<option value="werkstatt">Werkst�tte</option>
				<option value="gebaude">Theoriegeb�ude</option>
			</select>
			<select id="filterGeraete">
				<option value="">Ger�te ausw�hlen</option>
				<option value="heizung">Heizung</option>
				<option value="drehmaschine">Drehmaschine</option>
				<option value="fraesmaschine">Fr�smaschine</option>
				<option value="klimaanlage">Klimaanlage</option>
			</select>
			<select id="filterStatus">
				<option value="">Status ausw�hlen</option>
				<option value="status-on">Ein</option>
				<option value="status-off">Aus</option>
				<option value="status-save">Energiespar</option>
			</select>
			
			<div class="ger�teliste" >
			<table class="content-daten" border="3">
			  <tr>
				<th> Geb�ude</th>
				<th> Ger�tbezeichnung</th>
				<th> Verbrauch</th>
				<th> Leistung</th>
				<th> Status</th>
				<th><input disabled selected type="checkbox"/></th>
			  </tr>
			 <tr>
				 <td></td>
				 <td></td>
				 <td>kWh</td>
				 <td>kW</td>
				 <td></td>
				 <td style="text-align:center;"><input type="checkbox"/></td>
			 </tr>
			 <tr>
				 <td></td>
				 <td></td>
				 <td>kWh</td>
				 <td>kW</td>
				 <td></td>
				 <td style="text-align:center;"><input type="checkbox"/></td>
			 </tr>
			 <tr>
				 <td></td>
				 <td></td>
				 <td>kWh</td>
				 <td>kW</td>
				 <td></td>
				 <td style="text-align:center;"><input type="checkbox"/></td>
			 </tr>
			 <tr>
				 <td></td>
				 <td></td>
				 <td>kWh</td>
				 <td>kW</td>
				 <td></td>
				 <td style="text-align:center;"><input type="checkbox"/></td>
			 </tr>
			 <tr style="font-weight:bold">
				 <td >Gesamtverbrauch</td>
				 <td></td>
				 <td>kWh</td> 
				 <td>kW</td>
				 <td></td>
				 <td style="text-align:center;"><input type="checkbox"/></td>
			 </tr>
			 
			</table>
		    </div>
		
		
		<div class="textbox-container">	
		<h1 style="text-align:center;"> Ger�te �ndern</h1>
		<h4 style="text-align:left; color:white;">Bezeichnung</h4>
		<div class="textbox2">
			<input type="text" name="bezeichnung" />
		</div>
		<h4 style="text-align:left; color:white;">Geb�ude</h4>
		<div class="textbox">
			<input type="text" name="gerbaude" />
		</div>
		</div>
		</form>
			
</header>
</body>
</html>      
<style>
body{
	margin: 0;
	padding: 0;
	font-family: Calibri Light;
	font-weight: bold;
	background-color: #32373A;
	background-size: cover;
    color: #fff;
    }

    .content-daten {
		position: absolute;
		top:10%;
		left: 1%;
        margin-left:auto; 
        margin-right:auto;
        border-collapse: collapse;
        width: 50%;
		height: 10%;
		border: 1px solid #fff;
        
    }
    .content-daten th{
        font-weight: bold;
        color: #fff;
        height: 30px;
        text-align: center;
        border: 1px solid #fff;
        
    }
    .content-daten td{
        color: #fff;
        height: 30px;
        vertical-align: center;
        border: 1px solid #fff;

    }
	
    .btn-bearbeiten{
        background: none;
        display: inline-block;
        border: 1.5px solid #fff;
        color: #fff;
        padding: 5px 20px;
        font-size: 14px;
        cursor: pointer;
		position: absolute;
		top:38%;
		left:42%;
    }
        
    .btn-bearbeiten:hover{
        background-color: #fff;
        color: black;
    }
	#filterGebaeude,#filterGeraete,#filterStatus {
		position: absolute;
		top: 3%;
	}
	#filterGebaeude{left: 1%;}
	#filterGeraete{left: 18%;}
	#filterStatus{left: 40%;}
	
	select{
		width: 11%;
		height: 25px;
		padding-left: 10px;
		background: none;
		border: 1.5px solid #fff;
		color: #fff;
		cursor: pointer;
	}
	select option {
		background-color: white;
		color: #000000;
	}
	
.textbox-container{
	width: 20%;
	position: absolute;
	top: 45%;
	left: 1%;
	color: #fff;
}

.textbox-container h1{
	float: center;
	font-size: 16px;
	border-bottom: 1.5px solid #fff;
}
	
.textbox, .textbox2{
	width: 100%;
	overflow: hidden;
	font-size: 18px;
	border-bottom: 1.5px solid #fff;

}

.textbox input, .textbox2 input{
	border: none;
	outline: none;
	background: none;
	color: #fff;
	font-size: 16px;
	width: 100%;
	float: left;

}
.btn-speichern {
    background: none;
    display: inline-block;
    border: 1.5px solid #fff;
    color: #fff;
    padding: 5px 20px;
    font-size: 14px;
    cursor: pointer;
	position: absolute;
	bottom:20%;
}
.btn-speichern{left:1%;}

        
.btn-speichern:hover{
    background-color: #fff;
    color: #000000;
}
</style>
                        