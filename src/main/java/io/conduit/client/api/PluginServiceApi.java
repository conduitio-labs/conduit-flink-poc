/*
 * Conduit REST API
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: v0.1.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package io.conduit.client.api;

import io.conduit.client.ApiCallback;
import io.conduit.client.ApiClient;
import io.conduit.client.ApiException;
import io.conduit.client.ApiResponse;
import io.conduit.client.Configuration;
import io.conduit.client.Pair;
import io.conduit.client.ProgressRequestBody;
import io.conduit.client.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;


import io.conduit.client.model.GooglerpcStatus;
import io.conduit.client.model.V1PluginSpecifications;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PluginServiceApi {
    private ApiClient apiClient;

    public PluginServiceApi() {
        this(Configuration.getDefaultApiClient());
    }

    public PluginServiceApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for pluginServiceListPlugins
     * @param name Regex to filter plugins by name. (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call pluginServiceListPluginsCall(String name, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/v1/plugins";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (name != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("name", name));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call pluginServiceListPluginsValidateBeforeCall(String name, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        

        com.squareup.okhttp.Call call = pluginServiceListPluginsCall(name, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Deprecated: use ConnectorService.ListConnectorPlugins instead.
     * 
     * @param name Regex to filter plugins by name. (optional)
     * @return List&lt;V1PluginSpecifications&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<V1PluginSpecifications> pluginServiceListPlugins(String name) throws ApiException {
        ApiResponse<List<V1PluginSpecifications>> resp = pluginServiceListPluginsWithHttpInfo(name);
        return resp.getData();
    }

    /**
     * Deprecated: use ConnectorService.ListConnectorPlugins instead.
     * 
     * @param name Regex to filter plugins by name. (optional)
     * @return ApiResponse&lt;List&lt;V1PluginSpecifications&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<V1PluginSpecifications>> pluginServiceListPluginsWithHttpInfo(String name) throws ApiException {
        com.squareup.okhttp.Call call = pluginServiceListPluginsValidateBeforeCall(name, null, null);
        Type localVarReturnType = new TypeToken<List<V1PluginSpecifications>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Deprecated: use ConnectorService.ListConnectorPlugins instead. (asynchronously)
     * 
     * @param name Regex to filter plugins by name. (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call pluginServiceListPluginsAsync(String name, final ApiCallback<List<V1PluginSpecifications>> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = pluginServiceListPluginsValidateBeforeCall(name, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<V1PluginSpecifications>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
