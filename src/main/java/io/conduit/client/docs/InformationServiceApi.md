# InformationServiceApi

All URIs are relative to *https://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**informationServiceGetInfo**](InformationServiceApi.md#informationServiceGetInfo) | **GET** /info | 


<a name="informationServiceGetInfo"></a>
# **informationServiceGetInfo**
> Apiv1Info informationServiceGetInfo()



### Example
```java
// Import classes:
//import io.conduit.client.ApiException;
//import io.conduit.client.api.InformationServiceApi;


InformationServiceApi apiInstance = new InformationServiceApi();
try {
    Apiv1Info result = apiInstance.informationServiceGetInfo();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling InformationServiceApi#informationServiceGetInfo");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**Apiv1Info**](Apiv1Info.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

