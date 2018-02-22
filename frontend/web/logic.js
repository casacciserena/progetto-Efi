
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
switch	(arreyNomeome[arreyNome.lenght-1]) {
	case "o": 
	  elementNone.style.color = "lightblue";
	case "O":
	  elementNome.style.color = "lightblue";
	case "a":   
	  elementNome.style.color = "pink";
	case "A":
      elementNome.style.color = "pink";
	default:
       elementNome.style.color = "green";	
}
	
	
	elementNome.innerHTML = " " + nome;
	
	document.getElementById("fraseCss").style.display = "initial";
}

 
		
