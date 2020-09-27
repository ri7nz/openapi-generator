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
import static org.apache.commons.lang3.StringUtils.capitalize;

public class ReasonMLClientCodegen extends DefaultCodegen {
  public static final String PROJECT_NAME = "projectName";

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
    apiPackage = File.separator + "src/apis";
    modelPackage = File.separator + "src/models";
    supportingFiles.add(new SupportingFile("README.mustache", "", "README.md"));
    /**
     * supportingFiles for Api and Model Model.re - module Category =
     * Model__Category; - module Tag = Model__Tag;
     *
     * Api.re - module Response = Api__Response;
     */
    supportingFiles.add(new SupportingFile("models.mustache", "", "src/models/Model.re"));
    supportingFiles.add(new SupportingFile("apis.mustache", "", "src/apis/Api.re"));
  }

  @Override
  public String toModelFilename(String name) {
    String _modelNamePrefix = "model__";
    return capitalize(_modelNamePrefix) + capitalize(name);
  }

  @Override
  public String toApiFilename(String name) {
    String _apiNamePrefix = "api__";
    return capitalize(_apiNamePrefix) + capitalize(name);
  }

}
