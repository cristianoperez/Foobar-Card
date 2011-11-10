jQuery(function($){
	$.mask.definitions['~']='[123]';
	$.mask.definitions['=']='[123456789]';  
	$(".data").mask("~=/99");
	$(".real").maskMoney({decimal:".", thousands:","});
});