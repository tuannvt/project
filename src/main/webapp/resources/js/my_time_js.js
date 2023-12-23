
console.log("Start js");


// Update the countdown every second
const countdownInterval = setInterval(updateCountdown, 1000);
function updateCountdown() {
var targetDate = document.getElementsByClassName("targetDate");
var targetAuctionId = document.getElementsByClassName("targetAuctionId");
/*for(int i = 0 ; i < targetDate.length; i++){
}*/
for (let i = 0; i < targetDate.length; i++) {
  // Parse the date string into a Date object
  var dateObject = new Date(targetDate[i].value);

  // Get the timestamp in milliseconds
  var timestamp = dateObject.getTime();
    // Get the current date and time
    const currentDate = new Date().getTime();

    // Calculate the remaining time
    const timeRemaining = timestamp - currentDate;

    // Check if the countdown has reached zero
    if (timeRemaining <= 0) {
      clearInterval(countdownInterval); // Stop the countdown
      document.getElementById('countdown').innerHTML = 'Countdown expired!';
      $.ajax({
      			url : '/user/hethan/' + targetAuctionId[i].value,
      			type: "GET",
      			data : {
      				auctionId : targetAuctionId[i].value
      			},
      			success : function(responseText) {
              location.href = '/home'
      			}
      		});

    } else {
      // Calculate days, hours, minutes, and seconds
      const days = Math.floor(timeRemaining / (1000 * 60 * 60 * 24));
      const hours = Math.floor((timeRemaining % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
      const minutes = Math.floor((timeRemaining % (1000 * 60 * 60)) / (1000 * 60));
      const seconds = Math.floor((timeRemaining % (1000 * 60)) / 1000);

      // Display the countdown
      //document.getElementById('countdown').innerHTML = `${days}d ${hours}h ${minutes}m ${seconds}s`;
      document.getElementById('d'+i).innerHTML = `${days}d `;
      document.getElementById('h'+i).innerHTML = `${hours}h `;
      document.getElementById('p'+i).innerHTML = `${minutes}m`;
      document.getElementById('s'+i).innerHTML = `${seconds}s`;
    }
}

}
