function login() {

    const username = document.getElementById("username");
    const password = document.getElementById("password");
    const error = document.getElementById("error");

    if (!username.value || !password.value) {
        error.textContent = "Enter credentials";
        return;
    }

    fetch("/auth/login", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({
            username: username.value,
            password: password.value
        })
    })
    .then(res => {
        if (!res.ok) throw new Error("Invalid credentials");
        return res.json();
    })
    .then(user => {
        localStorage.setItem("userId", user.id);
        window.location.href = "dashboard.html";
    })
    .catch(err => {
        error.textContent = err.message;
    });
}
