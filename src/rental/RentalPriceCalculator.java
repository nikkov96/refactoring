package rental;

public class RentalPriceCalculator {
	
	// driverAge - age of driver
	// licenceHoldingYears - number of full years person holds driving licence
	// carClass - class of the car from 1 (smallest) to 5 (largest) that person wishes to rent
	// hadAccidents - has s/he caused any accidents within last year
	// isHighSeason - if it is high season or not
	public double price(int driverAge, int licenceHoldingYears, int carClass, boolean hadAccidents, boolean isHighSeason) {
		
		if (driverAge < 18) {
			throw new IllegalArgumentException("Driver too young - cannot quote the price");
		}
		if (driverAge <= 21 && carClass > 2) {
			throw new UnsupportedOperationException("Drivers 21 y/o or less can only rent Class 1 vehicles");
		}
		
		double rentalPrice = driverAge;
		
		if (carClass >=4 && driverAge <= 25 && isHighSeason != false) {
			rentalprice = rentalPrice * 1.5 ;
		}
		
		if (licenceHoldingYears < 1) {
			throw new IllegalArgumentException("Driver must hold driving licence at least for one year. Can not rent a car!");
		}
		
		if (licenceHoldingYears < 3) {
			rentalPrice = rentalPrice * 1.3;
		}
		
		if (hadAccidents == true &&  < 30) {
			rentalPrice += 15;
		}

		if (rentalPrice > 1000) {
			return 1000.00;
		}
		return rentalPrice;
	}
	public boolean validAge(int age) {
		if (age < 18) {
			throw new IllegalArgumentException("Driver too young - cannot quote the price");
		}
		return true
	}
	
	public boolean canDriveCar(int age, int carClass) {
		if (carClass > 2) {
			if (age <= 21) {
				throw new UnsupportedOperationException("Drivers 21 y/o or less can only rent Class 1 vehicles");
			}
		} else {
			return validAge(age);
		}
	}
	public double calcRentalPrice(int age, int carClass, boolean isHighSeason, int licenseHoldingYears, boolean hasAccidents) {
		double rentalPrice = age;
		if (carClass >=4 && driverAge <= 25 && isHighSeason != false) {
			return (rentalPrice * 1.5 * addRentalPriceAccordingToYears(licenseHoldingYears)) + RentalPriceAdditionAccordingAccidents(hasAccidents);	
		}
		
		return (rentalPrice * addRentalPriceAccordingToYears(licenseHoldingYears)) + RentalPriceAdditionAccordingAccidents(hasAccidents);
	}
	
	public double RentalPriceMultiplierAccordingToYears(int licenceHoldingYears) {
		if (licenceHoldingYears < 3) {
			return 1.3;
		}
		return 1.0;
	}
	
	public double RentalPriceAdditionAccordingAccidents(boolean hasAccidents) {
		if (hasAccidents) {
			return 15;
		}
		return 0;
	}
	
	public boolean isValidLicenceHoldingYears(int year) {
		if (year < 1) {
			throw new IllegalArgumentException("Driver must hold driving licence at least for one year. Can not rent a car!");
		}
		return true;
	}
}
