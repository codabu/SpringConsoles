package dmacc.beans;

import java.text.NumberFormat;
import java.util.Locale;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Entity @NoArgsConstructor
public class Console {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String make;
	private String model;
	private Double price;
	
	public Console (String make, String model, double price) {
		this.make = make;
		this.model = model;
		this.price = price;
	}
	
	public String formatCurrency (){
		String out;
		
		Locale usa = new Locale("en", "US");
		NumberFormat dollarFormat = NumberFormat.getCurrencyInstance(usa);
		out = dollarFormat.format(price);
		
		return out;
	}
}
