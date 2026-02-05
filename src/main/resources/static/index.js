window.onload = function () {
    setTimeout(() => {
        document.getElementById("welcome").classList.add("hidden");
        document.getElementById("loginSlide").classList.remove("hidden");
    }, 2500);
};

function login() {
    fetch("/auth/login", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({
            username: username.value,
            password: password.value
        })
    })
    .then(res => {
        if (!res.ok) throw new Error();
        return res.json();
    })
    .then(user => {
        localStorage.setItem("userId", user.id);
        window.location.href = "dashboard.html";
    })
    .catch(() => {
        error.innerText = "Invalid credentials";
    });
}
