package com.github.JanLoebel.jsonschemavalidationexample.config;

import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;
import com.networknt.schema.ValidationMessage;
import com.github.JanLoebel.jsonschemavalidation.provider.CacheableJsonSchemaProvider;

import java.util.Collection;

/**
 * NOTE: This is optional! This just shows how you can modify the validation.
 */
// We extend our json schema provider from the existing cachable implementation to avoid loading schemas each time.
// If you don't want caching for the validation use "DefaultJsonSchemaProvider".
public class MyCustomJsonSchemaProvider extends CacheableJsonSchemaProvider {

    @Override
    public JsonSchema loadSchema(String url) {
        // Set base path of the schemas, so it's easier to annotate the e.g.: BookDto with the path.
        // Full path then will be: 'classpath:jsonschema/book.json'
        final String fullPath =  "classpath:jsonschema/" + url;
        return super.loadSchema(fullPath);
    }

    @Override
    protected JsonSchemaFactory getJsonSchemaFactory() {
        // In this example we use version 4 of the json schema specification, so we have to create a json
        // schema factory with this version. By default version 7 is used.
        return JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V4);
    }

    @Override
    public void handleValidationMessages(Collection<ValidationMessage> validationMessages) {
        // Here you could handle the validation messages yourself
        super.handleValidationMessages(validationMessages);
    }
}
