/**
 * 
 */


function greeting_filter(){
	var val = document.getElementById("greeting").value;
	console.log("Select option is:"+val);
	switch(val){
	
	case "Republic Day Greetings":
  	  document.getElementById("republic_day").style.display = "block";
	  document.getElementById("babyshower").style.display = "none";
	  document.getElementById("holi").style.display = "none";
	  document.getElementById("ganesh_chatturthi").style.display = "none";
	  document.getElementById("independence_day").style.display = "none";
	  document.getElementById("navratri").style.display = "none";
	  document.getElementById("birthday").style.display = "none";
	  document.getElementById("diwali").style.display = "none";
	  document.getElementById("marriage").style.display = "none";
	  document.getElementById("makar_sankrant").style.display = "none";
	  document.getElementById("anniversary").style.display = "none";
	  document.getElementById("guddi_padwa").style.display = "none";
		document.getElementById("yoga").style.display="none";
	  document.getElementById("eid").style.display = "none";
	  
	  break;
	  
	case "Independence Day Greetings":
		document.getElementById("independence_day").style.display = "block";
	  	document.getElementById("republic_day").style.display = "none";
		document.getElementById("babyshower").style.display = "none";
		document.getElementById("holi").style.display = "none";
		document.getElementById("ganesh_chatturthi").style.display = "none";
		document.getElementById("navratri").style.display = "none";
		document.getElementById("birthday").style.display = "none";
		document.getElementById("diwali").style.display = "none";
		document.getElementById("marriage").style.display = "none";
		document.getElementById("makar_sankrant").style.display = "none";
		document.getElementById("anniversary").style.display = "none";
		document.getElementById("guddi_padwa").style.display = "none";
		document.getElementById("yoga").style.display="none";
		document.getElementById("eid").style.display = "none";  
	 break
	 
	case "Guddi Padwa Greetings":
		document.getElementById("guddi_padwa").style.display = "block";
		document.getElementById("independence_day").style.display = "none";
	  	document.getElementById("republic_day").style.display = "none";
		document.getElementById("babyshower").style.display = "none";
		document.getElementById("holi").style.display = "none";
		document.getElementById("ganesh_chatturthi").style.display = "none";
		document.getElementById("navratri").style.display = "none";
		document.getElementById("birthday").style.display = "none";
		document.getElementById("diwali").style.display = "none";
		document.getElementById("marriage").style.display = "none";
		document.getElementById("makar_sankrant").style.display = "none";
		document.getElementById("anniversary").style.display = "none";
		document.getElementById("yoga").style.display="none";
		document.getElementById("eid").style.display = "none";
	 break;
	  
	case "Anniversary Greetings":
		document.getElementById("anniversary").style.display = "block";
		document.getElementById("guddi_padwa").style.display = "none";
		document.getElementById("independence_day").style.display = "none";
	  	document.getElementById("republic_day").style.display = "none";
		document.getElementById("babyshower").style.display = "none";
		document.getElementById("holi").style.display = "none";
		document.getElementById("ganesh_chatturthi").style.display = "none";
		document.getElementById("navratri").style.display = "none";
		document.getElementById("birthday").style.display = "none";
		document.getElementById("diwali").style.display = "none";
		document.getElementById("marriage").style.display = "none";
		document.getElementById("makar_sankrant").style.display = "none";
		document.getElementById("yoga").style.display="none";
		document.getElementById("eid").style.display = "none";
	break;
	
	case "Marriage Greetings":
		document.getElementById("marriage").style.display = "block";
		document.getElementById("anniversary").style.display = "none";
		document.getElementById("guddi_padwa").style.display = "none";
		document.getElementById("independence_day").style.display = "none";
	  	document.getElementById("republic_day").style.display = "none";
		document.getElementById("babyshower").style.display = "none";
		document.getElementById("holi").style.display = "none";
		document.getElementById("ganesh_chatturthi").style.display = "none";
		document.getElementById("navratri").style.display = "none";
		document.getElementById("birthday").style.display = "none";
		document.getElementById("diwali").style.display = "none";
		document.getElementById("makar_sankrant").style.display = "none";
		document.getElementById("yoga").style.display="none";
		document.getElementById("eid").style.display = "none";
	break;
	
	case "Diwali Greetings":
		document.getElementById("diwali").style.display = "block";
		document.getElementById("marriage").style.display = "none";
		document.getElementById("anniversary").style.display = "none";
		document.getElementById("guddi_padwa").style.display = "none";
		document.getElementById("independence_day").style.display = "none";
	  	document.getElementById("republic_day").style.display = "none";
		document.getElementById("babyshower").style.display = "none";
		document.getElementById("holi").style.display = "none";
		document.getElementById("ganesh_chatturthi").style.display = "none";
		document.getElementById("navratri").style.display = "none";
		document.getElementById("birthday").style.display = "none";
		document.getElementById("makar_sankrant").style.display = "none";
		document.getElementById("yoga").style.display="none";
		document.getElementById("eid").style.display = "none";
	 break;
	 
	case "Birthday Greetings":
		document.getElementById("birthday").style.display = "block";
		document.getElementById("diwali").style.display = "none";
		document.getElementById("marriage").style.display = "none";
		document.getElementById("anniversary").style.display = "none";
		document.getElementById("guddi_padwa").style.display = "none";
		document.getElementById("independence_day").style.display = "none";
	  	document.getElementById("republic_day").style.display = "none";
		document.getElementById("babyshower").style.display = "none";
		document.getElementById("holi").style.display = "none";
		document.getElementById("ganesh_chatturthi").style.display = "none";
		document.getElementById("navratri").style.display = "none";
		document.getElementById("makar_sankrant").style.display = "none";
		document.getElementById("yoga").style.display="none";
		document.getElementById("eid").style.display = "none";
	break;
	
	case "Navrattri Greetings":
		document.getElementById("navratri").style.display = "block";
		document.getElementById("birthday").style.display = "none";
		document.getElementById("diwali").style.display = "none";
		document.getElementById("marriage").style.display = "none";
		document.getElementById("anniversary").style.display = "none";
		document.getElementById("guddi_padwa").style.display = "none";
		document.getElementById("independence_day").style.display = "none";
	  	document.getElementById("republic_day").style.display = "none";
		document.getElementById("babyshower").style.display = "none";
		document.getElementById("holi").style.display = "none";
		document.getElementById("ganesh_chatturthi").style.display = "none";
		document.getElementById("makar_sankrant").style.display = "none";
		document.getElementById("yoga").style.display="none";
		document.getElementById("eid").style.display = "none";		
	break;
	
	case "Holi Greetings":
		document.getElementById("holi").style.display = "block";
		document.getElementById("navratri").style.display = "none";
		document.getElementById("birthday").style.display = "none";
		document.getElementById("diwali").style.display = "none";
		document.getElementById("marriage").style.display = "none";
		document.getElementById("anniversary").style.display = "none";
		document.getElementById("guddi_padwa").style.display = "none";
		document.getElementById("independence_day").style.display = "none";
	  	document.getElementById("republic_day").style.display = "none";
		document.getElementById("babyshower").style.display = "none";
		document.getElementById("ganesh_chatturthi").style.display = "none";
		document.getElementById("makar_sankrant").style.display = "none";
		document.getElementById("yoga").style.display="none";
		document.getElementById("eid").style.display = "none";	
	break;
	
	case "Baby Shower Greetings":
		document.getElementById("babyshower").style.display = "block";
		document.getElementById("holi").style.display = "none";
		document.getElementById("navratri").style.display = "none";
		document.getElementById("birthday").style.display = "none";
		document.getElementById("diwali").style.display = "none";
		document.getElementById("marriage").style.display = "none";
		document.getElementById("anniversary").style.display = "none";
		document.getElementById("guddi_padwa").style.display = "none";
		document.getElementById("independence_day").style.display = "none";
	  	document.getElementById("republic_day").style.display = "none";
		document.getElementById("ganesh_chatturthi").style.display = "none";
		document.getElementById("makar_sankrant").style.display = "none";
		document.getElementById("yoga").style.display="none";
		document.getElementById("eid").style.display = "none";
	break;
	
	case "Eid Greetings":
		document.getElementById("eid").style.display = "block";
		document.getElementById("babyshower").style.display = "none";
		document.getElementById("holi").style.display = "none";
		document.getElementById("navratri").style.display = "none";
		document.getElementById("birthday").style.display = "none";
		document.getElementById("diwali").style.display = "none";
		document.getElementById("marriage").style.display = "none";
		document.getElementById("anniversary").style.display = "none";
		document.getElementById("guddi_padwa").style.display = "none";
		document.getElementById("independence_day").style.display = "none";
	  	document.getElementById("republic_day").style.display = "none";
		document.getElementById("ganesh_chatturthi").style.display = "none";
		document.getElementById("makar_sankrant").style.display = "none";
		document.getElementById("yoga").style.display="none";
	break;
	case "Makkar Sankrati Greetings":
		document.getElementById("makar_sankrant").style.display = "block";
		document.getElementById("eid").style.display = "none";
		document.getElementById("babyshower").style.display = "none";
		document.getElementById("holi").style.display = "none";
		document.getElementById("navratri").style.display = "none";
		document.getElementById("birthday").style.display = "none";
		document.getElementById("diwali").style.display = "none";
		document.getElementById("marriage").style.display = "none";
		document.getElementById("anniversary").style.display = "none";
		document.getElementById("guddi_padwa").style.display = "none";
		document.getElementById("independence_day").style.display = "none";
	  	document.getElementById("republic_day").style.display = "none";
		document.getElementById("ganesh_chatturthi").style.display = "none";
		document.getElementById("yoga").style.display="none";
		document.getElementById("eid").style.display = "none";
	break;
	
	case "Ganesh Chatturthi":
		document.getElementById("ganesh_chatturthi").style.display = "block";
		document.getElementById("makar_sankrant").style.display = "none";
		document.getElementById("eid").style.display = "none";
		document.getElementById("babyshower").style.display = "none";
		document.getElementById("holi").style.display = "none";
		document.getElementById("navratri").style.display = "none";
		document.getElementById("birthday").style.display = "none";
		document.getElementById("diwali").style.display = "none";
		document.getElementById("marriage").style.display = "none";
		document.getElementById("anniversary").style.display = "none";
		document.getElementById("guddi_padwa").style.display = "none";
		document.getElementById("independence_day").style.display = "none";
	  	document.getElementById("republic_day").style.display = "none";
		document.getElementById("yoga").style.display="none";
	  	document.getElementById("eid").style.display = "none";

	break;
	
	case "Yoga Day Greetings":
		document.getElementById("yoga").style.display="block";
		document.getElementById("ganesh_chatturthi").style.display = "none";
		document.getElementById("makar_sankrant").style.display = "none";
		document.getElementById("eid").style.display = "none";
		document.getElementById("babyshower").style.display = "none";
		document.getElementById("holi").style.display = "none";
		document.getElementById("navratri").style.display = "none";
		document.getElementById("birthday").style.display = "none";
		document.getElementById("diwali").style.display = "none";
		document.getElementById("marriage").style.display = "none";
		document.getElementById("anniversary").style.display = "none";
		document.getElementById("guddi_padwa").style.display = "none";
		document.getElementById("independence_day").style.display = "none";
	  	document.getElementById("republic_day").style.display = "none";
		document.getElementById("eid").style.display = "none";
	break;
	
	default:
	document.getElementById("birthday").style.display = "block";
	document.getElementById("diwali").style.display = "block";
	document.getElementById("marriage").style.display = "block";
	document.getElementById("anniversary").style.display = "block";
	document.getElementById("guddi_padwa").style.display = "block";
	document.getElementById("independence_day").style.display = "block";
  	document.getElementById("republic_day").style.display = "block";
	document.getElementById("babyshower").style.display = "block";
	document.getElementById("holi").style.display = "block";
	document.getElementById("ganesh_chatturthi").style.display = "block";
	document.getElementById("navratri").style.display = "block";
	document.getElementById("makar_sankrant").style.display = "block";
	document.getElementById("yoga").style.display="block";
	document.getElementById("eid").style.display = "block";
	
	}

}