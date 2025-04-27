<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script src="https://checkout.razorpay.com/v1/checkout.js"></script>
<script>
let xhttp=new XMLHttpRequest();
let RazorpayOrderId;
let url;
let key="<%= Dotenv.configure().load().get("API_KEY_ID") %>";
function CreateOrderId(nameReceived,emailReceived,mnoReceived){
	const production="https://razorpay-java-integration.herokuapp.com/OrderCreationDemo";
	const development="http://localhost:8081/RazorpayIntegration/OrderCreationDemo";
	let isProduction=<%= Dotenv.configure().load().get("ENV_TYPE") %>;
	url = (isProduction ? production : development);
	xhttp.open("GET",url,false);
	xhttp.send();
	RazorpayOrderId=xhttp.responseText;
	OpenCheckout(nameReceived,emailReceived,mnoReceived);
}

function OpenCheckout(nameReceived,emailReceived,mnoReceived){
	var options = {
    "key": key, // Enter the Key ID generated from the Dashboard
    "amount": "10000", // Amount is in currency subunits. Default currency is INR. Hence, 50000 refers to 50000 paise
    "currency": "INR",
    "name": "Acme Corp",
    "description": "Test Transaction",
    "image": "images/logo.jpg",
    "order_id": RazorpayOrderId, //This is a sample Order ID. Pass the `id` obtained in the response of Step 1
    "callback_url": url,
    "prefill": {
        "name": nameReceived,
        "email":emailReceived,
        "contact": mnoReceived
    },
    "notes": {
        "address": "Razorpay Corporate Office"
    },
    "theme": {
        "color": "#3399cc"
    }
   };
var rzp1 = new Razorpay(options);

    
rzp1.on('payment.failed', function (response){
    alert(response.error.code);
    alert(response.error.description);
    alert(response.error.source);
    alert(response.error.step);
    alert(response.error.reason);
    alert(response.error.metadata.order_id);
    alert(response.error.metadata.payment_id);
    });
    rzp1.open();
    e.preventDefault();

}

</script>
<title>Razorpay Java Integration</title>
<link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.2/css/all.min.css">
    <style>
        *{
            box-sizing: border-box;
            font-family: 'Noto Sans', sans-serif;
        }
        body{
            background-color: #02042b;   
            display: flex;
            align-items: center;
            justify-content: center;
            margin: 0px;
            min-height: 100vh;
        }
        .container{
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.3);
            overflow: hidden;
            width: 50%;
            max-width: 100%;
            margin: 10px;
        }
        .header{
            background-color: #f7f7f7;
            border-bottom: 1px solid #f0f0f0;
            padding: 20px 40px;
        }
        .header h2{
            margin: 0;
        }
        .form{
            padding: 30px 40px;
        }
        .form-control{
            margin-bottom: 10px;
            padding-bottom: 20px;
            position: relative;
        }
        .form-control label{
            display: inline-block;
            margin-bottom: 5px;
        }
        .form-control input{
            border: 2px solid #f0f0f0;
            border-radius: 4px;
            display: block;
            font-size: 14px;
            width: 100%;
            padding:10px;
            font-family: inherit;
        }
        .form-control.success input{
            border-color: #2ecc71;
        }
        .form-control.error input{
            border-color: #e74c3c;
        }
        .form-control.success i.fa-check-circle{
            visibility: visible;
            color: #2ecc71;
        }
        .form-control.error i.fa-exclamation-circle{
            visibility: visible;
            color: #e74c3c;
        }
        .form-control.error small{
            color: #e74c3c;
            visibility: visible;
        }
        .form-control i{
            position: absolute;
            top: 40px;
            right: 10px;
            visibility: hidden;
        }
        .form-control small{
            position: absolute;
            bottom: 0;
            left: 0;
            visibility: hidden;
        }
        button{
            background-color:#2b84ea;
            border: 2px solid #2b84ea;
            border-radius: 50px;
            color: white;
            padding: 10px;
            font-family: inherit;
            font-size: 16px;
            width: 50%;
            margin-left: 25%;
        }
        button:hover{
           color:white;
           background:#2ecc71;
           border:2px solid #2ecc71;
           cursor:pointer;
        } 
      </style>
</head>
<body>
<div class="container">
        <div class="header">
            <h2>Make a payment of Rs.100</h2>
        </div>
        <form class="form" id="form" autocomplete="off">
            <div class="form-control">
                <label for="">Your Name</label>
                <input type="text" name="name" id="name" placeholder="Gaurav Kumar">
                <i class="fas fa-check-circle"></i>
                <i class="fas fa-exclamation-circle"></i>
                <small>Error Message</small>
            </div>
            <div class="form-control ">
                <label for="">Your Email</label>
                <input type="text" name="email" id="email" placeholder="gaurav.kumar@gmail.com">
                <i class="fas fa-check-circle"></i>
                <i class="fas fa-exclamation-circle"></i>
                <small>Error Message</small>
            </div>
             <div class="form-control">
                <label for="">Mobile Number</label>
                <input type="tel" name="mno" id="mno" placeholder="9999999999" onkeypress="return onlyNumberKey(event)" maxlength="10">
                <i class="fas fa-check-circle"></i>
                <i class="fas fa-exclamation-circle"></i>
                <small>Error Message</small>
            </div>
           <button onclick="checkInputs()">Proceed To Pay</button>
           </form>
    </div>
    <script>
        const form=document.getElementById('form');
        const name=document.getElementById('name');
        const email=document.getElementById('email');
        const mno=document.getElementById('mno');
        form.addEventListener('submit',(e) => {
            e.preventDefault();
       });
        function checkInputs(){
           const nameValue = name.value.trim();
           const emailValue = email.value.trim();
           const mnoValue = mno.value.trim();         
          
           if(nameValue === ''){
               setErrorFor(name,'Name cannot be empty!');
           }else{
              setSuccessFor(name);
           }
           if(emailValue === ''){
               setErrorFor(email,'Email cannot be empty!');
           }else if(!isEmail(emailValue)){
            setErrorFor(email,'Email is not valid!');
           }
           else{
              setSuccessFor(email);
           }
           if(mnoValue === ''){
               setErrorFor(mno,'Mobile Number cannot be empty!');
           }else{
              setSuccessFor(mno);
           }
          
          doSubmit();
        }
        function setErrorFor(input,message){
            const formControl=input.parentElement;
            const small=formControl.querySelector('small');
            small.innerText=message;
            formControl.className='form-control error';
        }
        function setSuccessFor(input){
            const formControl=input.parentElement;
            formControl.className='form-control success';
        }
        function isEmail(email){
            return /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/.test(email);
        }
        function onlyNumberKey(evt) {
         var ASCIICode = (evt.which) ? evt.which : evt.keyCode
         if (ASCIICode > 31 && (ASCIICode < 48 || ASCIICode > 57))
             return false;
         return true;
     }
      
     function doSubmit(){
    	 const nameValue = name.value.trim();
         const emailValue = email.value.trim();
         const mnoValue = mno.value.trim();
         
    	 if((nameValue !=='') && (emailValue !=='') && (mnoValue !=='') && isEmail(emailValue)){
    		 CreateOrderId(nameValue,emailValue,mnoValue);
           }
    	 else{
    		 alert('Form cannot be submitted.\nPlease check your details again.');
    	 }
     }
    </script>
</body>
</html>

<%@ page import="io.github.cdimascio.dotenv.Dotenv"%>