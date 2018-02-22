
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

	switch	(arrayNome[arrayNome.length-1]) {
	case "o": 
	  elementNome.style.color = "lightblue";
	  break;
	case "O":
	  elementNome.style.color = "lightblue";
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

 
		
