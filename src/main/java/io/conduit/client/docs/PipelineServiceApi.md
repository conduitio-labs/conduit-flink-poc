# PipelineServiceApi

All URIs are relative to *https://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**pipelineServiceCreatePipeline**](PipelineServiceApi.md#pipelineServiceCreatePipeline) | **POST** /v1/pipelines | 
[**pipelineServiceDeletePipeline**](PipelineServiceApi.md#pipelineServiceDeletePipeline) | **DELETE** /v1/pipelines/{id} | 
[**pipelineServiceExportPipeline**](PipelineServiceApi.md#pipelineServiceExportPipeline) | **POST** /v1/pipelines/{id}/export | 
[**pipelineServiceGetDLQ**](PipelineServiceApi.md#pipelineServiceGetDLQ) | **GET** /v1/pipelines/{id}/dead-letter-queue | 
[**pipelineServiceGetPipeline**](PipelineServiceApi.md#pipelineServiceGetPipeline) | **GET** /v1/pipelines/{id} | 
[**pipelineServiceImportPipeline**](PipelineServiceApi.md#pipelineServiceImportPipeline) | **POST** /v1/pipelines/import | 
[**pipelineServiceListPipelines**](PipelineServiceApi.md#pipelineServiceListPipelines) | **GET** /v1/pipelines | 
[**pipelineServiceStartPipeline**](PipelineServiceApi.md#pipelineServiceStartPipeline) | **POST** /v1/pipelines/{id}/start | 
[**pipelineServiceStopPipeline**](PipelineServiceApi.md#pipelineServiceStopPipeline) | **POST** /v1/pipelines/{id}/stop | 
[**pipelineServiceUpdateDLQ**](PipelineServiceApi.md#pipelineServiceUpdateDLQ) | **PUT** /v1/pipelines/{id}/dead-letter-queue | 
[**pipelineServiceUpdatePipeline**](PipelineServiceApi.md#pipelineServiceUpdatePipeline) | **PUT** /v1/pipelines/{id} | 


<a name="pipelineServiceCreatePipeline"></a>
# **pipelineServiceCreatePipeline**
> V1Pipeline pipelineServiceCreatePipeline(body)



### Example
```java
// Import classes:
//import io.conduit.client.ApiException;
//import io.conduit.client.api.PipelineServiceApi;


PipelineServiceApi apiInstance = new PipelineServiceApi();
V1CreatePipelineRequest body = new V1CreatePipelineRequest(); // V1CreatePipelineRequest | 
try {
    V1Pipeline result = apiInstance.pipelineServiceCreatePipeline(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PipelineServiceApi#pipelineServiceCreatePipeline");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**V1CreatePipelineRequest**](V1CreatePipelineRequest.md)|  |

### Return type

[**V1Pipeline**](V1Pipeline.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="pipelineServiceDeletePipeline"></a>
# **pipelineServiceDeletePipeline**
> V1DeletePipelineResponse pipelineServiceDeletePipeline(id)



### Example
```java
// Import classes:
//import io.conduit.client.ApiException;
//import io.conduit.client.api.PipelineServiceApi;


PipelineServiceApi apiInstance = new PipelineServiceApi();
String id = "id_example"; // String | 
try {
    V1DeletePipelineResponse result = apiInstance.pipelineServiceDeletePipeline(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PipelineServiceApi#pipelineServiceDeletePipeline");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  |

### Return type

[**V1DeletePipelineResponse**](V1DeletePipelineResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="pipelineServiceExportPipeline"></a>
# **pipelineServiceExportPipeline**
> V1Pipeline pipelineServiceExportPipeline(id)



### Example
```java
// Import classes:
//import io.conduit.client.ApiException;
//import io.conduit.client.api.PipelineServiceApi;


PipelineServiceApi apiInstance = new PipelineServiceApi();
String id = "id_example"; // String | 
try {
    V1Pipeline result = apiInstance.pipelineServiceExportPipeline(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PipelineServiceApi#pipelineServiceExportPipeline");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  |

### Return type

[**V1Pipeline**](V1Pipeline.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="pipelineServiceGetDLQ"></a>
# **pipelineServiceGetDLQ**
> PipelineDLQ pipelineServiceGetDLQ(id)



### Example
```java
// Import classes:
//import io.conduit.client.ApiException;
//import io.conduit.client.api.PipelineServiceApi;


PipelineServiceApi apiInstance = new PipelineServiceApi();
String id = "id_example"; // String | 
try {
    PipelineDLQ result = apiInstance.pipelineServiceGetDLQ(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PipelineServiceApi#pipelineServiceGetDLQ");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  |

### Return type

[**PipelineDLQ**](PipelineDLQ.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="pipelineServiceGetPipeline"></a>
# **pipelineServiceGetPipeline**
> V1Pipeline pipelineServiceGetPipeline(id)



### Example
```java
// Import classes:
//import io.conduit.client.ApiException;
//import io.conduit.client.api.PipelineServiceApi;


PipelineServiceApi apiInstance = new PipelineServiceApi();
String id = "id_example"; // String | 
try {
    V1Pipeline result = apiInstance.pipelineServiceGetPipeline(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PipelineServiceApi#pipelineServiceGetPipeline");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  |

### Return type

[**V1Pipeline**](V1Pipeline.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="pipelineServiceImportPipeline"></a>
# **pipelineServiceImportPipeline**
> V1Pipeline pipelineServiceImportPipeline(pipeline)



### Example
```java
// Import classes:
//import io.conduit.client.ApiException;
//import io.conduit.client.api.PipelineServiceApi;


PipelineServiceApi apiInstance = new PipelineServiceApi();
V1Pipeline pipeline = new V1Pipeline(); // V1Pipeline | 
try {
    V1Pipeline result = apiInstance.pipelineServiceImportPipeline(pipeline);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PipelineServiceApi#pipelineServiceImportPipeline");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **pipeline** | [**V1Pipeline**](V1Pipeline.md)|  |

### Return type

[**V1Pipeline**](V1Pipeline.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="pipelineServiceListPipelines"></a>
# **pipelineServiceListPipelines**
> List&lt;V1Pipeline&gt; pipelineServiceListPipelines(name)



### Example
```java
// Import classes:
//import io.conduit.client.ApiException;
//import io.conduit.client.api.PipelineServiceApi;


PipelineServiceApi apiInstance = new PipelineServiceApi();
String name = "name_example"; // String | Regex to filter pipelines by name.
try {
    List<V1Pipeline> result = apiInstance.pipelineServiceListPipelines(name);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PipelineServiceApi#pipelineServiceListPipelines");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **name** | **String**| Regex to filter pipelines by name. | [optional]

### Return type

[**List&lt;V1Pipeline&gt;**](V1Pipeline.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="pipelineServiceStartPipeline"></a>
# **pipelineServiceStartPipeline**
> V1StartPipelineResponse pipelineServiceStartPipeline(id)



### Example
```java
// Import classes:
//import io.conduit.client.ApiException;
//import io.conduit.client.api.PipelineServiceApi;


PipelineServiceApi apiInstance = new PipelineServiceApi();
String id = "id_example"; // String | 
try {
    V1StartPipelineResponse result = apiInstance.pipelineServiceStartPipeline(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PipelineServiceApi#pipelineServiceStartPipeline");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  |

### Return type

[**V1StartPipelineResponse**](V1StartPipelineResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="pipelineServiceStopPipeline"></a>
# **pipelineServiceStopPipeline**
> V1StopPipelineResponse pipelineServiceStopPipeline(id, body)



### Example
```java
// Import classes:
//import io.conduit.client.ApiException;
//import io.conduit.client.api.PipelineServiceApi;


PipelineServiceApi apiInstance = new PipelineServiceApi();
String id = "id_example"; // String | 
Body2 body = new Body2(); // Body2 | 
try {
    V1StopPipelineResponse result = apiInstance.pipelineServiceStopPipeline(id, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PipelineServiceApi#pipelineServiceStopPipeline");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  |
 **body** | [**Body2**](Body2.md)|  |

### Return type

[**V1StopPipelineResponse**](V1StopPipelineResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="pipelineServiceUpdateDLQ"></a>
# **pipelineServiceUpdateDLQ**
> PipelineDLQ pipelineServiceUpdateDLQ(id, dlq)



### Example
```java
// Import classes:
//import io.conduit.client.ApiException;
//import io.conduit.client.api.PipelineServiceApi;


PipelineServiceApi apiInstance = new PipelineServiceApi();
String id = "id_example"; // String | 
PipelineDLQ dlq = new PipelineDLQ(); // PipelineDLQ | 
try {
    PipelineDLQ result = apiInstance.pipelineServiceUpdateDLQ(id, dlq);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PipelineServiceApi#pipelineServiceUpdateDLQ");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  |
 **dlq** | [**PipelineDLQ**](PipelineDLQ.md)|  |

### Return type

[**PipelineDLQ**](PipelineDLQ.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="pipelineServiceUpdatePipeline"></a>
# **pipelineServiceUpdatePipeline**
> V1Pipeline pipelineServiceUpdatePipeline(id, body)



### Example
```java
// Import classes:
//import io.conduit.client.ApiException;
//import io.conduit.client.api.PipelineServiceApi;


PipelineServiceApi apiInstance = new PipelineServiceApi();
String id = "id_example"; // String | 
Body1 body = new Body1(); // Body1 | 
try {
    V1Pipeline result = apiInstance.pipelineServiceUpdatePipeline(id, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PipelineServiceApi#pipelineServiceUpdatePipeline");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  |
 **body** | [**Body1**](Body1.md)|  |

### Return type

[**V1Pipeline**](V1Pipeline.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

