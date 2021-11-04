package ml.bigbrains.shtrafovnetclient;


import lombok.extern.slf4j.Slf4j;
import ml.bigbrains.shtrafovnetclient.model.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RunWith(JUnit4.class)
@Slf4j
public class ShatafovnetClientApplicationTests {

	private static final  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.S'Z'");

	@Test
	public void loadContext()
	{

	}

	@Test
	public void testLogin() throws IOException
	{
		LoginRequest request = new LoginRequest("***@yandex.ru","***",0);
		ShtrafovnetApiClient client = new ShtrafovnetApiClient();
		LoginResponse  resp = client.postAccountLogin(request);
		Assert.assertNotNull(resp);

		log.debug("RESP: {}",resp);
	}

	@Test
	public void testErrorLogin() throws IOException
	{
		LoginRequest request = new LoginRequest("***@yandex.ru","***",0);
		ShtrafovnetApiClient client = new ShtrafovnetApiClient();
		LoginResponse  resp = client.postAccountLogin(request);
		Assert.assertNotNull(resp);

		log.debug("RESP: {}",resp);
	}

	@Test
	public void testGetAccountDetails()
	{
		String token = "***";
		AccountRequest request = new AccountRequest();
		ShtrafovnetApiClient client = new ShtrafovnetApiClient();
		AccountResponse resp = client.getAccount(token,request);
		Assert.assertNotNull(resp);

		log.debug("RESP: {}",resp);

	}

	@Test
	public void testGetCompaniesDetails()
	{
		String token = "***";
		CompaniesRequest request = new CompaniesRequest();
		ShtrafovnetApiClient client = new ShtrafovnetApiClient();
		CompaniesResponse resp = client.getCompanies(token,request);
		Assert.assertNotNull(resp);

		log.debug("RESP: {}",resp);

	}


	@Test
	public void testGetCars()
	{
		String token = "***";
		Long accountId = 11L;
		CarsRequest request = new CarsRequest(accountId);

		int size = 0;
		int offset=0;
		ShtrafovnetApiClient client = new ShtrafovnetApiClient();
		do {
			request.setLimit(100);
			request.setOffset(offset);
			CarsResponse resp = client.getCars(token, request);
			Assert.assertNotNull(resp);
			size =  resp.getCars().size();
			log.debug("RESP: {}", resp);
			log.debug("SIZE: {}",size);
			offset+=100;
		}while (size>=100);

	}

	@Test
	public void testGetFines()
	{
		String token = "***";
		Long accountId = 11L;
		FinesRequest request = new FinesRequest(accountId);
		log.debug("Create start time: {}",LocalDateTime.now().minusDays(2).format(formatter));
		request.setCreateStarted(LocalDateTime.now().minusDays(2).format(formatter));
		int size = 0;
		int offset=0;
		ShtrafovnetApiClient client = new ShtrafovnetApiClient();
		do {
			request.setLimit(100);
			request.setOffset(offset);
			FinesResponse resp = client.getFines(token, request);
			Assert.assertNotNull(resp);
			size =  resp.getFines().size();
//			log.debug("RESP: {}", resp);
			log.debug("SIZE: {}",size);
			offset+=100;
		}while (size>=100);

	}
}
