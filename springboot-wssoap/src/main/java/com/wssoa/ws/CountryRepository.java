package com.wssoa.ws;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.wssoa.ws.impl.Country;
import com.wssoa.ws.impl.Currency;

@Component
public class CountryRepository {
	private static final List<Country> countries = new ArrayList<Country>();

	@PostConstruct
	public void initData() {
		Country spain = new Country();
		spain.setName("Spain");
		spain.setCapital("Madrid");
		spain.setCurrency(Currency.EUR);
		spain.setPopulation(46704314);

		countries.add(spain);

		Country poland = new Country();
		poland.setName("Poland");
		poland.setCapital("Warsaw");
		poland.setCurrency(Currency.PLN);
		poland.setPopulation(38186860);

		countries.add(poland);

		Country uk = new Country();
		uk.setName("United Kingdom");
		uk.setCapital("London");
		uk.setCurrency(Currency.GBP);
		uk.setPopulation(63705000);

		countries.add(uk);
		
		Country usa = new Country();
		usa.setName("USA");
		usa.setCapital("Washington");
		usa.setCurrency(Currency.DLS);
		usa.setPopulation(350000000);

		countries.add(usa);
		
		Country mex = new Country();
		mex.setName("Mexico");
		mex.setCapital("Mexico");
		mex.setCurrency(Currency.MXN);
		mex.setPopulation(122000000);

		countries.add(mex);
	}

	public Country findCountry(String name) {
		Assert.notNull(name, "");

		Country result = null;

		for (Country country : countries) {
			if (name.equals(country.getName())) {
				result = country;
			}
		}

		return result;
	}
}
