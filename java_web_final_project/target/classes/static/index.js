const heroesSection = document.getElementById("dataDisplay");
const form = document.getElementById("heroPostForm");

// get Hero
async function fetchHeroes() {
    const data = await fetch("http://localhost:8080/api/v1/heroes");
    const dataJson = await data.json();
    for (const hero of dataJson) {
        const el = document.createElement("div");
        el.innerHTML = "------------<br/>";

        for(const property in hero) {
            el.innerHTML+= `${property} of this hero is; ${hero[property]} <br/>`;
        }
        el.innerHTML += "--------------<br/>";
        heroesSection.appendChild(el);
    }

}

fetchHeroes();


//add Hero
async function postHero(event) {
    event.preventDefault();
    const heroName = document.getElementById();
    const heroRating = document.getElementById();
    const heroStrength = document.getElementById();
    const heroWeapon = document.getElementById();

    const heroDto = {
        name:heroName.value,
        rating:heroRating.value,
        strength:heroStrength.value,
        weapon:heroWeapon.value,
    }

    const intialRequestObj = {
        method: "POST",
        headers: [
            "Content-type": "application/json"
        ],
        body: JSON.stringify(heroDto)
    }

    await fetch("http://localhost:8080/api/v1/heroes", intialRequestObj);

    await fetchHeroes();

}