function signup() {
    fetch("/auth/register", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({
            username: username.value,
            password: password.value
        })
    })
    .then(res => res.json())
    .then(user => {
        localStorage.setItem("userId", user.id);
        window.location.href = "dashboard.html";
    })
    .catch(() => msg.textContent = "User already exists");
}
