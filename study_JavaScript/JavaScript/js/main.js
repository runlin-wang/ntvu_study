function sleep(millis) {
	const start = new Date().getTime();
	while (new Date().getTime() - start < millis){
		continue;
	};
}