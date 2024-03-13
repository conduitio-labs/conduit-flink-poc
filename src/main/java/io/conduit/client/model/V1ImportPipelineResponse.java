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


package io.conduit.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.conduit.client.model.V1Pipeline;
import java.io.IOException;

/**
 * V1ImportPipelineResponse
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2024-03-13T16:13:27.395+01:00")
public class V1ImportPipelineResponse {
  @SerializedName("pipeline")
  private V1Pipeline pipeline = null;

  public V1ImportPipelineResponse pipeline(V1Pipeline pipeline) {
    this.pipeline = pipeline;
    return this;
  }

   /**
   * Get pipeline
   * @return pipeline
  **/
  @ApiModelProperty(value = "")
  public V1Pipeline getPipeline() {
    return pipeline;
  }

  public void setPipeline(V1Pipeline pipeline) {
    this.pipeline = pipeline;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    V1ImportPipelineResponse v1ImportPipelineResponse = (V1ImportPipelineResponse) o;
    return Objects.equals(this.pipeline, v1ImportPipelineResponse.pipeline);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pipeline);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class V1ImportPipelineResponse {\n");
    
    sb.append("    pipeline: ").append(toIndentedString(pipeline)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

