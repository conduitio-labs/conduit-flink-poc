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
import java.util.ArrayList;
import java.util.List;

/**
 * V1ListPipelinesResponse
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2024-03-13T16:13:27.395+01:00")
public class V1ListPipelinesResponse {
  @SerializedName("pipelines")
  private List<V1Pipeline> pipelines = null;

  public V1ListPipelinesResponse pipelines(List<V1Pipeline> pipelines) {
    this.pipelines = pipelines;
    return this;
  }

  public V1ListPipelinesResponse addPipelinesItem(V1Pipeline pipelinesItem) {
    if (this.pipelines == null) {
      this.pipelines = new ArrayList<V1Pipeline>();
    }
    this.pipelines.add(pipelinesItem);
    return this;
  }

   /**
   * Get pipelines
   * @return pipelines
  **/
  @ApiModelProperty(value = "")
  public List<V1Pipeline> getPipelines() {
    return pipelines;
  }

  public void setPipelines(List<V1Pipeline> pipelines) {
    this.pipelines = pipelines;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    V1ListPipelinesResponse v1ListPipelinesResponse = (V1ListPipelinesResponse) o;
    return Objects.equals(this.pipelines, v1ListPipelinesResponse.pipelines);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pipelines);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class V1ListPipelinesResponse {\n");
    
    sb.append("    pipelines: ").append(toIndentedString(pipelines)).append("\n");
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
