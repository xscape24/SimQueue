// Connect to WebSocket
let socket = new SockJS('/ws');
let stompClient = Stomp.over(socket);

stompClient.connect({}, function (frame) {
    console.log('Connected: ' + frame);

    // Subscribe to live events
    stompClient.subscribe('/topic/events', function (event) {
        console.log("Received event:", event.body);
        const liveList = document.getElementById("live-events");
        const li = document.createElement("li");
        li.style.
        li.textContent = event.body;
        liveList.appendChild(li);
    });
});

// Trigger simulation via REST endpoint
document.getElementById("start-btn").addEventListener("click", () => {
    fetch("/start-simulation")
        .then(response => response.text())
        .then(text => console.log(text));
});
