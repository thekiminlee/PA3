 function switchImage(id){
	var newSrc = document.getElementById(id).src;
	var newAlt = document.getElementById(id).alt;
	document.getElementById("mainImage").src = newSrc;
	document.getElementById("mainImage").alt = newAlt;
}


function getLocation(zip){
	if (window.XMLHttpRequest) {
		// IE7+, Firefox, Chrome, Opera, Safari
		var xhr = new XMLHttpRequest();
	} else {
		// IE5, IE6
		var xhr = new ActiveXObject ("Microsoft.XMLHTTP");
	}

	xhr.onreadystatechange = function () {
		if(xhr.readyState === 4 && xhr.status === 200) {
			var result = xhr.responseText;
			var place = result.split(', ');

			document.getElementById("city").value = place[1];
			document.getElementById("state").value = place[0];
		}
	};

	xhr.open("POST", "../_getCityState.php", true);
	xhr.setRequestHeader("content-type", "application/x-www-form-urlencoded");
	xhr.send("zip="+zip);
}

function calculateTotal(price, quantity){
	var total = price * quantity;
	document.getElementById("total").innerHTML = total + ".00";
} 
