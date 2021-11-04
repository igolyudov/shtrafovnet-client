package ml.bigbrains.shtrafovnetclient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import ml.bigbrains.shtrafovnetclient.model.*;
import okhttp3.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Slf4j
public class ShtrafovnetApiClient {

    private String baseUrl = "https://api.b2b.shtrafovnet.ru/";
    private String secretKey;
    private String clientId;

    private static final ObjectMapper mapper = new ObjectMapper();
    private static final OkHttpClient client = new OkHttpClient();

    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    public LoginResponse postAccountLogin(LoginRequest request) {
        log.debug("post account login with request: {}",request);
        LoginResponse response = postRequest(request.getRequestUrl(), null, request, LoginResponse.class);
        return response;
    }

    public AccountResponse getAccount(String token, AccountRequest request)
    {
        log.debug("get accout details with request: {}",request);
        AccountResponse response = getRequest(request.getRequestUrl(), token, new HashMap<>(), AccountResponse.class);
        return response;
    }


    public CompaniesResponse getCompanies(String token, CompaniesRequest request)
    {
        log.debug("get account companies details with request: {}",request);
        CompaniesResponse response = getRequest(request.getRequestUrl(), token, new HashMap<>(), CompaniesResponse.class);
        return response;
    }


    public CarsResponse getCars(String token, CarsRequest request)
    {
        log.debug("get cars with request: {}",request);
        CarsResponse carsResponse = getRequest(request.getRequestUrl(),token, request.getParams(), CarsResponse.class);
        return carsResponse;
    }

    public AddCarResponse postAddCar(String token, AddCarRequest request)
    {
        log.debug("post add car with request: {}",request);
        AddCarResponse response = postRequest(request.getRequestUrl(), token, request, AddCarResponse.class);
        return response;
    }

    public DelCarsResponse postDelCars(String token, DelCarsRequest request)
    {
        log.debug("post del cars with request: {}",request);
        DelCarsResponse response = postRequest(request.getRequestUrl(), token, request, DelCarsResponse.class);
        return response;
    }

    public FinesResponse getFines(String token, FinesRequest request)
    {
        log.debug("get fines with request: {}",request);
        FinesResponse response = getRequest(request.getRequestUrl(), token, request.getParams(), FinesResponse.class);
        return response;
    }

    private <T> T getRequest(String url, String token, Map<String, String> params, Class<T> responseClass) {

        HttpUrl.Builder requestUrl = HttpUrl.parse(baseUrl+url).newBuilder();

        for(Map.Entry<String, String> param : params.entrySet()) {
            requestUrl.addQueryParameter(param.getKey(),param.getValue());
        }

        okhttp3.Request request = new Request.Builder()
                .url(requestUrl.build())
                .header("content-type","application/json")
                .header("accept","application/json")
                .header("Authorization","Bearer "+token)
                .build();
        log.debug("TOKEN: {}",token);
        log.debug("REQUEST: {}",request);
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful())
            {
                log.warn("Response is not success. Response code: {}",response.code());
            }
            return mapper.readValue(Objects.requireNonNull(response.body()).string(), responseClass);
        }
        catch (NullPointerException e)
        {
            log.error("Empty response body after request to {}",url);
            return null;
        }
        catch (IOException e)
        {
            log.error("Error in getRequest to {}",url,e);
            return null;
        }
    }

    private <T> T postRequest(String url, String token, Object requestObject, Class<T> responseClass) {

        String strRequest = "";
        try {
            strRequest = mapper.writeValueAsString(requestObject);
        }
        catch (JsonProcessingException e)
        {
            log.error("Error in convert request object to JSON",e);
        }

        Request.Builder urlBuilder = new Request.Builder()
                                                .url(baseUrl + url)
                                                .header("Content-Type", "application/json");

        if(token!=null && !token.isEmpty() && !token.trim().equals(""))
            urlBuilder.header("Authorization","Bearer "+token);

        RequestBody formBody  = RequestBody.create(strRequest, JSON);
        okhttp3.Request request = urlBuilder.post(formBody).build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful())
            {
                log.warn("Response is not success. Response code: {}",response.code());
            }
            if(response.body()!=null)
                return mapper.readValue(response.body().string(), responseClass);
            else
            {
                log.error("Empty response body after request to {}",url);
                return null;
            }
        }
        catch (IOException e)
        {
            log.error("Error in postRequest to {}",url,e);
            return null;
        }
    }

}
