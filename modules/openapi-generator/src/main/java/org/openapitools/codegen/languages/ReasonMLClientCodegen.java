package org.openapitools.codegen.languages;

import org.openapitools.codegen.*;
import io.swagger.models.properties.ArrayProperty;
import io.swagger.models.properties.MapProperty;
import io.swagger.models.properties.Property;
import io.swagger.models.parameters.Parameter;

import java.io.File;
import java.util.*;

import org.apache.commons.lang3.StringUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReasonMLClientCodegen extends DefaultCodegen implements CodegenConfig {
    public static final String PROJECT_NAME = "projectName";

    // <project>/src/generated
    protected String sourceFolder = "src";

    static Logger LOGGER = LoggerFactory.getLogger(ReasonMLClientCodegen.class);

    public CodegenType getTag() {
        return CodegenType.CLIENT;
    }

    public String getName() {
        return "reasonml";
    }

    public String getHelp() {
        return "Generates a ReasonML client library (beta).";
    }

    public ReasonMLClientCodegen() {
        super();

        outputFolder = "generated-code" + File.separator + "reasonml";
        modelTemplateFiles.put("model.mustache", ".re");
        apiTemplateFiles.put("api.mustache", ".re");
        embeddedTemplateDir = templateDir = "reasonml-client";
        apiPackage = File.separator + "Apis";
        modelPackage = File.separator + "Models";
        supportingFiles.add(new SupportingFile("README.mustache", "", "README.md"));
    }
}
