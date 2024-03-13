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
import io.conduit.client.model.Opencdcv1Operation;
import io.conduit.client.model.V1Change;
import io.conduit.client.model.V1Data;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Record contains data about a single change event related to a single entity.
 */
@ApiModel(description = "Record contains data about a single change event related to a single entity.")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2024-03-13T16:13:27.395+01:00")
public class V1Record {
  @SerializedName("position")
  private byte[] position = null;

  @SerializedName("operation")
  private Opencdcv1Operation operation = null;

  @SerializedName("metadata")
  private Map<String, String> metadata = null;

  @SerializedName("key")
  private V1Data key = null;

  @SerializedName("payload")
  private V1Change payload = null;

  public V1Record position(byte[] position) {
    this.position = position;
    return this;
  }

   /**
   * Position uniquely identifies the record.
   * @return position
  **/
  @ApiModelProperty(value = "Position uniquely identifies the record.")
  public byte[] getPosition() {
    return position;
  }

  public void setPosition(byte[] position) {
    this.position = position;
  }

  public V1Record operation(Opencdcv1Operation operation) {
    this.operation = operation;
    return this;
  }

   /**
   * Operation defines what triggered the creation of a record. There are four possibilities: create, update, delete or snapshot. The first three operations are encountered during normal CDC operation, while \&quot;snapshot\&quot; is meant to represent records during an initial load. Depending on the operation, the record will contain either the payload before the change, after the change, or both (see field payload).
   * @return operation
  **/
  @ApiModelProperty(value = "Operation defines what triggered the creation of a record. There are four possibilities: create, update, delete or snapshot. The first three operations are encountered during normal CDC operation, while \"snapshot\" is meant to represent records during an initial load. Depending on the operation, the record will contain either the payload before the change, after the change, or both (see field payload).")
  public Opencdcv1Operation getOperation() {
    return operation;
  }

  public void setOperation(Opencdcv1Operation operation) {
    this.operation = operation;
  }

  public V1Record metadata(Map<String, String> metadata) {
    this.metadata = metadata;
    return this;
  }

  public V1Record putMetadataItem(String key, String metadataItem) {
    if (this.metadata == null) {
      this.metadata = new HashMap<String, String>();
    }
    this.metadata.put(key, metadataItem);
    return this;
  }

   /**
   * Metadata contains optional information related to the record. Although the map can contain arbitrary keys, the standard provides a set of standard metadata fields (see options prefixed with metadata_*).
   * @return metadata
  **/
  @ApiModelProperty(value = "Metadata contains optional information related to the record. Although the map can contain arbitrary keys, the standard provides a set of standard metadata fields (see options prefixed with metadata_*).")
  public Map<String, String> getMetadata() {
    return metadata;
  }

  public void setMetadata(Map<String, String> metadata) {
    this.metadata = metadata;
  }

  public V1Record key(V1Data key) {
    this.key = key;
    return this;
  }

   /**
   * Key represents a value that should identify the entity (e.g. database row).
   * @return key
  **/
  @ApiModelProperty(value = "Key represents a value that should identify the entity (e.g. database row).")
  public V1Data getKey() {
    return key;
  }

  public void setKey(V1Data key) {
    this.key = key;
  }

  public V1Record payload(V1Change payload) {
    this.payload = payload;
    return this;
  }

   /**
   * Payload holds the payload change (data before and after the operation occurred).
   * @return payload
  **/
  @ApiModelProperty(value = "Payload holds the payload change (data before and after the operation occurred).")
  public V1Change getPayload() {
    return payload;
  }

  public void setPayload(V1Change payload) {
    this.payload = payload;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    V1Record v1Record = (V1Record) o;
    return Arrays.equals(this.position, v1Record.position) &&
        Objects.equals(this.operation, v1Record.operation) &&
        Objects.equals(this.metadata, v1Record.metadata) &&
        Objects.equals(this.key, v1Record.key) &&
        Objects.equals(this.payload, v1Record.payload);
  }

  @Override
  public int hashCode() {
    return Objects.hash(Arrays.hashCode(position), operation, metadata, key, payload);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class V1Record {\n");
    
    sb.append("    position: ").append(toIndentedString(position)).append("\n");
    sb.append("    operation: ").append(toIndentedString(operation)).append("\n");
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
    sb.append("    key: ").append(toIndentedString(key)).append("\n");
    sb.append("    payload: ").append(toIndentedString(payload)).append("\n");
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

