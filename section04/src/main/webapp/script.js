const price = {
	size:{
		'S': 4500,
		'M': 5500,
		'L': 6500
	},
	ingredients: {
		'패티': 2000,
		'치즈': 1000,
		'베이컨': 1500,
		'더블 패티': 3000,
		'더블 치즈': 1500,
		'더블 베이컨': 2500,
	},
	drink: {
		'없음': 0,
		'콜라': 3000,
		'제로콜라': 3500,
		'사이다': 3000
	}
}

const size  = document.getElementById("size");
const ingredient  = document.getElementById("ingredient");
const drink  = document.getElementById("drink");
const complain  = document.getElementById("complain");

const sizeRadio = document.querySelectorAll("input[name='size']");
const ingredientCheckbox = document.querySelectorAll("input[name='ingredient']");
const drinkSelect  = document.querySelector("select[name='drink']");
const complainTextarea  = document.querySelector("textarea");

sizeRadio.forEach( radio => {
	radio.addEventListener("change", () => {
		size.classList.add("active");
		updateOrder();
	});
});

ingredientCheckbox.forEach( ingredients => {
	ingredients.addEventListener("change", () => {
		let anyChecked = false;
		ingredientCheckbox.forEach( c => {if(c.checked) {anyChecked = true}});

		if(anyChecked){
			ingredient.classList.add("active");
		} else ingredient.classList.remove("active");
		updateOrder();
	});
});

drinkSelect.addEventListener("change", () => {
	if(drinkSelect.value == "no" ){drink.classList.remove("active");}
	else drink.classList.add("active");
	updateOrder();
});

complainTextarea.addEventListener("input", () => {
	if(complainTextarea.value.length <= 0){complain.classList.remove("active");}
	else complain.classList.add("active");
});



function updateOrder() {
	const selectSize = document.querySelector("input[name='size']:checked") ? document.querySelector("input[name='size']:checked").value : 0;
	const sizePrice = price.size[selectSize] || 0;

	const selectIngredient = document.querySelectorAll("input[name='ingredient']:checked");
	const selectIngrValue = [];
	let ingredientPrice = 0;
	selectIngredient.forEach((r) => {
		const ingr = r.value;
		selectIngrValue.push(ingr);
		ingredientPrice += price.ingredients[ingr];
	});

	const selectDrink = document.querySelector("select[name='drink']").value;
	console.log('selectDrink', selectDrink);
	const drinkPrice = price.drink[selectDrink] || 0;

	document.querySelector("#order-sumary").innerHTML = sizePrice + drinkPrice + ingredientPrice;
}