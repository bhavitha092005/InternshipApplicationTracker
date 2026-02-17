const userId = localStorage.getItem("userId");

if (!userId) {
    window.location.href = "login.html";
}

window.onload = function () {
    loadCounts();
};

function goAdd() {
    window.location.href = "add.html";
}

function logout() {
    localStorage.removeItem("userId");
    window.location.href = "index.html";
}

function loadCounts() {
    loadCount("APPLIED", "appliedCount");
    loadCount("INTERVIEW", "interviewCount");
    loadCount("OFFER", "offerCount");
    loadCount("REJECTED", "rejectedCount");
}

function loadCount(status, elementId) {
    fetch(`/applications/${userId}/count?status=${status}`)
        .then(res => res.text())
        .then(count => {
            document.getElementById(elementId).innerText = count;
        });
}

function loadStatus(status) {
    fetch(`/applications/${userId}/status?status=${status}`)
        .then(res => res.json())
        .then(data => {
            const tableBody = document.getElementById("apps");
            tableBody.innerHTML = "";

            if (data.length === 0) {
                tableBody.innerHTML =
                    "<tr><td colspan='3'>No records found</td></tr>";
                return;
            }

            data.forEach(app => {
                tableBody.innerHTML += `
                    <tr>
                        <td>${app.companyName}</td>
                        <td>${app.role}</td>
                        <td>${app.status}</td>
                    </tr>
                `;
            });
        });
}

		
		
		
		
		
		
		
		
		
		
		
