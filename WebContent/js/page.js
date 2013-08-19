$(document).ready(function () { 
	function getRow(key, value) {
		return "<tr><td>" + key + "</td><td>" + value + "</td></tr>";
	}
	
	setInterval(function() {
		var loading = $("#loading-div");
		loading.removeClass("hidden");
		loading.addClass('hidden');

		$.ajax({
			url: "se",
			type: "GET",
			contentType: "application/json; charset=utf-8",
			dataType: "json",
			success: function(data){
				var items = [];
				items.push("<table>");
				items.push(getRow("Päringu id:", data.number));
				if(data.enabled == true) {
					if(data.active == "A") {
					items.push(getRow("Telefon: ", data.phoneNumber));
					items.push(getRow("Keel: ", (data.language == "I" ? "Inglise": "Eesti")));
					var date = data.serviceEndDate + data.serviceEndTime;
					var match = /([0-9]{4})([0-9]{2})([0-9]{2})([0-9]{2})([0-9]{2})/.exec(date);
					var realDate = new Date();
					realDate.setYear(match[1]);
					realDate.setMonth(match[2]);
					realDate.setDate(match[3]);
					realDate.setHours(match[4]);
					realDate.setMinutes(match[5]);
					items.push(getRow("Teenuse lõppkuupäev: ", realDate.toString('dd M yyyy hh:mm'))); //TODO: here need some library for date format.
					items.push(getRow("Teenuse lõpetamise aeg: ", data.serviceEndTime));
					items.push(getRow("Lisateenuse keel: ", (data.additionalServiceLanguage == "I" ? "Inglise": "Eesti")));
					items.push(getRow("Aktiivse teenuse algne aeg: ", data.serviceActivationStartTime));
					items.push(getRow("Aktiivse teenuse lõpp aeg: ", data.serviceActivationEndTime));

					if(data.list == "K") {
						items.push("<tr><td><table><tr><th>Telefon</th><th>Nimi</th></tr>");
						$.each(data.phoneNumbers, function(index, value) {
							if ($.trim(value).length > 0) { // do not add text with all spaces
								items.push(getRow(value, data.names[index]));
							}
						});
						items.push("</table></td><td></td></tr>");
					}
					} else {
						items.push(getRow("Teenus pole aktiivne", ""));
					}
				items.push("</table>");
				} else {
					items.push(getRow("Teenus pole kättesaadav", ""));
				}
				$("#con-result").html(items.join("")); 
			},
			error:function(xhr, textStatus, errorThrown){
				$("#con-result").html('Ei saanud uued andmeid katte.');
			}   
		});
	}, 1000);
}); 