var xhttp = new XMLHttpRequest();/*XMLHttpRequest è una dicitura obbligatoria per creare una variabile che utilizzi le funzionalità Ajax*/
xhttp.onreadystatechange = function() {
if (this.readyState == 4 && this.status == 200) {
	console.log(this.responseText);
	var animalArray = JSON.parse(this.responseText).content
	var html = "";
	for (var k = 0; k < animalArray.length; k++) {
		html += "<tr>"
			html += "<td>" + animalArray[k].animal_name + "</td>"
		 	html += "<td>" + animalArray[k].animal_family + "</td>"
		 	html += "<td>" + animalArray[k].animal_race + "</td>"
		 	html += "<td>" + animalArray[k].animal_descent + "</td>"
			html += "<td>" + animalArray[k].animal_legs + "</td>"
		 	html += "</tr>"
		}
		document.getElementById("animalTable").innerHTML = html;
	}
};
xhttp.open("GET", "http://localhost:8080/api/animal", true);
xhttp.send();

function myFunction() {
	console.log("Ciao Serena, come va oggi?");

	var nome = document.getElementById("name").value;

	var elementNome = document.getElementById("nome");

	var arrayNome = nome.split("");
	console.log(arrayNome);

	/* if (arrayNome[arrayNome.length-1] == "o" || arrayNome[arrayNome.length-1] == "O") {
		elementNome.style.color = "lightblue";
	} else if (arrayNome[arrayNome.length-1] == "a" || arrayNome[arrayNome.length-1] == "A") {
		elementNome.style.color = "pink";
	} else {
		elementNome.style.color = "green";
	}	*/

	switch(arrayNome[arrayNome.length-1]) {
	case "o":
	  elementNome.style.color = "darkviolet";
	  break;
	case "O":
	  elementNome.style.color = "ldarkviolet";
	  break;
	case "a":
	  elementNome.style.color = "pink";
	  break;
	case "A":
      elementNome.style.color = "pink";
	  break;
	default:
       elementNome.style.color = "green";
	   break;
	}

	elementNome.innerHTML = " " + nome;

	document.getElementById("fraseCss").style.display = "initial";
}

for (i = 0; i < 20; i++) {
	console.log("Ciao!!!!! :)" + i);
}

var animal1 = {
	nomeAnimale:"anacleto" ,
	famiglia:"tytonidae",
	razza:"barbagianni",
	discendenza:"tyto",
	numeroZampe:"2",
}

var animal2 = {
	nomeAnimale:"poldo",
	famiglia:"strygidae",
	razza:"gufo reale",
	discendenza:"b.bulbo",
	numeroZampe:"2",
}

var animal3 = {
	nomeAnimale:"arpa",
	famiglia:"accipitridae",
	razza:"aquila arpia",
	discendenza:"harpia harpyja",
	numeroZampe:"2"
}

var animalArray = [];
animalArray.push(animal1, animal2, animal3);
console.log(animal1.nomeAnimale, animal2.nomeAnimale, animal3.nomeAnimale);
for (var i = 0; i < animalArray.length; i++) {
	console.log(animalArray[i].nomeAnimale);
}

/*var html = "";
for (var k = 0; k < animalArray.length; k++) {
 	html += "<tr>"
		html += "<td>" + animalArray[k].nomeAnimale + "</td>"
		html += "<td>" + animalArray[k].famiglia + "</td>"
		html += "<td>" + animalArray[k].razza + "</td>"
		html += "<td>" + animalArray[k].discendenza + "</td>"
		html += "<td>" + animalArray[k].numeroZampe + "</td>"
	html += "</tr>"
}
document.getElementById("animalTable").innerHTML = html;*/
