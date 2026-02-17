function signup() {

    const username = document.getElementById("username");
    const password = document.getElementById("password");
    const error = document.getElementById("error");

    if (!username.value || !password.value) {
        error.textContent = "Enter details";
        return;
    }

    fetch("/auth/register", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({
            username: username.value,
            password: password.value
        })
    })
    .then(res => {
        if (!res.ok) {
            return res.text().then(text => {
                throw new Error(text);
            });
        }
        return res.json();
    })
    .then(user => {
        localStorage.setItem("userId", user.id);
        window.location.href = "index.html";
    })
    .catch(err => {
        error.textContent = err.message;
    });
}
