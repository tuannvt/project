
console.log("Start js");


// Update the countdown every second
const countdownInterval = setInterval(updateCountdown, 1000);
function updateCountdown() {
var targetDate = document.getElementById('targetDate').value;
  // Get the current date and time
  const currentDate = new Date().getTime();

  // Calculate the remaining time
  const timeRemaining = targetDate - currentDate;

  // Check if the countdown has reached zero
  if (timeRemaining <= 0) {
    clearInterval(countdownInterval); // Stop the countdown
    document.getElementById('countdown').innerHTML = 'Countdown expired!';
  } else {
    // Calculate days, hours, minutes, and seconds
    const days = Math.floor(timeRemaining / (1000 * 60 * 60 * 24));
    const hours = Math.floor((timeRemaining % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
    const minutes = Math.floor((timeRemaining % (1000 * 60 * 60)) / (1000 * 60));
    const seconds = Math.floor((timeRemaining % (1000 * 60)) / 1000);

    // Display the countdown
    //document.getElementById('countdown').innerHTML = `${days}d ${hours}h ${minutes}m ${seconds}s`;
    document.getElementById('d').innerHTML = `${days}d `;
    document.getElementById('h').innerHTML = `${hours}h `;
    document.getElementById('p').innerHTML = `${minutes}m`;
    document.getElementById('s').innerHTML = `${seconds}s`;
  }
}
