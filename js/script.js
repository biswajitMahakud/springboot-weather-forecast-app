 document.getElementById('myForm').addEventListener('submit', function (event) {
    event.preventDefault(); // Prevents the form from submitting traditionally

    var cityName = document.getElementById('cityName').value;

    var xhr = new XMLHttpRequest();
    xhr.open('POST', 'http://localhost:8080/weather/get/forecast/data', true);
    xhr.setRequestHeader('Content-Type', 'application/json');

    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                var response = JSON.parse(xhr.responseText);
                console.log('Response:', response);
                //loading data in card
                let wMaxTemp = farenheitToCelcius(response.maxTemp);
                let wMinTemp = farenheitToCelcius(response.minTemp);

                let tempLoadObj = document.getElementById("weatherTempData");
                tempLoadObj.innerHTML = wMaxTemp + "&deg;C/ " + wMinTemp + "&deg;C";
                let tempLoadObj2 = document.getElementById("minTemp");
                tempLoadObj2.innerHTML = "Min: " + wMinTemp + "&deg;C";
                let tempLoadObj3 = document.getElementById("maxTemp");
                tempLoadObj3.innerHTML = "Max: " + wMaxTemp + "&deg;C";

                document.getElementById("dayIconPhrase").innerHTML =  "<h4>Weather: </h4>" + response.dayIconPhrase + " ";

                document.getElementById("nightIconPhrase").innerHTML =  "<h4>Weather: </h4>" + response.nightIconPhrase + " ";
                

            } else {
                console.error('Error:', xhr.status, xhr.statusText);
                // Handle the error here
            }
        }
    };

    xhr.send(JSON.stringify({ city: cityName }));
}); 



function farenheitToCelcius(temp) {
    let celVal = (temp - 32) * (5 / 9);
    console.log(celVal.toFixed(2));
    return celVal.toFixed(2);
}

