const content = document.getElementById("content");

function showOwnerLogin() {
    content.innerHTML = `
        <div class="card">
            <h2>Post Flat as Owner</h2>
            <input type="text" placeholder="Flat Title">
            <input type="text" placeholder="Location">
            <input type="number" placeholder="Rent">
            <input type="file" multiple>
            <button class="btn btn-primary" onclick="postFlat()">
                Upload Flat
            </button>
        </div>
    `;
}

function showUserLogin() {
    content.innerHTML = `
        <div class="card">
            <h2>Search Flats</h2>
            <input type="text" placeholder="Location">
            <input type="number" placeholder="Budget">
            <button class="btn btn-secondary" onclick="showFlats()">
                Search
            </button>
        </div>
    `;
}

function postFlat() {
    alert("Flat uploaded successfully!");
}

function showFlats() {
    content.innerHTML = `
        <div class="card flat-card">
            <img src="https://images.unsplash.com/photo-1502672260266-1c1ef2d93688">
            <div>
                <h2>2BHK in Bangalore</h2>
                <p>₹12000/month</p>
                <p>Veg • Female preferred • Non-smoker</p>
                <br>
                <button class="btn btn-secondary" onclick="bookFlat()">
                    Book Flat
                </button>
            </div>
        </div>
    `;
}

function bookFlat() {
    alert("Preference matched! Flat locked for booking.");
}