package com.paypalexamples.test;




import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.paypal.examples.BaseClass;
import com.paypal.payment.pojo.Amount;
import com.paypal.payment.pojo.Details;
import com.paypal.payment.pojo.Item_List;
import com.paypal.payment.pojo.Items;
import com.paypal.payment.pojo.Payer;
import com.paypal.payment.pojo.Payment_Options;
import com.paypal.payment.pojo.PostObj;
import com.paypal.payment.pojo.Redirect_urls;
import com.paypal.payment.pojo.Shipping_address;
import com.paypal.payment.pojo.Transactions;



public class PostAsObject  extends BaseClass{

	
	
	@Test
	public void createAPayment() {
		
		Redirect_urls red_url= new Redirect_urls();
		red_url.setCancel_url("http://www.huwai.com");
		red_url.setReturn_url("http://www.amazon.com");
		
		
		Details details=new Details();
		details.setHandling_fee("1.00");
		details.setInsurance("0.01");
		details.setShipping("0.03");
		details.setShipping_discount("-1.00");
		details.setSubtotal("30.00");
		details.setTax("0.07");
		
		
		Amount amnt=new Amount();
		amnt.setCurrency("USD");
		amnt.setDetails(details);
		amnt.setTotal("30.01");
		
		Shipping_address sh_address= new Shipping_address();
		sh_address.setCity("Bangalore");
		sh_address.setCountry_code("IN");
		sh_address.setLine1("4thfloor");
		sh_address.setLine2("unit45");	
		sh_address.setPhone("26112454654646");
		sh_address.setPostal_code("951624");
		sh_address.setRecipient_name("PAB");
		sh_address.setState("KA");
		
	   Items items= new Items();
	   items.setCurrency("USD");
	   items.setDescription("Brown Color hat");
	   items.setName("hat");
	   items.setPrice("4");
	   items.setQuantity("5");
	   items.setSku("1");
	   items.setTax("0.01");
	   
	   Items items2= new Items();
	   items2.setCurrency("USD");
	   items2.setDescription("Brown Color Bag");
	   items2.setName("Bag");
	   items2.setPrice("4");
	   items2.setQuantity("5");
	   items2.setSku("1");
	   items2.setTax("0.01");
	   
	   List<Items> item= new ArrayList<Items>();
	    item.add(items);
	    item.add(items2);
	
	   
	   
	   Item_List item_list= new Item_List();
	   item_list.setItems(item);
		
	   Payment_Options pa_options= new Payment_Options();
	   pa_options.setAllowed_payment_method("INSTANT FINDING SOURCE");
	   
	   Transactions transc= new Transactions();
	   transc.setAmount(amnt);
	   transc.setCustom("EBAY_EMS_9456565635595");
	   transc.setDescription("Payment transcaton descrption");
	   transc.setInvoice_number("946464649861");
	   transc.setItem_list(item_list);
	   transc.setPayment_options(pa_options);
	   transc.setSoft_descriptor("ECHI45944645");
	   
	   
	   
	   List<Transactions> transcation= new ArrayList<Transactions>();
	   transcation.add(transc);
	   
	   Payer payer= new Payer();
	   payer.setPayment_method("paypal");
	   
	   PostObj postobject= new PostObj();
	   postobject.setIntent("sale");
	   postobject.setNote_to_payer("Contact us");
	   postobject.setRedirect_urls(red_url);
	   postobject.setPayer(payer);
	   postobject.setTransactions(transcation);
	   
		given()
		.contentType(ContentType.JSON)
		.auth()
		.oauth2(accesToken)
		.when()
		.body(postobject)
		.post("/payments/payment")
		.then()
		.log()
		.all();
		
	}	
}
