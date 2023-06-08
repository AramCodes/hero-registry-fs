console.log("JavaScript connected")
const form = document.getElementById("heroPostForm");

// get Hero
async function fetchHeroes() {
    const data = await fetch("http://localhost:8080/api/v1/heroes");
    const dataJson = await data.json();

    const heroesSection = document.getElementById("dataDisplay");
    heroesSection.innerHTML = "";
    
    for(const hero of dataJson){
        const el = document.createElement("div");
        console.log(hero);
        el.innerHTML = "------------------<br/>";
        for(const property in hero) {
            console.log(property);
            el.innerHTML += `${property} of this hero is: ${hero[property]}<br/>`;
        }
        el.innerHTML += "------------------<br/>";
        heroesSection.appendChild(el);
    }
}

fetchHeroes();

async function postHero(event) {
    event.preventDefault();
    const heroName = document.getElementById("name");
    const heroRating = document.getElementById("rating");
    const heroStrength = document.getElementById("strength");
    const heroWeapon = document.getElementById("weapon");
    

    const heroDto = {
        name:heroName.value,
        rating:heroRating.value,
        strength:heroStrength.value,
        weapon:heroWeapon.value
    }

    const initialRequestObj = {
        method: "POST",
        headers: {
            "Content-type": "application/json"
        },
        body: JSON.stringify(heroDto)
    }

    await fetch("http://localhost:8080/api/v1/heroes", initialRequestObj);

    await fetchHeroes();

}

form.addEventListener("submit", postHero)


