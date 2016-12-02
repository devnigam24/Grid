<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="includes/resources.inc"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Genre</title>
</head>
<body class="ContentBody" id="contentBody">
	<div id="mainDiv" class="mainDiv">
		<div class="col-xs-12 genreBody" id="genreBody">
			<div class="col-xs-12 middle genreHead">
				<label class="genreTitle">GENRES</label>
				<hr class="style-one">
			</div>
			<div class="col-xs-12 middle genreTitleContent">
				<label class="genreTitle">title of trending content in all genres</label>				
			</div>
			<div class="col-xs-12 genreArrowDivs">
				<div class="col-xs-12 middle genreArrow">
					<label id="actorArrow" class="col-xs-12">Actor</label>
				</div>
				<div class="col-xs-12 middle genreArrow">
					<label id="socianInfluncerArrow" class="col-xs-12">Social Influencer</label>
				</div>
				<div class="col-xs-12 middle genreArrow">
					<label id="musicianArrow" class="col-xs-12">Musician</label>
				</div>
				<div class="col-xs-12 middle genreArrow">
					<label id="musicianArrow" class="col-xs-12">Fashion</label>
				</div>
				<div class="col-xs-12 middle genreArrow">
					<label id="artistsArrow" class="col-xs-12">Artists</label>
				</div>
				<div class="col-xs-12 middle genreArrow">
					<label id="comedianArrow" class="col-xs-12">Comedians</label>
				</div>
				<div class="col-xs-12 middle genreArrow">
					<label id="atheletesArrow" class="col-xs-12">Athletes</label>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
<script type="text/javascript">

	$( document ).ready(function() {
		$("#actorArrow").on("swiperight", function() {
			alert("actor")
		});
	});	
</script>