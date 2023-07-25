function chgFill(color, id) {
	document.getElementById(id).style.fill = color;
}


$(document).ready(function() {	
	$(".fadeIn").css("border-bottom", "2px solid white");
});


$(document).ready(function() {
	var progressPercentage = $("#amountSaved").val() / $("#goalAmount").val() * 100;
	
	if (progressPercentage >= 100) {
		$(".circle").css("background", "blue");
	}
	
	else {
		$(".circle").css(
			"background", "linear-gradient(to top, blue " + progressPercentage + "%, transparent " + progressPercentage + "%)"
			);
	}
}) 

