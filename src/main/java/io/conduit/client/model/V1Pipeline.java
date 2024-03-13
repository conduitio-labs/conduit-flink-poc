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
import io.conduit.client.model.PipelineState;
import io.conduit.client.model.V1PipelineConfig;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.threeten.bp.OffsetDateTime;

/**
 * V1Pipeline
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2024-03-13T16:13:27.395+01:00")
public class V1Pipeline {
  @SerializedName("id")
  private String id = null;

  @SerializedName("state")
  private PipelineState state = null;

  @SerializedName("config")
  private V1PipelineConfig config = null;

  @SerializedName("connectorIds")
  private List<String> connectorIds = null;

  @SerializedName("processorIds")
  private List<String> processorIds = null;

  @SerializedName("createdAt")
  private OffsetDateTime createdAt = null;

  @SerializedName("updatedAt")
  private OffsetDateTime updatedAt = null;

   /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")
  public String getId() {
    return id;
  }

  public V1Pipeline state(PipelineState state) {
    this.state = state;
    return this;
  }

   /**
   * Get state
   * @return state
  **/
  @ApiModelProperty(value = "")
  public PipelineState getState() {
    return state;
  }

  public void setState(PipelineState state) {
    this.state = state;
  }

  public V1Pipeline config(V1PipelineConfig config) {
    this.config = config;
    return this;
  }

   /**
   * Get config
   * @return config
  **/
  @ApiModelProperty(value = "")
  public V1PipelineConfig getConfig() {
    return config;
  }

  public void setConfig(V1PipelineConfig config) {
    this.config = config;
  }

   /**
   * Get connectorIds
   * @return connectorIds
  **/
  @ApiModelProperty(value = "")
  public List<String> getConnectorIds() {
    return connectorIds;
  }

   /**
   * Get processorIds
   * @return processorIds
  **/
  @ApiModelProperty(value = "")
  public List<String> getProcessorIds() {
    return processorIds;
  }

  public V1Pipeline createdAt(OffsetDateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

   /**
   * Get createdAt
   * @return createdAt
  **/
  @ApiModelProperty(value = "")
  public OffsetDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(OffsetDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public V1Pipeline updatedAt(OffsetDateTime updatedAt) {
    this.updatedAt = updatedAt;
    return this;
  }

   /**
   * Get updatedAt
   * @return updatedAt
  **/
  @ApiModelProperty(value = "")
  public OffsetDateTime getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(OffsetDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    V1Pipeline v1Pipeline = (V1Pipeline) o;
    return Objects.equals(this.id, v1Pipeline.id) &&
        Objects.equals(this.state, v1Pipeline.state) &&
        Objects.equals(this.config, v1Pipeline.config) &&
        Objects.equals(this.connectorIds, v1Pipeline.connectorIds) &&
        Objects.equals(this.processorIds, v1Pipeline.processorIds) &&
        Objects.equals(this.createdAt, v1Pipeline.createdAt) &&
        Objects.equals(this.updatedAt, v1Pipeline.updatedAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, state, config, connectorIds, processorIds, createdAt, updatedAt);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class V1Pipeline {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    config: ").append(toIndentedString(config)).append("\n");
    sb.append("    connectorIds: ").append(toIndentedString(connectorIds)).append("\n");
    sb.append("    processorIds: ").append(toIndentedString(processorIds)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    updatedAt: ").append(toIndentedString(updatedAt)).append("\n");
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

