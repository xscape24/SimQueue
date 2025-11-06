// script.js

let stompClient = null;

function connect() {
    const socket = new SockJS("/ws");
    stompClient = Stomp.over(socket);

    stompClient.connect({}, (frame) => {
        console.log("✅ Connected: " + frame);

        // Subscribe to backend events
        stompClient.subscribe("/topic/events", (message) => {
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

    // Start simulation when user clicks start
    const startButton = document.getElementById("start-btn");
    startButton.addEventListener("click", () => {
        fetch("/start-simulation")
            .then((res) => {
                console.log("▶️ Simulation started:", res);
            })
            .catch((err) => console.error("Error starting simulation:", err));
    });
});
