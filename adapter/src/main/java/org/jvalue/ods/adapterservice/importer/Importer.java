package org.jvalue.ods.adapterservice.importer;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jvalue.ods.adapterservice.interpreter.InterpreterParameterDescription;

public abstract class Importer {

    public abstract String getType();
    public abstract String getDescription();

    @JsonProperty("parameters")
    public abstract List<ImporterParameterDescription> getAvailableParameters();

    public final String fetch(Map<String, Object> parameters) {
      validateParameters(parameters);
      return doFetch(parameters);
    }
    protected abstract String doFetch(Map<String, Object> parameters);

    protected void validateParameters(Map<String, Object> inputParameters) {
      boolean illegalArguments = false;
      String illegalArgumentsMessage = "";

      for (ImporterParameterDescription requiredParameter : getAvailableParameters()) {
        if (inputParameters.get(requiredParameter.getName()) == null) {
          illegalArguments = true;
          illegalArgumentsMessage = illegalArgumentsMessage + getType() + " importer requires parameter "
            + requiredParameter.getName() + "/n";

        } else if (inputParameters.get(requiredParameter.getName()).getClass() != requiredParameter.getType()) {
          illegalArguments = true;
          illegalArgumentsMessage = illegalArgumentsMessage + getType() + " importer requires parameter "
            + requiredParameter.getName() + " to be type " + requiredParameter.getType().toString() + "/n";
        }
      }
      if (illegalArguments) {
        throw new IllegalArgumentException(illegalArgumentsMessage);
      }
    }

}
