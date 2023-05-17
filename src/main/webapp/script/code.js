function handleResponse(resp, msg){
    if(!( resp.status === 302 || resp.status === 201 || resp.status === 200)){
        throw new Error(msg);
    }

    return resp;
}

function getAllUser(){
	let ul = document.getElementById('all-res');

    const BASE_URL = "http://localhost:8080/spring-rest-interno23/utentirest/";

    let header = new Headers();
    header.append('Content-type', 'application/json');
    header.append('Accept', 'application/json');

    let request = new Request(BASE_URL, {
        headers : header, 
        method : 'GET'
    });

    let out = "";

    fetch(request)
        .then(resp => handleResponse(resp, `Errore: Non è stato possibile recuperare la lista dal server`)) 
        .then(resp => resp.json())
        .then(resp => {
            console.log(resp);
            
            resp.forEach(element => {
                out += ` 
                    <li> ID : ${element["id-utente"]}
                            - Nome : ${element.nome} 
                            - Email : ${element.email}
                            - Numero Figli : ${element.num_figli}
                            - Reddito : ${element.reddito}
                    </li>`;
            });
        })
        .catch(err => {
            console.log('---> Catch Block');
            out = `<p><strong> ${err.message}</strong></p>`;
        })
        .finally(
            () => {
                console.log('---> Finally Block');
                ul.innerHTML = out
            }
        );
}