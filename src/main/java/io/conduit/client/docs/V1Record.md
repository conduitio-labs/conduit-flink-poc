
# V1Record

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**position** | **byte[]** | Position uniquely identifies the record. |  [optional]
**operation** | [**Opencdcv1Operation**](Opencdcv1Operation.md) | Operation defines what triggered the creation of a record. There are four possibilities: create, update, delete or snapshot. The first three operations are encountered during normal CDC operation, while \&quot;snapshot\&quot; is meant to represent records during an initial load. Depending on the operation, the record will contain either the payload before the change, after the change, or both (see field payload). |  [optional]
**metadata** | **Map&lt;String, String&gt;** | Metadata contains optional information related to the record. Although the map can contain arbitrary keys, the standard provides a set of standard metadata fields (see options prefixed with metadata_*). |  [optional]
**key** | [**V1Data**](V1Data.md) | Key represents a value that should identify the entity (e.g. database row). |  [optional]
**payload** | [**V1Change**](V1Change.md) | Payload holds the payload change (data before and after the operation occurred). |  [optional]



