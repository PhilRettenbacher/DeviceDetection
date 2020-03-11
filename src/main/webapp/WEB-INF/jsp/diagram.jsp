<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Geräteerkennung</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript">
window.onload = function() {
	
var dataPoints = [];
var chart = new CanvasJS.Chart("chartContainer", {
	theme: "dark2", // "light1", "dark1", "dark2"
	
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
		suffix: " Â°C"
	},
	data: [{
		type: "line",
		xValueFormatString: "After #,##0 s",
		yValueFormatString: "#,##0.0 Â°C",
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
<div id="chartContainer" style="height: 370px; width: 45%; float:right;"></div>
<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
<header>
<br>
            <input class="btn-bearbeiten" type="button" name="" value="Bearbeiten"><br></br>
			<input class="btn-speichern" type="button" name="" value="Speichern"><br></br>
			
			
			<select id="filterGebaeude">
				<option value="">Gebäude auswählen</option>
				<option value="werkstatt">Werkstätte</option>
				<option value="gebaude">Theoriegebäude</option>
			</select>
			<select id="filterGeraete">
				<option value="">Geräte auswählen</option>
				<option value="heizung">Heizung</option>
				<option value="drehmaschine">Drehmaschine</option>
				<option value="fraesmaschine">Fräsmaschine</option>
				<option value="klimaanlage">Klimaanlage</option>
			</select>
			<select id="filterStatus">
				<option value="">Status auswählen</option>
				<option value="status-on">Ein</option>
				<option value="status-off">Aus</option>
				<option value="status-save">Energiespar</option>
			</select>
			
			<div class="geräteliste" >
			<table class="content-daten" border="3">
			  <tr>
				<th> Gebäude</th>
				<th> Gerätbezeichnung</th>
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
		<h1 style="text-align:center;"> Geräte ändern</h1>
		<h4 style="text-align:left; color:white;">Bezeichnung</h4>
		<div class="textbox2">
			<input type="text" name="bezeichnung" />
		</div>
		<h4 style="text-align:left; color:white;">Gebäude</h4>
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
                        