# ProcessorServiceApi

All URIs are relative to *https://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**processorServiceCreateProcessor**](ProcessorServiceApi.md#processorServiceCreateProcessor) | **POST** /v1/processors | 
[**processorServiceDeleteProcessor**](ProcessorServiceApi.md#processorServiceDeleteProcessor) | **DELETE** /v1/processors/{id} | 
[**processorServiceGetProcessor**](ProcessorServiceApi.md#processorServiceGetProcessor) | **GET** /v1/processors/{id} | 
[**processorServiceInspectProcessorIn**](ProcessorServiceApi.md#processorServiceInspectProcessorIn) | **GET** /v1/processors/{id}/inspect-in | InspectProcessorIn streams records coming into the specified processor
[**processorServiceInspectProcessorOut**](ProcessorServiceApi.md#processorServiceInspectProcessorOut) | **GET** /v1/processors/{id}/inspect-out | InspectProcessorOut streams the output records from the specified processor
[**processorServiceListProcessorPlugins**](ProcessorServiceApi.md#processorServiceListProcessorPlugins) | **GET** /v1/processors/plugins | 
[**processorServiceListProcessors**](ProcessorServiceApi.md#processorServiceListProcessors) | **GET** /v1/processors | 
[**processorServiceUpdateProcessor**](ProcessorServiceApi.md#processorServiceUpdateProcessor) | **PUT** /v1/processors/{id} | 


<a name="processorServiceCreateProcessor"></a>
# **processorServiceCreateProcessor**
> V1Processor processorServiceCreateProcessor(body)



### Example
```java
// Import classes:
//import io.conduit.client.ApiException;
//import io.conduit.client.api.ProcessorServiceApi;


ProcessorServiceApi apiInstance = new ProcessorServiceApi();
V1CreateProcessorRequest body = new V1CreateProcessorRequest(); // V1CreateProcessorRequest | 
try {
    V1Processor result = apiInstance.processorServiceCreateProcessor(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProcessorServiceApi#processorServiceCreateProcessor");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**V1CreateProcessorRequest**](V1CreateProcessorRequest.md)|  |

### Return type

[**V1Processor**](V1Processor.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="processorServiceDeleteProcessor"></a>
# **processorServiceDeleteProcessor**
> V1DeleteProcessorResponse processorServiceDeleteProcessor(id)



### Example
```java
// Import classes:
//import io.conduit.client.ApiException;
//import io.conduit.client.api.ProcessorServiceApi;


ProcessorServiceApi apiInstance = new ProcessorServiceApi();
String id = "id_example"; // String | 
try {
    V1DeleteProcessorResponse result = apiInstance.processorServiceDeleteProcessor(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProcessorServiceApi#processorServiceDeleteProcessor");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  |

### Return type

[**V1DeleteProcessorResponse**](V1DeleteProcessorResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="processorServiceGetProcessor"></a>
# **processorServiceGetProcessor**
> V1Processor processorServiceGetProcessor(id)



### Example
```java
// Import classes:
//import io.conduit.client.ApiException;
//import io.conduit.client.api.ProcessorServiceApi;


ProcessorServiceApi apiInstance = new ProcessorServiceApi();
String id = "id_example"; // String | 
try {
    V1Processor result = apiInstance.processorServiceGetProcessor(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProcessorServiceApi#processorServiceGetProcessor");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  |

### Return type

[**V1Processor**](V1Processor.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="processorServiceInspectProcessorIn"></a>
# **processorServiceInspectProcessorIn**
> StreamResultOfV1InspectConnectorResponse processorServiceInspectProcessorIn(id)

InspectProcessorIn streams records coming into the specified processor

### Example
```java
// Import classes:
//import io.conduit.client.ApiException;
//import io.conduit.client.api.ProcessorServiceApi;


ProcessorServiceApi apiInstance = new ProcessorServiceApi();
String id = "id_example"; // String | 
try {
    StreamResultOfV1InspectConnectorResponse result = apiInstance.processorServiceInspectProcessorIn(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProcessorServiceApi#processorServiceInspectProcessorIn");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  |

### Return type

[**StreamResultOfV1InspectConnectorResponse**](StreamResultOfV1InspectConnectorResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="processorServiceInspectProcessorOut"></a>
# **processorServiceInspectProcessorOut**
> StreamResultOfV1InspectConnectorResponse processorServiceInspectProcessorOut(id)

InspectProcessorOut streams the output records from the specified processor

### Example
```java
// Import classes:
//import io.conduit.client.ApiException;
//import io.conduit.client.api.ProcessorServiceApi;


ProcessorServiceApi apiInstance = new ProcessorServiceApi();
String id = "id_example"; // String | 
try {
    StreamResultOfV1InspectConnectorResponse result = apiInstance.processorServiceInspectProcessorOut(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProcessorServiceApi#processorServiceInspectProcessorOut");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  |

### Return type

[**StreamResultOfV1InspectConnectorResponse**](StreamResultOfV1InspectConnectorResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="processorServiceListProcessorPlugins"></a>
# **processorServiceListProcessorPlugins**
> List&lt;V1ProcessorPluginSpecifications&gt; processorServiceListProcessorPlugins(name)



### Example
```java
// Import classes:
//import io.conduit.client.ApiException;
//import io.conduit.client.api.ProcessorServiceApi;


ProcessorServiceApi apiInstance = new ProcessorServiceApi();
String name = "name_example"; // String | Regex to filter plugins by name.
try {
    List<V1ProcessorPluginSpecifications> result = apiInstance.processorServiceListProcessorPlugins(name);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProcessorServiceApi#processorServiceListProcessorPlugins");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **name** | **String**| Regex to filter plugins by name. | [optional]

### Return type

[**List&lt;V1ProcessorPluginSpecifications&gt;**](V1ProcessorPluginSpecifications.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="processorServiceListProcessors"></a>
# **processorServiceListProcessors**
> List&lt;V1Processor&gt; processorServiceListProcessors(parentIds)



### Example
```java
// Import classes:
//import io.conduit.client.ApiException;
//import io.conduit.client.api.ProcessorServiceApi;


ProcessorServiceApi apiInstance = new ProcessorServiceApi();
List<String> parentIds = Arrays.asList("parentIds_example"); // List<String> | 
try {
    List<V1Processor> result = apiInstance.processorServiceListProcessors(parentIds);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProcessorServiceApi#processorServiceListProcessors");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **parentIds** | [**List&lt;String&gt;**](String.md)|  | [optional]

### Return type

[**List&lt;V1Processor&gt;**](V1Processor.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="processorServiceUpdateProcessor"></a>
# **processorServiceUpdateProcessor**
> V1Processor processorServiceUpdateProcessor(id, body)



### Example
```java
// Import classes:
//import io.conduit.client.ApiException;
//import io.conduit.client.api.ProcessorServiceApi;


ProcessorServiceApi apiInstance = new ProcessorServiceApi();
String id = "id_example"; // String | 
Body3 body = new Body3(); // Body3 | 
try {
    V1Processor result = apiInstance.processorServiceUpdateProcessor(id, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProcessorServiceApi#processorServiceUpdateProcessor");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  |
 **body** | [**Body3**](Body3.md)|  |

### Return type

[**V1Processor**](V1Processor.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

