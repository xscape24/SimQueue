// script.js

let stompClient = null;

function connect() {
    const socket = new SockJS("/ws");
    stompClient = Stomp.over(socket);

    stompClient.connect({}, (frame) => {
        console.log("✅ Connected: " + frame);

        // Subscribe to backend events
        stompClient.subscribe("/topic/events", (message) => {//listens for messages sent by the backend
            if (message.body) {
                addEventToList(message.body);
            }
        });
    }, (error) => {
        console.error("❌ STOMP connection error:", error);
    });
}

function addEventToList(message) {
    const liveEventsList = document.getElementById("live-events");
    const li = document.createElement("li");
    li.textContent = message;
    li.style.fontSize="1vw";
    liveEventsList.appendChild(li);
    liveEventsList.scrollTop = liveEventsList.scrollHeight; // auto scroll
}

// Connect immediately when page loads
document.addEventListener("DOMContentLoaded", () => {
    connect();

    const startButton = document.getElementById("start-btn"); 
    // Start simulation when user clicks the start button
    startButton.addEventListener("click", () => {
        fetch("/start-simulation")
            .then((res) => {
                console.log("▶️ Simulation started:", res);
            })
            .catch((err) => console.error("Error starting simulation:", err));
    });
});
window.addEventListener('load', function() {
    const socket = new SockJS('/ws');    // must match WebSocketConfig endpoint
    const stompClient = Stomp.over(socket);

    stompClient.connect({}, function(frame) {
        console.log('Connected: ' + frame);

        // Subscribe to /topic/live-events
        stompClient.subscribe('/topic/live-events', function(message) {
            const ul = document.getElementById('live-events');
            const li = document.createElement('li');
            li.textContent = message.body;
            ul.appendChild(li);
        });
    });
});