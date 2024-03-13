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


package io.conduit;

import java.util.List;

import io.conduit.client.model.Body1;
import io.conduit.client.model.Body2;
import io.conduit.client.model.PipelineDLQ;
import io.conduit.client.model.V1CreatePipelineRequest;
import io.conduit.client.model.V1DeletePipelineResponse;
import io.conduit.client.model.V1Pipeline;
import io.conduit.client.model.V1StartPipelineResponse;
import io.conduit.client.model.V1StopPipelineResponse;
import org.junit.Ignore;
import org.junit.Test;

/**
 * API tests for PipelineServiceApi
 */
@Ignore
public class PipelineServiceApiTest {

    private final PipelineServiceApi api = new PipelineServiceApi();

    
    /**
     * 
     *
     * 
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void pipelineServiceCreatePipelineTest() throws Exception {
        V1CreatePipelineRequest body = null;
        V1Pipeline response = api.pipelineServiceCreatePipeline(body);

        // TODO: test validations
    }
    
    /**
     * 
     *
     * 
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void pipelineServiceDeletePipelineTest() throws Exception {
        String id = null;
        V1DeletePipelineResponse response = api.pipelineServiceDeletePipeline(id);

        // TODO: test validations
    }
    
    /**
     * 
     *
     * 
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void pipelineServiceExportPipelineTest() throws Exception {
        String id = null;
        V1Pipeline response = api.pipelineServiceExportPipeline(id);

        // TODO: test validations
    }
    
    /**
     * 
     *
     * 
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void pipelineServiceGetDLQTest() throws Exception {
        String id = null;
        PipelineDLQ response = api.pipelineServiceGetDLQ(id);

        // TODO: test validations
    }
    
    /**
     * 
     *
     * 
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void pipelineServiceGetPipelineTest() throws Exception {
        String id = null;
        V1Pipeline response = api.pipelineServiceGetPipeline(id);

        // TODO: test validations
    }
    
    /**
     * 
     *
     * 
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void pipelineServiceImportPipelineTest() throws Exception {
        V1Pipeline pipeline = null;
        V1Pipeline response = api.pipelineServiceImportPipeline(pipeline);

        // TODO: test validations
    }
    
    /**
     * 
     *
     * 
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void pipelineServiceListPipelinesTest() throws Exception {
        String name = null;
        List<V1Pipeline> response = api.pipelineServiceListPipelines(name);

        // TODO: test validations
    }
    
    /**
     * 
     *
     * 
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void pipelineServiceStartPipelineTest() throws Exception {
        String id = null;
        V1StartPipelineResponse response = api.pipelineServiceStartPipeline(id);

        // TODO: test validations
    }
    
    /**
     * 
     *
     * 
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void pipelineServiceStopPipelineTest() throws Exception {
        String id = null;
        Body2 body = null;
        V1StopPipelineResponse response = api.pipelineServiceStopPipeline(id, body);

        // TODO: test validations
    }
    
    /**
     * 
     *
     * 
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void pipelineServiceUpdateDLQTest() throws Exception {
        String id = null;
        PipelineDLQ dlq = null;
        PipelineDLQ response = api.pipelineServiceUpdateDLQ(id, dlq);

        // TODO: test validations
    }
    
    /**
     * 
     *
     * 
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void pipelineServiceUpdatePipelineTest() throws Exception {
        String id = null;
        Body1 body = null;
        V1Pipeline response = api.pipelineServiceUpdatePipeline(id, body);

        // TODO: test validations
    }
    
}