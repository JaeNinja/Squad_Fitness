function Background_Change(){
	var time = newDate().getHours();
	if(time < 15){
		document.body.style.background = " url('https://c2.staticflickr.com/8/7007/6435783981_c24f8bd9ca_z.jpg') no-repeat";
	} else if( time <= 20){
		document.body.style.background = " url('http://cdn.instructables.com/FL8/HWSO/G3KY0MA6/FL8HWSOG3KY0MA6.LARGE.jpg') no-repeat";
	} else{
		document.body.style.background = " url('http://cdn.instructables.com/FL8/HWSO/G3KY0MA6/FL8HWSOG3KY0MA6.LARGE.jpg') no-repeat";
	}
	
	
}
