// Update the count down every 1 second
let x = setInterval(function() {

	let now = new Date().getTime();
	let distance = countDownDate - now;
    
	let days = Math.floor(distance / (1000 * 60 * 60 * 24));
	let hours = Math.floor((distance % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
	let minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
	let seconds = Math.floor((distance % (1000 * 60)) / 1000);
  	
	if (distance > 0) {
		if (days < 10) {
			document.getElementById("days").innerHTML = "0" + days;
		} else {
			document.getElementById("days").innerHTML = days;
		}
		if (hours < 10) {
			document.getElementById("hours").innerHTML = "0" + hours;
		} else {
			document.getElementById("hours").innerHTML = hours;
		}
		if (minutes < 10) {
			document.getElementById("mins").innerHTML = "0" + minutes;
		} else {
			document.getElementById("mins").innerHTML = minutes;
		}
		if (seconds < 10) {
			document.getElementById("secs").innerHTML = "0" + seconds;
		} else {
			document.getElementById("secs").innerHTML = seconds;
		}
	} else {
		document.getElementsById("countdown").style.display = "none";
	}
}, 1000);