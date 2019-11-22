"use strict"
var app = app || {}
app = (()=>{
	let _, js
	let init=()=>{
		_ = $.ctx()
		js = $.js()
	}
	let run=x=>{
		$.getScript(x+'/resources/js/cmm/router.js', ()=>{
			$.extend(new Session(x))
			alert('떠라')
			onCreate()
		})
	}

	let onCreate=()=>{
		setContentView()
	}
	let setContentView=()=>{
		$('<table id="tab"><tr></tr></table>')
		.css({  width: '80%',
            height: '800px',
            border: '1px solid black',
            margin: '0 auto'})
        .appendTo('#wrapper')
        $('<td/>', {id : "left"})
        .css({  width: '20%',
            height: '100%',
            border: '1px solid black',
            'vertical-align': 'top'})
        .appendTo('tr')
        $('<td/>', {id : "right"})
        .css({width: '80%',
            height: '100%',
            border: '1px solid black'})
		.appendTo('tr')
		$.each(['NAVER', 'CGV', 'BUGS'], (i,j)=>{
			 $('<div/>')
			    .text(j)
		        .css({
						width: '100%',
			            height: '50px',
			            border: '1px solid black',
			            'text-align' : 'center' 
					}).appendTo('#left')	
				.click(function(){
					$(this).css({'background-color' : 'yellow'})
					$(this).siblings().css({'background-color' : 'white'})
					_ = $.ctx()
				switch($(this).text()){
				case 'NAVER' : 
					$.getJSON(_+'/crawls/naver', d=>{				
						$.each(d,(i,j)=>{
							$('<div/>')
							.css({
								width: '40%',
					            height: '40%',
					            border: '3px solid red',       
					            float: 'left'})
					            .html('<h1>'+j.origin+'</h1><h4>'+j.trans+'</h4>')
					            .appendTo('#right')	
						})
					})
					break;
				case 'CGV' : 	
					$.getJSON(_+'/crawls/cgv', d=>{
						$('#right').empty()
							$.each(d,(i,j)=>{
								$('<div><img style="width:200px;" src="'+j.photo+'"><h3>'+j.title+'</h3><h4>'+j.precent+'</h4><h4>'+j.textinfo+'</h4></div>')  //
								.css({
						            border: '3px solid red',       
						            float: 'left'})
						        .appendTo('#right')
							})	
						

					})
					break;
				case 'BUGS' : 
					$.getJSON(_+'/crawls/bugs', d=>{})
					break;
				}
					
				})
		})
       
	}
	return{run}
})()