
# V1ProcessorPluginSpecifications

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**name** | **String** | Name is the name of the plugin. |  [optional]
**summary** | **String** | Summary is a brief description of the plugin and what it does, ideally not longer than one sentence. |  [optional]
**description** | **String** | Description is a longer form field, appropriate for README-like text that the author can provide for documentation about the usage of the plugin. |  [optional]
**version** | **String** | Version string. Should follow semantic versioning and use the \&quot;v\&quot; prefix (e.g. v1.23.4). |  [optional]
**author** | **String** | Author declares the entity that created or maintains this plugin. |  [optional]
**parameters** | [**Map&lt;String, Configv1Parameter&gt;**](Configv1Parameter.md) | A map that describes parameters available for configuring the processor plugin. |  [optional]



