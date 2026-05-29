/**
 * 
 */

function invitation_filter(){
	var val = document.getElementById("invites").value;
	console.log("Select option is:"+val);
	
 switch(val){
	case "Republic Day Invitations":
		document.getElementById("republic_day_invite").style.display="block";
		document.getElementById("holi_invite").style.display="none";
		document.getElementById("ganesh_chaturthi_invite").style.display="none";
		document.getElementById("independence_day_invite").style.display="none";
		document.getElementById("navratri_invite").style.display="none";
		document.getElementById("birthday_invite").style.display="none";
		document.getElementById("diwali_invite").style.display="none";
		document.getElementById("marriage_invite").style.display="none";
		document.getElementById("makar_sankrant_invite").style.display="none";
		document.getElementById("anniversary_invite").style.display="none";
		document.getElementById("guddi_padwa_invite").style.display="none";
		document.getElementById("eid_invite").style.display="none";
		document.getElementById("baby_shower_invite").style.display="none";
	break;
	
	case "Independence Day Invitations":
		document.getElementById("independence_day_invite").style.display="block";
		document.getElementById("republic_day_invite").style.display="none";
		document.getElementById("holi_invite").style.display="none";
		document.getElementById("ganesh_chaturthi_invite").style.display="none";
		document.getElementById("navratri_invite").style.display="none";
		document.getElementById("birthday_invite").style.display="none";
		document.getElementById("diwali_invite").style.display="none";
		document.getElementById("marriage_invite").style.display="none";
		document.getElementById("makar_sankrant_invite").style.display="none";
		document.getElementById("anniversary_invite").style.display="none";
		document.getElementById("guddi_padwa_invite").style.display="none";
		document.getElementById("eid_invite").style.display="none";
		document.getElementById("baby_shower_invite").style.display="none";
	break;
	
	case "Ganesh Chatturthi Invitations":
		document.getElementById("ganesh_chaturthi_invite").style.display="block";
		document.getElementById("independence_day_invite").style.display="none";
		document.getElementById("republic_day_invite").style.display="none";
		document.getElementById("holi_invite").style.display="none";
		document.getElementById("navratri_invite").style.display="none";
		document.getElementById("birthday_invite").style.display="none";
		document.getElementById("diwali_invite").style.display="none";
		document.getElementById("marriage_invite").style.display="none";
		document.getElementById("makar_sankrant_invite").style.display="none";
		document.getElementById("anniversary_invite").style.display="none";
		document.getElementById("guddi_padwa_invite").style.display="none";
		document.getElementById("eid_invite").style.display="none";
		document.getElementById("baby_shower_invite").style.display="none";
	break;
	
	case "Guddi Padwa Invitations":
		document.getElementById("guddi_padwa_invite").style.display="block";
		document.getElementById("ganesh_chaturthi_invite").style.display="none";
		document.getElementById("independence_day_invite").style.display="none";
		document.getElementById("republic_day_invite").style.display="none";
		document.getElementById("holi_invite").style.display="none";
		document.getElementById("navratri_invite").style.display="none";
		document.getElementById("birthday_invite").style.display="none";
		document.getElementById("diwali_invite").style.display="none";
		document.getElementById("marriage_invite").style.display="none";
		document.getElementById("makar_sankrant_invite").style.display="none";
		document.getElementById("anniversary_invite").style.display="none";
		document.getElementById("eid_invite").style.display="none";
		document.getElementById("baby_shower_invite").style.display="none";	
	break;
	
	case "Anniversary Invitations":
		document.getElementById("anniversary_invite").style.display="block";
		document.getElementById("guddi_padwa_invite").style.display="none";
		document.getElementById("ganesh_chaturthi_invite").style.display="none";
		document.getElementById("independence_day_invite").style.display="none";
		document.getElementById("republic_day_invite").style.display="none";
		document.getElementById("holi_invite").style.display="none";
		document.getElementById("navratri_invite").style.display="none";
		document.getElementById("birthday_invite").style.display="none";
		document.getElementById("diwali_invite").style.display="none";
		document.getElementById("marriage_invite").style.display="none";
		document.getElementById("makar_sankrant_invite").style.display="none";
		document.getElementById("eid_invite").style.display="none";
		document.getElementById("baby_shower_invite").style.display="none";	
	break;
	
	case "Marriage Invitations":
		document.getElementById("marriage_invite").style.display="block";
		document.getElementById("anniversary_invite").style.display="none";
		document.getElementById("guddi_padwa_invite").style.display="none";
		document.getElementById("ganesh_chaturthi_invite").style.display="none";
		document.getElementById("independence_day_invite").style.display="none";
		document.getElementById("republic_day_invite").style.display="none";
		document.getElementById("holi_invite").style.display="none";
		document.getElementById("navratri_invite").style.display="none";
		document.getElementById("birthday_invite").style.display="none";
		document.getElementById("diwali_invite").style.display="none";
		document.getElementById("makar_sankrant_invite").style.display="none";
		document.getElementById("eid_invite").style.display="none";
		document.getElementById("baby_shower_invite").style.display="none";	
	break;
	
	case "Makkar Sankrati Invitations":
		document.getElementById("makar_sankrant_invite").style.display="block";
		document.getElementById("marriage_invite").style.display="none";
		document.getElementById("anniversary_invite").style.display="none";
		document.getElementById("guddi_padwa_invite").style.display="none";
		document.getElementById("ganesh_chaturthi_invite").style.display="none";
		document.getElementById("independence_day_invite").style.display="none";
		document.getElementById("republic_day_invite").style.display="none";
		document.getElementById("holi_invite").style.display="none";
		document.getElementById("navratri_invite").style.display="none";
		document.getElementById("birthday_invite").style.display="none";
		document.getElementById("diwali_invite").style.display="none";
		document.getElementById("eid_invite").style.display="none";
		document.getElementById("baby_shower_invite").style.display="none";
	break;
	
	case "Diwali Invitations":
		document.getElementById("diwali_invite").style.display="block";
		document.getElementById("makar_sankrant_invite").style.display="none";
		document.getElementById("marriage_invite").style.display="none";
		document.getElementById("anniversary_invite").style.display="none";
		document.getElementById("guddi_padwa_invite").style.display="none";
		document.getElementById("ganesh_chaturthi_invite").style.display="none";
		document.getElementById("independence_day_invite").style.display="none";
		document.getElementById("republic_day_invite").style.display="none";
		document.getElementById("holi_invite").style.display="none";
		document.getElementById("navratri_invite").style.display="none";
		document.getElementById("birthday_invite").style.display="none";
		document.getElementById("eid_invite").style.display="none";
		document.getElementById("baby_shower_invite").style.display="none";	
	break;
	
	case "Birthday Invitations":
		document.getElementById("birthday_invite").style.display="block";
		document.getElementById("diwali_invite").style.display="none";
		document.getElementById("makar_sankrant_invite").style.display="none";
		document.getElementById("marriage_invite").style.display="none";
		document.getElementById("anniversary_invite").style.display="none";
		document.getElementById("guddi_padwa_invite").style.display="none";
		document.getElementById("ganesh_chaturthi_invite").style.display="none";
		document.getElementById("independence_day_invite").style.display="none";
		document.getElementById("republic_day_invite").style.display="none";
		document.getElementById("holi_invite").style.display="none";
		document.getElementById("navratri_invite").style.display="none";
		document.getElementById("eid_invite").style.display="none";
		document.getElementById("baby_shower_invite").style.display="none";	
	break;
	
	case "Navrattri Invitations":
		document.getElementById("navratri_invite").style.display="block";
		document.getElementById("birthday_invite").style.display="none";
		document.getElementById("diwali_invite").style.display="none";
		document.getElementById("makar_sankrant_invite").style.display="none";
		document.getElementById("marriage_invite").style.display="none";
		document.getElementById("anniversary_invite").style.display="none";
		document.getElementById("guddi_padwa_invite").style.display="none";
		document.getElementById("ganesh_chaturthi_invite").style.display="none";
		document.getElementById("independence_day_invite").style.display="none";
		document.getElementById("republic_day_invite").style.display="none";
		document.getElementById("holi_invite").style.display="none";
		document.getElementById("eid_invite").style.display="none";
		document.getElementById("baby_shower_invite").style.display="none";	
	break;
	
	case "Holi Invitations":
		document.getElementById("holi_invite").style.display="block";
		document.getElementById("navratri_invite").style.display="none";
		document.getElementById("birthday_invite").style.display="none";
		document.getElementById("diwali_invite").style.display="none";
		document.getElementById("makar_sankrant_invite").style.display="none";
		document.getElementById("marriage_invite").style.display="none";
		document.getElementById("anniversary_invite").style.display="none";
		document.getElementById("guddi_padwa_invite").style.display="none";
		document.getElementById("ganesh_chaturthi_invite").style.display="none";
		document.getElementById("independence_day_invite").style.display="none";
		document.getElementById("republic_day_invite").style.display="none";
		document.getElementById("eid_invite").style.display="none";
		document.getElementById("baby_shower_invite").style.display="none";	
	break;
	
	case "Baby Shower Invitations":
		document.getElementById("baby_shower_invite").style.display="block";	
		document.getElementById("holi_invite").style.display="none";
		document.getElementById("navratri_invite").style.display="none";
		document.getElementById("birthday_invite").style.display="none";
		document.getElementById("diwali_invite").style.display="none";
		document.getElementById("makar_sankrant_invite").style.display="none";
		document.getElementById("marriage_invite").style.display="none";
		document.getElementById("anniversary_invite").style.display="none";
		document.getElementById("guddi_padwa_invite").style.display="none";
		document.getElementById("ganesh_chaturthi_invite").style.display="none";
		document.getElementById("independence_day_invite").style.display="none";
		document.getElementById("republic_day_invite").style.display="none";
		document.getElementById("eid_invite").style.display="none";
	break;
	
	case "Eid Invitations":
		document.getElementById("eid_invite").style.display="block";
		document.getElementById("baby_shower_invite").style.display="none";	
		document.getElementById("holi_invite").style.display="none";
		document.getElementById("navratri_invite").style.display="none";
		document.getElementById("birthday_invite").style.display="none";
		document.getElementById("diwali_invite").style.display="none";
		document.getElementById("makar_sankrant_invite").style.display="none";
		document.getElementById("marriage_invite").style.display="none";
		document.getElementById("anniversary_invite").style.display="none";
		document.getElementById("guddi_padwa_invite").style.display="none";
		document.getElementById("ganesh_chaturthi_invite").style.display="none";
		document.getElementById("independence_day_invite").style.display="none";
		document.getElementById("republic_day_invite").style.display="none";
	break;
	
	case "Yoga Day Invitations":
		
	break;

	default:
	document.getElementById("republic_day_invite").style.display="block";
	document.getElementById("holi_invite").style.display="block";
	document.getElementById("ganesh_chaturthi_invite").style.display="block";
	document.getElementById("independence_day_invite").style.display="block";
	document.getElementById("navratri_invite").style.display="block";
	document.getElementById("birthday_invite").style.display="block";
	document.getElementById("diwali_invite").style.display="block";
	document.getElementById("marriage_invite").style.display="block";
	document.getElementById("makar_sankrant_invite").style.display="block";
	document.getElementById("anniversary_invite").style.display="block";
	document.getElementById("guddi_padwa_invite").style.display="block";
	document.getElementById("eid_invite").style.display="block";
	document.getElementById("baby_shower_invite").style.display="block";
   }	
}