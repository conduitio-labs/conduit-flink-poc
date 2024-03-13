# ConnectorServiceApi

All URIs are relative to *https://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**connectorServiceCreateConnector**](ConnectorServiceApi.md#connectorServiceCreateConnector) | **POST** /v1/connectors | 
[**connectorServiceDeleteConnector**](ConnectorServiceApi.md#connectorServiceDeleteConnector) | **DELETE** /v1/connectors/{id} | 
[**connectorServiceGetConnector**](ConnectorServiceApi.md#connectorServiceGetConnector) | **GET** /v1/connectors/{id} | 
[**connectorServiceInspectConnector**](ConnectorServiceApi.md#connectorServiceInspectConnector) | **GET** /v1/connectors/{id}/inspect | 
[**connectorServiceListConnectorPlugins**](ConnectorServiceApi.md#connectorServiceListConnectorPlugins) | **GET** /v1/connectors/plugins | 
[**connectorServiceListConnectors**](ConnectorServiceApi.md#connectorServiceListConnectors) | **GET** /v1/connectors | 
[**connectorServiceUpdateConnector**](ConnectorServiceApi.md#connectorServiceUpdateConnector) | **PUT** /v1/connectors/{id} | 
[**connectorServiceValidateConnector**](ConnectorServiceApi.md#connectorServiceValidateConnector) | **POST** /v1/connectors/validate | 


<a name="connectorServiceCreateConnector"></a>
# **connectorServiceCreateConnector**
> V1Connector connectorServiceCreateConnector(body)



### Example
```java
// Import classes:
//import io.conduit.client.ApiException;
//import io.conduit.client.api.ConnectorServiceApi;


ConnectorServiceApi apiInstance = new ConnectorServiceApi();
V1CreateConnectorRequest body = new V1CreateConnectorRequest(); // V1CreateConnectorRequest | 
try {
    V1Connector result = apiInstance.connectorServiceCreateConnector(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ConnectorServiceApi#connectorServiceCreateConnector");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**V1CreateConnectorRequest**](V1CreateConnectorRequest.md)|  |

### Return type

[**V1Connector**](V1Connector.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="connectorServiceDeleteConnector"></a>
# **connectorServiceDeleteConnector**
> V1DeleteConnectorResponse connectorServiceDeleteConnector(id)



### Example
```java
// Import classes:
//import io.conduit.client.ApiException;
//import io.conduit.client.api.ConnectorServiceApi;


ConnectorServiceApi apiInstance = new ConnectorServiceApi();
String id = "id_example"; // String | 
try {
    V1DeleteConnectorResponse result = apiInstance.connectorServiceDeleteConnector(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ConnectorServiceApi#connectorServiceDeleteConnector");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  |

### Return type

[**V1DeleteConnectorResponse**](V1DeleteConnectorResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="connectorServiceGetConnector"></a>
# **connectorServiceGetConnector**
> V1Connector connectorServiceGetConnector(id)



### Example
```java
// Import classes:
//import io.conduit.client.ApiException;
//import io.conduit.client.api.ConnectorServiceApi;


ConnectorServiceApi apiInstance = new ConnectorServiceApi();
String id = "id_example"; // String | 
try {
    V1Connector result = apiInstance.connectorServiceGetConnector(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ConnectorServiceApi#connectorServiceGetConnector");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  |

### Return type

[**V1Connector**](V1Connector.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="connectorServiceInspectConnector"></a>
# **connectorServiceInspectConnector**
> StreamResultOfV1InspectConnectorResponse connectorServiceInspectConnector(id)



### Example
```java
// Import classes:
//import io.conduit.client.ApiException;
//import io.conduit.client.api.ConnectorServiceApi;


ConnectorServiceApi apiInstance = new ConnectorServiceApi();
String id = "id_example"; // String | 
try {
    StreamResultOfV1InspectConnectorResponse result = apiInstance.connectorServiceInspectConnector(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ConnectorServiceApi#connectorServiceInspectConnector");
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

<a name="connectorServiceListConnectorPlugins"></a>
# **connectorServiceListConnectorPlugins**
> List&lt;V1ConnectorPluginSpecifications&gt; connectorServiceListConnectorPlugins(name)



### Example
```java
// Import classes:
//import io.conduit.client.ApiException;
//import io.conduit.client.api.ConnectorServiceApi;


ConnectorServiceApi apiInstance = new ConnectorServiceApi();
String name = "name_example"; // String | Regex to filter plugins by name.
try {
    List<V1ConnectorPluginSpecifications> result = apiInstance.connectorServiceListConnectorPlugins(name);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ConnectorServiceApi#connectorServiceListConnectorPlugins");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **name** | **String**| Regex to filter plugins by name. | [optional]

### Return type

[**List&lt;V1ConnectorPluginSpecifications&gt;**](V1ConnectorPluginSpecifications.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="connectorServiceListConnectors"></a>
# **connectorServiceListConnectors**
> List&lt;V1Connector&gt; connectorServiceListConnectors(pipelineId)



### Example
```java
// Import classes:
//import io.conduit.client.ApiException;
//import io.conduit.client.api.ConnectorServiceApi;


ConnectorServiceApi apiInstance = new ConnectorServiceApi();
String pipelineId = "pipelineId_example"; // String | 
try {
    List<V1Connector> result = apiInstance.connectorServiceListConnectors(pipelineId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ConnectorServiceApi#connectorServiceListConnectors");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **pipelineId** | **String**|  | [optional]

### Return type

[**List&lt;V1Connector&gt;**](V1Connector.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="connectorServiceUpdateConnector"></a>
# **connectorServiceUpdateConnector**
> V1Connector connectorServiceUpdateConnector(id, body)



### Example
```java
// Import classes:
//import io.conduit.client.ApiException;
//import io.conduit.client.api.ConnectorServiceApi;


ConnectorServiceApi apiInstance = new ConnectorServiceApi();
String id = "id_example"; // String | 
Body body = new Body(); // Body | 
try {
    V1Connector result = apiInstance.connectorServiceUpdateConnector(id, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ConnectorServiceApi#connectorServiceUpdateConnector");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  |
 **body** | [**Body**](Body.md)|  |

### Return type

[**V1Connector**](V1Connector.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="connectorServiceValidateConnector"></a>
# **connectorServiceValidateConnector**
> V1ValidateConnectorResponse connectorServiceValidateConnector(body)



### Example
```java
// Import classes:
//import io.conduit.client.ApiException;
//import io.conduit.client.api.ConnectorServiceApi;


ConnectorServiceApi apiInstance = new ConnectorServiceApi();
V1ValidateConnectorRequest body = new V1ValidateConnectorRequest(); // V1ValidateConnectorRequest | 
try {
    V1ValidateConnectorResponse result = apiInstance.connectorServiceValidateConnector(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ConnectorServiceApi#connectorServiceValidateConnector");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**V1ValidateConnectorRequest**](V1ValidateConnectorRequest.md)|  |

### Return type

[**V1ValidateConnectorResponse**](V1ValidateConnectorResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

