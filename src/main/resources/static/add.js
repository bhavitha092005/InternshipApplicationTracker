function save() {
    const userId = localStorage.getItem("userId");

    console.log("Saving application for userId:", userId);

    fetch(`/applications/${userId}`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({
            companyName: document.getElementById("company").value,
            role: document.getElementById("role").value,
            status: document.getElementById("status").value
        })
    })
    .then(res => {
        if (!res.ok) throw new Error("Save failed");
        return res.json();
    })
    .then(data => {
        console.log("Saved application:", data);
        window.location.href = "dashboard.html";
    })
    .catch(err => {
        alert("Error saving application");
        console.error(err);
    });
}
