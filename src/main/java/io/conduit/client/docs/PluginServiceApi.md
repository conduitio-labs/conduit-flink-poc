# PluginServiceApi

All URIs are relative to *https://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**pluginServiceListPlugins**](PluginServiceApi.md#pluginServiceListPlugins) | **GET** /v1/plugins | Deprecated: use ConnectorService.ListConnectorPlugins instead.


<a name="pluginServiceListPlugins"></a>
# **pluginServiceListPlugins**
> List&lt;V1PluginSpecifications&gt; pluginServiceListPlugins(name)

Deprecated: use ConnectorService.ListConnectorPlugins instead.

### Example
```java
// Import classes:
//import io.conduit.client.ApiException;
//import io.conduit.client.api.PluginServiceApi;


PluginServiceApi apiInstance = new PluginServiceApi();
String name = "name_example"; // String | Regex to filter plugins by name.
try {
    List<V1PluginSpecifications> result = apiInstance.pluginServiceListPlugins(name);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PluginServiceApi#pluginServiceListPlugins");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **name** | **String**| Regex to filter plugins by name. | [optional]

### Return type

[**List&lt;V1PluginSpecifications&gt;**](V1PluginSpecifications.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

