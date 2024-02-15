//spinner set to block

document.getElementById("search-btn").addEventListener("click", function () {
    document.getElementById("Loading-spinner").style.display = "block";
});

document.getElementById("5-day-weather-data-form").addEventListener("submit", function (event) {
    event.preventDefault();
    let cityname = document.getElementById("cityName").value;
    let url = "http://localhost:8080/weather/get/five/day/weather/data";
    let xhtr = new XMLHttpRequest();
    xhtr.open("POST", url, true);
    xhtr.setRequestHeader("Content-Type", "application/json");
    xhtr.onreadystatechange = function () {
        if (xhtr.readyState === 4) {
            if (xhtr.status === 200) {
                console.log("Data successfully received from the server...");
                console.log(JSON.parse(xhtr.responseText));
                let responseObj = JSON.parse(xhtr.responseText);
                let demoObj = document.getElementById("demo");

                //show time and data
                let showTimeDateHtmEle = document.getElementById("show-time-date");
                showTimeDateHtmEle.style.backgroundColor = "#0e78cf";
                showTimeDateHtmEle.style.color = "white";
                showTimeDateHtmEle.innerHTML = getCurrentTime() + " || " + getDateAndWeek();
                ;
                //Today sunrise time
                let sunriseTimeHtmEle = document.getElementById("sunriseTime");
                let sunriseTime = responseObj[0].dailyForecastSunrise;
                console.log("sunrise time is: ", sunriseTime);
                sunriseTimeHtmEle.innerHTML = timeSplit(sunriseTime);

                //Today sunset time
                let sunsetTimeHtmEle = document.getElementById("sunsetTime");
                let sunsetTime = responseObj[0].dailyForecastSunset;
                console.log("sunset time is: ", sunsetTime);
                sunsetTimeHtmEle.innerHTML = timeSplit(sunsetTime);

                //Today moonrise time
                let moonriseTimeHtmEle = document.getElementById("moonriseTime");
                let moonriseTime = responseObj[0].dailyForecastMoonrise;
                console.log("moonrise time is: ", moonriseTime);
                moonriseTimeHtmEle.innerHTML = timeSplit(moonriseTime);

                //Today moonrise time
                let moonsetTimeHtmEle = document.getElementById("moonsetTime");
                let moonsetTime = responseObj[0].dailyForecastMoonset;
                console.log("moonset time is: ", moonsetTime);
                moonsetTimeHtmEle.innerHTML = timeSplit(moonsetTime);

                //oneday temperature showcase
                let tempHtmEle = document.getElementById("one-day-temp");
                let celMaxTemp = farenheitToCelcius(responseObj[0].maxTemp);
                let CelMinTemp = farenheitToCelcius(responseObj[0].minTemp);
                let realFealCelMaxTemp = farenheitToCelcius(responseObj[0].realFeelMaxTemp);

                //today real feal temperature
                tempHtmEle.innerHTML = celMaxTemp + "&deg;C/ " + CelMinTemp + "&deg;C ";
                let maxTempHtmEle = document.getElementById("real-feal-maxTemp");
                maxTempHtmEle.innerHTML = "RealFeal: " + realFealCelMaxTemp + "&deg;C ";

                //today real feal temp phrase
                let realFealMaxTempPhraseHtmEle = document.getElementById("real-feal-maxTemp-phrase");
                let realFealPhrase = responseObj[0].realFeelMaxTempPhrase;
                realFealMaxTempPhraseHtmEle.innerHTML = "Feals like " + "<i>" + realFealPhrase + "</i>";

                //today air quality data
                let airqualityHtmEle = document.getElementById("airQuality");
                let airQualityPhrase = responseObj[0].airPolutionCategory;
                airqualityHtmEle.innerHTML = "Air Quality: " + airQualityPhrase;

                //today wind speed according to the time
                let WindHtmEle = document.getElementById("windSpeed");

                let dayWindSpeed = responseObj[0].dayWindSpeed;
                let dayWindSpeedUnit = responseObj[0].dayWindSpeedUnit;
                let dayWindSpeedDirection = responseObj[0].dayWindSpeedDirection;
                let dayWindSpeedDegree = responseObj[0].dayWindSpeedDegree;
                console.log("Day Wind Data: ", dayWindSpeed, dayWindSpeedUnit, dayWindSpeedDirection, dayWindSpeedDegree);
                //tonight wind speed
                let nightWindSpeed = responseObj[0].nightWindSpeed;
                let nightWindSpeedUnit = responseObj[0].nightWindSpeedUnit;
                let nightWindSpeedDirection = responseObj[0].nightWindSpeedDirection;
                let nightWindSpeedDegree = responseObj[0].nightWindSpeedDegree;
                console.log("Night Wind Data: ", nightWindSpeed, nightWindSpeedUnit, nightWindSpeedDirection, nightWindSpeedDegree);
                var now = new Date();
                var hours = now.getHours();
                console.log("My created hours: " + hours);
                if (hours >= 18 || hours <= 6) {
                    WindHtmEle.innerHTML = nightWindSpeed + nightWindSpeedUnit + " " + nightWindSpeedDirection + " " + nightWindSpeedDegree + "&deg;";
                } else {
                    WindHtmEle.innerHTML = dayWindSpeed + dayWindSpeedUnit + " " + dayWindSpeedDirection + " " + dayWindSpeedDegree + "&deg;";
                }

                let humidityHtmEle = document.getElementById("humidity");
                let dayHumidity = responseObj[0].dayRelativeHumbidityAvg;
                let nightHumidity = responseObj[0].nightRelativeHumbidityAvg;
                console.log("day humidity: " + dayHumidity + "night humidity: " + nightHumidity);
                if (hours >= 18 || hours <= 6) {
                    humidityHtmEle.innerHTML = nightHumidity;
                } else {
                    humidityHtmEle.innerHTML = dayHumidity;
                }

                //solar iradiance 

                let solarIradianceHtmEle = document.getElementById("solarIridiance");
                let daySolarIrradianceValue = responseObj[0].daySolarIrradianceValue;
                let daySolarIrradianceUnit = responseObj[0].daySolarIrradianceUnit;
                solarIradianceHtmEle.innerHTML = "Solar Irradiance: " + daySolarIrradianceValue + daySolarIrradianceUnit;

                //After that spinner set to none
                document.getElementById("Loading-spinner").style.display = "none";
                document.getElementById("weather-card-01").style.display = "block";
                document.getElementById("weather-card-02").style.display = "block";


                //Five day weather data showcase... 
                document.getElementById("dateAndWeek1").innerHTML = getNextFourDayDateAndWeek(1);
                document.getElementById("dateAndWeek2").innerHTML = getNextFourDayDateAndWeek(2);
                document.getElementById("dateAndWeek3").innerHTML = getNextFourDayDateAndWeek(3);
                document.getElementById("dateAndWeek4").innerHTML = getNextFourDayDateAndWeek(4);


                let daySecondHtmEle = document.getElementById("day2");
                let dayThirdHtmEle = document.getElementById("day3");
                let dayFourthHtmEle = document.getElementById("day4");
                let dayFifthHtmEle = document.getElementById("day5");
                let weatherDivArr = [daySecondHtmEle, dayThirdHtmEle, dayFourthHtmEle, dayFifthHtmEle];

                let nightSecondHtmEle = document.getElementById("night2");
                let nightThirdHtmEle = document.getElementById("night3");
                let nightFourthHtmEle = document.getElementById("night4");
                let nightFifthHtmEle = document.getElementById("night5");
                let weatherDivArr2 = [nightSecondHtmEle, nightThirdHtmEle, nightFourthHtmEle, nightFifthHtmEle];

                // Loop through the div elements and clear day icon content
                for (let i = 0; i < weatherDivArr.length; i++) {
                    weatherDivArr[i].innerHTML = "";
                }

                // Loop through the div elements and clear night icon content
                for (let i = 0; i < weatherDivArr2.length; i++) {
                    weatherDivArr2[i].innerHTML = "";
                }
                let temp = 0;
                //changing weather icon based on phrase
                for (let ele = 1; ele < responseObj.length; ele++) {
                    console.log("Inside loop code executed...");
                    let dayIconPhrase = responseObj[ele].dayIconPhrase;
                    let nightIconPhrase = responseObj[ele].nightIconPhrase;
                    if (dayIconPhrase.includes("Sun") || dayIconPhrase.includes("sun")) {
                        let sunnyImg = document.createElement("img");
                        sunnyImg.id = "sunnyImgShowcase";
                        sunnyImg.src = "images/sun-01.svg";
                        sunnyImg.alt = "sunnyDay";
                        sunnyImg.style.height = "3rem";
                        sunnyImg.style.width = "3rem";
                        sunnyImg.style.marginTop = "1rem";
                        weatherDivArr[temp].appendChild(sunnyImg);
                    }
                    else if (dayIconPhrase.includes("Cloud") || dayIconPhrase.includes("cloud")) {
                        let cloudImg = document.createElement("img");
                        cloudImg.id = "cloudImgShowcase";
                        cloudImg.src = "weatherIcons/cloudy.png";
                        cloudImg.alt = "cloudy";
                        cloudImg.style.height = "3rem";
                        cloudImg.style.width = "3rem";
                        cloudImg.style.marginTop = "1rem";
                        weatherDivArr[temp].appendChild(cloudImg);
                    }
                    else if (dayIconPhrase.includes("Showers") || dayIconPhrase.includes("showers")
                        || dayIconPhrase.includes("Rain") || dayIconPhrase.includes("rain")) {
                        let rainImg = document.createElement("img");
                        rainImg.id = "rainImgShowcase";
                        rainImg.src = "weatherIcons/heavy-rain.png";
                        rainImg.alt = "rainy";
                        rainImg.style.height = "3rem";
                        rainImg.style.width = "3rem";
                        rainImg.style.marginTop = "1rem";
                        weatherDivArr[temp].appendChild(rainImg);
                    }
                    else if (dayIconPhrase.includes("snow") || dayIconPhrase.includes("Snow")) {
                        let snowImg = document.createElement("img");
                        snowImg.id = "snowImgShowcase";
                        snowImg.src = "weatherIcons/snow.png";
                        snowImg.alt = "snow";
                        snowImg.style.height = "3rem";
                        snowImg.style.width = "3rem";
                        snowImg.style.marginTop = "1rem";
                        weatherDivArr[temp].appendChild(snowImg);
                    }
                    else {
                        let thunderstormImg = document.createElement("img");
                        thunderstormImg.id = "thunderstormImgShowcase";
                        thunderstormImg.src = "images/thunderstorm.png";
                        thunderstormImg.alt = "thunderstorm";
                        thunderstormImg.style.height = "3rem";
                        thunderstormImg.style.width = "3rem";
                        thunderstormImg.style.marginTop = "1rem";
                        weatherDivArr[temp].appendChild(thunderstormImg);
                    }
                    //night icon showcase
                    //keywords: Hazy Moonlight, clear, cloudy, showers, thunderstorm,snow
                    if (nightIconPhrase.includes("Moon") || nightIconPhrase.includes("moon")
                        || nightIconPhrase.includes("clear") || nightIconPhrase.includes("Clear")) {
                        let clearMoonImg = document.createElement("img");
                        clearMoonImg.id = "clearMonnImgShowcase";
                        clearMoonImg.src = "weatherIcons/clear-moon.svg";
                        clearMoonImg.alt = "clearMoon";
                        clearMoonImg.style.height = "4rem";
                        clearMoonImg.style.width = "4rem";
                        // clearMoonImg.style.marginTop = "1rem";
                        weatherDivArr2[temp].appendChild(clearMoonImg);
                    }
                    else if (nightIconPhrase.includes("cloud") || nightIconPhrase.includes("Cloud")) {
                        let cloudImg = document.createElement("img");
                        cloudImg.id = "nightCloudImgShowcase";
                        cloudImg.src = "weatherIcons/cloudy-moon.svg";
                        cloudImg.alt = "cloudy";
                        cloudImg.style.height = "4rem";
                        cloudImg.style.width = "4rem";
                        // cloudImg.style.marginTop = "1rem";
                        weatherDivArr2[temp].appendChild(cloudImg);
                    }
                    else if (nightIconPhrase.includes("Showers") || nightIconPhrase.includes("showers")
                        || nightIconPhrase.includes("Rain") || nightIconPhrase.includes("rain")) {
                        let rainImg = document.createElement("img");
                        rainImg.id = "nightrainImgShowcase";
                        rainImg.src = "weatherIcons/moon-rain.svg";
                        rainImg.alt = "rainy";
                        rainImg.style.height = "4rem";
                        rainImg.style.width = "4rem";
                        // rainImg.style.marginTop = "1rem";
                        weatherDivArr2[temp].appendChild(rainImg);
                    }
                    else if (nightIconPhrase.includes("snow") || nightIconPhrase.includes("Snow")) {
                        let snowImg = document.createElement("img");
                        snowImg.id = "snowImgShowcase";
                        snowImg.src = "weatherIcons/snow.png";
                        snowImg.alt = "snow";
                        snowImg.style.height = "3rem";
                        snowImg.style.width = "3rem";
                        // snowImg.style.marginTop = "1rem";
                        weatherDivArr2[temp].appendChild(snowImg);
                    }
                    else {
                        let thunderstormImg = document.createElement("img");
                        thunderstormImg.id = "thunderstormImgShowcase";
                        thunderstormImg.src = "weatherIcons/moon-thunderstorm.svg";
                        thunderstormImg.alt = "thunderstorm";
                        thunderstormImg.style.height = "4rem";
                        thunderstormImg.style.width = "4rem";
                        // thunderstormImg.style.marginTop = "1rem";
                        weatherDivArr2[temp].appendChild(thunderstormImg);
                    }


                    ++temp;
                }

                //printing 5day weather details 
                let day2Phrase = document.getElementById("day2-phrase");
                let day2Temp = document.getElementById("day2-temp");
                let day2Humidity = document.getElementById("day2-humidity");

                let day3Phrase = document.getElementById("day3-phrase");
                let day3Temp = document.getElementById("day3-temp");
                let day3Humidity = document.getElementById("day3-humidity");

                let day4Phrase = document.getElementById("day4-phrase");
                let day4Temp = document.getElementById("day4-temp");
                let day4Humidity = document.getElementById("day4-humidity");

                let day5Phrase = document.getElementById("day5-phrase");
                let day5Temp = document.getElementById("day5-temp");
                let day5Humidity = document.getElementById("day5-humidity");

                //night data printing

                let night2Phrase = document.getElementById("night2-phrase");
                let night2Humidity = document.getElementById("night2-humidity");
                let night2Windspeed = document.getElementById("night2-windspeed");


                let night3Phrase = document.getElementById("night3-phrase");
                let night3Humidity = document.getElementById("night3-humidity");
                let night3Windspeed = document.getElementById("night3-windspeed");


                let night4Phrase = document.getElementById("night4-phrase");
                let night4Humidity = document.getElementById("night4-humidity");
                let night4Windspeed = document.getElementById("night4-windspeed");


                let night5Phrase = document.getElementById("night5-phrase");
                let night5Humidity = document.getElementById("night5-humidity");
                let night5Windspeed = document.getElementById("night5-windspeed");


                for (let ele = 1; ele < responseObj.length; ele++) {
                    let dayIconPhrase = responseObj[ele].dayIconPhrase;
                    let dayMinTemp = responseObj[ele].minTemp;
                    let dayMaxTemp = responseObj[ele].maxTemp;
                    let dayRelativeHumidity = responseObj[ele].dayRelativeHumbidityAvg;

                    let nightIconPhrase = responseObj[ele].nightIconPhrase;
                    let nightWindspeed = responseObj[ele].nightWindSpeed;
                    let nightwindDegree = responseObj[ele].nightWindSpeedDegree;
                    let nightwindDirection = responseObj[ele].nightWindSpeedDirection;
                    let nightwindspeedUnit = responseObj[ele].nightWindSpeedUnit;
                    let nightRelativeHumidity = responseObj[ele].nightRelativeHumbidityAvg;
                    if (ele == 1) {
                        day2Phrase.innerHTML = dayIconPhrase;
                        day2Temp.innerHTML = "<b>Temp: </b>" + farenheitToCelcius(dayMaxTemp) + "&deg;C /" + farenheitToCelcius(dayMinTemp) + "&deg;C ";
                        day2Humidity.innerHTML = "<b>Humidity: </b>" + dayRelativeHumidity;

                        night2Phrase.innerHTML = nightIconPhrase;
                        night2Windspeed.innerHTML = "<b>Wind: </b>" + nightWindspeed + nightwindspeedUnit + " " + nightwindDirection + " " + nightwindDegree + "&deg;";
                        night2Humidity.innerHTML = "<b>Humidity: </b>" + nightRelativeHumidity;
                    }
                    else if (ele == 2) {
                        day3Phrase.innerHTML = dayIconPhrase;
                        day3Temp.innerHTML = "<b>Temp: </b>" + farenheitToCelcius(dayMaxTemp) + "&deg;C /" + farenheitToCelcius(dayMinTemp) + "&deg;C ";
                        day3Humidity.innerHTML = "<b>Humidity: </b>" + dayRelativeHumidity;

                        night3Phrase.innerHTML = nightIconPhrase;
                        night3Windspeed.innerHTML = "<b>Wind: </b>" + nightWindspeed + nightwindspeedUnit + " " + nightwindDirection + " " + nightwindDegree + "&deg; ";
                        night3Humidity.innerHTML = "<b>Humidity: </b>" + nightRelativeHumidity;
                    }
                    else if (ele == 3) {
                        day4Phrase.innerHTML = dayIconPhrase;
                        day4Temp.innerHTML = "<b>Temp: </b>" + farenheitToCelcius(dayMaxTemp) + "&deg;C /" + farenheitToCelcius(dayMinTemp) + "&deg;C ";
                        day4Humidity.innerHTML = "<b>Humidity: </b>" + dayRelativeHumidity;

                        night4Phrase.innerHTML = nightIconPhrase;
                        night4Windspeed.innerHTML = "<b>Wind: </b>" + nightWindspeed + nightwindspeedUnit + " " + nightwindDirection + " " + nightwindDegree + "&deg; ";
                        night4Humidity.innerHTML = "<b>Humidity: </b>" + nightRelativeHumidity;
                    }
                    else {
                        day5Phrase.innerHTML = dayIconPhrase;
                        day5Temp.innerHTML = "<b>Temp: </b>" + farenheitToCelcius(dayMaxTemp) + "&deg;C /" + farenheitToCelcius(dayMinTemp) + "&deg;C ";
                        day5Humidity.innerHTML = "<b>Humidity: </b>" + dayRelativeHumidity;

                        night5Phrase.innerHTML = nightIconPhrase;
                        night5Windspeed.innerHTML = "<b>Wind: </b>" + nightWindspeed + nightwindspeedUnit + " " + nightwindDirection + " " + nightwindDegree + "&deg; ";
                        night5Humidity.innerHTML = "<b>Humidity: </b>" + nightRelativeHumidity;
                    }
                }
                /*                 document.getElementById("five-day-card-1").style.display = "block"; 
                                document.getElementById("five-day-card-2").style.display = "block"; 
                                document.getElementById("five-day-card-3").style.display = "block"; 
                                document.getElementById("five-day-card-4").style.display = "block"; */

            } else {
                console.log("some Error happens at server level...");
            }
        }
    }
    xhtr.send(JSON.stringify({ city: cityname }));
});

function timeSplit(dateString) {
    var timeComponents = dateString.split('T')[1].split(':');

    var hours = timeComponents[0];
    var minutes = timeComponents[1];
    var secondsWithOffset = timeComponents[2];

    // Split seconds and remove timezone offset
    var seconds = secondsWithOffset.split(/[+-]/)[0];

    console.log(hours + '.' + minutes + '.' + seconds);
    var time = hours + '.' + minutes + '.' + seconds;
    let finalResult = convertTo12HourFormat(time);
    return finalResult;


}

function convertTo12HourFormat(time24) {
    var timeComponents = time24.split('.');
    var hours = parseInt(timeComponents[0], 10);
    var minutes = timeComponents[1];

    var ampm = hours >= 12 ? 'PM' : 'AM';

    // Convert hours to 12-hour format
    hours = hours % 12;
    hours = hours === 0 ? 12 : hours;

    return hours + ':' + minutes + ' ' + ampm;
}

function farenheitToCelcius(temp) {
    let celVal = (temp - 32) * (5 / 9);
    console.log(celVal.toFixed(2));
    return celVal.toFixed(2);
}

function getCurrentTime() {
    var now = new Date();
    var hours = now.getHours();
    var minutes = now.getMinutes();
    var ampm = hours >= 12 ? 'PM' : 'AM';

    // Convert hours to 12-hour format
    hours = hours % 12;
    hours = hours ? hours : 12; // 0 should be displayed as 12 in 12-hour format

    // Add leading zero to minutes if needed
    minutes = minutes < 10 ? '0' + minutes : minutes;

    var currentTime = hours + ':' + minutes + ' ' + ampm;
    return currentTime;
}

function getDateAndWeek() {
    const days = ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'];

    const currentDate = new Date();

    const day = currentDate.getDate();

    // Get the current month (months are zero-based, so add 1)
    const month = currentDate.getMonth() + 1;

    // Get the current year
    const year = currentDate.getFullYear();

    // Get the current day of the week (0 = Sunday, 1 = Monday, ..., 6 = Saturday)
    const dayOfWeek = currentDate.getDay();

    console.log(`Current Date: ${year}-${month}-${day}`);
    console.log(`Day of the Week: ${days[dayOfWeek]}`);

    return days[dayOfWeek] + ", " + `${year}-${month}-${day}`;
}

function getNextFourDayDateAndWeek(i) {
    // Get the current date
    let currentDate = new Date();
/*     currentDate.setDate(27);
    currentDate.setFullYear(2024);
    currentDate.setMonth(1); */
    let dayName = null;
    let nextDate = null;
    // Calculate and display the next four days
    for (; i <= 4; i++) {
        // Calculate the next day by adding the current day with the loop counter
        nextDate = new Date(currentDate);
        nextDate.setDate(currentDate.getDate() + i);

        // Get the day name
        let daysOfWeek = ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'];
        dayName = daysOfWeek[nextDate.getDay()];
        break;
    }

    return `${nextDate.toDateString()}`;
}
